package Labs_OOP.prometheus._week6.task_1;

public class ApplicationRLE {
    public static void main( String[] args ){
        int count = 0;
        String rle = "";
        int numb;
        if (args.length>0){
            String s = args[0];
            while (count<s.length()){
                numb =1;
                char cur = s.charAt(count);
                char next = 0;
                if (count+1<s.length()) {
                    next = s.charAt(count + 1);
                }
                else {rle+=cur; break;}
                if (cur ==next){
                    rle+=cur;
                    while (cur==next&&Character.isLetter(cur)&&Character.isLetter(next)){
                        numb++;
                        count++;
                        cur=next;
                        if (count+1<s.length())
                            next = s.charAt(count + 1);
                        else break;

                    }
                    if (numb>=2&&numb<=9){
                        rle+=numb;
                    }else if (numb>9){
                        rle+=9;
                        rle+=rle.charAt(rle.length()-2);
                        rle+=numb-9;
                    }
                    count++;
                }else{
                    rle+=cur;
                    count++;
                }
            }
            System.out.println(rle);
        }
    }
}

