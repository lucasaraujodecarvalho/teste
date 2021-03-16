import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from '../auth.guard';
import { LayoutComponent } from '../layout/layout.component';
import { UsuariosListaComponent } from './usuarios-lista/usuarios-lista.component';

const routes: Routes = [
  { path: 'usuarios', component: LayoutComponent, canActivate: [AuthGuard], children: [
   { path: 'lista' , component: UsuariosListaComponent },
    { path: '', redirectTo: '/usuarios/lista', pathMatch: 'full' }
  ] }
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LoginRoutingModule { }
