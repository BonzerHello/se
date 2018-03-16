package ch.bfh.domain;

import java.util.Date;

public class Task {

    private String description;
    private Date dueDate;
    private Status status;

    public Task(String description,Date dueDate){
        this.description = description;
        this.dueDate = dueDate;
        this.status = Status.OPEN;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
