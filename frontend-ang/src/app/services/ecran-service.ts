import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Marque} from './marque-service';

export interface Ecran {
  numEcran: number;
  marque: Marque;
  taille: string;
}

@Injectable({
  providedIn: 'root'
})
export class EcranService {
  private baseUrl = 'https://localhost:8080/ecrans';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Ecran[]> {
    return this.http.get<Ecran[]>(this.baseUrl);
  }
}
