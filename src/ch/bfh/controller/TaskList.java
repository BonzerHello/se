package ch.bfh.controller;

import ch.bfh.domain.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private List<Task> tasks;


    public TaskList(){
        tasks = new ArrayList<Task>();
    }
}
