export class Customer {
  id: string;
  pesel: string;
  name: string;
  surname: string;
  age: number;

  constructor(id: string, pesel: string, name: string, surname: string, age: number) {
    this.id = id;
    this.pesel = pesel;
    this.name = name;
    this.surname = surname;
    this.age = age;
  }
}
