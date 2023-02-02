import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeMainContentComponent } from './home-main-content.component';

describe('HomeMainContentComponent', () => {
  let component: HomeMainContentComponent;
  let fixture: ComponentFixture<HomeMainContentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomeMainContentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomeMainContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
