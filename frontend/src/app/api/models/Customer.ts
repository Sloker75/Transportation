import {AuthData} from "./AuthData";

export interface Customer{
  id: number,
  name: string,
  lastName: string,
  phoneNumber: string,

  authData: AuthData,

}
