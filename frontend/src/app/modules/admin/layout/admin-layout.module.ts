import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AdminLayoutComponent} from "./admin-layout.component";
import {RouterModule} from "@angular/router";
import { AdminHeaderComponent } from './admin-header/admin-header.component';



@NgModule({
  declarations: [
    AdminLayoutComponent,
    AdminHeaderComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
  ]
})
export class AdminLayoutModule { }
