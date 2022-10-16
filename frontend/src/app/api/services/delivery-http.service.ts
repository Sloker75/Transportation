import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {API_URL} from "../../config/Constants";
import {Delivery} from "../models/Delivery";
import {RestPage} from "../models/RestPage";

@Injectable({providedIn: 'root'})
export class DeliveryHttpService {
  private readonly URL = `${API_URL}/deliveries`;

  constructor(private http: HttpClient) {
  }

  getAll(){
    return this.http.get<RestPage<Delivery>>(this.URL)
  }

  get(id: number){
    return this.http.get<Delivery>(`${this.URL}/${id}`)
  }

  delete(id: number){
    return this.http.delete<Delivery>(`${this.URL}/${id}`)
  }


}
