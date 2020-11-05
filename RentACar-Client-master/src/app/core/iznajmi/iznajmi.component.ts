import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LoginAuthService } from 'src/app/shared/service/login-auth.service';
import { CarService } from 'src/app/shared/service/car.service';
import { RentServiceService } from 'src/app/shared/service/rent-service.service';

@Component({
  selector: 'app-iznajmi',
  templateUrl: './iznajmi.component.html',
  styleUrls: ['./iznajmi.component.css']
})
export class IznajmiComponent implements OnInit {

  postId:number;

  fromDate:any;
  toDate:any;
 
  car:any={};
  rent:any={};

  public loginuser:any={};
  public currentStatus:any={};
  constructor(private route:ActivatedRoute,private authService:LoginAuthService,private carService:CarService,private rentService:RentServiceService) {
    if(localStorage.getItem('currentUser')){
      this.currentStatus.status=true;
    }else{
      this.currentStatus.status=false;
    }
    this.loginuser=JSON.parse(localStorage.getItem('currentUser'));
   }

  ngOnInit() {
    this.route.params.subscribe(params =>{
      this.postId=params["id"];
    });
    this.carService.findCarById(this.postId).subscribe((response)=>{
      this.car=response;
    })
  }
  iznajmi(){
    if(this.fromDate.year>this.toDate.year){
      alert('You cant go in past');
      return;
    }
    if(this.fromDate.month>this.toDate.month){
      alert('You cant go in past');
      return;
    }
    
      if(this.fromDate.year<this.toDate.year){
        alert('You can rent a car just in month');
        return;
      }
      if(this.fromDate.month<this.toDate.month){
        alert('You can rent a car just in month');
        return;
      }
      if(this.fromDate.day<this.toDate.day){
        let x=confirm("Are you shure");
        if(x){
        let totalPrice=(this.toDate.day-this.fromDate.day)*this.car.pricePerDay;
        let sendFromDate=`${this.fromDate.year}-${this.fromDate.month}-${this.fromDate.day}`;
        let sendToDate=`${this.toDate.year}-${this.toDate.month}-${this.toDate.day}`;
        
        this.rentService.rentACar(this.loginuser.token,{
          "totalPrice":totalPrice,
          "carId":this.car.id,
          "userId":this.loginuser.user.id,
          "fromDate":sendFromDate.toString(),
          "toDate":sendToDate.toString()
        }).subscribe((response)=>{
          console.log(response);
          
        },error=>{
          console.log(error);
          
        })
        }
      }
    
  }

}
