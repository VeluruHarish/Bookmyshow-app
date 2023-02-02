import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMultiplexComponent } from './add-multiplex.component';

describe('AddMultiplexComponent', () => {
  let component: AddMultiplexComponent;
  let fixture: ComponentFixture<AddMultiplexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddMultiplexComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddMultiplexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
