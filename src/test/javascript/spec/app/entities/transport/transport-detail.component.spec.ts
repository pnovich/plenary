/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils, JhiDataUtils, JhiEventManager } from 'ng-jhipster';
import { PlenaryErpTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { TransportDetailComponent } from '../../../../../../main/webapp/app/entities/transport/transport-detail.component';
import { TransportService } from '../../../../../../main/webapp/app/entities/transport/transport.service';
import { Transport } from '../../../../../../main/webapp/app/entities/transport/transport.model';

describe('Component Tests', () => {

    describe('Transport Management Detail Component', () => {
        let comp: TransportDetailComponent;
        let fixture: ComponentFixture<TransportDetailComponent>;
        let service: TransportService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [PlenaryErpTestModule],
                declarations: [TransportDetailComponent],
                providers: [
                    JhiDateUtils,
                    JhiDataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    TransportService,
                    JhiEventManager
                ]
            }).overrideTemplate(TransportDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(TransportDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(TransportService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new Transport(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.transport).toEqual(jasmine.objectContaining({id: 10}));
            });
        });
    });

});
