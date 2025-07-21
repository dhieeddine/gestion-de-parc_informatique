import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

export interface CarteVideo {
  numCarteVideo: number;
  nomCarte: string;
  memoire: string;
}

@Injectable({
  providedIn: 'root'
})
export class CarteVideoService {
  private baseUrl = 'http://localhost:8080/carteVideos';

  constructor(private http: HttpClient) {}

  getAll(): Observable<CarteVideo[]> {
    return this.http.get<CarteVideo[]>(this.baseUrl);
  }
}
