import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {routing} from "./main.routing";
import {MainLayoutComponent} from "./layout/main-layout.component";
import {MainLayoutModule} from "./layout/main-layout.module";


@NgModule({
  declarations: [

  ],
  imports: [
    routing,
    MainLayoutModule
  ]
})
export class MainModule { }
