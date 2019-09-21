import { TestBed } from '@angular/core/testing';

import { SpielService } from './spiel.service';

describe('SpielService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SpielService = TestBed.get(SpielService);
    expect(service).toBeTruthy();
  });
});
