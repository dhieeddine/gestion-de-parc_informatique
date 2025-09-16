import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { environment } from '../../environments/environment';

export interface Ddur {
  numDD: number;
  capaciteDD: string;
  typeDD: string;
  etatDD : string;
}

@Injectable({
  providedIn: 'root'
})
export class DdurService {
  private baseUrl = environment.apiBaseUrl + '/ddurs';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Ddur[]> {
    return this.http.get<Ddur[]>(this.baseUrl);
  }
}
