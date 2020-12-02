import {Component, OnInit} from '@angular/core';
import 'devextreme/data/odata/store';

import {Descricao} from "../listar/descricao";
import {ListaService} from "../../shared/services/listar.service";

@Component({
  templateUrl: 'tasks.component.html'
})

export class TasksComponent implements OnInit {
  dataSource: Descricao[];
  priority: any[];

  constructor(private services: ListaService) {
  }
  ngOnInit(): void {

    this.services.list().subscribe(dados => {
      this.dataSource = dados;
    });
  }
}
