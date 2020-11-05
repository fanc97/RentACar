import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user.model';

const baseUrl='http://localhost:8080/api/users';
const loginUrl='http://localhost:8080/api/auth/login';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }


  loginUser(user:any):Observable<any>{
    const headers = new HttpHeaders({'Access-Controll-Allow-Origin':'*'});
    return this.http.post(`${loginUrl}`,user,{headers:headers});
  }
  
  register(formData:FormData):Observable<any>{
    return this.http.post(`${baseUrl}`,formData);
  }

  findAllPage(token:any,page:number):Observable<any>{
    const headers = new HttpHeaders({'Authorization':'Bearer '+token});
    return this.http.get(`${baseUrl}`,{headers:headers,observe:'response'});
  }

  searchUsers(token:any,ImeIPrezime:string,korisnickoIme:string,blokiran:boolean,page:number):Observable<any>{
    const headers = new HttpHeaders({'Authorization':'Bearer '+token});
    return this.http.get(`${baseUrl}/search?name=${ImeIPrezime}&username=${korisnickoIme}&enable=${blokiran}&pageNum=${page}`,{headers:headers,observe:'response'});
  }
  
  delete(token:any,id:number):Observable<any>{
    const headers = new HttpHeaders({'Authorization':'Bearer '+token});
    return this.http.delete(`${baseUrl}/${id}`,{headers:headers});
  }
  edit(token:any,id:number,userEdit:any):Observable<any>{
    const headers = new HttpHeaders({'Authorization':'Bearer '+token});
    return this.http.put(`${baseUrl}/${id}`,userEdit,{headers:headers});
  }
  block(token:any,id:number,u:any):Observable<any>{
    const headers = new HttpHeaders({'Authorization':'Bearer '+token});
    return this.http.put(`${baseUrl}/block/${id}`,u,{headers:headers});
  }
}
