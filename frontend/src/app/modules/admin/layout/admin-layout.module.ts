import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AdminLayoutComponent} from "./admin-layout.component";
import {RouterModule} from "@angular/router";
import { AdminHeaderComponent } from './admin-header/admin-header.component';
import {AvatarModule} from "primeng/avatar";
import {MenuModule} from "primeng/menu";



@NgModule({
  declarations: [
    AdminLayoutComponent,
    AdminHeaderComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    AvatarModule,
    MenuModule,
  ]
})
export class AdminLayoutModule { }
