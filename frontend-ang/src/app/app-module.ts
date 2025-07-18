import { NgModule, provideBrowserGlobalErrorListeners, provideZonelessChangeDetection } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { AdminAtmplate } from './admin-atmplate/admin-atmplate';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule} from '@angular/material/icon';
import {MatSidenavModule} from '@angular/material/sidenav';
import { Machines } from './machines/machines';
import { Logiciel } from './logiciel/logiciel';
import { Utilisateur } from './utilisateur/utilisateur';
import { Fournisseur } from './fournisseur/fournisseur';
import { Emplacement } from './emplacement/emplacement';
import {MatMenuModule} from '@angular/material/menu';
import {MatListModule} from '@angular/material/list';
import { MatCardModule} from '@angular/material/card';
import { Login } from './login/login';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {ReactiveFormsModule} from '@angular/forms';
import {AuthGuard} from './gards/auth-guard';
import {AuthorizationGuard} from './gards/authorization-guard';
import {MatTableModule} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import {HttpClientModule} from '@angular/common/http';
import {MatSortModule} from '@angular/material/sort';
import {NgOptimizedImage} from '@angular/common';
@NgModule({
  declarations: [
    App,
    AdminAtmplate,
    Machines,
    Logiciel,
    Utilisateur,
    Fournisseur,
    Emplacement,
    Login
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatSidenavModule,
    MatMenuModule,
    MatListModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    MatTableModule,
    MatPaginatorModule,
    HttpClientModule,
    MatSortModule,
    NgOptimizedImage


  ],
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideZonelessChangeDetection(),
    AuthGuard, AuthorizationGuard
  ],
  bootstrap: [App]
})
export class AppModule { }
