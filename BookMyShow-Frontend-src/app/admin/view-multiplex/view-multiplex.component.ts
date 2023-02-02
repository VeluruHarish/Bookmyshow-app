import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Multiplex } from 'src/Entities/Multiplex';
import { MultiplexApiService } from 'src/services/multiplex-api.service';

@Component({
  selector: 'app-view-multiplex',
  templateUrl: './view-multiplex.component.html',
  styleUrls: ['./view-multiplex.component.css']
})
export class ViewMultiplexComponent implements OnInit {

  constructor(private _route:Router,private _multiplexServiceClient:MultiplexApiService) { }

  ngOnInit(): void {
    this.getTheatres()
  }

  multiplexList:Multiplex[]=[];

  getTheatres(){
    this._multiplexServiceClient.getMultiplexesFromDb().subscribe(data=>{
      this.multiplexList=data
      this.multiplexList.forEach(t=>console.log(t.name))
    }
    ,error=>console.log(error));
  }

  deleteMultiplex(multiplex:Multiplex){
    this._multiplexServiceClient.deleteMultiplexFromDb(multiplex)
  }

  updateMultiplex(multiplexid:number){
    this._route.navigate(['/add-multiplex/'+multiplexid])
  }

}
