import {Component, OnInit, ViewChild} from '@angular/core';
import {ModeEnum} from "../../shared/enum/mode.enum";
import {Router} from "@angular/router";
import {Produto} from "../../shared/models/Produto";
import {DxFormComponent} from "devextreme-angular";
import notify from "devextreme/ui/notify";
import {CrudComponent} from "../../shared/components/base-crud/crud.component";

@Component({
    selector: 'app-produto',
    templateUrl: './produto.component.html',
    styleUrls: ['./produto.component.scss']
})
export class ProdutoComponent implements OnInit {

    @ViewChild('produtoForm') produtoForm: DxFormComponent;
    @ViewChild('crud') crud: CrudComponent;

    mode: ModeEnum = ModeEnum.List;
    isEdit: boolean = false;
    produto: Produto;
    produtos: Produto[];
    dxSelectBoxAtivoOptions: any = ['Ativo', 'Inativo'];
    protected readonly ModeEnum = ModeEnum;

    constructor(private router: Router) {
        this.editCheck();
    }

    ngOnInit(): void {
        this.produto = new Produto();
        this.produto.ativo = true
    }

    novoProduto(): void {
        this.router.navigate(['pages', 'produto', 'edit'])
    }

    salvarProduto() {
        // this.produtoForm.instance.validate();
        if (this.produtoForm.instance.validate().isValid) {
            notify('Salvo com sucesso', 'success', 3000);
            this.crud.voltar();
            return;
        }
        notify('Verifique os campos indicados', 'error', 3000);
    }

    private editCheck() {
        this.isEdit = this.router.url.split('/').includes('edit');
        this.mode = this.isEdit ? ModeEnum.Edit : ModeEnum.List;
    }
}
