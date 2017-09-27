/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils, JhiDataUtils, JhiEventManager } from 'ng-jhipster';
import { PlenaryErpTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { StreetDetailComponent } from '../../../../../../main/webapp/app/entities/street/street-detail.component';
import { StreetService } from '../../../../../../main/webapp/app/entities/street/street.service';
import { Street } from '../../../../../../main/webapp/app/entities/street/street.model';

describe('Component Tests', () => {

    describe('Street Management Detail Component', () => {
        let comp: StreetDetailComponent;
        let fixture: ComponentFixture<StreetDetailComponent>;
        let service: StreetService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [PlenaryErpTestModule],
                declarations: [StreetDetailComponent],
                providers: [
                    JhiDateUtils,
                    JhiDataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    StreetService,
                    JhiEventManager
                ]
            }).overrideTemplate(StreetDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(StreetDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(StreetService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new Street(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.street).toEqual(jasmine.objectContaining({id: 10}));
            });
        });
    });

});
