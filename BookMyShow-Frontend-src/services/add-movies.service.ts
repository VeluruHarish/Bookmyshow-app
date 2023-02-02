import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Movies } from 'src/Entities/Movies';

@Injectable({
  providedIn: 'root'
})
export class AddMoviesService {
  base_url="http://localhost:8888/info/movie"
  constructor(private _http:HttpClient) { }
  

  addmovie(movie:Movies):Observable<Movies>{
    console.log(movie)
    return this._http.post<Movies>(this.base_url,movie)
  }

  getMovies():Observable<Array<Movies>>{
    return this._http.get<Array<Movies>>(this.base_url+"/")
  }

  deletemovie(movie:Movies):Observable<Movies>{
    return this._http.put<Movies>(this.base_url+"/delete",movie)
  }
}
