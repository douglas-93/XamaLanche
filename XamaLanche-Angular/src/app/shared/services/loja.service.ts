import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Loja} from "../models/loja";
import {AbstractCRUDService} from "./abstractCRUD.service";

@Injectable()
export class LojaService extends AbstractCRUDService<Loja>{

  constructor(http: HttpClient) {
    super(http, "loja");
  }

}
