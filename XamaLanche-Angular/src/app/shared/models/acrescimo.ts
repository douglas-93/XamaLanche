import {Produto} from "./Produto";

export class Acrescimo {
    id: number;
    nome: string;
    ativo: boolean;
    valor: number;
    quantidade: number;
    produto: Produto;
    versao: number;
}
