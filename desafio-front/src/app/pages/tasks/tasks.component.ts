import {Component, OnInit} from '@angular/core';
import 'devextreme/data/odata/store';


import {ListaService} from "../../shared/services/listar.service";
import {Fornecedor} from "../../model/fornecedor";

@Component({
  templateUrl: 'tasks.component.html'
})

export class TasksComponent implements OnInit {
  dataSource: Fornecedor[];
  priority: any[];

  constructor(private services: ListaService) {
  }
  ngOnInit(): void {

    this.services.list().subscribe(dados => {
      this.dataSource = dados;
    });
  }
}
