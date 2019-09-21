import { Injectable, Output, EventEmitter } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SeitenService {

  path: string;
  @Output() resetSpiel = new EventEmitter();

  constructor() { }

  reset(): void {
    this.resetSpiel.emit();
  }
}
