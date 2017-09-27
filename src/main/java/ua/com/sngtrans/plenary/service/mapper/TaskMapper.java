package ua.com.sngtrans.plenary.service.mapper;

import ua.com.sngtrans.plenary.domain.*;
import ua.com.sngtrans.plenary.service.dto.TaskDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Task and its DTO TaskDTO.
 */
@Mapper(componentModel = "spring", uses = {CompanyMapper.class, BranchMapper.class, WarehouseMapper.class, TransportMapper.class, PointMapper.class, StatusMapper.class, })
public interface TaskMapper extends EntityMapper <TaskDTO, Task> {

    @Mapping(source = "company.id", target = "companyId")
    @Mapping(source = "company.fullName", target = "companyFullName")

    @Mapping(source = "branch.id", target = "branchId")
    @Mapping(source = "branch.fullName", target = "branchFullName")

    @Mapping(source = "warehouse.id", target = "warehouseId")
    @Mapping(source = "warehouse.fullName", target = "warehouseFullName")

    @Mapping(source = "transport.id", target = "transportId")
    @Mapping(source = "transport.fullName", target = "transportFullName")

    @Mapping(source = "point.id", target = "pointId")
    @Mapping(source = "point.fullName", target = "pointFullName")

    @Mapping(source = "status.id", target = "statusId")
    @Mapping(source = "status.fullName", target = "statusFullName")
    TaskDTO toDto(Task task); 
    @Mapping(target = "taskDetails", ignore = true)
    @Mapping(target = "taskAvailables", ignore = true)

    @Mapping(source = "companyId", target = "company")

    @Mapping(source = "branchId", target = "branch")

    @Mapping(source = "warehouseId", target = "warehouse")

    @Mapping(source = "transportId", target = "transport")

    @Mapping(source = "pointId", target = "point")

    @Mapping(source = "statusId", target = "status")
    Task toEntity(TaskDTO taskDTO); 
    default Task fromId(Long id) {
        if (id == null) {
            return null;
        }
        Task task = new Task();
        task.setId(id);
        return task;
    }
}
