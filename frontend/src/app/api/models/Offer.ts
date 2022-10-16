import {State} from "./enums.ts/State";
import {Delivery} from "./Delivery";
// @ts-ignore
import {Transporter} from "./Transporter";

export interface Offer{
  id: number,
  transportationInfo: string,
  price: number,
  state: State,
  transporter: Transporter,
  delivery: Delivery

}
