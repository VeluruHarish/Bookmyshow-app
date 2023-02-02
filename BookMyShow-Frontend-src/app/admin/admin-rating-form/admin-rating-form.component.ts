import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Movies } from 'src/Entities/Movies';
import { MoviesApiService } from 'src/services/movies-api.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-admin-rating-form',
  templateUrl: './admin-rating-form.component.html',
  styleUrls: ['./admin-rating-form.component.css']
})
export class AdminRatingFormComponent implements OnInit {
  
  movies?:Movies
  constructor(public _route:ActivatedRoute, private _movieClient:MoviesApiService) { }
  rating:number=0
  ngOnInit(): void {
    this._route.params.subscribe(
      param=>{
        const id=param['id']
        this._movieClient.findMovieById(id).subscribe(
          
          data=>((console.log(data),this.movies=data,this.rating=this.movies.rating))
        )
      }
    )
  }


  submitRating(){
    console.log(this.rating)
    if(this.movies!= undefined){
    this.movies.rating=+this.rating
    this._movieClient.updateMovie(this.movies).subscribe(data=>{(Swal.fire({
      title: "Rating Update Status",
      text: "Rating Updated",
      icon: "success",
    })
    )
    this.ngOnInit()
  }
    )
  }
}

}
