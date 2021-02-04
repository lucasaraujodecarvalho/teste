import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { Usuario } from './usuario';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  username: string;
  password: string;
  errors: String[];
  isRegister: boolean;
  messageSuccess: string;
  
  constructor(
    private router: Router,
    private authService: AuthService
    ) { }

  onSubmit() {
    this.router.navigate(['/home'])
    console.log(`User: ${this.username}, Pass: ${this.password}`)
  }

  prepareRegistration(event) {
    event.preventDefault();
    this.isRegister = true;
  }

  unregister() {
    this.isRegister = false;
  }

  register() {
    const usuario: Usuario = new Usuario();
    usuario.username = this.username;
    usuario.password = this.password;
    this.authService
      .salvar(usuario)
      .subscribe( response => {
        this.messageSuccess = "Cadastro realizado com sucesso !";
        this.isRegister = false;
        this.username = '';
        this.password = '';
        this.errors = []
      }, errorResponse => {
        this.messageSuccess = null;
        this.errors = errorResponse.error.errors;
      })
  }
}
