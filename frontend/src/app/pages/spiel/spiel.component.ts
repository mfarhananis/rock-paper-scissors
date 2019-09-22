import { Ergebnis } from './../../model/ergebnis.enum';
import { Player } from './../../model/player';
import { SpielService } from './../../services/spiel.service';
import { Spielsymbols } from './../../model/spielsymbols.enum';
import { Component, OnInit } from '@angular/core';
import { SeitenService } from 'src/app/services/seiten.service';
import { SpielResponse } from 'src/app/model/spiel-response';

@Component({
  selector: 'app-spiel',
  templateUrl: './spiel.component.html',
  styleUrls: ['./spiel.component.css']
})
export class SpielComponent implements OnInit {

  stein: Spielsymbols = Spielsymbols.STEIN;
  papier: Spielsymbols = Spielsymbols.PAPIER;
  schere: Spielsymbols = Spielsymbols.SCHERE;

  player1: Player;
  player2: Player;

  auswahlErgebnisZeigen: boolean;
  unentschieden: boolean;
  gewonnen: boolean;
  verloren: boolean;

  constructor(public spielService: SpielService, private seitenService: SeitenService) { }

  ngOnInit() {
    this.seitenService.path = 'spiel';

    this.seitenService.resetSpiel.subscribe(() => {
      this.reset();
    });

    this.reset();
  }

  reset(): void {
    this.auswahlErgebnisZeigen = false;
    this.unentschieden = false;
    this.gewonnen = false;
    this.verloren = false;

    this.spielService.reset();
  }

  symbolClicked(symbol: Spielsymbols) {
    this.auswahlErgebnisZeigen = true;

    this.player1 = new Player();
    this.player1.selectedSymbol = symbol;

    this.player2 = new Player();
    this.player2.name = 'Rechner';

    this.spielService.spielen(this.player1.selectedSymbol).subscribe((response: SpielResponse) => {
      this.player2.selectedSymbol = response.rechnerWahl;

      switch (response.ergebnis) {
        case Ergebnis.GEWONNEN:
          this.spielService.gewinnCount++;
          this.unentschieden = false;
          this.gewonnen = true;
          this.verloren = false;
          break;
        case Ergebnis.VERLOREN:
          this.spielService.verlorCount++;
          this.unentschieden = false;
          this.verloren = true;
          this.gewonnen = false;
          break;
        case Ergebnis.UNENTSCHIEDEN:
          this.spielService.unentCount++;
          this.unentschieden = true;
          this.gewonnen = false;
          this.verloren = false;
          break;
      }

    });
  }
}
