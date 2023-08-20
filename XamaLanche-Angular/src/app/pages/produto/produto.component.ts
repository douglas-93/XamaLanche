import {Component, OnInit} from '@angular/core';
import {ModeEnum} from "../../shared/enum/mode.enum";
import {Router} from "@angular/router";
import {Produto} from "../../shared/models/Produto";

@Component({
    selector: 'app-produto',
    templateUrl: './produto.component.html',
    styleUrls: ['./produto.component.scss']
})
export class ProdutoComponent implements OnInit {
    mode: ModeEnum = ModeEnum.List;
    isEdit: boolean = false;
    produto: Produto;
    produtos: Produto[];
    dxSelectBoxAtivoOptions: any = ['Ativo', 'Inativo'];

    constructor(private router: Router) {
        this.editCheck();
    }

    ngOnInit(): void {
        this.produto = new Produto();
    }

    novoProduto(): void {
        this.router.navigate(['pages', 'produto', 'edit'])
    }

    private editCheck() {
        this.isEdit = this.router.url.split('/').includes('edit');
        this.mode = this.isEdit ? ModeEnum.Edit : ModeEnum.List;
    }

    protected readonly ModeEnum = ModeEnum;
}
