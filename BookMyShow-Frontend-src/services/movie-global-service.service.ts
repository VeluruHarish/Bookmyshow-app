
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Movies } from 'src/Entities/Movies';

@Injectable({
  providedIn: 'root'
})
export class MovieGlobalServiceService {

  constructor(public _httpClient:HttpClient) { }

  public movies?:Movies

  getDetails(movie:Movies){
    this.movies=movie;
    console.log(this.movies.title)
  }

}
