import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { SettlementComponent } from './settlement.component';
import { SettlementDetailComponent } from './settlement-detail.component';
import { SettlementPopupComponent } from './settlement-dialog.component';
import { SettlementDeletePopupComponent } from './settlement-delete-dialog.component';

@Injectable()
export class SettlementResolvePagingParams implements Resolve<any> {

    constructor(private paginationUtil: JhiPaginationUtil) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const page = route.queryParams['page'] ? route.queryParams['page'] : '1';
        const sort = route.queryParams['sort'] ? route.queryParams['sort'] : 'id,asc';
        return {
            page: this.paginationUtil.parsePage(page),
            predicate: this.paginationUtil.parsePredicate(sort),
            ascending: this.paginationUtil.parseAscending(sort)
      };
    }
}

export const settlementRoute: Routes = [
    {
        path: 'settlement',
        component: SettlementComponent,
        resolve: {
            'pagingParams': SettlementResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'plenaryErpApp.settlement.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'settlement/:id',
        component: SettlementDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'plenaryErpApp.settlement.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const settlementPopupRoute: Routes = [
    {
        path: 'settlement-new',
        component: SettlementPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'plenaryErpApp.settlement.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'settlement/:id/edit',
        component: SettlementPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'plenaryErpApp.settlement.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'settlement/:id/delete',
        component: SettlementDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'plenaryErpApp.settlement.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
