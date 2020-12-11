import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Estados} from "../../../model/estados";

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

  constructor() {}

  onShown() {
    setTimeout(() => {
      this.loadingVisible = false;
    }, 3000);
  }
  onHidden() {
    this.cidadesinf = this.estradaCidade;
    console.log(this.cidadesinf);
  }
  showListaCidade(){
    this.cidadesinf = {};
    this.loadingVisible = true;
  }

  ngOnInit(): void {  }

   enviaEstado(event: any){
    this.saidaEstado.emit(event);
   }
}
