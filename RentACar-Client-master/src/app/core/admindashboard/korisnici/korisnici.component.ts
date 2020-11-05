import { Component, OnInit } from '@angular/core';
import { CarService } from 'src/app/shared/service/car.service';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'src/app/shared/service/user.service';

@Component({
  selector: 'app-korisnici',
  templateUrl: './korisnici.component.html',
  styleUrls: ['./korisnici.component.css']
})
export class KorisniciComponent implements OnInit {

  forEdit=false;

  private page:number=0;
  private totalPageNumber:Array<number>;

  users:any=[];

  public loginuser:any={};
  public currentStatus:any={};
  constructor(private userService:UserService,private route:Router) {
    if(localStorage.getItem('currentUser')){
      this.currentStatus.status=true;
    }else{
      this.currentStatus.status=false;
    }
    this.loginuser=JSON.parse(localStorage.getItem('currentUser'));
   }
   logout(){
    localStorage.removeItem('currentUser');    
    this.route.navigate(['login']);
  }

  ngOnInit() {
    this.getUsers();
  }

  setPage(i ,event:any){
    event.preventDefault();
    this.page=i;
    this.getUsers();
  }
  getUsers(){
    this.userService.findAllPage(this.loginuser.token,this.page).subscribe((response)=>{ 
      this.users=response.body;
      this.totalPageNumber=Array(Number.parseInt(response.headers.get("totalPages"))).fill(0).map((x,i)=>i);
    })
  }

  userSearch:any={};

  searchUsers(userSearch:any,rentForm:any){
    this.page=0;
    console.log(userSearch);
    
    this.userService.searchUsers(this.loginuser.token,userSearch.imeIPrezime,userSearch.korisnickoIme,!JSON.parse(userSearch.blokiran),this.page).subscribe((response)=>{
      this.users=response.body;
      console.log(response.body);
      this.totalPageNumber=Array(Number.parseInt(response.headers.get("totalPages"))).fill(0).map((x,i)=>i);
    })
  }
  delete(id:number){
    this.userService.delete(this.loginuser.token,id).subscribe((response)=>{
      this.getUsers();
    })
  }
  block(u:any){
    u.enable=!u.enable;
    this.userService.block(this.loginuser.token,u.id,u).subscribe((response)=>{
      this.getUsers();      
    })
  }
  userEdit:any={};
  doneUser:any={};
  openEdit(u:any){
    this.userEdit=u;
    this.userEdit.username=u.username;
    this.userEdit.enable=u.enable;
    this.forEdit=true;
    
    }
  edit(newName:string,userEditForm:any){
    this.doneUser=this.userEdit;
    this.doneUser.name=newName;
    let x=confirm("Are you shure?")
    if(x){    
    this.userService.edit(this.loginuser.token,this.doneUser.id,this.doneUser).subscribe((response)=>{
      this.getUsers();
      this.forEdit=false;
    })
    }
  }

}
