import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

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
   constructor(private http: HttpClient) { }

  deleteLogiciel(id: number) {
    return this.http.delete(`https://localhost:8080/logiciels/${id}`);
  }
  public saveLogiciel(data:FormData){
    return this.http.post('https://localhost:8080/logiciels',data);
  }


}
