import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ListaService} from "../../services/listar.service";
import {Estados} from "../../../model/estados";
import {Observable} from "rxjs";

@Component({
  selector: 'estados-cidades',
  templateUrl: './estados-cidades.component.html'
})
export class EstadosCidadesComponent implements OnInit {

  /*estados: Observable<Estados[]>;*/
  estadoUF: Estados;
  /*cidades: string[] = [];*/

  @Input() estradaEstado: any | Estados;
  @Input() estradaCidade: any[] | string[];
  @Output() saidaEstado = new EventEmitter;

  constructor(private services: ListaService) { }

  ngOnInit(): void {

    /*this.estados = this.services.listaEstados();*/

  }

   enviaEstado(event: any){
    this.saidaEstado.emit(event);
   }

  /*setEstado(event: Estados){
   if(event && event!=this.estadoUF){
     this.estadoUF = event;
     this.services.listaCidades(this.estadoUF.sigla).subscribe(dados => {
       // @ts-ignore
       this.cidades = dados;
     });
   }
  }*/

}
