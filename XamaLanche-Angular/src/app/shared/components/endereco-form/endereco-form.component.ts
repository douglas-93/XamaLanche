import {Component, ViewChild} from '@angular/core';
import {Endereco} from "../../models/endereco";
import {ChangeEvent} from "devextreme/ui/text_box";
import {CepService} from "../../services/cep.service";
import notify from "devextreme/ui/notify";
import {DxFormComponent} from "devextreme-angular";

@Component({
    selector: 'app-endereco-form',
    templateUrl: './endereco-form.component.html',
    styleUrls: ['./endereco-form.component.scss']
})
export class EnderecoFormComponent {

    @ViewChild('enderecoForm', {static: false}) enderecoForm: DxFormComponent;
    endereco: Endereco;


    constructor(private cepService: CepService) {
        this.endereco = new Endereco();
    }

    buscaCep(e: ChangeEvent) {
        let cep = e.component.instance().option('value');
        if (cep) {
            this.cepService.buscaCep(cep).subscribe(res => {
                    if (res.ok && res.body?.erro !== true) {
                        this.endereco.rua = res.body?.logradouro!;
                        this.endereco.bairro = res.body?.bairro!;
                        this.endereco.cidade = res.body?.localidade!;
                        this.endereco.estado = res.body?.uf!;
                        return;
                    }
                    if (res.body?.erro === true) {
                        this.clearEndereco()
                        notify('Não conseguimos identificar seu CEP', 'error', 3000);
                    }
                }
            );
        }
    }

    clearEndereco() {
        this.endereco.rua = '';
        this.endereco.bairro = '';
        this.endereco.cidade = '';
        this.endereco.estado = '';
    }

    validateForm() {
        this.enderecoForm.instance.validate()
        return this.enderecoForm.instance.validate().isValid
    }

    getFormData() {
        return this.enderecoForm.formData
    }
}
