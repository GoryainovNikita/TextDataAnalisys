package model;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class CounterOfSpace extends Counter{
    public CounterOfSpace(Path path) {
        super(path);
    }

    @Override
    public Integer call() throws Exception {
        int value = 0;
        try (BufferedReader bufferedReader = Files.newBufferedReader(getPath())) {
            char[] chars = new char[65000];
            while (bufferedReader.ready()) {
               bufferedReader.read(chars);
                for(var elem : chars){
                    if(elem == '\u0020'){
                        value+=1;
                    }
                }
            }
        }
        System.out.println("В тексте, расположенному по пути : " + getPath() + " \n" +
                value + " пробел(ов/а)");
        return value;
    }
}
