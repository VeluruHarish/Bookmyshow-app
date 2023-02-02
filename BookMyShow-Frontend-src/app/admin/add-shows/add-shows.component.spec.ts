import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddShowsComponent } from './add-shows.component';

describe('AddShowsComponent', () => {
  let component: AddShowsComponent;
  let fixture: ComponentFixture<AddShowsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddShowsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddShowsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
