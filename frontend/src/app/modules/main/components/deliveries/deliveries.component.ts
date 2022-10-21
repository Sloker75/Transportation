import {Component, NgModule, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {Delivery} from "../../../../api/models/Delivery";
import {SelectItem} from "primeng/api";
import {FormsModule} from "@angular/forms";
import {DropdownModule} from "primeng/dropdown";
import {DataViewModule} from "primeng/dataview";
import {RatingModule} from "primeng/rating";
import {ButtonModule} from "primeng/button";
import {DeliveryHttpService} from "../../../../api/services/delivery-http.service";
import {RouterModule} from "@angular/router";
import {RestPage} from "../../../../api/models/RestPage";
import {InputTextModule} from "primeng/inputtext";
import {AuthHttpService} from "../../../../api/services/auth-http.service";
import {SecurityService} from "../../../../services/security.service";
import {untilDestroyed} from "@ngneat/until-destroy";
import {Role} from "../../../../api/models/enums.ts/Role";
import {Pagination} from "../../../../api/models/Pagination";
import {first} from "rxjs";

@Component({
  selector: 'app-deliveries',
  templateUrl: './deliveries.component.html',
  styleUrls: ['./deliveries.component.css']
})
export class DeliveriesComponent implements OnInit {

  deliveries: RestPage<Delivery> = new RestPage<Delivery>();
  isCustomer: boolean = false;
  isTransporter: boolean = false;


  sortOptions: SelectItem[] = [
    {label: 'Price High to Low', value: '!price'},
    {label: 'Price Low to High', value: 'price'}
  ];

  sortKey: string = this.sortOptions[0].value

  sortOrder: number = 1;

  sortField: string = "id";

  constructor(private deliveryHttpService: DeliveryHttpService,
              private authHttpService: AuthHttpService,
              private securityService: SecurityService) {
    this.securityService.isAuthenticated$
      .pipe(first())
      .subscribe(isAuthenticated => {
        this.isCustomer = this.securityService.hasRole(Role.USER);
        this.isTransporter = this.securityService.hasRole(Role.TRANSPORTER);
      })
    this.loadData()
  }

  ngOnInit() {

  }

  onLazyLoad(event: any) {
    this.loadData(Pagination.fromPrimeNg(event))
  }

  loadData(pagination: Pagination = new Pagination()){
    this.deliveryHttpService.getAll(pagination)
      .pipe(first())
      .subscribe({
        next: deliveries => {
          console.log(deliveries)
          this.deliveries = deliveries;
        },
        error: error => console.error(error)
      })
  }


  onSortChange($event: any) {

  }
}


@NgModule({
  declarations: [
    DeliveriesComponent
  ],
  imports: [
    RouterModule.forChild([{path: "", component: DeliveriesComponent}]),
    CommonModule,
    FormsModule,
    DropdownModule,
    DataViewModule,
    RatingModule,
    ButtonModule,
    InputTextModule
  ]
})
export class DeliveriesModule { }



