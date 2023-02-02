import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ShowWithDates } from 'src/Entities/show-with-dates';
import { AuthGuard } from '../auth.guard';
import { ErrorComponent } from '../components/error/error.component';
import { AddMoviesComponent } from './add-movies/add-movies.component';
import { AddMultiplexComponent } from './add-multiplex/add-multiplex.component';
import { AddRatingComponent } from './add-rating/add-rating.component';
import { AddShowsComponent } from './add-shows/add-shows.component';
import { AdminRatingFormComponent } from './admin-rating-form/admin-rating-form.component';
import { ViewMoviesComponent } from './view-movies/view-movies.component';
import { ViewMultiplexComponent } from './view-multiplex/view-multiplex.component';


const routes: Routes = [
  {
    path:'add-movies', component:AddMoviesComponent,canActivate:[AuthGuard],data:{roles:["Admin"]}
  },

  {
    path:'view-movies', component:ViewMoviesComponent,canActivate:[AuthGuard],data:{roles:["Admin"]}
  },
  {
    path:'add-multiplex', component:AddMultiplexComponent,canActivate:[AuthGuard],data:{roles:["Admin"]}
  },
  {
    path:'view-multiplex', component:ViewMultiplexComponent,canActivate:[AuthGuard],data:{roles:["Admin"]}
  },
  {
    path:'add-rating', component:AddRatingComponent,canActivate:[AuthGuard],data:{roles:["Admin"]}
  },
  {
    path:'add-rating/:id', component:AdminRatingFormComponent,canActivate:[AuthGuard],data:{roles:["Admin"]}
  },
  {
    path:'add-shows', component:AddShowsComponent,canActivate:[AuthGuard],data:{roles:["Admin"]}
  }


];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
