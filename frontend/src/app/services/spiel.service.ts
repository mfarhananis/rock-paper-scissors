import { Player } from './../model/player';
import { Spielsymbols } from './../model/spielsymbols.enum';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SpielService {

  gewinnCount: number;
  unentCount: number;
  verlorCount: number;

  constructor() {
    this.reset();
  }

  reset(): void {
    this.gewinnCount = 0;
    this.unentCount = 0;
    this.verlorCount = 0;
  }

  pickRandomSymbol(): Spielsymbols {
    return Math.floor(Math.random() * (1 + Spielsymbols.SCHERE - Spielsymbols.STEIN)) + Spielsymbols.STEIN;
  }

  istUnentschieden(p1: Player, p2: Player): boolean {
    return p1.selectedSymbol === p2.selectedSymbol;
  }
}
