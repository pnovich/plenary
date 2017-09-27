import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { PlenaryErpSharedModule } from '../../shared';
import {
    StatusService,
    StatusPopupService,
    StatusComponent,
    StatusDetailComponent,
    StatusDialogComponent,
    StatusPopupComponent,
    StatusDeletePopupComponent,
    StatusDeleteDialogComponent,
    statusRoute,
    statusPopupRoute,
    StatusResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...statusRoute,
    ...statusPopupRoute,
];

@NgModule({
    imports: [
        PlenaryErpSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        StatusComponent,
        StatusDetailComponent,
        StatusDialogComponent,
        StatusDeleteDialogComponent,
        StatusPopupComponent,
        StatusDeletePopupComponent,
    ],
    entryComponents: [
        StatusComponent,
        StatusDialogComponent,
        StatusPopupComponent,
        StatusDeleteDialogComponent,
        StatusDeletePopupComponent,
    ],
    providers: [
        StatusService,
        StatusPopupService,
        StatusResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class PlenaryErpStatusModule {}
