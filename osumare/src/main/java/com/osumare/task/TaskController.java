package com.osumare.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.osumare.task.dto.TaskDTO;
import com.osumare.task.repository.service.TaskService;

@RestController
public class TaskController {

	@Autowired
	private TaskService service;

	@GetMapping(path = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
	private List<TaskDTO> getAllTasks() {
		List<TaskDTO> tasks = service.getAllTasks();
		return tasks;
	}

	@GetMapping(path = "/tasks/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private TaskDTO getTaskById(@PathVariable int id) {
		TaskDTO task = service.getTaskById(id);
		return task;
	}

	@PostMapping(path = "/tasks", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private TaskDTO createTask(@RequestBody TaskDTO task) {
		TaskDTO dto = service.createTask(task);
		return dto;
	}

	@PutMapping(path = "/tasks/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private TaskDTO updateTaskById(@PathVariable int id, @RequestBody TaskDTO dto) {
		TaskDTO task = service.updateTaskById(id, dto);
		return task;
	}

	@DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private TaskDTO deleteTaskById(@PathVariable int id) {
		TaskDTO task = service.deleteTaskById(id);
		return task;
	}

}
