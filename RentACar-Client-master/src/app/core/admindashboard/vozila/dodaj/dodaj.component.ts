import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms';
import { CarService } from 'src/app/shared/service/car.service';
import { BodyTypeService } from 'src/app/shared/service/body-type.service';
import { CarNameService } from 'src/app/shared/service/car-name.service';
import { CarName } from 'src/app/shared/model/car-name.model';
import { BodyType } from 'src/app/shared/model/body-type.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dodaj',
  templateUrl: './dodaj.component.html',
  styleUrls: ['./dodaj.component.css']
})
export class DodajComponent implements OnInit {


  reactiveForm:any=FormGroup;
  userFile:any=File;

  carNames:CarName[];
  bodyTypes:BodyType[];
  models:any=[];
  driveTypes:any=[]
  fuelTypes:any=[];
  transmissionTypes:any=[];
  manufcaturers:any=[];

  public loginuser:any={};
  public currentStatus:any={};
  constructor(private route:Router,private fb:FormBuilder,private carService:CarService,private bodyTypeService:BodyTypeService,private carNameService:CarNameService) {
    if(localStorage.getItem('currentUser')){
      this.currentStatus.status=true;
    }else{
      this.currentStatus.status=false;
    }
    this.loginuser=JSON.parse(localStorage.getItem('currentUser'));

    this.reactiveForm=this.fb.group({
      carNameId: new FormControl(),
      enginePower: new FormControl(),
      doors: new FormControl(),
      modelId: new FormControl(),
      engineVolume: new FormControl(),
      seats: new FormControl(),
      driveTypeId: new FormControl(),
      transmissionTypeId: new FormControl(),
      gearNumber: new FormControl(),
      description: new FormControl(),
      bodyTypeId: new FormControl(),
      fuelTypeId: new FormControl(),
      pricePerDay: new FormControl(),
      manufacturerId: new FormControl()
    });
   }

  ngOnInit() {
    this.bodyTypeService.findAll().subscribe((response)=>{
      this.bodyTypes=response;
    })
    this.carNameService.findAll().subscribe((response)=>{
      this.carNames=response;
    })
    this.bodyTypeService.findAllFT().subscribe((response)=>{
      this.fuelTypes=response;
    })
    this.bodyTypeService.findAllDT().subscribe((response)=>{
      this.driveTypes=response;
    })
    this.bodyTypeService.findAllTT().subscribe((response)=>{
      this.transmissionTypes=response;
    })
    this.bodyTypeService.findAllModel().subscribe((response)=>{
      this.models=response;
    })
    this.bodyTypeService.findAllManu().subscribe((response)=>{
      this.manufcaturers=response;
    })
    
  }

  onSelectFile(event){
    this.userFile=event.target.files[0];
  }
  newCar:any={};
  addCar(submitForm:FormGroup){
      this.newCar=submitForm.value;
      const car=submitForm.value;
      const formData= new FormData();
      formData.append('car',JSON.stringify(car));
      formData.append('file',this.userFile);
      this.carService.newCar(this.loginuser.token,formData).subscribe((response)=>{
      });
      this.reactiveForm.reset();
    
  }
  logout(){
    localStorage.removeItem('currentUser');    
    this.route.navigate(['login']);
  }
}
