import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewMultiplexComponent } from './view-multiplex.component';

describe('ViewMultiplexComponent', () => {
  let component: ViewMultiplexComponent;
  let fixture: ComponentFixture<ViewMultiplexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewMultiplexComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewMultiplexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
