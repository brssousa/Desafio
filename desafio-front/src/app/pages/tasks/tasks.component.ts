import {Component, OnInit} from '@angular/core';
import 'devextreme/data/odata/store';


import {ListaService} from "../../shared/services/listar.service";
import {Fornecedor} from "../../model/fornecedor";
import {NotaFiscal} from "../../model/nota.fiscal";
import {Itens} from "../../model/itens";

@Component({
  templateUrl: 'tasks.component.html'
})

export class TasksComponent implements OnInit {
  notaFiscal: NotaFiscal = new NotaFiscal();

  fornecedores: Fornecedor[] = [];

  // itensLista: Itens[] = [];

  constructor(private services: ListaService) {

/*
    let item: Itens = new Itens();
    item.item = "Teste";
    item.valor = 2;

    this.itensLista.push(item);
    this.itensLista.push(item);
*/
  }
  ngOnInit(): void {

    this.notaFiscal.itens = new Array();
    let item: Itens = new Itens();
    item.item = "Teste";
    item.valor = 2;
    this.notaFiscal.itens.push(item);
    this.notaFiscal.itens.push(item);


    this.services.list()
      .subscribe(dados => {
      this.fornecedores = dados;
    });
  }


}
