import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {OrderServiceService} from "../../service/order-service.service";
import {Order} from "../../model/order.model";
@Component({
  selector: 'app-add-order-form',
  templateUrl: './add-order-form.component.html',
  styleUrl: './add-order-form.component.css'
})
export class AddOrderFormComponent {
  orderForm: FormGroup;
  customerId: string | undefined;
  constructor(private fb: FormBuilder,private router: Router, private orderService: OrderServiceService, private route: ActivatedRoute) {
    this.customerId = this.route.snapshot.params['id'];
    this.orderForm = this.fb.group({
      productName: ['', [Validators.required]],
      quantity: ['', [Validators.required]],
    });
  }
  addOrder() {
    if (this.orderForm.valid) {
      if (this.customerId){
        const newOrder: Order = {
          id: '',
          productName: this.orderForm.value.productName,
          quantity: this.orderForm.value.quantity,
          customer: this.customerId,
        };
        console.log(newOrder)
        this.orderService.addOrder(newOrder).subscribe(response => {
          this.router.navigate(['/customers', this.customerId]);
        });
      }
    }
  }
}
