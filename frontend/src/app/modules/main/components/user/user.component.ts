import {Component, NgModule, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {ActivatedRoute, RouterModule} from "@angular/router";
import {LoginComponent} from "../login/login.component";
import {Customer} from "../../../../api/models/Customer";
import {UserHttpService} from "../../../../api/services/user-http.service";
import {first} from "rxjs";
import {error} from "@angular/compiler-cli/src/transformers/util";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  customer?: Customer

  constructor(private userHttpService: UserHttpService) {
  }

  ngOnInit(): void {
  }

  getUser(id: Number){
    // @ts-ignore
    this.userHttpService.get(id)
      .pipe(first())
      .subscribe({
        next: customer => this.customer = customer,
        error: error => console.error(error)
      })
  }

}


@NgModule({
  declarations: [
    UserComponent
  ],
  imports: [
    RouterModule.forChild([{path: "", component: UserComponent}]),
    CommonModule
  ]
})
export class UserModule { }
