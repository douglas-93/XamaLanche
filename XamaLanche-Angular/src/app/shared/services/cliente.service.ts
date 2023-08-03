import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Loja} from "../models/loja";
import {Cliente} from "../models/cliente";

@Injectable()
export class ClienteService {
  url: string = 'http://localhost:8080/cliente';

  constructor(private http: HttpClient) {
  }

  getCliente() {
    return this.http.get<Cliente[]>(`${this.url}`, {observe: 'response'});
  }
}
