import { Component } from '@angular/core';
import {Customer} from "../../../customer/model/customer.model";
import {Order} from "../../model/order.model";
import {ActivatedRoute, Router} from "@angular/router";
import {CustomersServiceService} from "../../../customer/service/customers-service.service";
import {OrderServiceService} from "../../service/order-service.service";

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrl: './order-details.component.css'
})
export class OrderDetailsComponent {
  orderId: string | undefined;
  order: Order | undefined;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private orderService: OrderServiceService
  ) {}

  ngOnInit(): void {
    this.orderId = this.route.snapshot.params['id'];

    if (this.orderId) {
      this.orderService.getOrderById(this.orderId).subscribe((order: Order) => {
        this.order = order;
      });
    }
  }
}
