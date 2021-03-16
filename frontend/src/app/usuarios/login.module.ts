import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { LoginRoutingModule } from './login-routing.module';
import { UsuariosListaComponent } from './usuarios-lista/usuarios-lista.component';


@NgModule({
  declarations: [
    UsuariosListaComponent
  ],
  imports: [
    CommonModule,
    LoginRoutingModule,
    FormsModule
  ], exports: [
    UsuariosListaComponent
  ]
})
export class LoginModule { }
