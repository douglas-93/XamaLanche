import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Cliente} from "../models/cliente";
import {AbstractCrudService} from "./abstract.crud.service";

@Injectable()
export class ClienteService extends AbstractCrudService<Cliente> {

    constructor(http: HttpClient) {
        super(http, 'clientes');
    }

}
