import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { AuthGuard } from './auth.guard';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { SignupComponent } from './core/signup/signup.component';
import { LoginComponent } from './core/login/login.component';
import { UserService } from './shared/service/user.service';
import { LoginAuthService } from './shared/service/login-auth.service';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './core/home/home.component';
import { DetaljiComponent } from './core/detalji/detalji.component';
import { IznajmiComponent } from './core/iznajmi/iznajmi.component';
import { AdmindashboardComponent } from './core/admindashboard/admindashboard.component';
import { KorisniciComponent } from './core/admindashboard/korisnici/korisnici.component';
import { VozilaComponent } from './core/admindashboard/vozila/vozila.component';
import { DodajComponent } from './core/admindashboard/vozila/dodaj/dodaj.component';



@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LoginComponent,
    HomeComponent,
    DetaljiComponent,
    IznajmiComponent,
    AdmindashboardComponent,
    KorisniciComponent,
    VozilaComponent,
    DodajComponent,
    
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgbModule,
    BsDatepickerModule.forRoot()
  ],
  providers: [AuthGuard,LoginAuthService,UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
