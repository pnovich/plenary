import { BaseEntity } from './../../shared';

export class Driver implements BaseEntity {
    constructor(
        public id?: number,
        public firstName?: string,
        public lastName?: string,
        public middleName?: string,
        public fullName?: string,
        public guid?: string,
        public phone?: string,
        public email?: string,
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
