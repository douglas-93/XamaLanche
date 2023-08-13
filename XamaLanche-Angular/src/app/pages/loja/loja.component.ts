import {Component, Injector, OnInit, ViewChild} from '@angular/core';
import {LojaService} from "../../shared/services/loja.service";
import {Loja} from "../../shared/models/loja";
import {ModeEnum} from "../../shared/enum/mode.enum";
import {Router} from "@angular/router";
import {DxFormComponent} from "devextreme-angular";
import {Endereco} from "../../shared/models/endereco";
import {SituacaoAtivoInativoEnum} from "../../shared/enum/situacao.ativo.inativo.enum";
import {AbstractCrud} from "../../shared/crud/abstract.crud";
import {Observable} from "rxjs";

@Component({
  selector: 'app-loja',
  templateUrl: './loja.component.html',
  styleUrls: ['./loja.component.scss']
})
export class LojaComponent extends AbstractCrud<Loja,any>  {

  @ViewChild("mainForm",{static:false}) mainForm: DxFormComponent

  Mode:ModeEnum = ModeEnum.List



  loja:Loja;
  protected readonly ModeEnum = ModeEnum;
  situacaoLojas:string[] = Object.values(SituacaoAtivoInativoEnum);
  nomeLojaFilter: string;
  endereco:Endereco[]=[]

  constructor(private injector:Injector,
              private mainService:LojaService,
              private router: Router) {
    super(injector,"/loja");

  }


  protected override doOnInit() {
      if(this.model == null){
        this.model = new Loja()
      }
    super.doOnInit();
  }


  override doClear(){
    this.mainForm.instance.resetValues()
    // this.nomeLojaFilter = ""
  }

  novaLoja() {
    this.router.navigate(['pages', 'loja'])
    this.Mode = ModeEnum.Edit
  }


  override beforeDoSave(): Observable<any> | null {
    console.log(this.model)
    return super.beforeDoSave();
  }

  override getMainService(): any {
    return this.mainService;
  }
}
