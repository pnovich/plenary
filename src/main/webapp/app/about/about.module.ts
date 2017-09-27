import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { BrowserAnimationsModule} from '@angular/platform-browser/animations';

import { PlenaryErpSharedModule } from '../shared';

import { ABOUT_ROUTE, AboutComponent } from './';

@NgModule({
    imports: [
        PlenaryErpSharedModule,
        BrowserAnimationsModule,
        RouterModule.forRoot([ ABOUT_ROUTE ], { useHash: true })
    ],
    declarations: [
        AboutComponent,
    ],
    entryComponents: [
    ],
    providers: [
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class PlenaryErpAboutModule {}
