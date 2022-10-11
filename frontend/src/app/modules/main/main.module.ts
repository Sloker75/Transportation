import { NgModule } from '@angular/core';
import {routing} from "./main.routing";
import {MainLayoutModule} from "./layout/main-layout.module";
import { DeliveriesComponent } from './components/deliveries/deliveries.component';
import { DeliveryComponent } from './components/delivery/delivery.component';


@NgModule({
  declarations: [

  
    DeliveriesComponent,
        DeliveryComponent
  ],
  imports: [
    routing,
    MainLayoutModule
  ]
})
export class MainModule { }
