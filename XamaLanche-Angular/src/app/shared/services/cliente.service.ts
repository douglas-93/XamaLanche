import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Cliente} from "../models/cliente";
import {AbstractCRUDService} from "./abstractCRUD.service";

@Injectable()
export class ClienteService extends AbstractCRUDService<Cliente> {

    constructor(http: HttpClient,
                path: string = '/clientes') {
        super(path, http);
    }

}
