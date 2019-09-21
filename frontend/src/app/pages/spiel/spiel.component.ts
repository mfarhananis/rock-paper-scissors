import { Player } from './../../model/player';
import { SpielService } from './../../services/spiel.service';
import { Spielsymbols } from './../../model/spielsymbols.enum';
import { Component, OnInit } from '@angular/core';
import { SeitenService } from 'src/app/services/seiten.service';

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
    this.player2.selectedSymbol = this.spielService.pickRandomSymbol();

    if (this.spielService.istUnentschieden(this.player1, this.player2)) {
      this.spielService.unentCount++;
      this.unentschieden = true;
      this.gewonnen = false;
      this.verloren = false;
    } else {
      this.unentschieden = false;

      if ((this.player1.selectedSymbol === 1 && this.player2.selectedSymbol === 3)
      || (this.player1.selectedSymbol === 2 && this.player2.selectedSymbol === 1)
      || (this.player1.selectedSymbol === 3 && this.player2.selectedSymbol === 2)) {
        this.spielService.gewinnCount++;
        this.gewonnen = true;
        this.verloren = false;
      } else {
        this.spielService.verlorCount++;
        this.verloren = true;
        this.gewonnen = false;
      }
    }
  }
}
