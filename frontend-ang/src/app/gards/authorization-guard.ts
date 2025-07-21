import {ActivatedRouteSnapshot, Router, RouterStateSnapshot} from '@angular/router';
import {Injectable} from '@angular/core';
import {Auth} from '../services/auth';

@Injectable()
export class AuthorizationGuard  {

  constructor(private auth :Auth ,private router: Router) {
  }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if(this.auth.isAuthenticated){
      return true;
    }else{
      this.router.navigateByUrl('/login');
      return false;
    }
  }

}
