package com.todo.fullstack.controller;
import com.todo.fullstack.domain.dto.DetailmentDTO;
import com.todo.fullstack.domain.dto.RegisterDataDTO;
import com.todo.fullstack.domain.dto.TaskListDTO;
import com.todo.fullstack.domain.dto.UpdateTaskDataDTO;
import com.todo.fullstack.domain.entity.Task;
import com.todo.fullstack.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetailmentDTO> register(@RequestBody RegisterDataDTO data, UriComponentsBuilder uriBuilder){
        var task = new Task(data);
        repository.save(task);
        var uri = uriBuilder.path("/tasks/{id}").buildAndExpand(task.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetailmentDTO(task));
    }

    @GetMapping
    public ResponseEntity<Page<TaskListDTO>> list(Pageable pagination){
        var taskPage = repository.findAll(pagination).map(TaskListDTO::new);
        return ResponseEntity.ok().body(taskPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailmentDTO> findById(@PathVariable Long id){
        var findTask= repository.getReferenceById(id);
        return ResponseEntity.ok().body(new DetailmentDTO(findTask));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DetailmentDTO> update(@PathVariable Long id, @RequestBody UpdateTaskDataDTO data){
        var task = repository.getReferenceById(id);
        task.updateData(data);
        return ResponseEntity.ok().body(new DetailmentDTO(task));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
