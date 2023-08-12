import {Component, OnInit, ViewChild} from '@angular/core';
import {LojaService} from "../../shared/services/loja.service";
import {Loja} from "../../shared/models/loja";
import {ModeEnum} from "../../shared/enum/mode.enum";
import {Router} from "@angular/router";
import {DxFormComponent} from "devextreme-angular";
import {Endereco} from "../../shared/models/endereco";
import {SituacaoAtivoInativoEnum} from "../../shared/enum/situacao.ativo.inativo.enum";

@Component({
  selector: 'app-loja',
  templateUrl: './loja.component.html',
  styleUrls: ['./loja.component.scss']
})
export class LojaComponent implements OnInit {

  @ViewChild("mainForm",{static:false}) mainForm: DxFormComponent

  Mode:ModeEnum = ModeEnum.List


  lojas: Loja[];
  loja:Loja;
  protected readonly ModeEnum = ModeEnum;
  situacaoLojas:string[] = Object.values(SituacaoAtivoInativoEnum);
  nomeLojaFilter: string;
  endereco:Endereco[]=[]
  constructor(private lojaService: LojaService,
              private router: Router) { }

  ngOnInit(): void {
    if(this.loja == null){
      this.loja = new Loja()
    }
  }

  doClear(){
    this.mainForm.instance.resetValues()
    // this.nomeLojaFilter = ""
  }
  buscarLojas() {
    if (!this.lojas) {
      this.lojas = []
    }

    this.lojaService.getAll().subscribe(res => {
      if (res.ok) {
        this.lojas = res.body!;
      }
    })
  }
  novaLoja() {
    this.router.navigate(['pages', 'loja'])
    this.Mode = ModeEnum.Edit
  }



  salvarLoja() {
    console.log(this.loja)
    this.lojaService.save(this.loja).subscribe(res => console.log(res))
  }
}
