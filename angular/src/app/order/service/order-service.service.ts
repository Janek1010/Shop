import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Order} from "../model/order.model";
import {v4 as uuidv4} from "uuid";
import {Customer} from "../../customer/model/customer.model";

@Injectable({
  providedIn: 'root'
})
export class OrderServiceService {
  private readonly apiUrl = '/api/orders';
  private readonly apiByIdUrl = '/api/orders/{id}';
  private readonly apiByIdUrlOrders = '/api/customers/{id}/orders';

  constructor(private http: HttpClient) {
  }

  getOrdersByCustomerId(id: string): Observable<any[]> {
    const url = this.apiByIdUrlOrders.replace('{id}', id);
    console.log(url);
    return this.http.get<any[]>(url);
  }

  deleteOrder(id: string) {
    const url = this.apiByIdUrl.replace('{id}', id);
    return this.http.delete(url);
  }

  addOrder(order: Order): Observable<any> {
    order.id = uuidv4();
    return this.http.put<any>(`${this.apiUrl}/${order.id}`, order);
  }

  updateOrder(order: Order): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${order.id}`, order);
  }
  getOrderById(id: string): Observable<Order> {
    const url = this.apiByIdUrl.replace('{id}', id);
    return this.http.get<Order>(url);
  }
}
