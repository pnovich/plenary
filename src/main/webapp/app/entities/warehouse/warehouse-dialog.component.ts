import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { Warehouse } from './warehouse.model';
import { WarehousePopupService } from './warehouse-popup.service';
import { WarehouseService } from './warehouse.service';
import { Company, CompanyService } from '../company';
import { Branch, BranchService } from '../branch';
import { Country, CountryService } from '../country';
import { Region, RegionService } from '../region';
import { Settlement, SettlementService } from '../settlement';
import { Street, StreetService } from '../street';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-warehouse-dialog',
    templateUrl: './warehouse-dialog.component.html'
})
export class WarehouseDialogComponent implements OnInit {

    warehouse: Warehouse;
    isSaving: boolean;

    companies: Company[];

    branches: Branch[];

    countries: Country[];

    regions: Region[];

    settlements: Settlement[];

    streets: Street[];

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private warehouseService: WarehouseService,
        private companyService: CompanyService,
        private branchService: BranchService,
        private countryService: CountryService,
        private regionService: RegionService,
        private settlementService: SettlementService,
        private streetService: StreetService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.companyService.query()
            .subscribe((res: ResponseWrapper) => { this.companies = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
        this.branchService.query()
            .subscribe((res: ResponseWrapper) => { this.branches = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
        this.countryService.query()
            .subscribe((res: ResponseWrapper) => { this.countries = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
        this.regionService.query()
            .subscribe((res: ResponseWrapper) => { this.regions = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
        this.settlementService.query()
            .subscribe((res: ResponseWrapper) => { this.settlements = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
        this.streetService.query()
            .subscribe((res: ResponseWrapper) => { this.streets = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.warehouse.id !== undefined) {
            this.subscribeToSaveResponse(
                this.warehouseService.update(this.warehouse));
        } else {
            this.subscribeToSaveResponse(
                this.warehouseService.create(this.warehouse));
        }
    }

    private subscribeToSaveResponse(result: Observable<Warehouse>) {
        result.subscribe((res: Warehouse) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: Warehouse) {
        this.eventManager.broadcast({ name: 'warehouseListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError(error) {
        try {
            error.json();
        } catch (exception) {
            error.message = error.text();
        }
        this.isSaving = false;
        this.onError(error);
    }

    private onError(error) {
        this.alertService.error(error.message, null, null);
    }

    trackCompanyById(index: number, item: Company) {
        return item.id;
    }

    trackBranchById(index: number, item: Branch) {
        return item.id;
    }

    trackCountryById(index: number, item: Country) {
        return item.id;
    }

    trackRegionById(index: number, item: Region) {
        return item.id;
    }

    trackSettlementById(index: number, item: Settlement) {
        return item.id;
    }

    trackStreetById(index: number, item: Street) {
        return item.id;
    }
}

@Component({
    selector: 'jhi-warehouse-popup',
    template: ''
})
export class WarehousePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private warehousePopupService: WarehousePopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.warehousePopupService
                    .open(WarehouseDialogComponent as Component, params['id']);
            } else {
                this.warehousePopupService
                    .open(WarehouseDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
