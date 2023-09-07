import {Component, Injector} from '@angular/core';
import {AbstractCrud} from "../../shared/crud/abstract.crud";
import {Acrescimo} from "../../shared/models/acrescimo";
import {ModeEnum} from "../../shared/enum/mode.enum";
import {Router} from "@angular/router";

@Component({
  selector: 'app-acrescimo',
  templateUrl: './acrescimo.component.html',
  styleUrls: ['./acrescimo.component.scss']
})
export class AcrescimoComponent extends AbstractCrud<Acrescimo, any>{
    mode: ModeEnum = ModeEnum.List;

    protected readonly ModeEnum = ModeEnum;


    constructor(injector: Injector,
                private router: Router) {
        super(injector, '/acrecimo');
    }

    protected override doOnInit() {
        let isEditing: boolean = this.router.url.split('/').includes('edit');
        if (isEditing) {
            this.mode = ModeEnum.Edit;
            this.model = new Acrescimo();
            this.model.ativo = true;
        }
        super.doOnInit();
    }

    novoAcrescimo() {
        this.router.navigate(['pages', 'acrescimo', 'edit'])
    }
}
