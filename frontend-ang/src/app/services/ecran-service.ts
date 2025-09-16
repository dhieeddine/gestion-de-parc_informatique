import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Marque} from './marque-service';
import { environment } from '../../environments/environment';

export interface Ecran {
  numEcran: number;
  marque: Marque;
  taille: string;
}

@Injectable({
  providedIn: 'root'
})
export class EcranService {
private baseUrl = environment.apiBaseUrl + '/ecrans;

  constructor(private http: HttpClient) {}

  getAll(): Observable<Ecran[]> {
    return this.http.get<Ecran[]>(this.baseUrl);
  }
}
