import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Customer} from "../../../customer/model/customer.model";
import {ActivatedRoute, Router} from "@angular/router";
import {CustomersServiceService} from "../../../customer/service/customers-service.service";
import {Order} from "../../model/order.model";
import {OrderServiceService} from "../../service/order-service.service";

@Component({
  selector: 'app-edit-order-form',
  templateUrl: './edit-order-form.component.html',
  styleUrl: './edit-order-form.component.css'
})
export class EditOrderFormComponent {
  orderForm!: FormGroup;
  orderId: string;
  order!: Order;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private orderService: OrderServiceService
  ) {
    this.orderId = this.route.snapshot.params['id'];

    this.orderService.getOrderById(this.orderId).subscribe((order: Order) => {
      this.order = order;

      this.orderForm = this.fb.group({
        orderId: [this.order ? this.orderId : '', Validators.required],
        productName: [this.order ? this.order.productName : '', Validators.required],
        quantity: [this.order ? this.order.quantity : '', Validators.required],
        customerId: [this.order ? this.order.customer : '', Validators.required],
      });
    });
  }

  updateOrder() {
    if (this.orderForm.valid) {
      const updatedOrder: Order = {
        id: this.orderId,
        productName: this.orderForm.value.productName,
        quantity: this.orderForm.value.quantity,
        customer: this.orderForm.value.customerId,
      };

      this.orderService.updateOrder(updatedOrder).subscribe(response => {
        this.router.navigate(['/customers',updatedOrder.customer]);
      });
    }
  }
}
