import { NgModule } from "@angular/core";
import {Routes,RouterModule} from "@angular/router"
import { SignupComponent } from './core/signup/signup.component';
import { HomeComponent } from './core/home/home.component';
import { LoginComponent } from './core/login/login.component';
import { DetaljiComponent } from './core/detalji/detalji.component';
import { IznajmiComponent } from './core/iznajmi/iznajmi.component';
import { AuthGuard } from './auth.guard';
import { AdmindashboardComponent } from './core/admindashboard/admindashboard.component';
import { VozilaComponent } from './core/admindashboard/vozila/vozila.component';
import { KorisniciComponent } from './core/admindashboard/korisnici/korisnici.component';
import { DodajComponent } from './core/admindashboard/vozila/dodaj/dodaj.component';



const appRoutes: Routes=[
    {path:'home',component:HomeComponent},
    {path:'signup',component:SignupComponent},
    {path:'login',component:LoginComponent},
    {path:'detalji/:id',component:DetaljiComponent},
    {path:'iznajmi/:id',component:IznajmiComponent,canActivate:[AuthGuard]},
    {path:'admindashboard',component:AdmindashboardComponent,canActivate:[AuthGuard]},
    {path:'admindashboard/vozila',component:VozilaComponent,canActivate:[AuthGuard]},
    {path:'admindashboard/vozila/dodaj',component:DodajComponent,canActivate:[AuthGuard]},
    {path:'admindashboard/korisnici',component:KorisniciComponent,canActivate:[AuthGuard]},


    


    {path:'**',pathMatch:'full',redirectTo:'home'},
    
];
@NgModule({
imports: [RouterModule.forRoot(appRoutes)],
exports: [RouterModule]
})
export class AppRoutingModule{

}