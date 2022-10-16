import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from "@angular/router";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {SecurityService} from "../services/security.service";
import {Role} from "../api/models/enums.ts/Role";

@Injectable({providedIn: "root"})
export class AdminGuard implements CanActivate{

  constructor(private securityService: SecurityService,
              private router: Router) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (this.securityService.hasRole(Role.ADMIN)){
      return true;
    } else{
      return this.router.createUrlTree(['/'])
    }
  }

}
