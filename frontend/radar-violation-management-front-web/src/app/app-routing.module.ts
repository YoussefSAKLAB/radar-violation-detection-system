import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DashboardComponent} from "./component/dashboard/dashboard.component";
import {RadarsComponent} from "./component/radar/radars/radars.component";
import {VehiclesComponent} from "./component/vehicles/vehicles.component";
import {InfractionsComponent} from "./component/infractions/infractions.component";
import {NewRadarComponent} from "./component/radar/new-radar/new-radar.component";
import {EditRadarComponent} from "./component/radar/edit-radar/edit-radar.component";
import {AdminTemplateComponent} from "./component/admin-template/admin-template.component";
import {WelcomeComponent} from "./component/welcome/welcome.component";
import {OwnersComponent} from "./component/owners/owners.component";

const routes: Routes = [
  { path: '', redirectTo: '/admin', pathMatch: 'full' },
  {path:"admin",component:AdminTemplateComponent,children:[
      {path : "", component : WelcomeComponent},
      {path : "dashboard", component : DashboardComponent},
      {path : "radars", component : RadarsComponent},
      {path : "vehicles", component : VehiclesComponent},
      {path : "infractions", component : InfractionsComponent},
      {path : "newRadar", component : NewRadarComponent},
      {path : "owners", component : OwnersComponent},
      {path: 'editRadar/:id', component: EditRadarComponent }
    ]},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
