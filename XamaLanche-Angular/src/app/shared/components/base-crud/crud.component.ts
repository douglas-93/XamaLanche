import {Component, EventEmitter, Input, Output} from "@angular/core";
import {ModeEnum} from "../../enum/mode.enum";
import {Router} from "@angular/router";

@Component({
  selector: 'crud',
  templateUrl: './crud.component.html',
  styleUrls: ['./crud.component.scss']
})
export class CrudComponent {

  modes: any = ModeEnum;

  @Input()
  mode:ModeEnum = ModeEnum.List

  @Input() editToolbarTitle:String;
  @Input() listToolbarTitle:String;


  /**
   * filter button
   */
  @Input() listToolbarFilterButtonIconClass = "fa fa-search";
  @Input() listToolbarFilterButtonText = "Filtrar";
  @Input() listToolbarFilterButtonOrder = 0;
  @Input() listToolbarFilterButtonShow = true;
  @Input() listToolbarFilterButtonTitle = "Filtrar";
  @Input() listToolbarFilterButtonDisabled = false;

  /**
   * new button
   */
  @Input() listToolbarNewButtonIconClass = "fa fa-plus-square";
  @Input() listToolbarNewButtonText = "Novo";
  @Input() listToolbarNewButtonOrder = 1;
  @Input() listToolbarNewButtonShow = true;
  @Input() listToolbarNewButtonTitle = "Novo";
  @Input() listToolbarNewButtonDisabled = false;

  /**
   * clear button
   */
  @Input() listToolbarClearButtonIconClass = "fa fa-eraser";
  @Input() listToolbarClearButtonText = "Limpar";
  @Input() listToolbarClearButtonOrder = 2;
  @Input() listToolbarClearButtonShow = true;
  @Input() listToolbarClearButtonTitle = "Limpar";
  @Input() listToolbarClearButtonDisabled = false;


  /**
   * close button
   */
  @Input() listToolbarCloseButtonIconClass = "fa fa-times-circle";
  @Input() listToolbarCloseButtonText = "Fechar";
  @Input() listToolbarCloseButtonOrder = 3;
  @Input() listToolbarCloseButtonShow = true;
  @Input() listToolbarCloseButtonTitle = "Fechar";
  @Input() listToolbarCloseButtonDisabled = false;



  @Output() filtrar = new EventEmitter();
  @Output() novoCadastro = new EventEmitter();
  @Output() salvar = new EventEmitter();
  @Output() deletar = new EventEmitter();

  @Input() cadastro: boolean;

  @Input() desativarBotaoFechar: boolean;

  edit: boolean;

  constructor(private router: Router) {
    this.edit = this.router.url.includes('edit/')
  }

  filtrarEnv(e: any) {
    this.filtrar.emit(e)
  }

  novoCadEnv(e: any) {
    this.novoCadastro.emit(e)
    this.mode = ModeEnum.Edit
  }

  salvaEnv(e: any) {
    this.salvar.emit(e)
  }

  deleteEnv(e: any) {
    this.deletar.emit(e)
  }

  voltar() {
    window.history.back();
  }

}
