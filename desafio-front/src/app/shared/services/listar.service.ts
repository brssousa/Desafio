import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';

import {Fornecedor} from "../../model/fornecedor";
import {Estados} from "../../model/estados";



@Injectable({
  providedIn: 'root'
})
export class ListaService {

  urlApi = 'http://localhost:8080/fornecedor';
  apiNotas = 'http://localhost:8080/notaFiscal';
  estadoApi = 'https://servicodados.ibge.gov.br/api/v1/localidades/estados/31|35';
  cidadeApi = 'https://servicodados.ibge.gov.br/api/v1/localidades/estados/35/distritos?orderBy=nome';

  constructor(private http: HttpClient) { }


  list(){
    return this.http.get<Fornecedor[]>(this.urlApi);
  }

  listaEstados(){
    return this.http.get<Estados[]>(this.estadoApi);
  }

  listaCidades(){
    return this.http.get<string[]>(this.cidadeApi);
  }

  criar(fornecedor: any){
    return this.http.post(this.urlApi, fornecedor);
  }

  criarNota(nota: any){
    return this.http.post(this.apiNotas, nota);
  }
}
