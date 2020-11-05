import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const baseUrl="http://localhost:8080/api/rent";

@Injectable({
  providedIn: 'root'
})
export class RentServiceService {

  constructor(private http:HttpClient) { }

  rentACar(token:any,rent:any):Observable<any>{
    const headers = new HttpHeaders({'Authorization':'Bearer '+token});
    return this.http.post(`${baseUrl}`,rent,{headers:headers});
  }

  findAllPage(token:any,page:number):Observable<any>{
    const headers = new HttpHeaders({'Authorization':'Bearer '+token});
    return this.http.get(`${baseUrl}?pageNum=${page}`,{headers:headers,observe:'response'});
  }

  searchRent(token:any,korisnik:string,tip:string,name:string,model:string,page:number):Observable<any>{
    const headers = new HttpHeaders({'Authorization':'Bearer '+token});
    return this.http.get(`${baseUrl}/search?userName=${korisnik}&bodyType=${tip}&name=${name}&model=${model}&pageNum=${page}`,{headers:headers,observe:'response'});
  }
  
  delete(token:any,id:number):Observable<any>{
    const headers = new HttpHeaders({'Authorization':'Bearer '+token});
    return this.http.delete(`${baseUrl}/${id}`,{headers:headers});
  }
  edit(token:any,id:number,editRent:any):Observable<any>{
    const headers = new HttpHeaders({'Authorization':'Bearer '+token});
    return this.http.put(`${baseUrl}/${id}`,editRent,{headers:headers});
  }
}
