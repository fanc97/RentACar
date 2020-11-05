import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BodyType } from '../model/body-type.model';
const baseUrl="http://localhost:8080/api/bodyType";
@Injectable({
  providedIn: 'root'
})
export class BodyTypeService {

  constructor(private http:HttpClient) { }
  public findAll():Observable<BodyType[]>{
    return this.http.get<BodyType[]>(`${baseUrl}`);
  }
  public findAllDT():Observable<any>{
    return this.http.get("http://localhost:8080/api/driveType");
  }
  public findAllModel():Observable<any>{
    return this.http.get("http://localhost:8080/api/model");
  }
  public findAllFT():Observable<any>{
    return this.http.get("http://localhost:8080/api/fuelType");
  }
  public findAllTT():Observable<any>{
    return this.http.get("http://localhost:8080/api/transmissionType");
  }
  public findAllManu():Observable<any>{
    return this.http.get("http://localhost:8080/api/manufacturer");
  }
}
