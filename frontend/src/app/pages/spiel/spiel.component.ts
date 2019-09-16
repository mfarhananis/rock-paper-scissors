import { Spielsymbols } from './../../model/spielsymbols.enum';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-spiel',
  templateUrl: './spiel.component.html',
  styleUrls: ['./spiel.component.css']
})
export class SpielComponent implements OnInit {

  stein: Spielsymbols = Spielsymbols.STEIN;
  papier: Spielsymbols = Spielsymbols.PAPIER;
  schere: Spielsymbols = Spielsymbols.SCHERE;

  constructor() { }

  ngOnInit() {
  }

  symbolClicked(symbol: Spielsymbols) {
    console.log(symbol);
  }

}
