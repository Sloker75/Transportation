import {SecurityUser} from "./SecurityUser";

export interface Customer{
  id: number,
  name: string,
  lastName: string,
  phoneNumber: string,

  user: SecurityUser,

}
