import { BaseEntity } from './../../shared';

export class Transport implements BaseEntity {
    constructor(
        public id?: number,
        public name?: string,
        public identNumber?: string,
        public fullName?: string,
        public guid?: string,
        public comment?: string,
        public costKilometer?: number,
        public costHoure?: number,
        public costPutIn?: number,
        public minWeight?: number,
        public maxWeight?: number,
        public minVolume?: number,
        public maxVolume?: number,
        public capacity?: number,
        public createdBy?: string,
        public createdDate?: any,
        public lastModifiedBy?: string,
        public lastModifiedDate?: any,
        public tasks?: BaseEntity[],
        public companyId?: number,
        public branchId?: number,
        public warehouseId?: number,
        public driverId?: number,
        public sensorId?: number,
    ) {
    }
}
