import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MovieDescriptionComponent } from './components/movie-description/movie-description.component';
import { TheatreListComponent } from './components/theatre-list/theatre-list.component';
import { SeatLayoutComponent } from './components/seat-layout/seat-layout.component';
import { AdminHomeComponent } from './admin/admin-home/admin-home.component';
import { ViewReviewsComponent } from './components/view-reviews/view-reviews.component';
import { SignInComponent } from './authentication/sign-in/sign-in.component';
import { HomeMainContentComponent } from './home-main-content/home-main-content.component';
import { AuthGuard } from './auth.guard';
import { ErrorComponent } from './components/error/error.component';
// import { AddMoviesComponent } from './admin/add-movies/add-movies.component';
// import { AddMultiplexComponent } from './admin/add-multiplex/add-multiplex.component';
// import { AddRatingComponent } from './admin/add-rating/add-rating.component';

const routes: Routes = [
  {
    path:'', component:SignInComponent,
  },
  {
    path: 'user-home', component:HomeMainContentComponent,canActivate:[AuthGuard],data:{roles:["User"]}
  },
  {
    path:'user-home/:id', component:MovieDescriptionComponent,
  },
  {
    path:'view-reviews/:id', component:ViewReviewsComponent,
  },
  {
    path:'theatreList/:id', component:TheatreListComponent,
  },
 
  {
    path:'seat-layout/:id', component:SeatLayoutComponent
  },
  {
    path:'admin-home', component:AdminHomeComponent,canActivate:[AuthGuard],data:{roles:["Admin"]}
  }
  
 

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
