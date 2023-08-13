import {Component, ViewChild} from '@angular/core';
import {Endereco} from '../../models/endereco';
import {ChangeEvent} from 'devextreme/ui/text_box';
import {CepService} from '../../services/cep.service';
import notify from 'devextreme/ui/notify';
import {DxDataGridComponent, DxFormComponent} from 'devextreme-angular';
import {GoogleMapsAPIService} from '../../services/googleMapsAPI.service';

@Component({
    selector: 'app-endereco-form',
    templateUrl: './endereco-form.component.html',
    styleUrls: ['./endereco-form.component.scss']
})
export class EnderecoFormComponent {

    @ViewChild('enderecoForm', {static: false}) enderecoForm: DxFormComponent;
    @ViewChild('grid', {static: false}) grid: DxDataGridComponent;

    endereco: Endereco;
    enderecoSelecinado: Endereco;
    gridData: Endereco[];
    lat: number;
    long: number;

    constructor(private cepService: CepService,
                private googleMapsAPISerivce: GoogleMapsAPIService) {
        this.endereco = new Endereco();
        this.gridData = [];
        this.addAddress = this.addAddress.bind(this);
        this.removeAddress = this.removeAddress.bind(this);
        this.editAddress = this.editAddress.bind(this);
    }

    getLocation() {
        navigator.geolocation.getCurrentPosition(position => {
            this.lat = position.coords.latitude;
            this.long = position.coords.longitude;
            this.googleMapsAPISerivce.getAddress(this.lat, this.long).subscribe(res => {
                if (res.ok) {
                    res.body?.results.at(0)!.address_components.forEach(data => {
                        if (data.types.includes('street_number')) {
                            this.endereco.numero = data.long_name;
                        }
                        if (data.types.includes('route')) {
                            this.endereco.rua = data.long_name;
                        }
                        if (data.types.includes('sublocality_level_1')) {
                            this.endereco.bairro = data.long_name;
                        }
                        if (data.types.includes('administrative_area_level_2')) {
                            this.endereco.cidade = data.long_name;
                        }
                        if (data.types.includes('administrative_area_level_1')) {
                            this.endereco.estado = data.short_name;
                        }
                        /*if (data.types.includes('country')) {
                            this.endereco.pais = data.short_name;
                        }
                        if (data.types.includes('postal_code')) {
                            this.endereco.cep = data.long_name;
                        }*/
                    });
                }
            });
        });
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
                        this.clearEndereco();
                        notify('Não conseguimos identificar seu CEP', 'error', 3000);
                    }
                }
            );
        }
    }

    clearEndereco() {
        /*this.endereco.rua = '';
        this.endereco.bairro = '';
        this.endereco.cidade = '';
        this.endereco.estado = '';*/
        this.endereco = new Endereco();
    }

    validateForm() {
        this.enderecoForm.instance.validate();
        return this.enderecoForm.instance.validate().isValid;
    }

    private getFormData() {
        return this.enderecoForm.formData;
    }

    getGridData() {
        return this.gridData;
    }

    onToolbarPreparing(e: any) {
        // Adicione botões personalizados à toolbar
        e.toolbarOptions.items.push(
            {
                location: 'after',
                widget: 'dxButton',
                options: {
                    icon: 'fa fa-plus-circle',
                    onClick: this.addAddress,
                    onEnterKey: this.addAddress
                }
            },
            {
                location: 'after',
                widget: 'dxButton',
                options: {
                    icon: 'fa fa-minus-circle',
                    onClick: this.removeAddress,
                }
            },
            {
                location: 'after',
                widget: 'dxButton',
                options: {
                    icon: 'fa fa-pencil',
                    onClick: this.editAddress,
                }
            }
        );
    }

    editAddress() {
        let indexOfAddress = this.gridData.indexOf(this.enderecoSelecinado);
        if (indexOfAddress != -1) {
            this.endereco = this.enderecoSelecinado
            this.gridData.splice(indexOfAddress, 1);
            this.enderecoSelecinado = new Endereco();
            return;
        }
        notify('Selecione o endereço a ser editado', 'warning', 3000);
    }

    removeAddress() {
        let indexOfAddress = this.gridData.indexOf(this.enderecoSelecinado);
        if (indexOfAddress != -1) {
            this.gridData.splice(indexOfAddress, 1);
            this.enderecoSelecinado = new Endereco();
        } else {
            notify('Selecione o endereço a ser removido', 'warning', 3000);
        }
    }

    addAddress() {
        if (this.validateForm()) {
            this.gridData.push(this.getFormData());
            this.clearEndereco();
            return;
        }
        notify('Preencha todos os campos solicitados', 'error', 3000);
    }

    selectAddress(e: any) {
        e.component.byKey(e.currentSelectedRowKeys[0]).done(endereco => {
            if (endereco) {
                this.enderecoSelecinado = endereco;
            }
        });
    }
}
