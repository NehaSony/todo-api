package com.ey.api.todo.entity;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.Date;

/**
 * @author Neha.Sony
 */

@Entity
public class Todo {
    @Id
    @GeneratedValue
    private int id;
    private String task;
    private Boolean completed;
    private String createdBy;
    private Date timeCreate;

    public Todo(String task) {
        this.task=task;
        this.createdBy="Anonymous";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Date timeCreate) {
        this.timeCreate = timeCreate;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id='" + id + '\'' +
                ", task='" + task + '\'' +
                ", completed=" + completed +
                ", createdBy='" + createdBy + '\'' +
                ", timeCreate=" + timeCreate +
                '}';
    }
}
