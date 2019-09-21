import { Component, OnInit } from '@angular/core';
import { SeitenService } from 'src/app/services/seiten.service';

@Component({
  selector: 'app-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.css']
})
export class InfoComponent implements OnInit {

  constructor(private seitenService: SeitenService) { }

  ngOnInit() {
    this.seitenService.path = '';
  }

}
