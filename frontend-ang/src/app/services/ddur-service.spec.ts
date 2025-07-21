import {TestBed} from '@angular/core/testing';

import {DdurService} from './ddur-service';

describe('DdurService', () => {
  let service: DdurService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DdurService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
