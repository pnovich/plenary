import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { Street } from './street.model';
import { StreetPopupService } from './street-popup.service';
import { StreetService } from './street.service';
import { Settlement, SettlementService } from '../settlement';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-street-dialog',
    templateUrl: './street-dialog.component.html'
})
export class StreetDialogComponent implements OnInit {

    street: Street;
    isSaving: boolean;

    settlements: Settlement[];

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private streetService: StreetService,
        private settlementService: SettlementService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.settlementService.query()
            .subscribe((res: ResponseWrapper) => { this.settlements = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.street.id !== undefined) {
            this.subscribeToSaveResponse(
                this.streetService.update(this.street));
        } else {
            this.subscribeToSaveResponse(
                this.streetService.create(this.street));
        }
    }

    private subscribeToSaveResponse(result: Observable<Street>) {
        result.subscribe((res: Street) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: Street) {
        this.eventManager.broadcast({ name: 'streetListModification', content: 'OK'});
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

    trackSettlementById(index: number, item: Settlement) {
        return item.id;
    }
}

@Component({
    selector: 'jhi-street-popup',
    template: ''
})
export class StreetPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private streetPopupService: StreetPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.streetPopupService
                    .open(StreetDialogComponent as Component, params['id']);
            } else {
                this.streetPopupService
                    .open(StreetDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
