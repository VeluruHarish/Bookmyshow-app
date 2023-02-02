import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';


// import { HomeMainContentComponent } from './home-main-content.component';
import { MovieDescriptionComponent } from './components/movie-description/movie-description.component';
import { TheatreListComponent } from './components/theatre-list/theatre-list.component';
import { NgbModule, NgbTooltipModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'; 
import { MaterialModule } from './material/material.module';
import {MatNativeDateModule} from '@angular/material/core';
import { SeatLayoutComponent } from './components/seat-layout/seat-layout.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AdminModule } from './admin/admin.module';

import { MovieGlobalServiceService } from 'src/services/movie-global-service.service';
import { AuthenticationModule } from './authentication/authentication.module';
import { HomeMainContentComponent } from './home-main-content/home-main-content.component';
import { ViewReviewsComponent } from './components/view-reviews/view-reviews.component';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { AuthInterceptor } from './auth-interceptor';
import { ErrorComponent } from './components/error/error.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeMainContentComponent,
    MovieDescriptionComponent,
    TheatreListComponent,
    SeatLayoutComponent,
    ViewReviewsComponent,
    ErrorComponent,
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgMultiSelectDropDownModule,
    AppRoutingModule,
    NgbModule,
    BrowserAnimationsModule,
    MaterialModule,
    MatNativeDateModule,
    NgbTooltipModule,
    AdminModule,
    AuthenticationModule,
  
  ],
  providers: [MovieGlobalServiceService,{provide:HTTP_INTERCEPTORS,useClass:AuthInterceptor,multi:true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
