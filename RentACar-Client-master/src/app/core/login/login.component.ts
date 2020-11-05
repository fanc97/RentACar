import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/shared/service/user.service';
import { Route, Router } from '@angular/router';
import { AuthGuard } from 'src/app/auth.guard';
import { LoginAuthService } from 'src/app/shared/service/login-auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user:any={};

  constructor(private userService:UserService,private router:Router,private authGuard:LoginAuthService) {
    this.authGuard.isLoggedIn();
   }

  ngOnInit() {

    
  }
  loginUser(user:any){
    this.userService.loginUser(user).subscribe((response)=>{
      if(response){
        if(response.token){
          
          localStorage.setItem('currentUser',JSON.stringify(response));
            if(response.user.userAuthority[0].authority==='ROLE_ADMIN'){
            this.router.navigate(['/admindashboard']);
          }else{
            this.router.navigate(['/home']);
          }
        }
      }
    })
  }
}
