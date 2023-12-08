import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CustomersListComponent} from "./customer/view/customers-list/customers-list.component";
import {CustomerAddFormComponent} from "./customer/view/customer-add-form/customer-add-form.component";
import {AppComponent} from "./app.component";
import {CustomerEditComponent} from "./customer/view/customer-edit/customer-edit.component";
import {CustomerDetailsComponent} from "./customer/view/customer-details/customer-details.component";
import {AddOrderFormComponent} from "./order/view/add-order-form/add-order-form.component";
import {EditOrderFormComponent} from "./order/view/edit-order-form/edit-order-form.component";
import {OrderDetailsComponent} from "./order/view/order-details/order-details.component";

const routes: Routes = [
  { path: 'customers', component: CustomersListComponent },
  { path: 'add-customer', component: CustomerAddFormComponent },
  { path: 'customers/:id/edit', component: CustomerEditComponent },
  { path: 'orders/:id/edit', component: EditOrderFormComponent },
  { path: 'customers/:id', component: CustomerDetailsComponent },
  { path: 'orders/:id', component: OrderDetailsComponent },
  { path: 'customers/:id/add-order', component: AddOrderFormComponent },
  { path: '', redirectTo: '', pathMatch: 'full' }, // Domyślna trasa
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
