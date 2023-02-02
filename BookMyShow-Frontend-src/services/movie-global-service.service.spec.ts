import { TestBed } from '@angular/core/testing';

import { MovieGlobalServiceService } from './movie-global-service.service';

describe('MovieGlobalServiceService', () => {
  let service: MovieGlobalServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MovieGlobalServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
