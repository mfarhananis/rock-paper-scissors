import { Spielsymbols } from './spielsymbols.enum';
export class Player {
    name: string;
    selectedSymbol: Spielsymbols;

    public selectedSymboltoString(): string {
        switch (this.selectedSymbol) {
          case Spielsymbols.STEIN:
            return 'STEIN';
          case Spielsymbols.PAPIER:
            return 'PAPIER';
          case Spielsymbols.SCHERE:
            return 'SCHERE';
        }
      }
}
