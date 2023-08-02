import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginFormComponent, ResetPasswordFormComponent, CreateAccountFormComponent, ChangePasswordFormComponent } from './shared/components';
import { AuthGuardService } from './shared/services';
import { HomeComponent } from './pages/home/home.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { TasksComponent } from './pages/tasks/tasks.component';
import {DxButtonModule, DxDataGridModule, DxFormModule} from 'devextreme-angular';
import { LojaComponent } from './pages/loja/loja.component';
import { ProdutoComponent } from './pages/produto/produto.component';
import { CardapioComponent } from './pages/cardapio/cardapio.component';

const routes: Routes = [
  {
    path: 'pages/cardapio',
    component: CardapioComponent,
    canActivate: [ AuthGuardService ]
  },
  {
    path: 'pages/produto',
    component: ProdutoComponent,
    canActivate: [ AuthGuardService ]
  },
  {
    path: 'pages/loja',
    component: LojaComponent,
    canActivate: [ AuthGuardService ]
  },
  {
    path: 'tasks',
    component: TasksComponent,
    canActivate: [ AuthGuardService ]
  },
  {
    path: 'profile',
    component: ProfileComponent,
    canActivate: [ AuthGuardService ]
  },
  {
    path: 'home',
    component: HomeComponent,
    canActivate: [ AuthGuardService ]
  },
  {
    path: 'login-form',
    component: LoginFormComponent,
    canActivate: [ AuthGuardService ]
  },
  {
    path: 'reset-password',
    component: ResetPasswordFormComponent,
    canActivate: [ AuthGuardService ]
  },
  {
    path: 'create-account',
    component: CreateAccountFormComponent,
    canActivate: [ AuthGuardService ]
  },
  {
    path: 'change-password/:recoveryCode',
    component: ChangePasswordFormComponent,
    canActivate: [ AuthGuardService ]
  },
  {
    path: '**',
    redirectTo: 'home'
  }
];

@NgModule({
    imports: [RouterModule.forRoot(routes, {useHash: true}), DxDataGridModule, DxFormModule, DxButtonModule],
  providers: [AuthGuardService],
  exports: [RouterModule],
  declarations: [
    HomeComponent,
    ProfileComponent,
    TasksComponent,
    LojaComponent,
    ProdutoComponent,
    CardapioComponent
  ]
})
export class AppRoutingModule { }
