export class Order {
  id: string;
  productName: string;
  quantity: number;
  customer: string;

  constructor(id: string, productName: string, quantity: number, customerId: string) {
    this.id = id;
    this.productName = productName;
    this.quantity = quantity;
    this.customer = customerId;
  }
}
