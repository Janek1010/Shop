import { Component, OnInit } from '@angular/core';
import { CustomersServiceService } from '../../service/customers-service.service';
import { Customer } from '../../model/customer.model';
import  {OrderServiceService } from "../../../order/service/order-service.service";
import {Order} from "../../../order/model/order.model";
import {ActivatedRoute, Router} from "@angular/router";
@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrl: './customer-details.component.css'
})
export class CustomerDetailsComponent  implements OnInit {
  customerId: string | undefined;
  customer: Customer | undefined;
  orders: Order[] = [];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private customerService: CustomersServiceService,
    private orderService: OrderServiceService
  ) {}

  ngOnInit(): void {
    this.customerId = this.route.snapshot.params['id'];

    if (this.customerId) {
      this.customerService.getCustomerById(this.customerId).subscribe((customer: Customer) => {
        this.customer = customer;
        this.getOrdersByCustomerId(this.customerId!);
      });
    }
  }

    getOrdersByCustomerId(id: string) {
        this.orderService.getOrdersByCustomerId(id).subscribe((response: any) => {
            this.orders = response.orders;
            console.log(this.orders);
        });
    }


    deleteOrder(id: string) {
        this.orderService.deleteOrder(id).subscribe((response: any) => {
            this.getOrdersByCustomerId(this.customerId!);
        });
    }

  protected readonly Customer = Customer;
}
