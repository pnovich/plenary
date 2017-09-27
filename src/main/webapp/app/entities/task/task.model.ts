import { BaseEntity } from './../../shared';

export class Task implements BaseEntity {
    constructor(
        public id?: number,
        public number?: string,
        public date?: any,
        public fullName?: string,
        public invoiceNumber?: string,
        public invoiceDate?: any,
        public weight?: number,
        public volume?: number,
        public dateOfExecution?: any,
        public comment?: string,
        public createdBy?: string,
        public createdDate?: any,
        public lastModifiedBy?: string,
        public lastModifiedDate?: any,
        public taskDetails?: BaseEntity[],
        public taskAvailables?: BaseEntity[],
        public companyId?: number,
        public branchId?: number,
        public warehouseId?: number,
        public transportId?: number,
        public pointId?: number,
        public statusId?: number,
    ) {
    }
}
