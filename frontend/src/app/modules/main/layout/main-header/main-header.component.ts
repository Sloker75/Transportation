import {Component, OnInit} from '@angular/core';
import {MenuItem} from "primeng/api";

@Component({
  selector: 'app-main-header',
  templateUrl: './main-header.component.html',
  styleUrls: ['./main-header.component.css']
})
export class MainHeaderComponent implements OnInit {

  userMenuItems: MenuItem[] = [
    {
      label: 'Login',
      icon: 'fa-solid fa-right-to-bracket',
      routerLink: '/login'
    },
    {
      label: 'Admin panel',
      icon: 'fa-solid fa-screwdriver-wrench',
      routerLink: '/admin',
    },
    {
      label: 'Logout',
      icon: 'fa-solid fa-right-from-bracket'
    }
  ];


  constructor() {
  }

  ngOnInit(): void {
  }

}
