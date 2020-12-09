import { Component, OnInit } from '@angular/core';


import { ListaService } from '../../shared/services/listar.service';
import {Fornecedor} from "../../model/fornecedor";

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.scss']
})
export class ListarComponent implements OnInit {

  fornecedor: Fornecedor[];

  constructor(private services: ListaService) { }

  ngOnInit(): void {

    this.services.list().subscribe(dados => {
      this.fornecedor = dados;
    });
  }

}

