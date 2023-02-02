import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Movies } from 'src/Entities/Movies';
import { MovieGlobalServiceService } from 'src/services/movie-global-service.service';
import { MoviesApiService } from 'src/services/movies-api.service';

@Component({
  selector: 'app-movie-description',
  templateUrl: './movie-description.component.html',
  styleUrls: ['./movie-description.component.css']
})
export class MovieDescriptionComponent implements OnInit {

  constructor(public _route:ActivatedRoute, public _movieClient:MoviesApiService,public _globalService:MovieGlobalServiceService) { }
  movies?:Movies
  ngOnInit(): void {
    this._route.params.subscribe(
      param=>{
        const id=param['id']
        this._movieClient.findMovieById(id).subscribe(
          data=>(this.movies=data,
          this._globalService.getDetails(data))
        )
      }
    )
  }

}
