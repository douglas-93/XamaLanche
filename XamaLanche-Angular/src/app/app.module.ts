import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {SideNavInnerToolbarModule, SideNavOuterToolbarModule, SingleCardModule} from './layouts';
import {
  ChangePasswordFormModule,
  CreateAccountFormModule,
  FooterModule,
  LoginFormModule,
  ResetPasswordFormModule
} from './shared/components';
import {AppInfoService, AuthService, ScreenService} from './shared/services';
import {UnauthenticatedContentModule} from './unauthenticated-content';
import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from "@angular/common/http";
import {LojaService} from "./shared/services/loja.service";
import {ClienteService} from "./shared/services/cliente.service";
import {CepService} from "./shared/services/cep.service";
import {DxFormModule} from "devextreme-angular";

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    SideNavOuterToolbarModule,
    SideNavInnerToolbarModule,
    SingleCardModule,
    FooterModule,
    ResetPasswordFormModule,
    CreateAccountFormModule,
    ChangePasswordFormModule,
    LoginFormModule,
    UnauthenticatedContentModule,
    HttpClientModule,
    AppRoutingModule,
    DxFormModule,
  ],
  providers: [
    AuthService,
    ScreenService,
    AppInfoService,
    CepService,
    LojaService,
    ClienteService
  ],
  exports: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
