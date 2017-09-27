import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { PlenaryErpSharedModule } from '../../shared';
import {
    StreetService,
    StreetPopupService,
    StreetComponent,
    StreetDetailComponent,
    StreetDialogComponent,
    StreetPopupComponent,
    StreetDeletePopupComponent,
    StreetDeleteDialogComponent,
    streetRoute,
    streetPopupRoute,
    StreetResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...streetRoute,
    ...streetPopupRoute,
];

@NgModule({
    imports: [
        PlenaryErpSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        StreetComponent,
        StreetDetailComponent,
        StreetDialogComponent,
        StreetDeleteDialogComponent,
        StreetPopupComponent,
        StreetDeletePopupComponent,
    ],
    entryComponents: [
        StreetComponent,
        StreetDialogComponent,
        StreetPopupComponent,
        StreetDeleteDialogComponent,
        StreetDeletePopupComponent,
    ],
    providers: [
        StreetService,
        StreetPopupService,
        StreetResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class PlenaryErpStreetModule {}
