import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from "@angular/router";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {SecurityService} from "../services/security.service";

@Injectable({providedIn: "root"})
export class NotAuthenticatedGuard implements CanActivate{

  constructor(private securityService: SecurityService,
              private router: Router) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (this.securityService.isAuthenticated()){
      return this.router.createUrlTree(['/deliveries'])
    } else{
      return true;
    }
  }

}
