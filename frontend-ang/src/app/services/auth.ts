import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {UtilisateurService} from './utilisateur-service';

@Injectable({
  providedIn: 'root'
})
export class Auth {
  public users: any = {};
  public username: string | undefined;
  public isAuthenticated: boolean = false;
  public role: string | undefined;

  constructor(private router: Router, private utilisateurService: UtilisateurService) {
    // Charger les utilisateurs depuis la BDD
    this.utilisateurService.getUtilisateurs().subscribe({
      next: (data) => {
        data.forEach(user => {
          this.users[user.nomU] = {
            password: user.password,
            role: user.droitU || 'user'// si `roles` n'est pas dans ton modèle, tu peux ajuster ici
          };
        });

        // Restaurer l'état de session après le chargement
        const storedUsername = localStorage.getItem('username');
        const storedRoles = localStorage.getItem('role');
        const storedAuth = localStorage.getItem('isAuthenticated');

        if (storedUsername && storedRoles && storedAuth === 'true') {
          this.username = storedUsername;
          this.role = storedRoles;
          this.isAuthenticated = true;
        }
      },
      error: (err) => {
        console.error("Erreur lors du chargement des utilisateurs", err);
      }
    });
  }

  public login(username: string, password: string): boolean {
    if (this.users[username] && this.users[username]['role'] && this.users[username]['password'] === password) {
      this.username = username;
      this.role = this.users[username]['role'];
      this.isAuthenticated = true;

      localStorage.setItem('username', this.username);

      localStorage.setItem('role', this.users[username]['role']);
      localStorage.setItem('isAuthenticated', 'true');

      return true;
    }
    return false;
  }

  logout() {
    this.isAuthenticated = false;
    this.role = undefined;
    this.username = undefined;

    localStorage.clear();

    this.router.navigateByUrl('/login');
  }
}
