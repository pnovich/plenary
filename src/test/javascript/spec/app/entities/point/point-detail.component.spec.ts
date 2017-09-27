/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils, JhiDataUtils, JhiEventManager } from 'ng-jhipster';
import { PlenaryErpTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { PointDetailComponent } from '../../../../../../main/webapp/app/entities/point/point-detail.component';
import { PointService } from '../../../../../../main/webapp/app/entities/point/point.service';
import { Point } from '../../../../../../main/webapp/app/entities/point/point.model';

describe('Component Tests', () => {

    describe('Point Management Detail Component', () => {
        let comp: PointDetailComponent;
        let fixture: ComponentFixture<PointDetailComponent>;
        let service: PointService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [PlenaryErpTestModule],
                declarations: [PointDetailComponent],
                providers: [
                    JhiDateUtils,
                    JhiDataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    PointService,
                    JhiEventManager
                ]
            }).overrideTemplate(PointDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(PointDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(PointService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new Point(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.point).toEqual(jasmine.objectContaining({id: 10}));
            });
        });
    });

});
