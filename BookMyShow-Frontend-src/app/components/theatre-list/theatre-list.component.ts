import { Component, OnInit } from '@angular/core';
// import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { Movies } from 'src/Entities/Movies';
import { MultiplexShows } from 'src/Entities/MultiplexShows';
import { ShowWithDates } from 'src/Entities/show-with-dates';
import { MovieGlobalServiceService } from 'src/services/movie-global-service.service';
import { MoviesApiService } from 'src/services/movies-api.service';
// import { PopUpWindowComponent } from '../pop-up-window/pop-up-window.component';




@Component({
  selector: 'app-theatre-list',
  templateUrl: './theatre-list.component.html',
  styleUrls: ['./theatre-list.component.css']
})
export class TheatreListComponent implements OnInit {

  finalResults:ShowWithDates[]=[]
  results:MultiplexShows[]=[]  
  multiplexList:any;
  
  constructor(private _route:ActivatedRoute,private _movieClient:MoviesApiService,public _globalService:MovieGlobalServiceService) {
  }
  // movies?:Movies
  ngOnInit(): void {
    this._route.params.subscribe(
      param=>{
        const id=param['id']
        this._movieClient.getTheatreDetails(id).subscribe(
          data=>(this.finalResults=data,this.results=data[0].results,console.log(data),
          console.log(this._globalService.movies?.title))
          )
      }
        )

      }
    
  

  // received_data: string | undefined;
  setResults(showWithDate:MultiplexShows[]){
    console.log(showWithDate)
    this.results=showWithDate
  }
 

  // OpenPopUp(){
  //   const popup=this.matdialog.open(PopUpWindowComponent,{width:'60%',height:'420px',
  //   // data:{
  //   //   seats:this.matdialog.getDialogById("seats"),
  //   //   date:"yyyy-mm-dd"
  //   // }
  // });

  // // popup.afterClosed().subscribe(item=>{
  // //   this.received_data=item.data;
  // //   console.log(item.data)
  // // });
  // }

  
}
