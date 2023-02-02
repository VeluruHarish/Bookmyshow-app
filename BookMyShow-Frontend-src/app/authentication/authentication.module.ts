import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuthenticationRoutingModule } from './authentication-routing.module';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { AuthHeaderComponent } from './auth-header/auth-header.component';
import { AuthFooterComponent } from './auth-footer/auth-footer.component';
import {FormsModule} from '@angular/forms';
import { ForbiddenComponent } from './forbidden/forbidden.component'



@NgModule({
  declarations: [
    SignInComponent,
    SignUpComponent,
    AuthHeaderComponent,
    AuthFooterComponent,
    ForbiddenComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    AuthenticationRoutingModule
  ]
})
export class AuthenticationModule { }
