import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { City } from 'src/Entities/City';
import { Multiplex } from 'src/Entities/Multiplex';
import { Screen } from 'src/Entities/Screen';

import { CityApiService } from 'src/services/city-api.service';
import { MultiplexApiService } from 'src/services/multiplex-api.service';

@Component({
  selector: 'app-add-multiplex',
  templateUrl: './add-multiplex.component.html',
  styleUrls: ['./add-multiplex.component.css']
})
export class AddMultiplexComponent implements OnInit {

  constructor(public router:Router,public _route:ActivatedRoute,private _theatreServiceClient:MultiplexApiService,private _cityServiceClient:CityApiService) { }

  id?:number

  cities:City[]=[]

  multiplex:Multiplex={
    id:0,
    address:"",
    city:{id:0,name:""},
    name:"",
    noOfScreens:0,
    screens:[]
  }


  ngOnInit(): void {
    this.getCities()
    this.id=this._route.snapshot.params["id"];
    if(this.id){
      this._theatreServiceClient.getMultiplexById(this.id).subscribe(data=>{this.multiplex=data;
                                                                            console.log(this.multiplex);})
    }
    this.multiplex.screens=this.multiplex.screens
  }

  initScreens() {
    this.multiplex.screens=[]
      for (let i = 0; i < this.multiplex.noOfScreens; i++) {
        this.multiplex.screens.push(new Screen());  
    }
  }

  saveMultiplex(){
    console.log(this.multiplex)
    this._theatreServiceClient.addMultiplexToDb(this.multiplex).subscribe(data=>{console.log("saved");
                                                                                  this.router.navigate(['/view-multiplex']);})
  }

  getCities(){
    this._cityServiceClient.getCitiesFromDb().subscribe(data=>{
      console.log(data)
      this.cities=data
    })
  }
  // addMultiplex(){
  //   this.router.navigate(["/view-multiplex"])
  // }

}
