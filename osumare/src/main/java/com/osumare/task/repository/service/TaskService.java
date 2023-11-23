package com.osumare.task.repository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osumare.task.dto.TaskDTO;
import com.osumare.task.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository repo;

	public List<TaskDTO> getAllTasks() {
		List<TaskDTO> tasks = repo.getAllTasks();
		return tasks;
	}

	public TaskDTO getTaskById(int id) {
		if (id < 1) {
			return null;
		}
		TaskDTO task = repo.getTaskById(id);
		return task;
	}

	public TaskDTO createTask(TaskDTO task) {
		if (task.getId() < 1 || task.getTitle() == null || task.getDescription() == null) {
			return null;
		}
		TaskDTO dto = repo.createTask(task);
		return dto;
	}

	public TaskDTO updateTaskById(int id, TaskDTO dto) {
		if (id < 1 || dto.getTitle() == null || dto.getDescription() == null) {
			return null;
		}
		TaskDTO task = repo.updateTaskById(id, dto);
		return task;
	}

	public TaskDTO deleteTaskById(int id) {
		if (id < 1) {
			return null;
		}
		TaskDTO task = repo.deleteTaskById(id);
		return task;
	}

}
