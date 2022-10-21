import {Component, NgModule, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {RouterModule} from "@angular/router";
import {OfferHttpService} from "../../../../api/services/offer-http.service";
import {first} from "rxjs";
import {Offer} from "../../../../api/models/Offer";
import {CardModule} from "primeng/card";
import {DataViewModule} from "primeng/dataview";
import {DropdownModule} from "primeng/dropdown";
import {SelectItem} from "primeng/api";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-offers',
  templateUrl: './offers.component.html',
  styleUrls: ['./offers.component.css']
})
export class OffersComponent implements OnInit {
  offers: Offer[] = []

  sortOptions: SelectItem[] = [
    {label: 'Price High to Low', value: '!price'},
    {label: 'Price Low to High', value: 'price'}
  ];

  sortKey: string = this.sortOptions[0].value

  sortOrder: number = 1;

  sortField: string = "id";

  constructor(private offerHttpService: OfferHttpService) {
    this.getOffers()
  }

  ngOnInit(): void {
  }

  getOffers(){
    this.offerHttpService.getAll()
      .pipe(first())
      .subscribe({
        next: offers => this.offers = offers,
        error: error => console.error(error)
      })
  }


  onSortChange($event: any) {

  }

}


@NgModule({
  declarations: [
    OffersComponent
  ],
  imports: [
    RouterModule.forChild([{path: "", component: OffersComponent}]),
    CommonModule,
    CardModule,
    DataViewModule,
    DropdownModule,
    FormsModule
  ]
})
export class OffersModule { }
