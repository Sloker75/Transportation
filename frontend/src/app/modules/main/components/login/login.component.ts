import {Component, NgModule, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {ButtonModule} from "primeng/button";
import {InputTextModule} from "primeng/inputtext";

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

  constructor() { }

  ngOnInit(): void {
  }

  login() {
    console.log(this.authData.email)
    console.log(this.authData.password)
    return false;
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
