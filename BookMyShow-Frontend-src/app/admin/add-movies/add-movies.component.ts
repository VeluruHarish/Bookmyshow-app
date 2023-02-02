import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Genre } from 'src/app/enum/genre';
import { Movies } from 'src/Entities/Movies';
import { AddMoviesService } from 'src/services/add-movies.service';

@Component({
  selector: 'app-add-movies',
  templateUrl: './add-movies.component.html',
  styleUrls: ['./add-movies.component.css']
})
export class AddMoviesComponent implements OnInit {

  movieList:Movies[]=[]

  ngOnInit(){
  }
constructor(private _movie:AddMoviesService, private router:Router){}
  
  add_movies(movie:any){
    this.router.navigate(["/view-movies"])
    alert("Added Successfully")
    console.log(movie)
    this._movie.addmovie(movie).subscribe(
     data=>(console.log(data))

    )
  }

  genres=Object.values(Genre)




  // getMovie(){
  //   this._movie.getMovies().subscribe(data=>this.movieList=data)
  // }
}

