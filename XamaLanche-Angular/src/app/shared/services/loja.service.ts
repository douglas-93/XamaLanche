import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Loja} from "../models/loja";

@Injectable()
export class LojaService {
  url: string = 'http://localhost:8080/loja';

  constructor(private http: HttpClient) {
  }

  getLoja() {
    return this.http.get<Loja[]>(`${this.url}`, {observe: 'response'});
  }

  saveLoja(loja: Loja){
    return this.http.post(`${this.url}`,loja);
  }
}
