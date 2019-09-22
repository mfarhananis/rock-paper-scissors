import { TestBed } from '@angular/core/testing';

import { SpielService } from './spiel.service';
import { HttpClientModule } from '@angular/common/http';

describe('SpielService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [HttpClientModule]
  }));

  it('should be created', () => {
    const service: SpielService = TestBed.get(SpielService);
    expect(service).toBeTruthy();
  });
});
