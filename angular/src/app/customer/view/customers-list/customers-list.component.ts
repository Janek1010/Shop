import { Component, OnInit } from '@angular/core';
import { CustomersServiceService } from '../../service/customers-service.service';
import { Customer } from '../../model/customer.model';

@Component({
  selector: 'app-customers-list',
  templateUrl: './customers-list.component.html',
  styleUrls: ['./customers-list.component.css']
})
export class CustomersListComponent implements OnInit {
  customers: Customer[] | undefined;

  constructor(private customersService: CustomersServiceService) {}

  ngOnInit(): void {
    this.loadCustomers();
  }

  loadCustomers(): void {
    this.customersService.getCustomers().subscribe((data: any) => {
      this.customers = data.customers.map((customer: any) => {
        return new Customer(
          customer.id,
          customer.pesel,
          customer.name,
          customer.surname,
          customer.age
        );
      });
      console.log('Otrzymane dane:', this.customers);
    });
  }

  deleteCustomer(id: string): void {
    this.customersService.deleteCustomer(id).subscribe(() => {
      this.loadCustomers();
    });
  }

}
