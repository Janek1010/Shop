import { Component } from '@angular/core';
import { Customer } from '../../model/customer.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CustomersServiceService } from '../../service/customers-service.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-customer-add-form',
  templateUrl: './customer-add-form.component.html',
  styleUrl: './customer-add-form.component.css'
})
export class CustomerAddFormComponent {
  customerForm: FormGroup;

  constructor(private fb: FormBuilder,private router: Router, private customerService: CustomersServiceService) {
    this.customerForm = this.fb.group({
      pesel: ['', [Validators.required]],
      name: ['', [Validators.required]],
      surname: ['', [Validators.required]],
      age: ['', [Validators.required, Validators.min(0)]],
    });
  }
  addCustomer() {
    if (this.customerForm.valid) {
      const newCustomer: Customer = {
        id: '',  // Automatycznie generowane w serwisie
        pesel: this.customerForm.value.pesel,
        name: this.customerForm.value.name,
        surname: this.customerForm.value.surname,
        age: this.customerForm.value.age,
      };

      this.customerService.addCustomer(newCustomer).subscribe(response => {
        this.router.navigate(['/customers']);
      });
    }
  }
}
