import {Injectable} from "@angular/core";
import {API_URL} from "../../config/Constants";
import {HttpClient} from "@angular/common/http";
import {AuthData} from "../models/AuthData";
import {SecurityUser} from "../models/SecurityUser";

@Injectable({providedIn: "root"})
export class AuthHttpService{
  private readonly URL = `${API_URL}/auth`;

  constructor(private http: HttpClient) {
  }

  login(authData: AuthData){
    return this.http.post<SecurityUser>(`${this.URL}/login`, authData)
  }

  logout(){
    return this.http.post(`${this.URL}/logout`, {responseType: 'text'})
  }

}
