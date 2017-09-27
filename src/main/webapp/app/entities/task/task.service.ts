import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils } from 'ng-jhipster';

import { Task } from './task.model';
import { ResponseWrapper, createRequestOption } from '../../shared';

@Injectable()
export class TaskService {

    private resourceUrl = 'api/tasks';
    private resourceSearchUrl = 'api/_search/tasks';

    constructor(private http: Http, private dateUtils: JhiDateUtils) { }

    create(task: Task): Observable<Task> {
        const copy = this.convert(task);
        return this.http.post(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            this.convertItemFromServer(jsonResponse);
            return jsonResponse;
        });
    }

    update(task: Task): Observable<Task> {
        const copy = this.convert(task);
        return this.http.put(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            this.convertItemFromServer(jsonResponse);
            return jsonResponse;
        });
    }

    find(id: number): Observable<Task> {
        return this.http.get(`${this.resourceUrl}/${id}`).map((res: Response) => {
            const jsonResponse = res.json();
            this.convertItemFromServer(jsonResponse);
            return jsonResponse;
        });
    }

    query(req?: any): Observable<ResponseWrapper> {
        const options = createRequestOption(req);
        return this.http.get(this.resourceUrl, options)
            .map((res: Response) => this.convertResponse(res));
    }

    delete(id: number): Observable<Response> {
        return this.http.delete(`${this.resourceUrl}/${id}`);
    }

    search(req?: any): Observable<ResponseWrapper> {
        const options = createRequestOption(req);
        return this.http.get(this.resourceSearchUrl, options)
            .map((res: any) => this.convertResponse(res));
    }

    private convertResponse(res: Response): ResponseWrapper {
        const jsonResponse = res.json();
        for (let i = 0; i < jsonResponse.length; i++) {
            this.convertItemFromServer(jsonResponse[i]);
        }
        return new ResponseWrapper(res.headers, jsonResponse, res.status);
    }

    private convertItemFromServer(entity: any) {
        entity.date = this.dateUtils
            .convertDateTimeFromServer(entity.date);
        entity.invoiceDate = this.dateUtils
            .convertDateTimeFromServer(entity.invoiceDate);
        entity.dateOfExecution = this.dateUtils
            .convertDateTimeFromServer(entity.dateOfExecution);
        entity.createdDate = this.dateUtils
            .convertDateTimeFromServer(entity.createdDate);
        entity.lastModifiedDate = this.dateUtils
            .convertDateTimeFromServer(entity.lastModifiedDate);
    }

    private convert(task: Task): Task {
        const copy: Task = Object.assign({}, task);

        copy.date = this.dateUtils.toDate(task.date);

        copy.invoiceDate = this.dateUtils.toDate(task.invoiceDate);

        copy.dateOfExecution = this.dateUtils.toDate(task.dateOfExecution);

        copy.createdDate = this.dateUtils.toDate(task.createdDate);

        copy.lastModifiedDate = this.dateUtils.toDate(task.lastModifiedDate);
        return copy;
    }
}
