import {Component, OnInit} from '@angular/core';
import {MenuItem} from "primeng/api";
import {AuthHttpService} from "../../../../api/services/auth-http.service";
import {SecurityService} from "../../../../services/security.service";
import {first, takeUntil} from "rxjs";
import {Role} from "../../../../api/models/enums.ts/Role";
import {UntilDestroy, untilDestroyed} from "@ngneat/until-destroy";


@UntilDestroy({checkProperties: true})
@Component({
  selector: 'app-admin-header',
  templateUrl: './admin-header.component.html',
  styleUrls: ['./admin-header.component.css']
})
export class AdminHeaderComponent implements OnInit{

  userMenuItems: MenuItem[] = [];


  constructor(private authHttpService: AuthHttpService,
              private securityService: SecurityService) {
    this.inutUserMenuItems()

    this.securityService.isAuthenticated$
      .pipe(untilDestroyed(this))
      .subscribe(isAuthenticated => {
        this.inutUserMenuItems(isAuthenticated);
      })
  }

  ngOnInit(): void {
  }

  logout(){
    this.authHttpService.logout()
      .pipe(first())
      .subscribe({
        next: () => this.securityService.logout(),
        error: error => console.log(error)
      })
  }

  inutUserMenuItems(isAuthenticated : boolean = this.securityService.isAuthenticated()){
    this.userMenuItems = [
      {
        label: 'Login',
        icon: 'fa-solid fa-right-to-bracket',
        routerLink: '/login',
        visible: !isAuthenticated
      },
      {
        label: 'View web site',
        icon: 'fa-solid fa-computer',
        routerLink: '/deliveries',
      },
      {
        label: 'Users',
        icon: 'fa-solid fa-user',
        routerLink: '/admin',
      },
      {
        label: 'Deliveries',
        icon: 'fa-solid fa-list-check',
        routerLink: '/admin/deliveries',
      },
      {
        label: 'Offers',
        icon: 'fa-solid fa-clipboard-list',
        routerLink: '/admin/offers',
      },
      {
        label: 'Logout',
        icon: 'fa-solid fa-right-from-bracket',
        command: () => this.logout(),
        visible: isAuthenticated
      }
    ];
  }

}
