import {Itens} from "./itens";
import {Fornecedor} from "./fornecedor";

export class NotaFiscal {

  id:number;

  numero: number;

  fornecedor: Fornecedor[];

  data: Date;

  estado: string;

  cidade: string;

  itens: Itens[];


}
