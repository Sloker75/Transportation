import {RouterModule, Routes} from "@angular/router";
import {AdminLayoutComponent} from "./layout/admin-layout.component";

const routes: Routes = [
  {
    path: "",
    component: AdminLayoutComponent,
    children:[
      {
        path: "", redirectTo: "users", pathMatch: "full"
      },
      {
        path: "users", loadChildren: ()=> import('./components/users/users.component')
          .then(m => m.UsersModule)
      },
      {
        path: "deliveries", loadChildren: ()=> import('./components/deliveries/deliveries.component')
          .then(m => m.DeliveriesModule)
      },
      {
        path: "offers", loadChildren: ()=> import('./components/offers/offers.component')
          .then(m => m.OffersModule)
      }
    ]
  }
]

export const routing = RouterModule.forChild(routes)
