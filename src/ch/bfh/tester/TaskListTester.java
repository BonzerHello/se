package ch.bfh.tester;

import ch.bfh.controller.TaskList;
import ch.bfh.domain.Status;
import ch.bfh.domain.Task;

import java.util.List;

public class TaskListTester {

    public static void main(String[] args) {
        TaskList list = new TaskList();
        list.createTask("buy milk", "30.03.2018");
        list.createTask("clean desk", "10.03.2018");

        //original List
        list.printList();

        System.out.println("Search Task Buy milk");
        List<Task> results = list.searchByDescription("buy milk");
        results.get(0).setStatus(Status.DONE);

        list.printList();

        System.out.println("SortBy Date");
        list.printList(list.sortByDate());

        System.out.println("SortBy Status and Date");
        list.printList(list.sortByStatusAndDate());

        System.out.println("Get Status = Done");
        list.printList(list.searchByStatus(Status.DONE));

        System.out.println("Get By Date 10.03.2018");
        list.printList(list.searchByDueDate("1003.20189"));

        list.exportListToTextFile();

    }
}
