import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { PlenaryErpCompanyModule } from './company/company.module';
import { PlenaryErpBranchModule } from './branch/branch.module';
import { PlenaryErpCountryModule } from './country/country.module';
import { PlenaryErpRegionModule } from './region/region.module';
import { PlenaryErpSettlementModule } from './settlement/settlement.module';
import { PlenaryErpStreetModule } from './street/street.module';
import { PlenaryErpStatusModule } from './status/status.module';
import { PlenaryErpWarehouseModule } from './warehouse/warehouse.module';
import { PlenaryErpPointModule } from './point/point.module';
import { PlenaryErpDriverModule } from './driver/driver.module';
import { PlenaryErpSensorModule } from './sensor/sensor.module';
import { PlenaryErpTransportModule } from './transport/transport.module';
import { PlenaryErpTaskModule } from './task/task.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        PlenaryErpCompanyModule,
        PlenaryErpBranchModule,
        PlenaryErpCountryModule,
        PlenaryErpRegionModule,
        PlenaryErpSettlementModule,
        PlenaryErpStreetModule,
        PlenaryErpStatusModule,
        PlenaryErpWarehouseModule,
        PlenaryErpPointModule,
        PlenaryErpDriverModule,
        PlenaryErpSensorModule,
        PlenaryErpTransportModule,
        PlenaryErpTaskModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class PlenaryErpEntityModule {}
