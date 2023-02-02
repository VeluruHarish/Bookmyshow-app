import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Movies } from 'src/Entities/Movies';
import { MoviesApiService } from 'src/services/movies-api.service';

@Component({
  selector: 'app-view-reviews',
  templateUrl: './view-reviews.component.html',
  styleUrls: ['./view-reviews.component.css']
})
export class ViewReviewsComponent implements OnInit {
  movies?:Movies

  review:any={
    user:sessionStorage.getItem("username")
  }
  reviews?:any[]
  constructor(private _movieClient:MoviesApiService, private _route:ActivatedRoute) { }

  ngOnInit(): void {
    this._route.params.subscribe(
      param=>{
        const id=param['id']
        this._movieClient.findMovieById(id).subscribe(
          data=>((console.log(data),this.movies=data,this.reviews=data.reviews))
        )
      }
    )
  }

  postReview(){
    console.log(this.review)
    if(this.movies!= undefined){
    this.movies.reviews= this.movies.reviews.concat(this.review)
    this._movieClient.updateMovie(this.movies).subscribe(data=>this.ngOnInit())
    }
  }
}
