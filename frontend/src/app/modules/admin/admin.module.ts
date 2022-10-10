import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {routing} from "./admin.routing";
import { AdminLayoutComponent } from './layout/admin-layout.component';
import {AdminLayoutModule} from "./layout/admin-layout.module";



@NgModule({
  declarations: [

  ],
  imports: [
    routing,
    AdminLayoutModule
  ]
})
export class AdminModule { }
