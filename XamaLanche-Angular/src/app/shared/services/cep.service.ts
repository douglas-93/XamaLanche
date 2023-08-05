import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {CepResponse} from "../models/cepResponse";

@Injectable()
export class CepService {

  url: string = 'http://viacep.com.br/ws/#/json/'

  constructor(private http: HttpClient) {
  }

  buscaCep(cep: string) {
    let urlAjustada = this.url.replace('#', cep)
    return this.http.get<CepResponse>(urlAjustada, {observe: 'response'})
  }
}
