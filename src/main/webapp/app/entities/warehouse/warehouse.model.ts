import { BaseEntity } from './../../shared';

export class Warehouse implements BaseEntity {
    constructor(
        public id?: number,
        public name?: string,
        public fullName?: string,
        public guid?: string,
        public longitude?: number,
        public latitude?: number,
        public address?: string,
        public houseNumber?: string,
        public createdBy?: string,
        public createdDate?: any,
        public lastModifiedBy?: string,
        public lastModifiedDate?: any,
        public warehouseAvailables?: BaseEntity[],
        public transports?: BaseEntity[],
        public tasks?: BaseEntity[],
        public companyId?: number,
        public branchId?: number,
        public countryId?: number,
        public regionId?: number,
        public settlementId?: number,
        public streetId?: number,
    ) {
    }
}
