import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

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
  private baseUrl = 'https://localhost:8080/ddurs';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Ddur[]> {
    return this.http.get<Ddur[]>(this.baseUrl);
  }
}
