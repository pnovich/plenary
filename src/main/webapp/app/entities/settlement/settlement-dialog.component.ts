import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { Settlement } from './settlement.model';
import { SettlementPopupService } from './settlement-popup.service';
import { SettlementService } from './settlement.service';
import { Region, RegionService } from '../region';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-settlement-dialog',
    templateUrl: './settlement-dialog.component.html'
})
export class SettlementDialogComponent implements OnInit {

    settlement: Settlement;
    isSaving: boolean;

    regions: Region[];

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private settlementService: SettlementService,
        private regionService: RegionService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.regionService.query()
            .subscribe((res: ResponseWrapper) => { this.regions = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.settlement.id !== undefined) {
            this.subscribeToSaveResponse(
                this.settlementService.update(this.settlement));
        } else {
            this.subscribeToSaveResponse(
                this.settlementService.create(this.settlement));
        }
    }

    private subscribeToSaveResponse(result: Observable<Settlement>) {
        result.subscribe((res: Settlement) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: Settlement) {
        this.eventManager.broadcast({ name: 'settlementListModification', content: 'OK'});
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

    trackRegionById(index: number, item: Region) {
        return item.id;
    }
}

@Component({
    selector: 'jhi-settlement-popup',
    template: ''
})
export class SettlementPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private settlementPopupService: SettlementPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.settlementPopupService
                    .open(SettlementDialogComponent as Component, params['id']);
            } else {
                this.settlementPopupService
                    .open(SettlementDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
