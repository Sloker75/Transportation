import {RouterModule, Routes} from "@angular/router";
import {MainLayoutComponent} from "./layout/main-layout.component";
import {NotAuthenticatedGuard} from "../../guards/not-authenticated.guard";
import {AuthenticatedGuard} from "../../guards/authenticated.guard";

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
          .then(m => m.DeliveriesModule), canActivate: [AuthenticatedGuard]
      },
      {
        path: "delivery", loadChildren: ()=> import('./components/delivery/delivery.component')
          .then(m => m.DeliveryModule), canActivate: [AuthenticatedGuard]
      },
      {
        path: "offers", loadChildren: ()=> import('./components/offers/offers.component')
          .then(m => m.OffersModule), canActivate: [AuthenticatedGuard]
      },
      {
        path: "offer", loadChildren: ()=> import('./components/offer/offer.component')
          .then(m => m.OfferModule), canActivate: [AuthenticatedGuard]
      },
      {
        path: "user/:id", loadChildren: ()=> import('./components/user/user.component')
          .then(m => m.UserModule), canActivate: [AuthenticatedGuard]
      }
    ]
  }
]

export const routing = RouterModule.forChild(routes)
