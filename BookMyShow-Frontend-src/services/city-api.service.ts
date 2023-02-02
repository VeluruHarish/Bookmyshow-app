import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { City } from 'src/Entities/City';

@Injectable({
  providedIn: 'root'
})
export class CityApiService {

  constructor(private _httpClient:HttpClient) { }

  cityUrl="http://localhost:8888/info/city"

  getCitiesFromDb():Observable<Array<City>>{
      return this._httpClient.get<Array<City>>("http://localhost:8888/info/city")
  }

  // doSomething():Observable<Map<any,any>>{
  //   return this._httpClient.get<Map<any,any>>("http://localhost:7799/something")
  // }

  // addCityToDb(city:City):Observable<City>{
  //     console.log(city)
  //     return this._httpClient.post<City>("http://localhost:8900/cities",city)
  // }
}
