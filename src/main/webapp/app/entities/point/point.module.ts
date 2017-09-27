import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { PlenaryErpSharedModule } from '../../shared';
import {
    PointService,
    PointPopupService,
    PointComponent,
    PointDetailComponent,
    PointDialogComponent,
    PointPopupComponent,
    PointDeletePopupComponent,
    PointDeleteDialogComponent,
    pointRoute,
    pointPopupRoute,
    PointResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...pointRoute,
    ...pointPopupRoute,
];

@NgModule({
    imports: [
        PlenaryErpSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        PointComponent,
        PointDetailComponent,
        PointDialogComponent,
        PointDeleteDialogComponent,
        PointPopupComponent,
        PointDeletePopupComponent,
    ],
    entryComponents: [
        PointComponent,
        PointDialogComponent,
        PointPopupComponent,
        PointDeleteDialogComponent,
        PointDeletePopupComponent,
    ],
    providers: [
        PointService,
        PointPopupService,
        PointResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class PlenaryErpPointModule {}
