/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils, JhiDataUtils, JhiEventManager } from 'ng-jhipster';
import { PlenaryErpTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { SensorDetailComponent } from '../../../../../../main/webapp/app/entities/sensor/sensor-detail.component';
import { SensorService } from '../../../../../../main/webapp/app/entities/sensor/sensor.service';
import { Sensor } from '../../../../../../main/webapp/app/entities/sensor/sensor.model';

describe('Component Tests', () => {

    describe('Sensor Management Detail Component', () => {
        let comp: SensorDetailComponent;
        let fixture: ComponentFixture<SensorDetailComponent>;
        let service: SensorService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [PlenaryErpTestModule],
                declarations: [SensorDetailComponent],
                providers: [
                    JhiDateUtils,
                    JhiDataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    SensorService,
                    JhiEventManager
                ]
            }).overrideTemplate(SensorDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(SensorDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SensorService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new Sensor(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.sensor).toEqual(jasmine.objectContaining({id: 10}));
            });
        });
    });

});
