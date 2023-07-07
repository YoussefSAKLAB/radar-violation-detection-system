import {APP_INITIALIZER, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HeaderComponent} from "./component/header/header.component";
import { VehiclesComponent } from './component/vehicles/vehicles.component';
import { OwnersComponent } from './component/owners/owners.component';
import { RadarsComponent } from './component/radar/radars/radars.component';
import { InfractionsComponent } from './component/infractions/infractions.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { NewRadarComponent } from './component/radar/new-radar/new-radar.component';
import { EditRadarComponent } from './component/radar/edit-radar/edit-radar.component';
import {DashboardComponent} from "./component/dashboard/dashboard.component";
import { AdminTemplateComponent } from './component/admin-template/admin-template.component';
import { WelcomeComponent } from './component/welcome/welcome.component';
import { CommonModule } from '@angular/common';
import {KeycloakAngularModule, KeycloakService} from "keycloak-angular";

function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:8080',
        realm: 'radar-realm',
        clientId: 'infraction-client',
      },
      initOptions: {
        onLoad: 'login-required',
        flow: 'standard',
        checkLoginIframe : true,
        checkLoginIframeInterval: 25
      },
      loadUserProfileAtStartUp : true
    });
}
@NgModule({
    declarations: [
        AppComponent,
        HeaderComponent,
        VehiclesComponent,
        OwnersComponent,
        RadarsComponent,
        InfractionsComponent,
        NewRadarComponent,
        EditRadarComponent,
        DashboardComponent,
        AdminTemplateComponent,
        WelcomeComponent
    ],
  imports: [
    BrowserModule,
    CommonModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    KeycloakAngularModule
  ],
  providers: [{
    provide: APP_INITIALIZER,
    useFactory: initializeKeycloak,
    multi: true,
    deps: [KeycloakService],
  },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
