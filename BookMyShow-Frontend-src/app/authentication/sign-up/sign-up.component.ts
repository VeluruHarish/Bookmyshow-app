import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/services/auth-services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  registerForm: any;

  constructor(private router: Router,
              private userService: UserService
              ) {}


    ngOnInit(): void {
      
    }
    register(registerForm:NgForm) {
      // console.warn(this.signupForm.value)
      this.userService.register(registerForm.value).subscribe((data) => {
        // SignUp Alert
        Swal.fire({
          title: "",
          text: "Registered Successfully",
          icon: "success",
        });
        // alert("SignUp Successfull")
        this.router.navigate(['/']);
      },

      (error) => {
        console.log(error.error.message);
        Swal.fire({
          title: "",
          text: error.error.message,
          icon: "warning",
        });
      }
      );
    }

}
