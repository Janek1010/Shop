import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Customer } from '../../model/customer.model';
import { CustomersServiceService } from '../../service/customers-service.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  customerForm!: FormGroup;
  customerId!: string;
  customer!: Customer;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private customerService: CustomersServiceService
  ) {}

  ngOnInit(): void {
    this.customerId = this.route.snapshot.params['id'];

    this.customerService.getCustomerById(this.customerId).subscribe((customer: Customer) => {
      this.customer = customer;

      // customer-edit.component.ts
      this.customerForm = this.fb.group({
        id: [this.customer ? this.customer.id : '', Validators.required],
        pesel: [this.customer ? this.customer.pesel : '', Validators.required],
        name: [this.customer ? this.customer.name : '', Validators.required],
        surname: [this.customer ? this.customer.surname : '', Validators.required],
        age: [this.customer ? this.customer.age : '', [Validators.required, Validators.min(0)]],
      });
    });
  }

  updateCustomer() {
    if (this.customerForm.valid) {
      const updatedCustomer: Customer = {
        id: this.customerForm.value.id,
        pesel: this.customerForm.value.pesel,
        name: this.customerForm.value.name,
        surname: this.customerForm.value.surname,
        age: this.customerForm.value.age,
      };

      this.customerService.updateCustomer(updatedCustomer).subscribe(response => {
        this.router.navigate(['/customers']);
      });
    }
  }
}
