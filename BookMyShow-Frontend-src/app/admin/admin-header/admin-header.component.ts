import { Component, OnInit } from '@angular/core';
import { Router, RouteReuseStrategy } from '@angular/router';
import { UserAuthService } from 'src/services/auth-services/user-auth.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-admin-header',
  templateUrl: './admin-header.component.html',
  styleUrls: ['./admin-header.component.css']
})
export class AdminHeaderComponent implements OnInit {

  constructor(private userAuthService:UserAuthService, private router:Router) { }

  ngOnInit(): void {
  }

  public isLoggedIn() {
    return this.userAuthService.isLoggedIn();
  }
  // public logout() {
  //   this.userAuthService.clear();
  //   this.router.navigate(['/']);
  // }
  public logout() {
    Swal.fire({
      title: 'Are you sure to logout?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085D6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Confirm'
    }).then((result) => {
      if (result.isConfirmed) {
        this.userAuthService.clear();
        Swal.fire(
          'Logged out successfully',
        )
        this.router.navigate(['/']);
      }
    })
  }

}
