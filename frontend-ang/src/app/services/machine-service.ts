import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MachineService {
  private baseUrl = environment.apiBaseUrl + '/machines';
  constructor(private http: HttpClient) { }
  deleteMachine(id: number) {
    return this.http.delete(`${baseUrl}/${id}`);
  }
  saveMachine(data:FormData)
  {
    return this.http.post(baseUrl,data);


  }



}
