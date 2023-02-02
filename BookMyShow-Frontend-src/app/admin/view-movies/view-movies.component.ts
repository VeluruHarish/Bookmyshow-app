import { Component, OnInit } from '@angular/core';
import { Movies } from 'src/Entities/Movies';
import { AddMoviesService } from 'src/services/add-movies.service';

@Component({
  selector: 'app-view-movies',
  templateUrl: './view-movies.component.html',
  styleUrls: ['./view-movies.component.css']
})
export class ViewMoviesComponent implements OnInit {

  constructor(private _movie:AddMoviesService) { }

  movieList:Movies[]=[]

  ngOnInit(){
    this.getMovie()
  }

  getMovie(){
    this._movie.getMovies().subscribe(data=>this.movieList=data)
  }

  delete(movie:Movies){
    if(confirm("sure want to delete")){
      this._movie.deletemovie(movie).subscribe(
        d=>{
          alert("Successfully Deleted")
        this.getMovie()
    })
    }
   
  }

}
