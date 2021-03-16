import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth.service';
import { Login } from '../login';

@Component({
  selector: 'app-usuarios-lista',
  templateUrl: './usuarios-lista.component.html',
  styleUrls: ['./usuarios-lista.component.css']
})
export class UsuariosListaComponent implements OnInit {

  logins: Login[] = [];
  mensagemSucesso: String;
  mensagemErro: String;

  constructor(
    private service: AuthService,
    ) { }

  ngOnInit(): void {
    this.service
    .getUsuarios()
    .subscribe( resposta => this.logins = resposta )
  }

}
