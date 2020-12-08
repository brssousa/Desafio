import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';

import {Descricao} from '../../pages/listar/descricao';

@Injectable({
  providedIn: 'root'
})
export class ListaService {

  urlApi = 'http://localhost:8080/descricao';

  constructor(private http: HttpClient) { }


  list(){
    return this.http.get<Descricao[]>(this.urlApi);
  }
  criar(descricao: any){
    return this.http.post(this.urlApi, descricao);
  }
}
