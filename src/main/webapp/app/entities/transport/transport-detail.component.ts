import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { JhiEventManager } from 'ng-jhipster';

import { Transport } from './transport.model';
import { TransportService } from './transport.service';

@Component({
    selector: 'jhi-transport-detail',
    templateUrl: './transport-detail.component.html'
})
export class TransportDetailComponent implements OnInit, OnDestroy {

    transport: Transport;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private transportService: TransportService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInTransports();
    }

    load(id) {
        this.transportService.find(id).subscribe((transport) => {
            this.transport = transport;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInTransports() {
        this.eventSubscriber = this.eventManager.subscribe(
            'transportListModification',
            (response) => this.load(this.transport.id)
        );
    }
}
