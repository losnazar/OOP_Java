package Labs_OOP.Los10;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

    public class Utility10 {
        public final static String INFO = "i", CREATE = "1", OUTPUT = "2",SAVE_IN_FILE = "save",READ_FROM_FILE= "read", EXIT = "e";
        public final static String NAME = "1",END = "e", DATE = "2", TIME = "3", DURATION = "4", PLACE = "5", INFO_Of_EVENT = "6", PARTICIPANTS = "7";
        public static String request = "";
        static EventContainer eventContainer = new EventContainer();
        static Scanner sc = new Scanner(System.in);
        static String programInfo = ".Планувальник. Захід: дата, час початку і тривалість; місце проведення;\n" +
                "опис; учасники (кількість не обмежена).\n";
        static String greetText = "Лаба №10, Варіант 14. \"Планувальник\"\n Список команд:\n" +
                "i. щоб переглянути інформацію про лабу\n" +
                "1. Створити нову подію\n" +
                "2. Вивести всі події;\n" +
                "save. зберегти події;\n" +
                "read. відкрити файл з подіями;\n" +
                "e. завершити;\n";
        final static String createEventInfo = "Введіть дані про нову подію\n" +
                "1. Щоб ввести назву події\n" +
                "2. Щоб ввети дату події у форматі DD/MM/YY\n" +
                "3. Щоб ввечсти час початку події\n" +
                "4. Щоб ввести тривалість події\n" +
                "5. Місце проведення події\n" +
                "6. Інформація про подію\n" +
                "7. Учасники події.\n" +
                "e. Щоб завершити створення події.";
        public static void usersRequest() throws IOException, ClassNotFoundException {
            Scanner sc = new Scanner(System.in);
            while (!request.equals(EXIT)) {
                System.out.print(greetText);
                request = sc.nextLine();
                if (request.equals(INFO)){
                    System.out.println(programInfo);
                }else if (request.equals(CREATE)){
                    createEvent();
                }else if (request.equals(OUTPUT)){
                    EventContainer eventContainer = new EventContainer();
                    printAllEvents(eventContainer.getAllEvents());
                }else if (request.equals(SAVE_IN_FILE)){
                    ArrayList<EventEntity> eventsToSave = eventContainer.getAllEvents();
                    EventDAO writerDAO = new EventDAO();
                    writerDAO.setEventContainer(eventsToSave);
                    System.out.println("Введіть назву файлу:");
                    String fileName = sc.nextLine()+".ser";
                    FileOutputStream outputStream = new FileOutputStream(fileName);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                    writerDAO.writeExternal(objectOutputStream);
                    objectOutputStream.flush();
                    outputStream.close();
                }else if (request.equals(READ_FROM_FILE)){
                    EventDAO readerDAO = new EventDAO();
                    System.out.println("Введіть назву файлу:");
                    String fileName = sc.nextLine()+".ser";
                    FileInputStream inputStream = new FileInputStream(fileName);
                    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                    readerDAO.readExternal(objectInputStream);
                    objectInputStream.close();
                    inputStream.close();
                    eventContainer.setAllEvents(readerDAO.getContainer());
                }
            }
        }
        public static void createEvent() {
            EventEntity newEvent = new EventEntity();
            String command = "";
            while (!command.equals(END)) {
                System.out.println(createEventInfo);
                command = sc.nextLine();
                switch (command) {
                    case NAME:
                        System.out.print("Назва події: ");
                        newEvent.setName(sc.nextLine());

                        break;
                    case DATE:
                        System.out.print("Дата: ");
                        newEvent.setDate(sc.nextLine());
                        break;
                    case TIME:
                        System.out.print("Час: ");
                        newEvent.setStart_time(sc.nextLine());
                        break;
                    case DURATION:
                        System.out.print("Тривалість: ");
                        newEvent.setDuration(sc.nextInt());
                        break;
                    case PLACE:
                        System.out.print("Місце проведення: ");
                        newEvent.setPlace(sc.nextLine());
                        break;
                    case INFO_Of_EVENT:
                        System.out.println("Інформація про подію");
                        newEvent.setInfo(sc.nextLine());
                        break;
                    case PARTICIPANTS:
                        System.out.println("Учасники(Щоб завершити введіть \".\"): ");
                        ArrayList<String> patric = new ArrayList<>();
                        while (!command.equals(".")) {
                            command = sc.nextLine();
                            patric.add(command);
                        }
                        newEvent.setParticipants(patric);
                        command = "";
                        break;
                    case END:
                        eventContainer.addEvent(newEvent);
                        break;
                    default:
                        System.out.println("Введіть правильну команду");
                        break;
                }
            }
        }
        public static void printAllEvents(ArrayList<EventEntity> events){
                int i = 1;
                for (EventEntity event : events) {
                    System.out.println(i + ". " + event.getName());
                    i++;
                }
            }
        }