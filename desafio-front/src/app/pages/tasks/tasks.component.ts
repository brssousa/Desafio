import {Component, OnInit} from '@angular/core';
import 'devextreme/data/odata/store';


import {ListaService} from "../../shared/services/listar.service";
import {Fornecedor} from "../../model/fornecedor";
import {Itens} from "../../model/itens";
import {NotaFiscal} from "../../model/nota.fiscal";

@Component({
  templateUrl: 'tasks.component.html'
})

export class TasksComponent implements OnInit {
  notaFiscal: NotaFiscal = new NotaFiscal();
  fornecedores: Fornecedor[];
  fornecedor: Fornecedor;
  itens: Itens[];


  constructor(private services: ListaService) {}

  ngOnInit(): void {

    this.notaFiscal.itens = new Array();

    this.services.list().subscribe(dados => {
      this.fornecedores = dados;
    });

  }

  click(event: NotaFiscal) {
    this.services.criarNota(this.notaFiscal)
      .subscribe((dado: NotaFiscal) => {
        this.notaFiscal = dado;
      });
    console.log(this.notaFiscal);
  }
}
