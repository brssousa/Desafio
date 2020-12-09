import {Component, OnInit} from '@angular/core';

import {ListaService} from '../../shared/services/listar.service';
import {Fornecedor} from "../../model/fornecedor";



@Component({
  templateUrl: 'profile.component.html',
  styleUrls: [ './profile.component.scss' ]
})

export class ProfileComponent implements OnInit{

  fornecedor: Fornecedor = new Fornecedor();
  template = 'buttonTemplate';

  constructor(private services: ListaService) { }

  // tslint:disable-next-line:typedef
  click(event: any) {
    this.services.criar(this.fornecedor)
      .subscribe((dado: Fornecedor) => {
        this.fornecedor = new Fornecedor();
      });
    console.log(this.fornecedor);

  }

  ngOnInit(): void {

  }
}
