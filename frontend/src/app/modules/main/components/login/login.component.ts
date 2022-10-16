import {Component, NgModule, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {ButtonModule} from "primeng/button";
import {InputTextModule} from "primeng/inputtext";
import {AuthHttpService} from "../../../../api/services/auth-http.service";
import {first} from "rxjs";
import {SecurityService} from "../../../../services/security.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  authData = {
    email: '',
    password: ''
  }

  constructor(private authHttpService: AuthHttpService,
              private securityService: SecurityService) {
    this.login();
  }

  ngOnInit(): void {
  }

  login() {
    this.authHttpService.login(this.authData)
      .pipe(first())
      .subscribe({
        next: user => this.securityService.login(user),
        error: error => console.log(error)
      })
  }
}

@NgModule({
  declarations: [
    LoginComponent
  ],
  imports: [
    RouterModule.forChild([{path: "", component: LoginComponent}]),
    CommonModule,
    FormsModule,
    InputTextModule,
    ButtonModule
  ]
})
export class LoginModule { }
