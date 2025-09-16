import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { environment } from '../../environments/environment';

export interface Garantie {
  numGarantie: number;
  duree: string;
  typeGarantie : string;
}

@Injectable({
  providedIn: 'root'
})
export class GarantieService {
  private baseUrl = environment.apiBaseUrl + '/garanties';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Garantie[]> {
    return this.http.get<Garantie[]>(this.baseUrl);
  }
}
