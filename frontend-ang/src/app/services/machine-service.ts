import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MachineService {
  constructor(private http: HttpClient) { }
  deleteMachine(id: number) {
    return this.http.delete(`http://localhost:8080/machines/${id}`);
  }
  saveMachine(data:FormData)
  {
    return this.http.post('http://localhost:8080/machines',data);


  }



}
