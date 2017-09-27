import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { PlenaryErpSharedModule } from '../../shared';
import {
    SettlementService,
    SettlementPopupService,
    SettlementComponent,
    SettlementDetailComponent,
    SettlementDialogComponent,
    SettlementPopupComponent,
    SettlementDeletePopupComponent,
    SettlementDeleteDialogComponent,
    settlementRoute,
    settlementPopupRoute,
    SettlementResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...settlementRoute,
    ...settlementPopupRoute,
];

@NgModule({
    imports: [
        PlenaryErpSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        SettlementComponent,
        SettlementDetailComponent,
        SettlementDialogComponent,
        SettlementDeleteDialogComponent,
        SettlementPopupComponent,
        SettlementDeletePopupComponent,
    ],
    entryComponents: [
        SettlementComponent,
        SettlementDialogComponent,
        SettlementPopupComponent,
        SettlementDeleteDialogComponent,
        SettlementDeletePopupComponent,
    ],
    providers: [
        SettlementService,
        SettlementPopupService,
        SettlementResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class PlenaryErpSettlementModule {}
