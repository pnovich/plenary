import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { Transport } from './transport.model';
import { TransportPopupService } from './transport-popup.service';
import { TransportService } from './transport.service';

@Component({
    selector: 'jhi-transport-delete-dialog',
    templateUrl: './transport-delete-dialog.component.html'
})
export class TransportDeleteDialogComponent {

    transport: Transport;

    constructor(
        private transportService: TransportService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.transportService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'transportListModification',
                content: 'Deleted an transport'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-transport-delete-popup',
    template: ''
})
export class TransportDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private transportPopupService: TransportPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.transportPopupService
                .open(TransportDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
