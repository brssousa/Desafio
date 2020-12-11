import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ListaService} from "../../services/listar.service";
import {Estados} from "../../../model/estados";
import {Observable} from "rxjs";

@Component({
  selector: 'estados-cidades',
  templateUrl: './estados-cidades.component.html'
})
export class EstadosCidadesComponent implements OnInit {

  estadoUF: Estados;
  loadingVisible = false;
  cidadesinf: any = {};


  @Input() estradaEstado: any | Estados;
  @Input() estradaCidade: any[] | string[];
  @Output() saidaEstado = new EventEmitter;

  constructor(private services: ListaService) {}

  showListaCidade(){
    this.cidadesinf = {};
    this.loadingVisible = true;
  }
  onShown() {
    setTimeout(() => {
      this.loadingVisible = false;
    }, 3000);
  }
  onHidden() {
    this.cidadesinf = this.estradaCidade;
  }

  ngOnInit(): void {  }

   enviaEstado(event: any){
    this.saidaEstado.emit(event);
   }
}
