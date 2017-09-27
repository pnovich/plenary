import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { PlenaryErpSharedModule } from '../../shared';
import {
    TransportService,
    TransportPopupService,
    TransportComponent,
    TransportDetailComponent,
    TransportDialogComponent,
    TransportPopupComponent,
    TransportDeletePopupComponent,
    TransportDeleteDialogComponent,
    transportRoute,
    transportPopupRoute,
    TransportResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...transportRoute,
    ...transportPopupRoute,
];

@NgModule({
    imports: [
        PlenaryErpSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        TransportComponent,
        TransportDetailComponent,
        TransportDialogComponent,
        TransportDeleteDialogComponent,
        TransportPopupComponent,
        TransportDeletePopupComponent,
    ],
    entryComponents: [
        TransportComponent,
        TransportDialogComponent,
        TransportPopupComponent,
        TransportDeleteDialogComponent,
        TransportDeletePopupComponent,
    ],
    providers: [
        TransportService,
        TransportPopupService,
        TransportResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class PlenaryErpTransportModule {}
