import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { DatePipe } from '@angular/common';
import { Task } from './task.model';
import { TaskService } from './task.service';

@Injectable()
export class TaskPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private datePipe: DatePipe,
        private modalService: NgbModal,
        private router: Router,
        private taskService: TaskService

    ) {
        this.ngbModalRef = null;
    }

    open(component: Component, id?: number | any): Promise<NgbModalRef> {
        return new Promise<NgbModalRef>((resolve, reject) => {
            const isOpen = this.ngbModalRef !== null;
            if (isOpen) {
                resolve(this.ngbModalRef);
            }

            if (id) {
                this.taskService.find(id).subscribe((task) => {
                    task.date = this.datePipe
                        .transform(task.date, 'yyyy-MM-ddTHH:mm:ss');
                    task.invoiceDate = this.datePipe
                        .transform(task.invoiceDate, 'yyyy-MM-ddTHH:mm:ss');
                    task.dateOfExecution = this.datePipe
                        .transform(task.dateOfExecution, 'yyyy-MM-ddTHH:mm:ss');
                    task.createdDate = this.datePipe
                        .transform(task.createdDate, 'yyyy-MM-ddTHH:mm:ss');
                    task.lastModifiedDate = this.datePipe
                        .transform(task.lastModifiedDate, 'yyyy-MM-ddTHH:mm:ss');
                    this.ngbModalRef = this.taskModalRef(component, task);
                    resolve(this.ngbModalRef);
                });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.taskModalRef(component, new Task());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    taskModalRef(component: Component, task: Task): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.task = task;
        modalRef.result.then((result) => {
            this.router.navigate([{ outlets: { popup: null }}], { replaceUrl: true });
            this.ngbModalRef = null;
        }, (reason) => {
            this.router.navigate([{ outlets: { popup: null }}], { replaceUrl: true });
            this.ngbModalRef = null;
        });
        return modalRef;
    }
}
