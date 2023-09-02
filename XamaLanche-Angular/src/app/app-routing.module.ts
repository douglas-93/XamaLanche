import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {
    ChangePasswordFormComponent
  , CreateAccountFormComponent
  , LoginFormComponent
  , ResetPasswordFormComponent
} from './shared/components';
import {AuthGuardService} from './shared/services';
import {HomeComponent} from './pages/home/home.component';
import {ProfileComponent} from './pages/profile/profile.component';
import {TasksComponent} from './pages/tasks/tasks.component';
import {
    DxButtonModule
  , DxDataGridModule
  , DxDateBoxModule
  , DxFormModule
  , DxLoadPanelModule, DxNumberBoxModule
  , DxSelectBoxModule
  , DxSwitchModule
  , DxTabPanelModule
  , DxTextBoxModule
  , DxValidatorModule
} from 'devextreme-angular';
import {LojaComponent} from './pages/loja/loja.component';
import {ProdutoComponent} from './pages/produto/produto.component';
import {CardapioComponent} from './pages/cardapio/cardapio.component';
import {ClienteComponent} from './pages/cliente/cliente.component';
import {ToolbarModule} from "./shared/components/toolbar/toolbar.component";
import {CrudComponent} from "./shared/components/base-crud/crud.component";
import {CommonModule} from "@angular/common";
import {AppModule} from "./app.module";
import {EnderecoFormComponent} from "./shared/components/endereco-form/endereco-form.component";
import {ReactiveFormsModule} from "@angular/forms";
import {PromocaoComponent} from './pages/promocao/promocao.component';
import {AcrescimoComponent} from './pages/acrescimo/acrescimo.component';

const routes: Routes = [
    {path: 'pages/acrescimo', component: AcrescimoComponent, canActivate: [AuthGuardService]},
    {path: 'pages/acrescimo/edit', component: AcrescimoComponent, canActivate: [AuthGuardService]},

    {path: 'pages/promocao', component: PromocaoComponent, canActivate: [AuthGuardService]},
    {path: 'pages/promocao/edit', component: PromocaoComponent, canActivate: [AuthGuardService]},

    {path: 'pages/cliente', component: ClienteComponent, canActivate: [AuthGuardService]},
    {path: 'pages/cliente/edit', component: ClienteComponent, canActivate: [AuthGuardService]},

    {path: 'pages/cardapio', component: CardapioComponent, canActivate: [AuthGuardService]},
    {path: 'pages/cardapio/edit', component: CardapioComponent, canActivate: [AuthGuardService]},

    {path: 'pages/produto', component: ProdutoComponent, canActivate: [AuthGuardService]},
    {path: 'pages/produto/edit', component: ProdutoComponent, canActivate: [AuthGuardService]},

    {path: 'pages/loja', component: LojaComponent, canActivate: [AuthGuardService]},
    {path: 'pages/loja/edit', component: LojaComponent, canActivate: [AuthGuardService]},

    /*{path: 'tasks', component: TasksComponent, canActivate: [AuthGuardService]},
    {path: 'profile', component: ProfileComponent, canActivate: [AuthGuardService]},
    {path: 'home', component: HomeComponent, canActivate: [AuthGuardService]},*/

    {path: 'login-form', component: LoginFormComponent, canActivate: [AuthGuardService]},
    {path: 'reset-password', component: ResetPasswordFormComponent, canActivate: [AuthGuardService]},
    {path: 'create-account', component: CreateAccountFormComponent, canActivate: [AuthGuardService]},
    {path: 'change-password/:recoveryCode', component: ChangePasswordFormComponent, canActivate: [AuthGuardService]},

    {path: '**', redirectTo: 'home'}
];

@NgModule({
    imports: [RouterModule.forRoot(routes, {useHash: true}), DxDataGridModule, DxFormModule, DxButtonModule, ToolbarModule, DxTextBoxModule, CommonModule, DxLoadPanelModule, ReactiveFormsModule, DxValidatorModule, DxTabPanelModule, DxDateBoxModule, DxSwitchModule, DxSelectBoxModule, DxNumberBoxModule]
  ,
    providers: [AuthGuardService]
  ,
    exports: [RouterModule]
  ,
    declarations: [
        HomeComponent,
        ProfileComponent,
        TasksComponent,
        LojaComponent,
        ProdutoComponent,
        CardapioComponent,
        ClienteComponent,
        CrudComponent,
        EnderecoFormComponent,
        PromocaoComponent,
        AcrescimoComponent
    ]
})
export class AppRoutingModule {
}
