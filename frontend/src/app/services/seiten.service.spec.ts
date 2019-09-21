import { TestBed } from '@angular/core/testing';

import { SeitenService } from './seiten.service';

describe('SeitenService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SeitenService = TestBed.get(SeitenService);
    expect(service).toBeTruthy();
  });
});
