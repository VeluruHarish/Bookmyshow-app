import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ErrorComponent } from '../components/error/error.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';

const routes: Routes = [
  {
    path:'',component:SignInComponent,
  },
  {
    path:'sign-up', component:SignUpComponent, 
  },
  {
    path:'forbidden', component:ForbiddenComponent,
  },
  {
    path:"error",component:ErrorComponent

  },
  {
    path:"**",redirectTo:"/error"
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthenticationRoutingModule { }
