package ch.bfh.controller;

import ch.bfh.domain.Status;
import ch.bfh.domain.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TaskList {

    private List<Task> tasks;

    private SimpleDateFormat sdf;

    Comparator<Task> sortByStatus = Comparator.comparing(Task::getStatus);
    Comparator<Task> sortByDate = (t1,t2) -> (t1.getDueDate().before(t2.getDueDate())?-1:1);


    public TaskList(){
        tasks = new ArrayList<Task>();
        sdf = new SimpleDateFormat("dd.MM.yyyy");
    }


    public boolean createTask(String description, String dueDate){
        try {
            Task newTask = new Task(description, sdf.parse(dueDate));
            this.tasks.add(newTask);
        }catch (ParseException e){
            System.out.println("Wrong Date Format! dd.MM.yyyy");
            return false;
        }catch(Exception e) {
            System.out.println("Error while creating new Task");
            return false;
        }
        return true;
    }

    public List<Task> searchByDescription(String term){
        List<Task> results = tasks.stream().
                filter(t -> t.getDescription().toUpperCase().contains(term.toUpperCase())).
                collect(Collectors.toList());
        return results;
    }

    public List<Task> searchByDueDate(String dateString){
        Date dueDate;
        try{
            dueDate = sdf.parse(dateString);
        }catch (ParseException e){
            System.out.println ("Wring Date Format! dd.MM.yyyy");
            return null;
        }
        List<Task> results = tasks.stream().
                filter(t -> t.getDueDate().before(dueDate) || t.getDueDate().equals(dueDate)).
                collect(Collectors.toList());
        return results;
    }


    public List<Task> searchByStatus(Status status){
        List<Task> results = tasks.stream().
                filter( t -> t.getStatus() == status).
                collect(Collectors.toList());
        return results;
    }

    public List<Task> sortByDate(){
        List<Task> results = tasks.stream().
                sorted(sortByDate).
                collect(Collectors.toList());
        return results;
    }
    public List<Task> sortByStatusAndDate(){


        List<Task> results = tasks.stream().
                sorted(sortByStatus.thenComparing(sortByDate)).
                collect(Collectors.toList());
        return results;
    }


    public void printList(){
        printList(this.tasks);
    }
    public void printList(List<Task> tasks){
        if(tasks != null && tasks.size()>0) {


            for (Task t : tasks) {
                System.out.println(t);
            }
        }else{
            System.out.println("List is Empty");
        }
    }

    public void exportListToTextFile(){
        FileExporter fe = FileExporter.getInstance();
        fe.writeTaskListToFileAsText(this.tasks);
    }
}
