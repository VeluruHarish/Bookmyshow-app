import { TestBed } from '@angular/core/testing';

import { AddMoviesService } from './add-movies.service';

describe('AddMoviesService', () => {
  let service: AddMoviesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddMoviesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
