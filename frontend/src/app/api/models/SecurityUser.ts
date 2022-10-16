import {Role} from "./enums.ts/Role";

export interface SecurityUser{
  id: number,
  email: string,
  role: Role,
}
