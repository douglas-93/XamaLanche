import {Endereco} from "./endereco";

class Cardapio {
}

export class Loja {
  id: number;
  nome: string;
  telefone:string;
  email:string;
  dataAbertura:Date;
  situacao:Boolean;
  endereco: Endereco[];
  pedidoMinimo: number;
  cardapio: Cardapio[];
  versao: number = 0;

}
