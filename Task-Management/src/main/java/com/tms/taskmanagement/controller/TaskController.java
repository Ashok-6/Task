package com.tms.taskmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.taskmanagement.dto.TaskDTO;
import com.tms.taskmanagement.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/task")
@CrossOrigin
public class TaskController {

    @Autowired
    private TaskService taskService;

    
    //method for create task
    @PostMapping("/create")
    public TaskDTO createTask(@Valid @RequestBody TaskDTO taskDTO) {
        return taskService.createTask(taskDTO);
    }
    
    //method for get task by taskid
    @GetMapping("/gettask/{tid}")
    public TaskDTO getTaskByTid(@PathVariable Long tid) 
    {
        return taskService.getTaskByTid(tid);
    }

    //method for get all task by projectid
    @GetMapping("/getalltasksbypid/{projectId}")
    public List<TaskDTO> getAllTasksByPid(@PathVariable Long projectId)
    {
    	return taskService.getAllTasksByPid(projectId);
    }
    
    //mentod for get all tasks
    @GetMapping("/getalltask")
    public List<TaskDTO> getAllTask() {
        return taskService.getAllTask();
    }
    
    //method for update task
    @PutMapping("/update/{tid}")
    public TaskDTO updateTask(@Valid @PathVariable Long tid, @RequestBody TaskDTO taskDTO) 
    {
        return taskService.updateTask(tid, taskDTO);
    }
    
    //method for update task status
    @PutMapping("/updatetstatus/{uid}/{projectId}/{taskId}/{taskStatus}")
	public void updateTaskStatus(@Valid @PathVariable Long uid,@PathVariable Long projectId,@PathVariable Long taskId,@PathVariable String taskStatus)
	{
		taskService.updateTaskStatus(uid, projectId, taskId, taskStatus);
	}
    //	method for delete task
    @DeleteMapping("/delete/{tid}")
    public void deleteTask(@PathVariable Long tid) 
    {
        taskService.deleteTaskDTO(tid);
    }
}
