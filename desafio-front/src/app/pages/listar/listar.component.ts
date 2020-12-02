import { Component, OnInit } from '@angular/core';

import { Descricao } from './descricao';
import { ListaService } from '../../shared/services/listar.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.scss']
})
export class ListarComponent implements OnInit {

  descricoes: Descricao[];

  constructor(private services: ListaService) { }

  ngOnInit(): void {

    this.services.list().subscribe(dados => {
      this.descricoes = dados;
    });
  }

}

