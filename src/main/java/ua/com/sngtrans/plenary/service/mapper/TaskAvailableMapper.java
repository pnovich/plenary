package ua.com.sngtrans.plenary.service.mapper;

import ua.com.sngtrans.plenary.domain.*;
import ua.com.sngtrans.plenary.service.dto.TaskAvailableDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity TaskAvailable and its DTO TaskAvailableDTO.
 */
@Mapper(componentModel = "spring", uses = {TaskMapper.class, })
public interface TaskAvailableMapper extends EntityMapper <TaskAvailableDTO, TaskAvailable> {

    @Mapping(source = "task.id", target = "taskId")
    TaskAvailableDTO toDto(TaskAvailable taskAvailable); 

    @Mapping(source = "taskId", target = "task")
    TaskAvailable toEntity(TaskAvailableDTO taskAvailableDTO); 
    default TaskAvailable fromId(Long id) {
        if (id == null) {
            return null;
        }
        TaskAvailable taskAvailable = new TaskAvailable();
        taskAvailable.setId(id);
        return taskAvailable;
    }
}
