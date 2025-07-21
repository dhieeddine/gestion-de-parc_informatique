import {TestBed} from '@angular/core/testing';

import {CarteVideoService} from './carte-video-service';

describe('CarteVideoService', () => {
  let service: CarteVideoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CarteVideoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
