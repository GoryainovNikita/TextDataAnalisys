package model;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Model {
    private static final List<Counter> listCounter = new ArrayList<>();//can be replaced with List.of() and insert elements



    public void createCounters(String string) {
        Path path = Path.of(string);
        path.toAbsolutePath();
        CounterOfChar counterOfChar = new CounterOfChar(path);
        CounterOfSentence counterOfSentence = new CounterOfSentence(path);
        CounterOfSpace counterOfSpace = new CounterOfSpace(path);
        CounterOfWords counterOfWords = new CounterOfWords(path);
        listCounter.add(counterOfSentence);
        listCounter.add(counterOfSpace);
        listCounter.add(counterOfChar);
        listCounter.add(counterOfWords);
    }

    public void start() throws Exception {
        if(!listCounter.isEmpty()){
            ExecutorService executor = Executors.newFixedThreadPool(3);
            for(var elem : listCounter){
                executor.submit(elem);
            }
            executor.shutdown();
        }
        else {
            throw new Exception();
        }



    }




}
