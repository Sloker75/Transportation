import {Component, NgModule, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {RouterModule} from "@angular/router";
import {RestPage} from "../../../../api/models/RestPage";
import {Delivery} from "../../../../api/models/Delivery";
import {SelectItem} from "primeng/api";
import {DeliveryHttpService} from "../../../../api/services/delivery-http.service";
import {first} from "rxjs";
import {DataViewModule} from "primeng/dataview";
import {DropdownModule} from "primeng/dropdown";
import {FormsModule} from "@angular/forms";
import {Pagination} from "../../../../api/models/Pagination";

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
    this.loadData()
  }

  ngOnInit() {

  }



  onSortChange($event: any) {

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
}

@NgModule({
  declarations: [
    DeliveriesComponent
  ],
  imports: [
    RouterModule.forChild([{path: "", component: DeliveriesComponent}]),
    CommonModule,
    DataViewModule,
    DropdownModule,
    FormsModule
  ]
})
export class DeliveriesModule { }
