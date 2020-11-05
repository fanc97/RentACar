import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { CarService } from 'src/app/shared/service/car.service';
import { Car } from 'src/app/shared/model/car.model';
import { LoginAuthService } from 'src/app/shared/service/login-auth.service';
import { Router } from '@angular/router';
import { CarName } from 'src/app/shared/model/car-name.model';
import { BodyType } from 'src/app/shared/model/body-type.model';
import { BodyTypeService } from 'src/app/shared/service/body-type.service';
import { CarNameService } from 'src/app/shared/service/car-name.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  private page:number=0;
  private totalPageNumber:Array<number>;
  
  cars:any=[];
  carNames:CarName[];
  bodyTypes:BodyType[];


  public loginuser:any={};
  public currentStatus:any={};
  constructor(private carService:CarService,private carNameService:CarNameService,private bodyTypeService:BodyTypeService,private route:Router) { 
    this.loginuser=JSON.parse(localStorage.getItem('currentUser'));
    if(localStorage.getItem('currentUser')){
      this.currentStatus.status=true;
    }else{
      this.currentStatus.status=false;
    }    
  }

  ngOnInit() {
   this.getCars();
   
    this.bodyTypeService.findAll().subscribe((response)=>{
      this.bodyTypes=response;
    })
    this.carNameService.findAll().subscribe((response)=>{
      this.carNames=response;
    })
  }
  logout(){
    localStorage.removeItem('currentUser');    
    this.route.navigate(['login']);
  }
  setPage(i ,event:any){
    event.preventDefault();
    this.page=i;
    this.getCars();
  }
  getCars(){
    this.carService.findAllCars(this.page).subscribe((response)=>{ 
      this.cars=response.body;
      this.totalPageNumber=Array(Number.parseInt(response.headers.get("totalPages"))).fill(0).map((x,i)=>i);
    })
  }

  carSearch:any={};
  searchCars(carSearch:any,carForm:any){
    this.page=0;
    this.carService.searchCar(carSearch.tip,carSearch.name,carSearch.model,carSearch.cenaOd,carSearch.cenaDo,this.page).subscribe(response =>{
      this.cars=response.body;
      this.totalPageNumber=Array(Number.parseInt(response.headers.get("totalPages"))).fill(0).map((x,i)=>i);
    })    
  }
}
