import { BaseEntity } from './../../shared';

export class Sensor implements BaseEntity {
    constructor(
        public id?: number,
        public name?: string,
        public fullName?: string,
        public imei?: string,
        public guid?: string,
        public createdBy?: string,
        public createdDate?: any,
        public lastModifiedBy?: string,
        public lastModifiedDate?: any,
        public transports?: BaseEntity[],
        public companyId?: number,
        public branchId?: number,
    ) {
    }
}
