import {Component, NgModule, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {RouterModule} from "@angular/router";
import {UserHttpService} from "../../../../api/services/user-http.service";
import {Customer} from "../../../../api/models/Customer";
import {error} from "@angular/compiler-cli/src/transformers/util";
import {first} from "rxjs";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  customers : Customer[] = []

  constructor(private userHttpService: UserHttpService) {
    this.getCustomers()
  }

  ngOnInit(): void {
  }

  getCustomers(){
    this.userHttpService.getAll()
      .pipe(first())
      .subscribe({
        next: customers => this.customers = customers,
        error: error => console.error(error)
      })
  }

}


@NgModule({
  declarations: [
    UsersComponent
  ],
  imports: [
    RouterModule.forChild([{path: "", component: UsersComponent }]),
    CommonModule
  ]
})
export class UsersModule { }
