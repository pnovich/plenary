import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { Task } from './task.model';
import { TaskPopupService } from './task-popup.service';
import { TaskService } from './task.service';
import { Company, CompanyService } from '../company';
import { Branch, BranchService } from '../branch';
import { Warehouse, WarehouseService } from '../warehouse';
import { Transport, TransportService } from '../transport';
import { Point, PointService } from '../point';
import { Status, StatusService } from '../status';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-task-dialog',
    templateUrl: './task-dialog.component.html'
})
export class TaskDialogComponent implements OnInit {

    task: Task;
    isSaving: boolean;

    companies: Company[];

    branches: Branch[];

    warehouses: Warehouse[];

    transports: Transport[];

    points: Point[];

    statuses: Status[];

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private taskService: TaskService,
        private companyService: CompanyService,
        private branchService: BranchService,
        private warehouseService: WarehouseService,
        private transportService: TransportService,
        private pointService: PointService,
        private statusService: StatusService,
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
        this.transportService.query()
            .subscribe((res: ResponseWrapper) => { this.transports = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
        this.pointService.query()
            .subscribe((res: ResponseWrapper) => { this.points = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
        this.statusService.query()
            .subscribe((res: ResponseWrapper) => { this.statuses = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.task.id !== undefined) {
            this.subscribeToSaveResponse(
                this.taskService.update(this.task));
        } else {
            this.subscribeToSaveResponse(
                this.taskService.create(this.task));
        }
    }

    private subscribeToSaveResponse(result: Observable<Task>) {
        result.subscribe((res: Task) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: Task) {
        this.eventManager.broadcast({ name: 'taskListModification', content: 'OK'});
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

    trackTransportById(index: number, item: Transport) {
        return item.id;
    }

    trackPointById(index: number, item: Point) {
        return item.id;
    }

    trackStatusById(index: number, item: Status) {
        return item.id;
    }
}

@Component({
    selector: 'jhi-task-popup',
    template: ''
})
export class TaskPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private taskPopupService: TaskPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.taskPopupService
                    .open(TaskDialogComponent as Component, params['id']);
            } else {
                this.taskPopupService
                    .open(TaskDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
