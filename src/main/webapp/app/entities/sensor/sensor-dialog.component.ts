import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { Sensor } from './sensor.model';
import { SensorPopupService } from './sensor-popup.service';
import { SensorService } from './sensor.service';
import { Company, CompanyService } from '../company';
import { Branch, BranchService } from '../branch';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-sensor-dialog',
    templateUrl: './sensor-dialog.component.html'
})
export class SensorDialogComponent implements OnInit {

    sensor: Sensor;
    isSaving: boolean;

    companies: Company[];

    branches: Branch[];

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private sensorService: SensorService,
        private companyService: CompanyService,
        private branchService: BranchService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.companyService.query()
            .subscribe((res: ResponseWrapper) => { this.companies = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
        this.branchService.query()
            .subscribe((res: ResponseWrapper) => { this.branches = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.sensor.id !== undefined) {
            this.subscribeToSaveResponse(
                this.sensorService.update(this.sensor));
        } else {
            this.subscribeToSaveResponse(
                this.sensorService.create(this.sensor));
        }
    }

    private subscribeToSaveResponse(result: Observable<Sensor>) {
        result.subscribe((res: Sensor) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: Sensor) {
        this.eventManager.broadcast({ name: 'sensorListModification', content: 'OK'});
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
}

@Component({
    selector: 'jhi-sensor-popup',
    template: ''
})
export class SensorPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private sensorPopupService: SensorPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.sensorPopupService
                    .open(SensorDialogComponent as Component, params['id']);
            } else {
                this.sensorPopupService
                    .open(SensorDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
