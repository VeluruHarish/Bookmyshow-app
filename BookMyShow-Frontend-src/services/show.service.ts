import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Show } from 'src/Entities/Show';

@Injectable({
  providedIn: 'root'
})
export class ShowService {

  constructor(private _httpClient:HttpClient) { }
  sendShowToDb(show:Show):Observable<Show>{
    console.log(show)
    return this._httpClient.post<Show>("http://localhost:8888/info/show",show)
  }
}
