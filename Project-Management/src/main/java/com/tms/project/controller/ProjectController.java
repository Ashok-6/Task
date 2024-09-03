package com.tms.project.controller;

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

import com.tms.project.dto.ApiResponseDTO;
import com.tms.project.dto.ProjectDTO;
import com.tms.project.service.ProjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/project")
@CrossOrigin
public class ProjectController {

	@Autowired
	private ProjectService service;

	
	//method for create project
	@PostMapping("/create")
	public ProjectDTO createProject(@Valid @RequestBody ProjectDTO projectdto) {
		return service.createProject(projectdto);
	}
	
	//method for get project by project Id
	@GetMapping("getproject/{projectId}")
	public ProjectDTO getProjectByPid( @PathVariable Long projectId) {
		return service.getProjectByProjectId(projectId);
	}
	//method for get all projects
	@GetMapping("/getall")
	public List<ProjectDTO> getAllProject() {
		return service.getAllProject();
	}
	
	@GetMapping("/getalltasks/{projectId}")
	public List<ApiResponseDTO> getAllProjectTasks(@PathVariable Long projectId) {
		return service.getAllProjectTasks(projectId);
	}
	//method for update project
	@PutMapping("/update/{projectId}")
	public ProjectDTO updateProject(@Valid @PathVariable Long projectId, @RequestBody ProjectDTO projectdto) 
	{
		return service.updateProject(projectId, projectdto);
	}
	
	//method for delete project
	@DeleteMapping("/delete/{projectId}")
	public void deleteProject(@PathVariable Long projectId) 
	{
		service.deleteProject(projectId);
	}
}