package com.techmaster.wlminus.springboot1.repository;

import com.techmaster.wlminus.springboot1.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    public List<Todo> getByStatus(Boolean status);

    @Query("select todo Todo where todo.status = :status")
    public List<Todo> getByStatusVer2(@Param("status") Boolean status);

    @Query(value = "SELECT * FROM TODO WHERE status = :status",nativeQuery = true)
    public List<Todo> getByStatusVer3(@Param("status") Boolean status);
}
