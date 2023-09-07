import {Component, Injector, ViewChild} from '@angular/core';
import {Cliente} from '../../shared/models/cliente';
import {ClienteService} from '../../shared/services/cliente.service';
import {Router} from '@angular/router';
import {ModeEnum} from 'src/app/shared/enum/mode.enum';
import notify from 'devextreme/ui/notify';
import {ChangeEvent} from 'devextreme/ui/text_box';
import {FormatAndMaks} from '../../shared/utils/FormatAndMaks';
import {DxFormComponent} from 'devextreme-angular';
import {EnderecoFormComponent} from '../../shared/components/endereco-form/endereco-form.component';
import {CrudComponent} from '../../shared/components/base-crud/crud.component';
import {AbstractCrud} from "../../shared/crud/abstract.crud";
import {Observable} from "rxjs";


@Component({
    selector: 'app-cliente',
    templateUrl: './cliente.component.html',
    styleUrls: ['./cliente.component.scss']
})
export class ClienteComponent extends AbstractCrud<Cliente, any>{

    @ViewChild('formularioCliente', {static: false})
    formularioCliente: DxFormComponent;

    @ViewChild('formularioEndereco', {static: false})
    formularioEndereco: EnderecoFormComponent;

    @ViewChild('crud', {static: false}) crud: CrudComponent;
    @ViewChild('filterForm', {static: false}) filterForm: DxFormComponent;


    mode: ModeEnum = ModeEnum.List;
    loadingVisible: boolean = false;
    cliente: Cliente;
    protected readonly ModeEnum = ModeEnum;


    constructor(injector: Injector,
                private mainService:ClienteService,
                private router:Router) {
        super(injector, "/clientes");
    }

    protected override doOnInit() {
        let isEditing: boolean = this.router.url.split('/').includes('edit');
        if (isEditing) {
            this.mode = ModeEnum.Edit;
            this.model = new Cliente();
        }
    }

    override validateSave() {
        if(this.model.nome == null){
            notify('Por favor, preencha o Nome do cliente', 'error', 3000);
            return false;
        }
        if(this.model.telefone == null){
            notify('Por favor, preencha o Telefone do cliente', 'error', 3000);
            return false;
        }
        if(this.model.endereco == null || this.model.endereco?.length <= 0 ){
            notify('Por favor, preencha pelo menos um endereço do cliente', 'error', 3000);
            return false;
        }

        return true;
        super.validateSave();
    }

    override beforeDoSave(): Observable<any> | null {
          if (this.formularioEndereco.getGridData().length > 0 && this.formularioCliente.instance.validate().isValid) {
              this.model.endereco = this.formularioEndereco.getGridData();
          }
        return super.beforeDoSave();
    }


    // buscaClientes() {
    //   this.loadingVisible = true;
    //   this.clienteService.getAll().subscribe(res => {
    //       if (res.ok) {
    //         this.clientes = res.body!;
    //         this.loadingVisible = false;
    //       }
    //     },
    //     error => {
    //       this.loadingVisible = false;
    //       notify('Não foi possível buscar os clientes cadastrados', 'error', 3000);
    //     }
    //   );
    // }
    //
    novoCliente() {
        this.router.navigate(['pages', 'cliente', 'edit']);
    }
    //
    // salvarCliente() {
    //   if (this.formularioEndereco.getGridData().length > 0 && this.formularioCliente.instance.validate().isValid) {
    //     this.cliente.endereco = this.formularioEndereco.getGridData();
    //     this.clienteService.save(this.cliente).subscribe(res => {
    //         if (res.ok) {
    //           notify('Cliente salvo com sucesso', 'success', 3000);
    //           this.crud.voltar();
    //           return;
    //         }
    //         if (res.status != 201) {
    //           notify('Algo deu errado ao tentar salvar', 'error', 3000);
    //           return;
    //         }
    //       },
    //       error => {
    //         notify('Algo deu errado ao tentar salvar', 'error', 3000);
    //         return;
    //       }
    //     );
    //   }
    //   if (!this.formularioCliente.instance.validate().isValid) {
    //     notify('Por favor, preencha os dados do cliente', 'error', 3000);
    //     return;
    //   }
    //   if (this.formularioEndereco.getGridData().length === 0) {
    //     notify('Por favor, adicione ao menos um endereço antes de prosseguir', 'error', 3000);
    //     return;
    //   }
    //
    // }

    formatPhone(e: ChangeEvent) {
        let phone = e.component.instance().option('value');
        this.cliente.telefone = FormatAndMaks.formatPhoneNumber(phone!);
    }

    override getMainService(): any {
        return this.mainService;
    }


    override doClear() {
        this.filterForm.instance.resetValues();
        super.doClear();
    }
}
