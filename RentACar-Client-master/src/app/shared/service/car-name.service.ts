import { Injectable } from '@angular/core';
import { CarName } from '../model/car-name.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
const baseUrl="http://localhost:8080/api/carNames";
@Injectable({
  providedIn: 'root'
})
export class CarNameService {

  constructor(private http:HttpClient) { }
  public findAll():Observable<CarName[]>{
    return this.http.get<CarName[]>(`${baseUrl}`);
  }
}
