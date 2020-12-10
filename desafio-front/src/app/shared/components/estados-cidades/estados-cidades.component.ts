import { Component, OnInit } from '@angular/core';
import {ListaService} from "../../services/listar.service";

@Component({
  selector: 'estados-cidades',
  templateUrl: './estados-cidades.component.html',
  styleUrls: ['./estados-cidades.component.scss']
})
export class EstadosCidadesComponent implements OnInit {

  estados: string[] = [];

  constructor(private services: ListaService) { }

  ngOnInit(): void {

    this.services.listaEstados().subscribe(dados => {
      this.estados = dados;
      console.log(this.estados);
    });
  }

}
