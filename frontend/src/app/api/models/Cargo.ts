import {Unit} from "./enums.ts/Unit";

export interface Cargo{
  id: number,
  itemName: string,
  weight: number,
  unit: Unit,
  quantity: number
}
