import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Cliente} from "../models/cliente";
import {AbstractCrudService} from "./abstract.crud.service";

@Injectable()
export class ClienteService extends AbstractCrudService<Cliente, any> {

    constructor(http: HttpClient) {
        super(http, 'cliente');
    }

}
