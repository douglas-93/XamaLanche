import { Component, OnInit } from '@angular/core';
import {LojaService} from "../../shared/services/loja.service";
import {Loja} from "../../shared/models/loja";

@Component({
  selector: 'app-loja',
  templateUrl: './loja.component.html',
  styleUrls: ['./loja.component.scss']
})
export class LojaComponent implements OnInit {

  lojas: Loja[];

  constructor(private lojaService: LojaService) { }

  ngOnInit(): void {
  }

  buscarLojas() {
    if (!this.lojas) {
      this.lojas = []
    }

    this.lojaService.getLoja().subscribe(res => {
      if (res.ok) {
        this.lojas = res.body!;
      }
    })
  }
}
