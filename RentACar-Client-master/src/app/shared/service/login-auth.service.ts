import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginAuthService {
  private subject= new Subject<any>();
  isLoggedIn(){
    console.log(localStorage.getItem('currentUser'));
    if(localStorage.getItem('currentUser')){
      this.subject.next({status:true});
    }else{
      this.subject.next({status:false});
    }
  }
  clearStatus(){
    this.subject.next();

  }
  getSutatus():Observable<any>{
    return this.subject.asObservable();
  }
  
  constructor() { }

}
