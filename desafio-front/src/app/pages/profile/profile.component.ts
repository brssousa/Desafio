import {Component, OnInit} from '@angular/core';

import {ListaService} from '../../shared/services/listar.service';
import {Descricao} from '../listar/descricao';


@Component({
  templateUrl: 'profile.component.html',
  styleUrls: [ './profile.component.scss' ]
})

export class ProfileComponent implements OnInit{

  descricao: Descricao;
  template = 'buttonTemplate';

  constructor(private services: ListaService) { }

  // tslint:disable-next-line:typedef
  click(event: any) {
    this.services.criar(this.descricao)
      .subscribe((dado: Descricao) => {
        this.descricao = dado;
      });
    console.log(this.descricao);
    
  }

  ngOnInit(): void {

  }
}