import {Component, ViewChild} from '@angular/core';
import {Cliente} from "../../shared/models/cliente";
import {CepService} from "../../shared/services/cep.service";
import {ChangeEvent} from "devextreme/ui/text_box";
import {Endereco} from "../../shared/models/endereco";
import {DxFormComponent} from "devextreme-angular";
import notify from "devextreme/ui/notify";

@Component({
    selector: 'app-cliente-form',
    templateUrl: './cliente-form.component.html',
    styleUrls: ['./cliente-form.component.scss']
})
export class ClienteFormComponent {

    @ViewChild('formularioCliente') formularioCliente: DxFormComponent;
    @ViewChild('formularioEndereco') formularioEndereco: DxFormComponent;

    cliente: Cliente;
    endereco: Endereco;

    constructor(private cepService: CepService) {
        this.cliente = new Cliente();
        this.endereco = new Endereco();
        this.cliente.endereco = this.endereco;
    }

    buscaCep(e: ChangeEvent) {
        let cep = e.component.instance().option('value')
        if (cep) {
            this.cepService.buscaCep(cep).subscribe(res => {
                if (res.ok) {
                    this.endereco.rua = res.body?.logradouro!
                    this.endereco.bairro = res.body?.bairro!
                    this.endereco.cidade = res.body?.localidade!
                    this.endereco.estado = res.body?.uf!
                }
            })
        }
    }

    salvarCliente() {
        this.formularioCliente.instance.validate();
        this.formularioEndereco.instance.validate();
        notify('Por favor, preencha os dados que estão faltando', 'error', 3000);
    }
}
