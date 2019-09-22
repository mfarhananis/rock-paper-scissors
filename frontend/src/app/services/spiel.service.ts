import { Player } from './../model/player';
import { Spielsymbols } from './../model/spielsymbols.enum';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { SpielResponse } from '../model/spiel-response';

@Injectable({
  providedIn: 'root'
})
export class SpielService {

  gewinnCount: number;
  unentCount: number;
  verlorCount: number;

  constructor(private http: HttpClient) {
    this.reset();
  }

  reset(): void {
    this.gewinnCount = 0;
    this.unentCount = 0;
    this.verlorCount = 0;
  }

  spielen(benutzerWahl: number): Observable<any> {
    const backendUrl = `${environment.backendUrl}${benutzerWahl}`;
    return this.http.get(backendUrl);
  }
}
