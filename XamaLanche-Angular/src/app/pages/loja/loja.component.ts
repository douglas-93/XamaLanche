import {Component, OnInit} from '@angular/core';
import {LojaService} from "../../shared/services/loja.service";
import {Loja} from "../../shared/models/loja";
import {ModeEnum} from "../../shared/enum/modeEnum";
import {Router} from "@angular/router";

@Component({
  selector: 'app-loja',
  templateUrl: './loja.component.html',
  styleUrls: ['./loja.component.scss']
})
export class LojaComponent implements OnInit {


  Mode:ModeEnum = ModeEnum.List


  lojas: Loja[];
  loja:Loja;

  constructor(private lojaService: LojaService,
              private router: Router) { }

  ngOnInit(): void {
    if(this.loja == null){
      this.loja = new Loja()
    }
  }

  buscarLojas() {
    if (!this.lojas) {
      this.lojas = []
    }

    this.lojaService.getAll().subscribe(res => {
      if (res.ok) {
        this.lojas = res.body!;
      }
    })
  }
  novaLoja() {
    this.router.navigate(['pages', 'loja'])
    this.Mode = ModeEnum.Edit
  }


  protected readonly ModeEnum = ModeEnum;

  salvarLoja() {
    console.log(this.loja)
    this.lojaService.save(this.loja).subscribe(res => console.log(res))
  }
}
