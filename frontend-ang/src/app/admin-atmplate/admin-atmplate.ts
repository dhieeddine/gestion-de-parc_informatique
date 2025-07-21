import {Component} from '@angular/core';
import {Auth} from '../services/auth';

@Component({
  selector: 'app-admin-atmplate',
  standalone: false,
  templateUrl: './admin-atmplate.html',
  styleUrl: './admin-atmplate.css'
})
export class AdminAtmplate {
  constructor(public auth: Auth) {
  }

  logout() {
    this.auth.logout();
  }


}
