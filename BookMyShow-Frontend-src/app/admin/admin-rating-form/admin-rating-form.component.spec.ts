import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminRatingFormComponent } from './admin-rating-form.component';

describe('AdminRatingFormComponent', () => {
  let component: AdminRatingFormComponent;
  let fixture: ComponentFixture<AdminRatingFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminRatingFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminRatingFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
