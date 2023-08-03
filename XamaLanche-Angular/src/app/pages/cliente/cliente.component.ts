import {Component} from '@angular/core';
import {Cliente} from "../../shared/models/cliente";
import {ClienteService} from "../../shared/services/cliente.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.scss']
})
export class ClienteComponent {

  clientes: Cliente[];


  constructor(private clienteService: ClienteService,
              private router: Router) {
  }

  buscaClientes() {
    this.clienteService.getCliente().subscribe(res => {
      if (res.ok) {
        this.clientes = res.body!
      }
    })
  }

  novoCliente() {
    this.router.navigate([])
  }
}
