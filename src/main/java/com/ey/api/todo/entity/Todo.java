package com.ey.api.todo.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Neha.Sony
 */

@Entity

public class Todo {
    @Id
    @GeneratedValue
    @JsonProperty("id")
    private int id;


    @NotNull
    @JsonProperty("task")
    private String task;


    @JsonProperty("task_status")
    private Boolean completed;


    @JsonProperty("last_updated_by")
    private String updatedBy;


    @DateTimeFormat(pattern = "yyyyy.MMMMM.dd GGG hh:mm aaa")
    @Temporal(value= TemporalType.TIMESTAMP)
    @JsonProperty("last_update_timestamp")
    private Date lastUpdated;

    public Todo() {
    }

    public Todo(String task) {
        this.task=task;
        this.updatedBy ="Anonymous";
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

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id='" + id + '\'' +
                ", task='" + task + '\'' +
                ", completed=" + completed +
                ", createdBy='" + updatedBy + '\'' +
                ", timeCreate=" + lastUpdated +
                '}';
    }
}
