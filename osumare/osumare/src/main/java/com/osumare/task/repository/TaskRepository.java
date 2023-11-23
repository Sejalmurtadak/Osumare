package com.osumare.task.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.osumare.task.dto.TaskDTO;

@Repository
public class TaskRepository {

	private List<TaskDTO> tasks = new ArrayList<TaskDTO>();

	public List<TaskDTO> getAllTasks() {
		return tasks;
	}

	public TaskDTO getTaskById(int id) {
		for (TaskDTO task : tasks) {
			if (task.getId() == id) {
				return task;
			}
		}
		return null;
	}

	public TaskDTO createTask(TaskDTO task) {
		tasks.add(task);
		return task;
	}

	public TaskDTO updateTaskById(int id, TaskDTO dto) {
		for (TaskDTO task : tasks) {
			if (task.getId() == id) {
				task.setTitle(dto.getTitle());
				task.setDescription(dto.getDescription());
				return task;
			}
		}
		return null;
	}

	public TaskDTO deleteTaskById(int id) {
		TaskDTO dto = new TaskDTO();
		for (TaskDTO task : tasks) {
			if (task.getId() == id) {
				dto = task;
				tasks.remove(tasks.indexOf(task));
				break;
			} else {
				dto = null;
			}
		}
		return dto;
	}

}
