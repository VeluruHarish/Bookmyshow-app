import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserAuthService } from 'src/services/auth-services/user-auth.service';
import { UserService } from 'src/services/auth-services/user.service';
import { NgForm } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  constructor(
    private userService: UserService, 
    private userAuthService: UserAuthService,
    
    private router: Router
    ) {}

ngOnInit(): void {

}

login(loginForm:NgForm){

  this.userService.login(loginForm.value).subscribe(
  (response:any)=>{
  console.log(response)

  this.userAuthService.setRoles(response.user.role);
  this.userAuthService.setToken(response.jwtToken);
  this.userAuthService.setUsername(response.user.username);
// Login Alert
  Swal.fire({
    title: "Welcome ...",
    text: "Login Successful",
    icon: "success",
  });
  
  const role = response.user.role.roleName;
  if(role === 'Admin' ) {
    this.router.navigate(['/admin-home']);
  }
  else {
    this.router.navigate(['/user-home']);
  }
  },
  (error) => {
  console.log(error);
  Swal.fire({
    title: "Error Message ",
    text: error.error.message,
    icon: "warning",
  })
  }

  );
}

}
