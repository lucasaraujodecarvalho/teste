import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ServicoPrestadoRoutingModule } from './servico-prestado-routing.module';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { ServicoPrestadoListaComponent } from './servico-prestado-lista/servico-prestado-lista.component';
import { ServicoPrestadoFormComponent } from './servico-prestado-form/servico-prestado-form.component';


@NgModule({
  declarations: [ServicoPrestadoFormComponent, ServicoPrestadoListaComponent],
  imports: [
    CommonModule,
    ServicoPrestadoRoutingModule,
    FormsModule,
    RouterModule
  ], exports: [
    ServicoPrestadoListaComponent,
    ServicoPrestadoFormComponent
  ]
})
export class ServicoPrestadoModule { }
