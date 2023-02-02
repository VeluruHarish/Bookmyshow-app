import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserAuthService } from 'src/services/auth-services/user-auth.service';
import { UserService } from 'src/services/auth-services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-auth-header',
  templateUrl: './auth-header.component.html',
  styleUrls: ['./auth-header.component.css']
})
export class AuthHeaderComponent implements OnInit {

  constructor(private userAuthService:UserAuthService,private router:Router,public userService: UserService) { }

  ngOnInit(): void {
  }

  public isLoggedIn() {
    return this.userAuthService.isLoggedIn();
  }

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
        this.router.navigate(['/home']);
      }
    })
  }

}
