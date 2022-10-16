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
import {first} from "rxjs";
import {RouterModule} from "@angular/router";
import {LoginComponent} from "../login/login.component";
import {RestPage} from "../../../../api/models/RestPage";
import {InputTextModule} from "primeng/inputtext";

@Component({
  selector: 'app-deliveries',
  templateUrl: './deliveries.component.html',
  styleUrls: ['./deliveries.component.css']
})
export class DeliveriesComponent implements OnInit {

  deliveries: RestPage<Delivery> = new RestPage<Delivery>();

  sortOptions: SelectItem[] = [
    {label: 'Price High to Low', value: '!price'},
    {label: 'Price Low to High', value: 'price'}
  ];

  sortKey: string = this.sortOptions[0].value

  sortOrder: number = 1;

  sortField: string = "id";

  constructor(private deliveryHttpService: DeliveryHttpService) {
    this.getDeliveries()
  }

  ngOnInit() {

  }

  getDeliveries(){
    this.deliveryHttpService.getAll()
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



