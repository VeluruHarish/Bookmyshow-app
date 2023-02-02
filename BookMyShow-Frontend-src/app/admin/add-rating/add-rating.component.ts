import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Movies } from 'src/Entities/Movies';
import { MoviesApiService } from 'src/services/movies-api.service';

@Component({
  selector: 'app-add-rating',
  templateUrl: './add-rating.component.html',
  styleUrls: ['./add-rating.component.css']
})
export class AddRatingComponent implements OnInit {

  constructor(public _route:ActivatedRoute, private _movieClient:MoviesApiService) { }
  movies?:Array<Movies>=[]

  ngOnInit(): void {
    this.fetchMoviesFromServer()
  }

  fetchMoviesFromServer(){
    this._movieClient.findAllMovies().subscribe(
      data=>this.movies=data
    )
  }

}
