package model;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class CounterOfWords extends Counter{
    public CounterOfWords(Path path) {
        super(path);
    }

    @Override
    public Integer call() throws Exception {

        int value = 0;
        try (BufferedReader bufferedReader = Files.newBufferedReader(getPath())) {
            while (bufferedReader.ready()) {
                String s = bufferedReader.readLine();
                String[] strings = s.split(" ");
                value+=strings.length;
            }

        }
        System.out.println("В тексте, расположенному по пути : " + getPath() + " \n" +
                value + " слов(а)");
        return value;
    }
}
