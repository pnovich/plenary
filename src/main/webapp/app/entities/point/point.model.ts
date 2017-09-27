import { BaseEntity } from './../../shared';

export class Point implements BaseEntity {
    constructor(
        public id?: number,
        public name?: string,
        public fullName?: string,
        public guid?: string,
        public houseNumber?: string,
        public address?: string,
        public longitude?: number,
        public latitude?: number,
        public serviceTime?: number,
        public comment?: string,
        public createdBy?: string,
        public createdDate?: any,
        public lastModifiedBy?: string,
        public lastModifiedDate?: any,
        public pointsCoordinates?: BaseEntity[],
        public pointsAvailables?: BaseEntity[],
        public pointsContacts?: BaseEntity[],
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
