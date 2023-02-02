import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminHeaderComponent } from './admin-header/admin-header.component';
import { AdminFooterComponent } from './admin-footer/admin-footer.component';
import { AddMoviesComponent } from './add-movies/add-movies.component';
import { AddMultiplexComponent } from './add-multiplex/add-multiplex.component';
import { AddRatingComponent } from './add-rating/add-rating.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { FormsModule } from '@angular/forms';
import { ViewMoviesComponent } from './view-movies/view-movies.component';
import { ViewMultiplexComponent } from './view-multiplex/view-multiplex.component';
// import { ViewRatingComponent } from './view-rating/view-rating.component';
import { AdminRatingFormComponent } from './admin-rating-form/admin-rating-form.component';
import { AddShowsComponent } from './add-shows/add-shows.component';


@NgModule({
  declarations: [
    AdminHeaderComponent,
    AdminFooterComponent,
    AddMoviesComponent,
    AddMultiplexComponent,
    AddRatingComponent,
    AdminHomeComponent,
    ViewMoviesComponent,
    ViewMultiplexComponent,
    AdminRatingFormComponent,
    AddShowsComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule
  ]
})
export class AdminModule { }
