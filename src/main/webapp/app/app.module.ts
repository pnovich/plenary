import './vendor.ts';

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Ng2Webstorage } from 'ng2-webstorage';

import { PlenaryErpSharedModule, UserRouteAccessService } from './shared';
import { PlenaryErpHomeModule } from './home/home.module';
import { PlenaryErpAboutModule } from './about/about.module';
import { PlenaryErpAdminModule } from './admin/admin.module';
import { PlenaryErpAccountModule } from './account/account.module';
import { PlenaryErpEntityModule } from './entities/entity.module';

import { customHttpProvider } from './blocks/interceptor/http.provider';
import { PaginationConfig } from './blocks/config/uib-pagination.config';

// jhipster-needle-angular-add-module-import JHipster will add new module here

import {
    JhiMainComponent,
    LayoutRoutingModule,
    NavbarComponent,
    ProfileService,
    PageRibbonComponent,
    ActiveMenuDirective,
    ErrorComponent
} from './layouts';

@NgModule({
    imports: [
        BrowserModule,
        LayoutRoutingModule,
        Ng2Webstorage.forRoot({ prefix: 'jhi', separator: '-'}),
        PlenaryErpSharedModule,
        PlenaryErpHomeModule,
        PlenaryErpAboutModule,
        PlenaryErpAdminModule,
        PlenaryErpAccountModule,
        PlenaryErpEntityModule,
        // jhipster-needle-angular-add-module JHipster will add new module here
    ],
    declarations: [
        JhiMainComponent,
        NavbarComponent,
        ErrorComponent,
        PageRibbonComponent,
        ActiveMenuDirective
    ],
    providers: [
        ProfileService,
        customHttpProvider(),
        PaginationConfig,
        UserRouteAccessService
    ],
    bootstrap: [ JhiMainComponent ]
})
export class PlenaryErpAppModule {}
