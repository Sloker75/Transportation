import {Component, NgModule, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {RouterModule} from "@angular/router";
import {UserHttpService} from "../../../../api/services/user-http.service";
import {Customer} from "../../../../api/models/Customer";
import {error} from "@angular/compiler-cli/src/transformers/util";
import {first} from "rxjs";
import {TableModule} from "primeng/table";
import {DropdownModule} from "primeng/dropdown";
import {FormsModule} from "@angular/forms";
import {RestPage} from "../../../../api/models/RestPage";
import {Pagination} from "../../../../api/models/Pagination";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  customers : RestPage<Customer> = new RestPage<Customer>()

  constructor(private userHttpService: UserHttpService) {
  }

  ngOnInit(): void {
  }


  onLazyLoad(event: any) {
    this.loadData(Pagination.fromPrimeNg(event))
  }

  loadData(pagination: Pagination = new Pagination()){
    this.userHttpService.getAll(pagination)
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
    RouterModule.forChild([{path: "", component: UsersComponent}]),
    CommonModule,
    TableModule,
    DropdownModule,
    FormsModule
  ]
})
export class UsersModule { }
