import { TestBed } from '@angular/core/testing';

import { MultiplexApiService } from './multiplex-api.service';

describe('MultiplexApiService', () => {
  let service: MultiplexApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MultiplexApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
