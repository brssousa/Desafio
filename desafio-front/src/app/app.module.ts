import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {SideNavInnerToolbarModule, SideNavOuterToolbarModule, SingleCardModule} from './layouts';
import {FooterModule, LoginFormModule} from './shared/components';
import {AppInfoService, AuthService, ScreenService} from './shared/services';
import {NotAuthorizedContainerModule} from './not-authorized-container';
import {
    DxButtonModule,
    DxDataGridModule,
    DxFormModule,
    DxLoadPanelModule,
    DxSelectBoxModule,
    DxTemplateModule
} from 'devextreme-angular';
import {HttpClientModule} from '@angular/common/http';
import {HomeComponent} from './pages/home/home.component';
import {ProfileComponent} from './pages/profile/profile.component';
import {TasksComponent} from './pages/tasks/tasks.component';
import {ListarComponent} from './pages/listar/listar.component';
import {ListaService} from './shared/services/listar.service';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AppRoutingModule} from './app-routing.module';
import { ItensNotaComponent } from './pages/itens-nota/itens-nota.component';
import { EstadosCidadesComponent } from './shared/components/estados-cidades/estados-cidades.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ProfileComponent,
    TasksComponent,
    ListarComponent,
    ItensNotaComponent,
    EstadosCidadesComponent
  ],
    imports: [
        BrowserModule,
        SideNavOuterToolbarModule,
        SideNavInnerToolbarModule,
        SingleCardModule,
        FooterModule,
        LoginFormModule,
        NotAuthorizedContainerModule,
        DxDataGridModule,
        DxButtonModule,
        DxFormModule,
        DxTemplateModule,
        HttpClientModule,
        ReactiveFormsModule,
        FormsModule,
        AppRoutingModule,
        DxSelectBoxModule,
        DxLoadPanelModule
    ],
  providers: [
    AuthService,
    ScreenService,
    AppInfoService,
    ListaService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
