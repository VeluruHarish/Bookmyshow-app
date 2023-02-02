import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatInputModule} from '@angular/material/input';
import {MatDialogModule} from '@angular/material/dialog';
import {MatDatepickerModule} from '@angular/material/datepicker';



@NgModule({
  declarations: [],
  exports: [
    CommonModule,
    MatInputModule,
    MatDialogModule,
    MatDatepickerModule,
    
  ]
})
export class MaterialModule { }
