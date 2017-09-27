import { BaseEntity } from './../../shared';

export class Settlement implements BaseEntity {
    constructor(
        public id?: number,
        public name?: string,
        public fullName?: string,
        public guid?: string,
        public createdBy?: string,
        public createdDate?: any,
        public lastModifiedBy?: string,
        public lastModifiedDate?: any,
        public streets?: BaseEntity[],
        public warehouses?: BaseEntity[],
        public points?: BaseEntity[],
        public regionId?: number,
    ) {
    }
}
