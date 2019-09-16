import { SpielComponent } from './pages/spiel/spiel.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InfoComponent } from './pages/info/info.component';


const routes: Routes = [
  { path: '', component: InfoComponent, pathMatch: 'full' },
  { path: 'spiel', component: SpielComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
