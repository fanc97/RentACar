import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RentServiceService } from 'src/app/shared/service/rent-service.service';
import { BodyTypeService } from 'src/app/shared/service/body-type.service';
import { CarNameService } from 'src/app/shared/service/car-name.service';
import { CarName } from 'src/app/shared/model/car-name.model';
import { BodyType } from 'src/app/shared/model/body-type.model';
import { CarService } from 'src/app/shared/service/car.service';
import { Car } from 'src/app/shared/model/car.model';

@Component({
  selector: 'app-admindashboard',
  templateUrl: './admindashboard.component.html',
  styleUrls: ['./admindashboard.component.css']
})
export class AdmindashboardComponent implements OnInit {

  forEdit=false;

  private page:number=0;
  private totalPageNumber:Array<number>;

  rents:any=[];
  bodyTypes:BodyType[];
  carNames:CarName[];
  cars:Car[];

  rentSearch:any={};

  public loginuser:any={};
  public currentStatus:any={};
  constructor(private carService:CarService,private route:ActivatedRoute,private rentService:RentServiceService,private bodyTypeService:BodyTypeService,private carNameService:CarNameService) {
    if(localStorage.getItem('currentUser')){
      this.currentStatus.status=true;
    }else{
      this.currentStatus.status=false;
    }
    this.loginuser=JSON.parse(localStorage.getItem('currentUser'));
   }

  ngOnInit() {
    this.getRents();

    this.bodyTypeService.findAll().subscribe((response)=>{
      this.bodyTypes=response;
    })
    this.carNameService.findAll().subscribe((response)=>{
      this.carNames=response;
    })
    this.carService.findAll().subscribe(response=>{
      this.cars=response;
      console.log(this.cars);
      
    })
  }

  setPage(i ,event:any){
    event.preventDefault();
    this.page=i;
    this.getRents();
  }

  getRents(){
    this.rentService.findAllPage(this.loginuser.token,this.page).subscribe((response)=>{ 
      this.rents=response.body;
      console.log(this.rents);
      
      this.totalPageNumber=Array(Number.parseInt(response.headers.get("totalPages"))).fill(0).map((x,i)=>i);
    })
  }

  searchRents(rentSearch:any,rentForm:any){
    this.page=0;
    this.rentService.searchRent(this.loginuser.token,rentSearch.korisnik,rentSearch.tip,rentSearch.name,rentSearch.model,this.page).subscribe((response)=>{
      this.rents=response.body;
      console.log(response.body);
      this.totalPageNumber=Array(Number.parseInt(response.headers.get("totalPages"))).fill(0).map((x,i)=>i);
    })
  }
  delete(event){
    let id=event;
    this.rentService.delete(this.loginuser.token,id).subscribe((response)=>{
      this.getRents();
    })
  }
  logout(){
    localStorage.removeItem('currentUser');    
    this.route.navigate(['login']);
  }

  rentEdit:any={};
  openEdit(r:any){
    this.rentEdit.id=r.id;
    this.rentEdit.userName=r.userName;
    this.rentEdit.fromDate=r.fromDate;
    this.rentEdit.toDate=r.toDate;
    this.rentEdit.userId=r.userId;
    this.forEdit=true;
  }
  edit(rentEdit:any,rentEditForm:any){
    let x=confirm("Are you shure?")
    if(x){
    let int =parseInt(this.rentEdit.carId);
    this.rentEdit.carId=int;
    this.rentService.edit(this.loginuser.token,rentEdit.id,rentEdit).subscribe((response)=>{
      this.getRents();
      this.forEdit=false;
    })
  }
  }
}
