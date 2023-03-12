package model;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;


public class CounterOfChar extends Counter {

    public CounterOfChar(Path path) {
        super(path);
    }

    @Override
    public Integer call() throws Exception {
        int value = 0;
        try (BufferedReader bufferedReader = Files.newBufferedReader(getPath())) {
            char[] chars = new char[65000];
            while (bufferedReader.ready()) {
                int reader = bufferedReader.read(chars);
                value += reader;
            }
        }
        System.out.println("В тексте, расположенному по пути : " + getPath() + " \n" +
                value + " символ(ов/а)");
        return value;
    }
}
