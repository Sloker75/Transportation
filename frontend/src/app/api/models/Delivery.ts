import {Customer} from "./Customer";
import {State} from "./enums.ts/State";
import {Address} from "./Address";
import {Cargo} from "./Cargo";

export interface Delivery{
  id: number,
  address: Address,
  destination:Address,
  state: State,
  description: string,
  creationDate: string,
  departureDate: string,
  arrivalDate: string,

  customer: Customer,
  cargo: Cargo[]

}
