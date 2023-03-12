package view;

import java.util.Scanner;

public class View {

    private static final Scanner scanner = new Scanner(System.in);

    public void greeting() {
        System.out.println("Добро пожаловать в наше приложение \"Мегаанализатор текстовых данных\"");
        System.out.println("Пожалуйста, введите пути к файлам, которые хотите проанализировать:\n" +
                "Каждый новый путь вводите с новой строки\n" +
                "Если, хотите запустить анализ введенных путей - введите \"Запуск\"");
    }

    public String input() {
        return scanner.nextLine();
    }

    public void emptyConsole(){
        System.out.println("Вы не ввели ни одного пути к файлу");
    }


}
