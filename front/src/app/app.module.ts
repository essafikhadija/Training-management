import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {SlideshowModule} from 'ng-simple-slideshow';
import {AppComponent} from './app.component';
import {AproposComponent} from './apropos/apropos.component';
import {FormationComponent} from './formation/formation.component';
import {NewFormationComponent} from './new-formation/new-formation.component';
import {AuthentificationComponent} from './authentification/authentification.component';
import {RouterModule, Routes} from "@angular/router";
import {EditFormationComponent} from './edit-formation/edit-formation.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {FormationService} from "../services/formation.service";
import {AccueilComponent} from './accueil/accueil.component';
import {LoginComponent} from './login/login.component';
import {LogoutComponent} from './logout/logout.component';
import {FooterComponent} from './footer/footer.component';
import {ParticipantComponent} from './participant/participant.component';

const appRoutes: Routes = [
  {path: 'accueil', component: AccueilComponent},
  {path: 'apropos', component: AproposComponent},
  {path: 'formations', component: FormationComponent},
  {path: 'edit-formation/:id', component: EditFormationComponent},
  {path: 'new-formation', component: NewFormationComponent},
  {path: 'participant', component: ParticipantComponent},
  {path: 'login', component: LoginComponent},
  {path: 'logout', component: LogoutComponent},
  {path: '', redirectTo: '/login', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    AproposComponent,
    FormationComponent,
    NewFormationComponent,
    AuthentificationComponent,
    EditFormationComponent,
    AccueilComponent,
    LoginComponent,
    LogoutComponent,
    FooterComponent,
    ParticipantComponent
  ],
  imports: [
    SlideshowModule,
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule,
    FormsModule

  ],
  providers: [FormationService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
