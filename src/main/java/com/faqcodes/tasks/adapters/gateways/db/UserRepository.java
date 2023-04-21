package com.faqcodes.tasks.adapters.gateways.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserData, String> {

  // @Query(value="SELECT USERS.*, TASKS.* FROM USERS INNER JOIN TASKS ON TASKS.userId = USERS.id WHERE TASKS.id = :taskId", nativeQuery = true)
  // TaskData getTaskById(@Param("taskId") String taskId);

}