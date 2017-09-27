import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { TransportComponent } from './transport.component';
import { TransportDetailComponent } from './transport-detail.component';
import { TransportPopupComponent } from './transport-dialog.component';
import { TransportDeletePopupComponent } from './transport-delete-dialog.component';

@Injectable()
export class TransportResolvePagingParams implements Resolve<any> {

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

export const transportRoute: Routes = [
    {
        path: 'transport',
        component: TransportComponent,
        resolve: {
            'pagingParams': TransportResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'plenaryErpApp.transport.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'transport/:id',
        component: TransportDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'plenaryErpApp.transport.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const transportPopupRoute: Routes = [
    {
        path: 'transport-new',
        component: TransportPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'plenaryErpApp.transport.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'transport/:id/edit',
        component: TransportPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'plenaryErpApp.transport.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'transport/:id/delete',
        component: TransportDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'plenaryErpApp.transport.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
