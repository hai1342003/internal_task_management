package com.example.task.repository;

import com.example.task.domain.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @EntityGraph(attributePaths = {"assignee"})
    Page<Task> findByAssigneeId(Long assigneeId, Pageable pageable);

    @EntityGraph(attributePaths = {"assignee"})
    Page<Task> findAll(Pageable pageable);

    @Query("""
    select t from Task t
    join fetch t.assignee
    where t.assignee.id = :userId
    """)
    List<Task> findTasksForUser(Long userId);

}
