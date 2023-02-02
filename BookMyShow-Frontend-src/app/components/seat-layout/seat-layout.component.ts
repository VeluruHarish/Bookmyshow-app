import { Component, NgModule, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Bookings } from 'src/Entities/Bookings';
import { SeatLayoutSeat } from 'src/Entities/SeatLayout';
import { UserAuthService } from 'src/services/auth-services/user-auth.service';
import { MovieGlobalServiceService } from 'src/services/movie-global-service.service';
import { MoviesApiService } from 'src/services/movies-api.service';
import Swal from 'sweetalert2';




@Component({
  selector: 'app-seat-layout',
  templateUrl: './seat-layout.component.html',
  styleUrls: ['./seat-layout.component.css']
})
export class SeatLayoutComponent implements OnInit {

  show: any;
  Book?: Bookings
  id: number = 0
  seatList: any;
  bookedSeatList: number[] = []
  constructor(public _route: ActivatedRoute, public _movieClient: MoviesApiService,public _globalService:MovieGlobalServiceService,public _authService:UserAuthService) { }
  Bookseats() {
    for (let seat of this.seatList) {
      if (seat.checked === true) {
        this.selectedSeats = this.selectedSeats.concat(seat.id)
        console.log(seat.id, seat.checked, seat)
      }
    }
    console.log(this.selectedSeats)
    let user:any=sessionStorage.getItem("user")
    this._movieClient.book(new Bookings(this._authService.getUsername(),this.id,this.selectedSeats)).subscribe(
      data=>{this.ngOnInit(),
      Swal.fire(
        'Booking Successful\n Get Your Tickets in Mail'
      )}
    )
  }
  selectedSeats: number[] = []
  ngOnInit(): void {
    this._route.params.subscribe(
      param => {
        const id = param['id']
        this.id = id
        this._movieClient.getshowDetails(this.id).subscribe(
          data => {
            console.log(data);
            this.show = data.show;
            console.log(this.show);
            this.seatList = data.layoutseats
            console.log(this.seatList);
          }
        )
      })
  }
  

}
