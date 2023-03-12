package model;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class CounterOfSentence extends Counter {

    public CounterOfSentence(Path path) {
        super(path);
    }

    @Override
    public Integer call() throws Exception {
        int value = 0;
        try (BufferedReader bufferedReader = Files.newBufferedReader(getPath())) {
            char[] chars = new char[65000];
            while (bufferedReader.ready()) {
                int reader = bufferedReader.read(chars);
                for (var elem : chars) {
                    if (elem == '.' || elem == '!' || elem == '?' || elem == ';') {
                        value += reader;
                    }
                }
            }
            System.out.println("В тексте, расположенному по пути : " + getPath() + " \n" +
                    value + " предложен(ий/я)");
            return value;
        }
    }
}
