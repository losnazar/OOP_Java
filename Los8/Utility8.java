package Labs_OOP.Los8;
public class Utility8 {
    public final static String INFO = "i",INPUT = "a", READ = "b", CALCULATE = "c", OUTPUT = "d", EXIT = "e";
    static Variant12 v = new Variant12();
    private static String programInfo = "Користувач вводить текст, програма розбиває його на речення, та визначає у яких реченнях існують слова у яких перша і остання літери співпадають.\nРезультат виводить у вигляді таблиці";
    private static String greetText = "Лаба №8.\n Список команд:\ni. щоб переглянути інформацію про лабу\na. щоб ввести дані;\n" +
            "b. для перегляду даних;\n" +
            "c. виконати обчислення;\n" +
            "d. відобразити результат;\n" +
            "e. повернутись до попереднього меню" ;
    private static String inputText;
    public static String outputText;
    public static String getGreetText(){
        return greetText;
    }
    public static String usersRequest(String request){
        if (request.equals(INFO)){
            return programInfo;
        }else if(request.equals(INPUT)){
            return INPUT;
        }else if (request.equals(READ)){
            if (!inputText.equals(null)){
                return inputText;
            }else {
                return "Ви не ввели текст";
            }
        }else if (request.equals(CALCULATE)){
            if (!inputText.equals(null)){
                v.calculate();

                System.out.println("Всі розрахунки успішно проведені");
            }else {
                return "Ви не ввели текст";
            }
        }else if (request.equals(OUTPUT)){
            outputText = v.output();
            return outputText;
        }
        else if (request.equals(EXIT)){
            System.out.println("Повертаємось в  основне меню\n");
            return EXIT;
        }
        else
            return "Введіть правильну команду";
        return "";
    }
    public static void setInputText(String text){
        inputText = text;
        v.setText(inputText);
    }
    public static String outputForLab9(String str){
        v.setText(str);
        v.calculate();
        String output = v.output();
        return output;
    }
}
