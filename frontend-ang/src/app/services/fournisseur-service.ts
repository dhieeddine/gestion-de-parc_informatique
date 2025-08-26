import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

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
  private baseUrl = 'https://localhost:8443/fournisseurs';
  constructor(private http: HttpClient) { }
  public saveFournisseur(data:FormData){
    return this.http.post('https://localhost:8443/fournisseurs',data);
  }

  deleteFournisseur(id: number) {
    return this.http.delete(`https://localhost:8443/fournisseurs/${id}`);
  }


  getAll(): Observable<Fournisseur[]> {
    return this.http.get<Fournisseur[]>(this.baseUrl);
  }
}
