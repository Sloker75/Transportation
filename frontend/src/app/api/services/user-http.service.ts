import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Customer} from "../models/Customer";
import {API_URL} from "../../config/Constants";
import {RestPage} from "../models/RestPage";
import {Pagination} from "../models/Pagination";
import * as http from "http";

@Injectable({providedIn: 'root'})
export class UserHttpService {
  private readonly URL = `${API_URL}/customers`;

  constructor(private http: HttpClient) {
  }

  getAll(pagination: Pagination){
    const params = new HttpParams({fromObject: {...pagination}})
    return this.http.get<RestPage<Customer>>(this.URL, {params})
  }

  get(id: number){
    return this.http.get<Customer>(`${this.URL}/${id}`)
  }

  create(customer: Customer){
    return this.http.post<void>(this.URL, customer)
  }

  update(customer: Customer){
    return this.http.put<void>(`${this.URL}/${customer.id}`, customer)
  }

  delete(id: number){
    return this.http.delete<Customer>(`${this.URL}/${id}`)
  }


}
