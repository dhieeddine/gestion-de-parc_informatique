import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

export interface Utilisateur {
  numU : number ;
  nomU :string ;
  prenomU : string ;
  password : string ;
  droitU : string ;
}
@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {
  constructor(private http: HttpClient) { }
  deleteUtilisateur(id: number) {
    return this.http.delete(`http://localhost:8080/utilisateurs/${id}`);
  }
  getUtilisateurs(): Observable<any[]> {
    return this.http.get<any[]>(`http://localhost:8080/utilisateurs`);
  }

  public saveUtilisateur(data:FormData){
    return this.http.post('http://localhost:8080/utilisateurs',data);
  }


}
