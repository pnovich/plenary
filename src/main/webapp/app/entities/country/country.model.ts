import { BaseEntity } from './../../shared';

export class Country implements BaseEntity {
    constructor(
        public id?: number,
        public name?: string,
        public fullName?: string,
        public guid?: string,
        public createdBy?: string,
        public createdDate?: any,
        public lastModifiedBy?: string,
        public lastModifiedDate?: any,
        public regions?: BaseEntity[],
        public warehouses?: BaseEntity[],
        public points?: BaseEntity[],
    ) {
    }
}
