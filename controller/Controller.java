package controller;

import model.Model;
import view.View;

public class Controller {

    private static final Model model = new Model();
    private static final View view = new View();

    public void execute() {
        view.greeting();
        while (true) {
            String s = view.input();
            if (s.equals("Запуск")) {
                try {
                    model.start();
                } catch (Exception e) {
                    view.emptyConsole();
                }
                break;
            } else {
                model.createCounters(s);
            }

        }

    }
}
