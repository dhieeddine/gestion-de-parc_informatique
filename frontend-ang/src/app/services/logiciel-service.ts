import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { environment } from '../../environments/environment';

export interface Logiciel {
  numL : number;
  nomL : string ;
  typeL : string ;
  licenceL : string ;
  versionL :  string ;
  editeurL :  string ;
  numSerieL : string ;
  dateL : Date ;

}
@Injectable({
  providedIn: 'root'
})
export class LogicielService {
   private baseUrl = environment.apiBaseUrl + '/cogiciels';
   constructor(private http: HttpClient) { }

  deleteLogiciel(id: number) {
    return this.http.delete(`${baseUrl}/${id}`);
  }
  public saveLogiciel(data:FormData){
    return this.http.post(baseUrl,data);
  }


}
