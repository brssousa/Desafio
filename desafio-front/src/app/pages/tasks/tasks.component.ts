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
  notaFiscal: Fornecedor;
  fornecedores: Fornecedor[];
  itens: Itens[];


  constructor(private services: ListaService) {}

  ngOnInit(): void {

    this.services.list().subscribe(dados => {
      this.fornecedores = dados;
    });

  }

  // tslint:disable-next-line:typedef
  click(event: any) {
    this.services.criarNota(this.notaFiscal)
      .subscribe((dado: NotaFiscal) => {
        this.notaFiscal = dado;
      });
    console.log(this.notaFiscal);
  }
}
