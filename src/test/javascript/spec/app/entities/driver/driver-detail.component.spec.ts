/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils, JhiDataUtils, JhiEventManager } from 'ng-jhipster';
import { PlenaryErpTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { DriverDetailComponent } from '../../../../../../main/webapp/app/entities/driver/driver-detail.component';
import { DriverService } from '../../../../../../main/webapp/app/entities/driver/driver.service';
import { Driver } from '../../../../../../main/webapp/app/entities/driver/driver.model';

describe('Component Tests', () => {

    describe('Driver Management Detail Component', () => {
        let comp: DriverDetailComponent;
        let fixture: ComponentFixture<DriverDetailComponent>;
        let service: DriverService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [PlenaryErpTestModule],
                declarations: [DriverDetailComponent],
                providers: [
                    JhiDateUtils,
                    JhiDataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    DriverService,
                    JhiEventManager
                ]
            }).overrideTemplate(DriverDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(DriverDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(DriverService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new Driver(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.driver).toEqual(jasmine.objectContaining({id: 10}));
            });
        });
    });

});
