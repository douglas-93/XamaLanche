import {Component, ViewChild} from '@angular/core';
import {Endereco} from '../../models/endereco';
import {ChangeEvent} from 'devextreme/ui/text_box';
import {CepService} from '../../services/cep.service';
import notify from 'devextreme/ui/notify';
import {DxFormComponent} from 'devextreme-angular';
import {GoogleMapsAPIService} from '../../services/googleMapsAPI.service';

@Component({
    selector: 'app-endereco-form',
    templateUrl: './endereco-form.component.html',
    styleUrls: ['./endereco-form.component.scss']
})
export class EnderecoFormComponent {

    @ViewChild('enderecoForm', {static: false}) enderecoForm: DxFormComponent;
    endereco: Endereco;

    lat: number;
    long: number;


    constructor(private cepService: CepService,
                private googleMapsAPISerivce: GoogleMapsAPIService) {
        this.endereco = new Endereco();
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
        this.endereco.rua = '';
        this.endereco.bairro = '';
        this.endereco.cidade = '';
        this.endereco.estado = '';
    }

    validateForm() {
        this.enderecoForm.instance.validate();
        return this.enderecoForm.instance.validate().isValid;
    }

    getFormData() {
        return this.enderecoForm.formData;
    }
}
