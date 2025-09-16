import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { environment } from '../../environments/environment';

export interface Emplacement{
  numEmplacement: number;
  nomEmplacement: string;
  service : string;
}
@Injectable({
  providedIn: 'root'
})
export class EmplacementService {
  private baseUrl = environment.apiBaseUrl + '/emplacements';
  constructor(private http: HttpClient) { }
  public saveEmplacement(data:FormData){
    return this.http.post(this.baseUrl,data);
  }
  deleteEmplacement(id: number) {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

  getAll(): Observable<Emplacement[]> {
    return this.http.get<Emplacement[]>(this.baseUrl);
  }


}
