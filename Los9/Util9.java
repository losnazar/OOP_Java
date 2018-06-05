package Labs_OOP.Los9;

import Labs_OOP.Los8.Utility8;
import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Util9 {
    public final static String INFO = "i", CREATE = "1", TO_STRING = "2", ADD = "3", CLEAR = "4", SIZE = "5", TO_ARRAY = "6",
            CONTAINS = "7", CONTAINS_ALL = "8",SAVE_IN_FILE = "save",READ_FROM_FILE= "read", EXIT = "e";


    static String command;
    static Object[] array;
    static Collection<String> sentences;
    public static String request = "";
    static String programInfo = "Розробити клас-контейнер, що ітерується. Передбачити серіалізацію";
    static String greetText = "Лаба №9.\n Список команд:\ni. щоб переглянути інформацію про лабу\n" +
            "1. Створити контейнер з початковим текстом(результат 8 лаби);\n" +
            "2. Вивести вміст контейнера стрінгом;\n" +
            "3. додати елемент(стрінг) в контейнер;\n" +
            "4. очистити контейнер;\n" +
            "5. розмір контейнера\n" +
            "6. виводить вміст контейнера об'єктом;\n" +
            "7. в контейнері існує даний елемент;\n" +
            "save. зберігає контейнер у окремий файл;\n" +
            "read. відкриває попередньо збережений контейнер;\n" +
            "e. завершити;\n";

    public static void usersRequest() {
        Scanner sc = new Scanner(System.in);
        while (!request.equals(EXIT)) {
            System.out.println(greetText);
            request = sc.nextLine();
            if (request.equals(INFO)) {
                System.out.println(programInfo);
            } else if (request.equals(CREATE)) {
                System.out.println("Введіть текст який потрібно обрахувати за алгоритмтом 8 лаби:");
                command = sc.nextLine();
                String text = Utility8.outputForLab9(command);
                sentences = new Container<String>();
                sentences.add(text);


            } else if (request.equals(TO_STRING)) {
                for (String sent : sentences)
                    System.out.println(sent);
            } else if (request.equals(ADD)) {
                System.out.println("Введіть текст який Ви хочете додати в контейнер");
                command = sc.nextLine();
                sentences.add(command);
            } else if (request.equals(CLEAR)) {
                System.out.println("Ви впевнені що хочете очистити контейнер? Введіть: \n 1 - так \n 2 - ні");
                command = sc.nextLine();
                if (command.equals("1")) {
                    sentences.clear();
                } else
                    continue;
            } else if (request.equals(SIZE)) {
                System.out.println(sentences.size());
            } else if (request.equals(TO_ARRAY)) {
                array = Arrays.copyOf(sentences.toArray(), sentences.toArray().length);
            } else if (request.equals(CONTAINS)) {
                System.out.println("Введіть присутність якого об'єкту ви хочете перевірити в контейнері");
                command = sc.nextLine();
                if (sentences.contains(command))
                    System.out.println("Присутнє");
                else
                    System.out.println("Відсутнє");
            }else if(request.equals(SAVE_IN_FILE)){
                try {
                    saveContainerToFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if (request.equals(READ_FROM_FILE)){
                try {
                    readObjectFromFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void saveContainerToFile() throws IOException {
        File file = new File("ContainerLab9.ser");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(sentences);
    }
    public static void readObjectFromFile() throws IOException{
        FileInputStream fileInputStream = new FileInputStream("ContainerLab9.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        try {
            sentences = (Collection<String>) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
