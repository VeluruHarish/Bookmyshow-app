import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bookings } from 'src/Entities/Bookings';
import { MultiplexShows } from 'src/Entities/MultiplexShows';
import { Show } from 'src/Entities/Show';
import { ShowWithDates } from 'src/Entities/show-with-dates';
import { Movies } from '../Entities/Movies';

@Injectable({
  providedIn: 'root'
})
export class MoviesApiService {

  constructor(public _httpClient:HttpClient) { }


  movieUrl="http://localhost:8888/info/movie/"

  findAllMovies():Observable<Array<Movies>>{
    return this._httpClient.get<Array<Movies>>(this.movieUrl)
  }

  findMovieById(id:number):Observable<Movies>{
    return this._httpClient.get<Movies>(this.movieUrl+id)
  }

  findMovies(searchText:string):Observable<Array<Movies>>{
    console.log(this.movieUrl+"?genre="+searchText)
    return this._httpClient.get<Array<Movies>>(this.movieUrl+"?genre="+searchText)
  }

  updateMovie(movie:Movies):Observable<Movies>{
    console.log(movie)
    return this._httpClient.put<Movies>("http://localhost:8888/info/updatemovie",movie)
  }

  public getshowDetails(id:number):Observable<any>{
    return this._httpClient.post<any>("http://localhost:8888/info/showDetails/"+id,null)
  }
  public book(bookings:Bookings):Observable<Bookings>{
    return this._httpClient.post<Bookings>("http://localhost:8888/booking/book/",bookings)
  }
  public getTheatreDetails(id:number):Observable<Array<ShowWithDates>>{
    return this._httpClient.post<Array<ShowWithDates>>("http://localhost:8888/info/multiplexShows/"+"1/"+id,null)
  }

}
