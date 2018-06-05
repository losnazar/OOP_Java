package Labs_OOP.prometheus._week6.task_2;

public class RLE_decoder {
    public static void main( String[] args )
    {
        int count = 1;
        int size = args[0].length();
        String rle = "";
        char next;
        boolean pass= true;
        if (args.length>0){
            if (size==0)
                System.out.println(rle);
            else {
                for (int i = 0; i < size-1; i++)
                    if (args[0].charAt(i)==args[0].charAt(i+1)) {
                        pass = !pass;
                        break;
                    }
                if (pass==true) {
                    if (!Character.isDigit(args[0].charAt(0))) {
                        args[0].charAt(0);
                        rle += args[0].charAt(0);
                        for (count = 1; count < size; count++) { //перебіркожного елемента стрічки
                            char cur = args[0].charAt(count); // даний елемент стрічки
                            if (count + 1 < args[0].length())
                                next = args[0].charAt(count + 1);
                            else {
                                next = 'a';
                            }
                            if (Character.isDigit(cur)) {
                                if (!Character.isDigit(next)) {// перевірка чи даний символ є число і наступний не число
                                    char last = rle.charAt((rle.length() - 1));
                                    for (int i = 1; i < Character.getNumericValue(cur); i++)  //луп для заміни числа на n кількість попередньої букви
                                        rle += last;
                                } else if (Character.isDigit(next)) {
                                    rle = "";
                                    break;
                                }
                            } else if (!Character.isDigit(cur))
                                rle += cur;
                        }
                    }
                }
                System.out.println(rle);
            }

        }
    }
}

