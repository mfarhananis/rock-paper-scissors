import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavibarComponent } from './components/navibar/navibar.component';
import { InfoComponent } from './pages/info/info.component';
import { SpielComponent } from './pages/spiel/spiel.component';

@NgModule({
  declarations: [
    AppComponent,
    NavibarComponent,
    InfoComponent,
    SpielComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
