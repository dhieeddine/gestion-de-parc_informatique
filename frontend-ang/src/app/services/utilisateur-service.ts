import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { environment } from '../../environments/environment';

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
  private baseUrl = environment.apiBaseUrl + '/utilisateurs';
  constructor(private http: HttpClient) { }
  deleteUtilisateur(id: number) {
    return this.http.delete(`${baseUrl}/${id}`);
  }
  getUtilisateurs(): Observable<any[]> {
    return this.http.get<any[]>(baseUrl);
  }

  public saveUtilisateur(data:FormData){
    return this.http.post(baseUrl,data);
  }


}
