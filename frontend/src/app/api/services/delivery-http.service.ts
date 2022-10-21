import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {API_URL} from "../../config/Constants";
import {Delivery} from "../models/Delivery";
import {RestPage} from "../models/RestPage";
import {Pagination} from "../models/Pagination";

@Injectable({providedIn: 'root'})
export class DeliveryHttpService {
  private readonly URL = `${API_URL}/deliveries`;

  constructor(private http: HttpClient) {
  }

  getAll(pagination: Pagination){
    const params = new HttpParams({fromObject: {...pagination}})
    return this.http.get<RestPage<Delivery>>(this.URL, {params})
  }

  get(id: number){
    return this.http.get<Delivery>(`${this.URL}/${id}`)
  }

  delete(id: number){
    return this.http.delete<Delivery>(`${this.URL}/${id}`)
  }


}
