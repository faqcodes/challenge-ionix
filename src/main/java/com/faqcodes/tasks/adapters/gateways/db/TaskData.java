package com.faqcodes.tasks.adapters.gateways.db;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.faqcodes.tasks.models.Status;

@Entity
@Table(name = "tasks")
public class TaskData {
  @Id
  @Column(name = "id")
  // @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "overdueAt")
  private LocalDateTime overdueAt;

  @Column(name = "comment")
  private String comment;

  @Column(name = "status")
  private String status;

  public TaskData() {
    super();
  }

  public TaskData(String id, String title, String description, String comment, LocalDateTime overdueAt,
      Status status) {
    super();
    this.id = id;
    this.title = title;
    this.description = description;
    this.overdueAt = overdueAt;
    this.comment = comment;
    this.status = status.toString();
  }
}