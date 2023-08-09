import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Loja} from "../models/loja";
import {AbstractCrudService} from "./abstract.crud.service";

@Injectable()
export class LojaService extends AbstractCrudService<Loja>{

  constructor(http: HttpClient) {
    super(http, "loja");
  }

}
