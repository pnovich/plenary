import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { Transport } from './transport.model';
import { TransportPopupService } from './transport-popup.service';
import { TransportService } from './transport.service';
import { Company, CompanyService } from '../company';
import { Branch, BranchService } from '../branch';
import { Warehouse, WarehouseService } from '../warehouse';
import { Driver, DriverService } from '../driver';
import { Sensor, SensorService } from '../sensor';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-transport-dialog',
    templateUrl: './transport-dialog.component.html'
})
export class TransportDialogComponent implements OnInit {

    transport: Transport;
    isSaving: boolean;

    companies: Company[];

    branches: Branch[];

    warehouses: Warehouse[];

    drivers: Driver[];

    sensors: Sensor[];

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private transportService: TransportService,
        private companyService: CompanyService,
        private branchService: BranchService,
        private warehouseService: WarehouseService,
        private driverService: DriverService,
        private sensorService: SensorService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.companyService.query()
            .subscribe((res: ResponseWrapper) => { this.companies = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
        this.branchService.query()
            .subscribe((res: ResponseWrapper) => { this.branches = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
        this.warehouseService.query()
            .subscribe((res: ResponseWrapper) => { this.warehouses = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
        this.driverService.query()
            .subscribe((res: ResponseWrapper) => { this.drivers = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
        this.sensorService.query()
            .subscribe((res: ResponseWrapper) => { this.sensors = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.transport.id !== undefined) {
            this.subscribeToSaveResponse(
                this.transportService.update(this.transport));
        } else {
            this.subscribeToSaveResponse(
                this.transportService.create(this.transport));
        }
    }

    private subscribeToSaveResponse(result: Observable<Transport>) {
        result.subscribe((res: Transport) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: Transport) {
        this.eventManager.broadcast({ name: 'transportListModification', content: 'OK'});
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

    trackWarehouseById(index: number, item: Warehouse) {
        return item.id;
    }

    trackDriverById(index: number, item: Driver) {
        return item.id;
    }

    trackSensorById(index: number, item: Sensor) {
        return item.id;
    }
}

@Component({
    selector: 'jhi-transport-popup',
    template: ''
})
export class TransportPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private transportPopupService: TransportPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.transportPopupService
                    .open(TransportDialogComponent as Component, params['id']);
            } else {
                this.transportPopupService
                    .open(TransportDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
