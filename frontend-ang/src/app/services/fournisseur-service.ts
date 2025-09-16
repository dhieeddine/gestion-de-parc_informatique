import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { environment } from '../../environments/environment'; // Import the environment

export interface Fournisseur {
  numF : number;
  nomF : string;
  adresseF : string;
  codePF : string;
  telF : string;

}
@Injectable({
  providedIn: 'root'
})
export class FournisseurService {
  private baseUrl = environment.apiBaseUrl + '/fournisseurs';

  constructor(private http: HttpClient) { }
  public saveFournisseur(data:FormData){
    return this.http.post(this.baseUrl,data);
  }

  deleteFournisseur(id: number) {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }


  getAll(): Observable<Fournisseur[]> {
    return this.http.get<Fournisseur[]>(this.baseUrl);
  }
}
