import {Role} from "./enums.ts/Role";

export interface AuthData{
  email: string,
  password: string,
  role: Role,
}
// private Long id;
// private String email;
// private Role role;
