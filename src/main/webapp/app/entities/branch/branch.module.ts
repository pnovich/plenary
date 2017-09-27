import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { PlenaryErpSharedModule } from '../../shared';
import {
    BranchService,
    BranchPopupService,
    BranchComponent,
    BranchDetailComponent,
    BranchDialogComponent,
    BranchPopupComponent,
    BranchDeletePopupComponent,
    BranchDeleteDialogComponent,
    branchRoute,
    branchPopupRoute,
    BranchResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...branchRoute,
    ...branchPopupRoute,
];

@NgModule({
    imports: [
        PlenaryErpSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        BranchComponent,
        BranchDetailComponent,
        BranchDialogComponent,
        BranchDeleteDialogComponent,
        BranchPopupComponent,
        BranchDeletePopupComponent,
    ],
    entryComponents: [
        BranchComponent,
        BranchDialogComponent,
        BranchPopupComponent,
        BranchDeleteDialogComponent,
        BranchDeletePopupComponent,
    ],
    providers: [
        BranchService,
        BranchPopupService,
        BranchResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class PlenaryErpBranchModule {}
