import { Component, OnInit } from '@angular/core';
import { Movies } from 'src/Entities/Movies';
import { Multiplex } from 'src/Entities/Multiplex';
import { Show } from 'src/Entities/Show';
import { MoviesApiService } from 'src/services/movies-api.service';
import { MultiplexApiService } from 'src/services/multiplex-api.service';
import { ShowService } from 'src/services/show.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-add-shows',
  templateUrl: './add-shows.component.html',
  styleUrls: ['./add-shows.component.css']
})
export class AddShowsComponent implements OnInit {

  constructor(private _showClient:ShowService,private _movieClient:MoviesApiService,private _multiplexClient:MultiplexApiService){}
  multiplexes:Multiplex[]=[]
  movies:Movies[]=[]
  multiplex:Multiplex={
    id:0,
    address:"",
    city:{id:0,name:""},
    name:"",
    noOfScreens:0,
    screens:[]
  }
  ngOnInit(){
    this.getTheatres()
    this.getMovie()
  }
  getTheatres(){
    this._multiplexClient.getMultiplexesFromDb().subscribe(data=>{
      this.multiplexes=data
      this.multiplexes.forEach(t=>console.log(t))
    }
    ,error=>console.log(error));
  }
  getMovie(){
    this._movieClient.findAllMovies().subscribe(data=>(this.movies=data,console.log(this.movies)))
  }
  saveShow(show:Show){
    console.log(show)
    this._showClient.sendShowToDb(show).subscribe(data=>Swal.fire({
      title: "",
      text: "Show added",
      icon: "success",
    }),error=>Swal.fire({
      title:"",
      text:error.error.message
        }))
  }
}
