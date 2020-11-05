import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Route } from '@angular/compiler/src/core';
import { LoginAuthService } from 'src/app/shared/service/login-auth.service';
import { CarService } from 'src/app/shared/service/car.service';

@Component({
  selector: 'app-detalji',
  templateUrl: './detalji.component.html',
  styleUrls: ['./detalji.component.css']
})
export class DetaljiComponent implements OnInit {
  model:any;
  
  dateOfBirth;

  postId:number;
  car={};

  public loginuser:any={};
  public currentStatus:any={};
  constructor(private routes:Router,private route:ActivatedRoute,private authService:LoginAuthService,private carService:CarService) {
    if(localStorage.getItem('currentUser')){
      this.currentStatus.status=true;
    }else{
      this.currentStatus.status=false;
    }
    this.loginuser=JSON.parse(localStorage.getItem('currentUser'));
   }

   logout(){
    localStorage.removeItem('currentUser');    
    this.routes.navigate(['login']);
  }
  ngOnInit() {
    this.route.params.subscribe(params =>{
      this.postId=params["id"];
      console.log(this.postId); 
    });
    this.carService.findCarById(this.postId).subscribe((response)=>{
      this.car=response;
      console.log(this.car);
      
    })
  }

}
