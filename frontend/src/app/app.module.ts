import { SpielService } from './services/spiel.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavibarComponent } from './components/navibar/navibar.component';
import { InfoComponent } from './pages/info/info.component';
import { SpielComponent } from './pages/spiel/spiel.component';
import { SeitenService } from './services/seiten.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    NavibarComponent,
    InfoComponent,
    SpielComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [SpielService, SeitenService],
  bootstrap: [AppComponent]
})
export class AppModule { }
