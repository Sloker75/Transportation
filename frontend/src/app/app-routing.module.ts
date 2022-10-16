import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {AdminGuard} from "./guards/admin.guard";

const routes: Routes = [
  {
    path: "admin",loadChildren: ()=> import('./modules/admin/admin.module').then(m => m.AdminModule),
    canActivate: [AdminGuard]
  },
  {
    path: "",loadChildren: ()=> import('./modules/main/main.module').then(m => m.MainModule)
  },
  {
    path: "deliveries",loadChildren: ()=> import('./modules/main/components/deliveries/deliveries.component')
      .then(m => m.DeliveriesModule)
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
