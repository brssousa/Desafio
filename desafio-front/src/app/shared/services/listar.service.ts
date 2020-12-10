import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';

import {Fornecedor} from "../../model/fornecedor";



@Injectable({
  providedIn: 'root'
})
export class ListaService {

  urlApi = 'http://localhost:8080/fornecedor';
  apiNotas = 'http://localhost:8080/notaFiscal';

  constructor(private http: HttpClient) { }


  list(){
    return this.http.get<Fornecedor[]>(this.urlApi);
  }
  criar(fornecedor: any){
    return this.http.post(this.urlApi, fornecedor);
  }

  criarNota(nota: any){
    return this.http.post(this.apiNotas, nota);
  }
}
