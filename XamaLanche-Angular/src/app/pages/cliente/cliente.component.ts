import {Component} from '@angular/core';
import {Cliente} from "../../shared/models/cliente";
import {ClienteService} from "../../shared/services/cliente.service";
import {Router} from "@angular/router";
import {ModeEnum} from "../../shared/enum/modeEnum";

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.scss']
})
export class ClienteComponent {

  mode: ModeEnum = ModeEnum.List;
  clientes: Cliente[];


  constructor(private clienteService: ClienteService,
              private router: Router) {
  }

  buscaClientes() {
    this.clienteService.getAll().subscribe(res => {
      if (res.ok) {
        this.clientes = res.body!
      }
    })
  }

  novoCliente() {
    this.router.navigate(['pages', 'cliente-form'])
  }

  protected readonly ModeEnum = ModeEnum;

  salvarCliente() {

  }
}
