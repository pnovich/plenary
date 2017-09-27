import { BaseEntity } from './../../shared';

export class Region implements BaseEntity {
    constructor(
        public id?: number,
        public name?: string,
        public fullName?: string,
        public guid?: string,
        public createdBy?: string,
        public createdDate?: any,
        public lastModifiedBy?: string,
        public lastModifiedDate?: any,
        public settlements?: BaseEntity[],
        public warehouses?: BaseEntity[],
        public points?: BaseEntity[],
        public countryId?: number,
    ) {
    }
}
