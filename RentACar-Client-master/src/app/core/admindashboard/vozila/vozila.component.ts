import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/shared/service/user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CarService } from 'src/app/shared/service/car.service';
import { BodyTypeService } from 'src/app/shared/service/body-type.service';
import { CarNameService } from 'src/app/shared/service/car-name.service';
import { CarName } from 'src/app/shared/model/car-name.model';
import { BodyType } from 'src/app/shared/model/body-type.model';

@Component({
  selector: 'app-vozila',
  templateUrl: './vozila.component.html',
  styleUrls: ['./vozila.component.css']
})
export class VozilaComponent implements OnInit {

  forEdit=false;

  private page:number=0;
  private totalPageNumber:Array<number>;

  cars:any=[];
  carNames:CarName[];
  bodyTypes:BodyType[];

  public loginuser:any={};
  public currentStatus:any={};
  constructor(private route:Router,private carService:CarService,private bodyTypeService:BodyTypeService,private carNameService:CarNameService) {
    if(localStorage.getItem('currentUser')){
      this.currentStatus.status=true;
    }else{
      this.currentStatus.status=false;
    }
    this.loginuser=JSON.parse(localStorage.getItem('currentUser'));
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
   getCars(){
    this.carService.findAllCars5(this.page).subscribe((response)=>{ 
      this.cars=response.body;
      
      this.totalPageNumber=Array(Number.parseInt(response.headers.get("totalPages"))).fill(0).map((x,i)=>i);
    })
  }

  setPage(i ,event:any){
    event.preventDefault();
    this.page=i;
    this.getCars();
  }
  carSearch:any={};
  searchCars(carSearch:any,carForm:any){
    this.page=0;
    this.carService.searchCar5(carSearch.tip,carSearch.name,carSearch.model,carSearch.cenaOd,carSearch.cenaDo,this.page).subscribe(response =>{
      this.cars=response.body;
      this.totalPageNumber=Array(Number.parseInt(response.headers.get("totalPages"))).fill(0).map((x,i)=>i);
    })    
  }


  
  car:any={};
  openEdit(c:any){
    this.car=c;
    this.forEdit=true;
    }
  edit(car:any,userEditForm:any){
    
    let x=confirm("Are you shure?")
    if(x){    
      
    }
  }
  delete(id:number){
    this.carService.delete(this.loginuser.token,id).subscribe((response)=>{
      this.getCars();
    })
  }
  logout(){
    localStorage.removeItem('currentUser');    
    this.route.navigate(['login']);
  }
}
