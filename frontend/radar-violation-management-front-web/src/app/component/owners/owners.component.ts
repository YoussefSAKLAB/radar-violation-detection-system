import { Component } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {Owner} from "../../models/owner.model";
import {OwnersService} from "../../services/owners.service";
import {Vehicle} from "../../models/vehicle.model";

@Component({
  selector: 'app-owners',
  templateUrl: './owners.component.html',
  styleUrls: ['./owners.component.css']
})
export class OwnersComponent {

  owners! : Owner[];
  errMessage! : string;
  ownerName! :string;

  currentPage : number=0;
  size : number=6;
  totalPages : number=0;
  currentAction : string="all";

  searchFormGroup! : FormGroup;
  selectedVehicleOwner : any;
  isVehicleInfoVisible: boolean = false;
  ownerVehicles! :Vehicle[];

  constructor(private ownersService : OwnersService,
              private fb : FormBuilder,
              private router : Router) {

  }

  ngOnInit(): void {
    this.searchFormGroup = this.fb.group({
      keyword : this.fb.control(null)
    });


    this.getOwners();
  }

  getOwners(): void {
    this.ownersService.getAllOwners()
      .subscribe((data) => {
          // @ts-ignore
          this.owners = data._embedded.owners;
        },
        error => {
          this.errMessage = "Data Not Found !";
        });
  }

  showVehicles(o: Owner) {
    this.isVehicleInfoVisible = true;
    this.ownerVehicles = o.vehicles;
    this.ownerName=o.name;
  }
}
