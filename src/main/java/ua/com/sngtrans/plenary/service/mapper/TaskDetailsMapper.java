package ua.com.sngtrans.plenary.service.mapper;

import ua.com.sngtrans.plenary.domain.*;
import ua.com.sngtrans.plenary.service.dto.TaskDetailsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity TaskDetails and its DTO TaskDetailsDTO.
 */
@Mapper(componentModel = "spring", uses = {TaskMapper.class, })
public interface TaskDetailsMapper extends EntityMapper <TaskDetailsDTO, TaskDetails> {

    @Mapping(source = "task.id", target = "taskId")
    TaskDetailsDTO toDto(TaskDetails taskDetails); 

    @Mapping(source = "taskId", target = "task")
    TaskDetails toEntity(TaskDetailsDTO taskDetailsDTO); 
    default TaskDetails fromId(Long id) {
        if (id == null) {
            return null;
        }
        TaskDetails taskDetails = new TaskDetails();
        taskDetails.setId(id);
        return taskDetails;
    }
}
