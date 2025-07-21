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
    return this.http.post('http://localhost:8080/emplacements',data);
  }
  deleteEmplacement(id: number) {
    return this.http.delete(`http://localhost:8080/emplacements/${id}`);
  }

  getAll(): Observable<Emplacement[]> {
    return this.http.get<Emplacement[]>('http://localhost:8080/emplacements');
  }


}
