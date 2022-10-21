import {Component, OnInit} from '@angular/core';
import {MenuItem} from "primeng/api";
import {AuthHttpService} from "../../../../api/services/auth-http.service";
import {first} from "rxjs";
import {SecurityService} from "../../../../services/security.service";
import {Role} from "../../../../api/models/enums.ts/Role";
import {UntilDestroy, untilDestroyed} from "@ngneat/until-destroy";


@UntilDestroy({checkProperties: true})
@Component({
  selector: 'app-main-header',
  templateUrl: './main-header.component.html',
  styleUrls: ['./main-header.component.css']
})
export class MainHeaderComponent implements OnInit {

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
        label: 'Admin panel',
        icon: 'fa-solid fa-screwdriver-wrench',
        routerLink: '/admin',
        visible: this.securityService.hasRole(Role.ADMIN)
      },
      {
        label: 'User panel',
        icon: 'fa-solid fa-screwdriver-wrench',
        //routerLink: ['/user', this.securityService.getUser().id],
        visible: this.securityService.hasRole(Role.USER || Role.TRANSPORTER)
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
