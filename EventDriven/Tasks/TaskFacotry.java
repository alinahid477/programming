package com.interview.atls.EventDriven.Tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//import com.interview.atls.EventDriven.Tasks.CoffeeOrderTask;

public class TaskFacotry {
    
    private static TaskFacotry factory;

    private List<PublishTask> tasks;

    private TaskFacotry() {
        tasks = new ArrayList<>();
    }

    public static TaskFacotry getInstance() {
        if(factory == null) {
            factory = new TaskFacotry();
        }
        return factory;
    }

    public PublishTask getTask(String taskType) {
        Optional<PublishTask> task = null;
        switch(taskType) {
            case "coffee":
                task = tasks.stream().filter(x->x.getClass().getName().contains("coffee")).findFirst();
                if(task == null || task.isPresent()) {
                    task = Optional.of(new CoffeeOrderTask()); 
                    tasks.add(task.get());
                }
                break;
            default:
                break;
        }

        return task.get();
        
    }
}