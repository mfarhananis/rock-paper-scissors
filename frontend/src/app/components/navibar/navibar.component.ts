import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { SeitenService } from 'src/app/services/seiten.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-navibar',
  templateUrl: './navibar.component.html',
  styleUrls: ['./navibar.component.css']
})
export class NavibarComponent implements OnInit {

  constructor(private seitenService: SeitenService) { }

  ngOnInit() {
  }

  reset(): void {
    this.seitenService.reset();
  }

  showReset(): boolean {
    return this.seitenService.path === 'spiel';
  }

}
