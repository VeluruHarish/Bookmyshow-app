import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Multiplex } from 'src/Entities/Multiplex';

@Injectable({
  providedIn: 'root'
})
export class MultiplexApiService {

  constructor(private _httpClient:HttpClient) { }

  multiplexUrl="http://localhost:8888/info/multiplex/"

  getMultiplexesFromDb():Observable<Array<Multiplex>>{
      return this._httpClient.get<Array<Multiplex>>(this.multiplexUrl)
  }

  addMultiplexToDb(multiplex:Multiplex):Observable<Multiplex>{
      console.log(multiplex)
      return this._httpClient.post<Multiplex>(this.multiplexUrl,multiplex)
  }

  deleteMultiplexFromDb(multiplex:Multiplex){
   this._httpClient.put<Multiplex>(this.multiplexUrl+"delete",multiplex).subscribe()
  }

  getMultiplexById(id:number):Observable<Multiplex>{
    return this._httpClient.get<Multiplex>(this.multiplexUrl+id)
  }
}
