import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {Machines} from './machines/machines';
import {Fournisseur} from './fournisseur/fournisseur';
import {Utilisateur} from './utilisateur/utilisateur';
import {Logiciel} from './logiciel/logiciel';
import {Emplacement} from './emplacement/emplacement';
import {Login} from './login/login';
import {AdminAtmplate} from './admin-atmplate/admin-atmplate';
import {AuthGuard} from './gards/auth-guard';

const routes: Routes = [
  { path: '', component: Login },
  { path: 'login', component: Login },
  { path: 'admin', component: AdminAtmplate ,
    canActivate: [AuthGuard] ,
    children: [
      { path: 'machines', component: Machines },
      { path: 'fournisseur', component: Fournisseur },
      { path: 'utilisateur', component: Utilisateur },
      { path: 'logiciel', component: Logiciel },
      { path: 'emplacement', component: Emplacement },
    ]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
