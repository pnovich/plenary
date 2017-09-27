import { BaseEntity } from './../../shared';

export class Company implements BaseEntity {
    constructor(
        public id?: number,
        public name?: string,
        public fullName?: string,
        public email?: string,
        public phone?: string,
        public address?: string,
        public createdBy?: string,
        public createdDate?: any,
        public lastModifiedBy?: string,
        public lastModifiedDate?: any,
        public branches?: BaseEntity[],
        public warehouses?: BaseEntity[],
        public points?: BaseEntity[],
        public drivers?: BaseEntity[],
        public sensors?: BaseEntity[],
        public transports?: BaseEntity[],
        public tasks?: BaseEntity[],
    ) {
    }
}
