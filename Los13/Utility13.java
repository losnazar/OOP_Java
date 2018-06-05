package Labs_OOP.Los13;
import java.util.Scanner;

    public class Utility13 {
        public final static String INFO = "i", SET_SIZE = "1", MULTI = "2", CONT = "3",RESULT = "4", EXIT = "e";
        public final static String PROGRAM_INFO = "Паралельне виконання. Багатопоточність. Ефективність використання.";
        public static String request = "";
        static MultiThreading multiThreading = new MultiThreading();
        static Scanner sc = new Scanner(System.in);
        static String greetText = "Лаба №13\n Програма, яка визначає скільки парних і непарних чисел є в масиві чисел (розмір масиву потрібно задати)\n" +
                "i. щоб переглянути інформацію про лабу\n" +
                "1. Розмір масиву\n" +
                "2. Багатопотоковість\n" +
                "3. Послідовність\n" +
                "4. Висновок по часу\n" +
                "e. завершити;\n";

        public static void usersRequest() {
            Scanner sc = new Scanner(System.in);
            while (!request.equals(EXIT)) {
                System.out.print(greetText);
                request = sc.nextLine();
                if (request.equals(INFO)) {
                    System.out.println(PROGRAM_INFO);
                } else if (request.equals(SET_SIZE)) {
                    System.out.println("Введіть розмір масиву");
                    multiThreading.setSize(sc.nextInt());
                }else if (request.equals(MULTI)){
                    multiThreading.parallel();
                }else if (request.equals(CONT)){
                    multiThreading.successively();
                }
                else if (request.equals(RESULT)){
                    System.out.println("Час витрачений на паралельний алгоритм: " + multiThreading.getParallel_time());
                    System.out.println("Час витрачений на послідовний алгоритм: " + multiThreading.getCont_time());
                    if (multiThreading.getCont_time()<multiThreading.getParallel_time()){
                        System.out.println("Послідовний алгоритм швидший");
                    }
                    else if (multiThreading.getCont_time()>multiThreading.getParallel_time())
                        System.out.println("Паралельний алгоритм швидший");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
