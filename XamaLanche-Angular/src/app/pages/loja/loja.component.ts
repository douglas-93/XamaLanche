import {Component, Injector, ViewChild} from '@angular/core';
import {LojaService} from "../../shared/services/loja.service";
import {Loja} from "../../shared/models/loja";
import {ModeEnum} from "../../shared/enum/mode.enum";
import {Router} from "@angular/router";
import {DxFormComponent} from "devextreme-angular";
import {SituacaoAtivoInativoEnum} from "../../shared/enum/situacao.ativo.inativo.enum";
import {AbstractCrud} from "../../shared/crud/abstract.crud";
import {Observable} from "rxjs";
import {EnderecoFormComponent} from "../../shared/components/endereco-form/endereco-form.component";

@Component({
    selector: 'app-loja',
    templateUrl: './loja.component.html',
    styleUrls: ['./loja.component.scss']
})
export class LojaComponent extends AbstractCrud<Loja, any> {

    @ViewChild("mainForm", {static: false}) mainForm: DxFormComponent;

    @ViewChild('formularioEndereco', {static: false})
    formularioEndereco: EnderecoFormComponent;

    Mode: ModeEnum = ModeEnum.List


    loja: Loja;
    situacaoLojas: string[] = Object.values(SituacaoAtivoInativoEnum);
    nomeLojaFilter: string;
    protected readonly ModeEnum = ModeEnum;

    constructor(private injector: Injector,
                private mainService: LojaService,
                private router: Router) {
        super(injector, "/loja");

    }

    override doClear() {
        this.mainForm.instance.resetValues()
    }

    novaLoja() {
        this.router.navigate(['pages', 'loja'])
        this.Mode = ModeEnum.Edit
    }

    override beforeDoSave(): Observable<any> | null {
        if (this.formularioEndereco.getGridData().length > 0) {
            this.model.endereco = this.formularioEndereco.getGridData();
        }
        return super.beforeDoSave();
    }

    override getMainService(): any {
        return this.mainService;
    }

    protected override doOnInit() {
        if (this.model == null) {
            this.model = new Loja()
        }
        super.doOnInit();
    }
}
