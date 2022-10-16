import { NgModule } from '@angular/core';
import {routing} from "./main.routing";
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
