import {RouterModule, Routes} from "@angular/router";
import {MainLayoutComponent} from "./layout/main-layout.component";
import {NotAuthenticatedGuard} from "../../guards/not-authenticated.guard";

const routes: Routes = [
  {
    path: "",
    component: MainLayoutComponent,
    children:[
      {
        path: "", redirectTo: "login", pathMatch: "full"
      },
      {
        path: "login", loadChildren: ()=> import('./components/login/login.component')
          .then(m => m.LoginModule), canActivate: [NotAuthenticatedGuard]
      },
      {
        path: "deliveries", loadChildren: ()=> import('./components/deliveries/deliveries.component')
          .then(m => m.DeliveriesModule)
      }
    ]
  }
]

export const routing = RouterModule.forChild(routes)
