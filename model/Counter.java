package model;

import java.nio.file.Path;
import java.util.concurrent.Callable;


public abstract class Counter implements Callable<Integer> {

    private Path path;

    public Counter(Path path){
        this.path = path;
    }

    @Override
    public Integer call() throws Exception {
        return null;
    }


    public Path getPath() {
        return path;
    }
}
