package Labs_OOP;
import Labs_OOP.Los10.Utility10;
import Labs_OOP.Los11.Utility11;
import Labs_OOP.Los12.Utility12;
import Labs_OOP.Los13.Utility13;
import Labs_OOP.Los8.Utility8;
import Labs_OOP.Los9.Util9;
import java.io.IOException;
import java.util.Scanner;

public class Nazar_all_labs {
    static final String HELP = "help", HELP2 = "h";
    static final String LABS = "l",LABS2 = "labs";
    static final String EXIT = "e";
    static final String EXIT2 = "exit";
    public static void main(String[]args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        String startMenu = "Введіть одну з команд:\n \"h\" або \"help\" щоб вивести інформацію про автора;\n \"l\" або \"labs\" щоб вивести всі готові лаби;" +
                "\n \"e\" або \"exit\" для завершення";
        String info ="Автор лаб - студент групи КН-107 Лось Назар";
        String command = "";
        String commandForLabs = "Яку лабу виконати";
        String allLabsList = "1. Лаба 8\n2. Лаба 9\n3. Лаба 10\n4. Лаба 11\n5. Лаба 12\n6. Лаба 13";
        while (!command.equals(EXIT)&&!command.equals(EXIT2)){
            System.out.println(startMenu);
            command = sc.nextLine();
            if (command.equals(HELP)||command.equals(HELP2)){
                System.out.println("\n"+info+"\n");
            }else if (command.equals(LABS)||command.equals(LABS2)){
                System.out.println(commandForLabs);
                System.out.println(allLabsList);
                command = sc.nextLine();
                if (command.equals("1")){
                    command = "";
                    System.out.println(Utility8.getGreetText());
                    while (!Utility8.usersRequest(command).equals(Utility8.EXIT)) {
                        command = sc.nextLine();
                        if (command.equals(Utility8.READ)){
                            System.out.println(Utility8.usersRequest(command));
                        }
                        if (command.equals(Utility8.INFO)){
                            System.out.println(Utility8.usersRequest(command));
                        }
                        if (command.equals(Utility8.OUTPUT)){
                            System.out.println(Utility8.usersRequest(command));
                        }
                        if (command.equals(Utility8.INPUT)){
                            System.out.println("Введіть текст для лаби:\n");
                            Utility8.setInputText(sc.nextLine());
                            System.out.println(Utility8.getGreetText());
                        }
                    }
                }else if (command.equals("2")){
                    Util9.usersRequest();
                }
                else if (command.equals("3")){
                    Utility10.usersRequest();
                }
                else if (command.equals("4")){
                    Utility11.usersRequest();
                }
                else if (command.equals("5")){
                    Utility12.usersRequest();
                }
                else if (command.equals("6")){
                    Utility13.usersRequest();
                }
                else
                    System.out.println("Введіть правильний номер лаби");
            }
            command = "";
        }
    }
}

