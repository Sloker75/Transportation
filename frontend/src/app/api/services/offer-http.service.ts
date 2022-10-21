import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {API_URL} from "../../config/Constants";
import {Offer} from "../models/Offer";

@Injectable({providedIn: 'root'})
export class OfferHttpService {
  private readonly URL = `${API_URL}/offers`;

  constructor(private http: HttpClient) {
  }

  getAll(){
    return this.http.get<Offer[]>(this.URL)
  }

  get(id: number){
    return this.http.get<Offer>(`${this.URL}/${id}`)
  }

  delete(id: number){
    return this.http.delete<Offer>(`${this.URL}/${id}`)
  }


}
