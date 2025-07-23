import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

export interface Marque {
  numMarque: number;
  nomMarque: string;
}

@Injectable({
  providedIn: 'root'
})


export class MarqueService {
  private baseUrl = 'https://localhost:8080/marques';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Marque[]> {
    return this.http.get<Marque[]>(this.baseUrl);
  }
}
