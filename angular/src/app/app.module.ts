import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomersListComponent } from './customer/view/customers-list/customers-list.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CustomerAddFormComponent } from './customer/view/customer-add-form/customer-add-form.component';
import { NavComponent } from './component/nav/nav.component';
import { CustomerEditComponent } from './customer/view/customer-edit/customer-edit.component';
import { CustomerDetailsComponent } from './customer/view/customer-details/customer-details.component';
import { AddOrderFormComponent } from './order/view/add-order-form/add-order-form.component';
import { EditOrderFormComponent } from './order/view/edit-order-form/edit-order-form.component';
import { OrderDetailsComponent } from './order/view/order-details/order-details.component';
import { NgbModule  } from '@ng-bootstrap/ng-bootstrap';

@NgModule({

  declarations: [
    AppComponent,
    CustomersListComponent,
    CustomerAddFormComponent,
    NavComponent,
    CustomerEditComponent,
    CustomerDetailsComponent,
    AddOrderFormComponent,
    EditOrderFormComponent,
    OrderDetailsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
