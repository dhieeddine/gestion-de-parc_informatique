import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {Machines} from './machines/machines';
import {Fournisseur} from './fournisseur/fournisseur';
import {Utilisateur} from './utilisateur/utilisateur';
import {Logiciel} from './logiciel/logiciel';
import {Emplacement} from './emplacement/emplacement';
import {Login} from './login/login';
import {AdminAtmplate} from './admin-atmplate/admin-atmplate';
import {AuthGuard} from './gards/auth-guard';
import {NewEmplacement} from './new-emplacement/new-emplacement';
import {NewFournisseur} from './new-fournisseur/new-fournisseur';
import {NewLogiciel} from './new-logiciel/new-logiciel';
import {NewUtilisateur} from './new-utilisateur/new-utilisateur';
import {NewMachine} from './new-machine/new-machine';
import {AcceuilComponent} from './acceuil/acceuil.component';

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
      { path: 'new-emplacement', component: NewEmplacement },
      { path: 'new-fournisseur', component: NewFournisseur },
      { path: 'new-logiciel', component: NewLogiciel },
      { path: 'new-utilisateur', component: NewUtilisateur },
      { path: 'new-machine', component: NewMachine },
      { path: 'acceuil', component: AcceuilComponent },







    ]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
