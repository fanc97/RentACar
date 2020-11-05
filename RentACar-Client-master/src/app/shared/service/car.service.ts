import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Car } from '../model/car.model';

const baseUrl="http://localhost:8080/api/cars";
@Injectable({
  providedIn: 'root'
})
export class CarService {

  constructor(private http:HttpClient) { }

  findAllCars(page:number):Observable<any>{
    const headers = new HttpHeaders();
    return this.http.get(`${baseUrl}?pageNum=${page}`,{headers:headers,observe:'response'});
  }
  findAllCars5(page:number):Observable<any>{
    const headers = new HttpHeaders();
    return this.http.get(`${baseUrl}/admin?pageNum=${page}`,{headers:headers,observe:'response'});
  }
  searchCar(tip:string,name:string,model:string,cenaOd:number,cenaDo:number,page:number):Observable<any>{
    const headers = new HttpHeaders();
    return this.http.get(`${baseUrl}/search?bodyType=${tip}&name=${name}&model=${model}&minPrice=${cenaOd}&maxPrice=${cenaDo}&page=${page}`,{headers:headers,observe:'response'});
  }
  searchCar5(tip:string,name:string,model:string,cenaOd:number,cenaDo:number,page:number):Observable<any>{
    const headers = new HttpHeaders();
    return this.http.get(`${baseUrl}/search5?bodyType=${tip}&name=${name}&model=${model}&minPrice=${cenaOd}&maxPrice=${cenaDo}&page=${page}`,{headers:headers,observe:'response'});
  }
  findCarById(id:number):Observable<any>{
    return this.http.get(`${baseUrl}/${id}`);
  }
  delete(token:any,id:number):Observable<any>{
    const headers = new HttpHeaders({'Authorization':'Bearer '+token});
    return this.http.delete(`${baseUrl}/${id}`,{headers:headers});
  }
  findAll():Observable<Car[]>{
    return this.http.get<Car[]>(`${baseUrl}/cars`);
  }
  newCar(token:any,formData:FormData):Observable<any>{
    const headers = new HttpHeaders({'Authorization':'Bearer '+token});
    return this.http.post(`${baseUrl}`,formData,{headers:headers});
  }
}
