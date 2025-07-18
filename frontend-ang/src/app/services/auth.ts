import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class Auth {
  public users: any = {
    admin: { password: 'admin', roles: ['admin', 'user'] },
    user1: { password: 'user', roles: ['user'] },
  };

  public username: string | undefined;
  public isAuthenticated: boolean = false;
  public roles: string[] = [];

  constructor(private router: Router) {
    // ⚠️ Récupérer les données sauvegardées lors d’un refresh
    const storedUsername = localStorage.getItem('username');
    const storedRoles = localStorage.getItem('roles');
    const storedAuth = localStorage.getItem('isAuthenticated');

    if (storedUsername && storedRoles && storedAuth === 'true') {
      this.username = storedUsername;
      this.roles = JSON.parse(storedRoles);
      this.isAuthenticated = true;
    }
  }

  public login(username: string, password: string): boolean {
    if (this.users[username] && this.users[username]['password'] === password) {
      this.username = username;
      this.roles = this.users[username]['roles'];
      this.isAuthenticated = true;

      // ✅ Sauvegarder dans le localStorage
      localStorage.setItem('username', this.username);
      localStorage.setItem('roles', JSON.stringify(this.roles));
      localStorage.setItem('isAuthenticated', 'true');

      return true;
    }
    return false;
  }

  logout() {
    this.isAuthenticated = false;
    this.roles = [];
    this.username = undefined;

    // ❌ Supprimer du localStorage
    localStorage.removeItem('username');
    localStorage.removeItem('roles');
    localStorage.removeItem('isAuthenticated');

    this.router.navigateByUrl('/login');
  }
}
