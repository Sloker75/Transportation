import { Component } from '@angular/core';
import {UserHttpService} from "./api/services/user-http.service";
import {Customer} from "./api/models/Customer";
import {first} from "rxjs";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';

  customer: Customer[] = []

  constructor(private userHttpService: UserHttpService) {
    this.getAll()
  }

  getAll(){
    this.userHttpService.getAll()
      .pipe(first())
      .subscribe({
      next: customer => this.customer = customer,
      error: error => console.error(error),
    })
  }


}
