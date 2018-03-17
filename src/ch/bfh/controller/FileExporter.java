package ch.bfh.controller;

import ch.bfh.domain.Task;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

public class FileExporter {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    private static FileExporter instance = null;

    public static FileExporter getInstance(){
        if(instance == null){
            instance = new FileExporter();
        }
        return instance;
    }


    public void writeTaskListToFileAsText(List<Task> list){
        try {
            FileWriter fileWriter = new FileWriter("taskList.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for(Task t:list){
                printWriter.print(t.getDescription()+";"+sdf.format(t.getDueDate())+";"+t.getStatus()+"\n");
            }
            printWriter.close();
        }catch(Exception e){

        }
    }
}
