import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

export interface Emplacement{
  numEmplacement: number;
  nomEmplacement: string;
  service : string;
}
@Injectable({
  providedIn: 'root'
})
export class EmplacementService {
  constructor(private http: HttpClient) { }
  public saveEmplacement(data:FormData){
    return this.http.post('https://localhost:8443/emplacements',data);
  }
  deleteEmplacement(id: number) {
    return this.http.delete(`https://localhost:8443/emplacements/${id}`);
  }

  getAll(): Observable<Emplacement[]> {
    return this.http.get<Emplacement[]>('https://localhost:8443/emplacements');
  }


}
