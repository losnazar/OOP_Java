package Labs_OOP.Los8;

public class Variant12 {
    private String text;
    private String[][] table = new String[100][2];
    private String sentence="";
    private int count=0;
    private char currLetter='\u0000';
    private String all_words_in_sentence = "";
    private String outputTable = "SENTENCE \t"+"\tWORDS\n";
    private boolean debug;

    public void setText(String text) {
        this.text = text;
    }
    public void calculate(){
        for (int i = 0; i < this.text.length(); i++) { //Розбивання тексту на речення
            currLetter = this.text.charAt(i);
            if (currLetter != '.')
                sentence += currLetter;
            else if (currLetter == '.') {
                sentence += '.';
                table[count][0] = sentence;
                for (int j = 0; j < sentence.length(); j++) { // Перевірка чи є в речення слова які починються і закінчуюються на однакову букву
                    currLetter = sentence.charAt(j);
                    char firstLetter = '\u0000';
                    char lastLetter = '\u0000';
                    String word = "";

                    if (Character.isAlphabetic(currLetter)) {
                        firstLetter = currLetter;
                        while (currLetter != ' ' && currLetter != '.') {
                            currLetter = sentence.charAt(j);
                            if (currLetter == ' ' || currLetter == '.') {
                                lastLetter = sentence.charAt(j - 1);
                            } else {
                                word += currLetter;
                                j++;
                            }

                        }
                        if (Character.isAlphabetic(firstLetter) && firstLetter == lastLetter) {
                            if (all_words_in_sentence.length() > 0)
                                all_words_in_sentence += " ";
                            all_words_in_sentence += word;
                            table[count][1] = all_words_in_sentence;
                        }
                    }
                }
                all_words_in_sentence = "";
                count++;
                sentence = "";
            }
        }
    }

    public String output(){
        String sentenceToAdd;
        int countSent = 1;
        for (int i = 0; i <this.count; i++) {
            sentenceToAdd = "";
            if (table[i][1]!=null){
                sentenceToAdd = "#"+countSent+" "+this.table[i][0] + "\t"+table[i][1]+"\n";
                this.outputTable+=sentenceToAdd;
                countSent++;
            }
        }
        return this.outputTable;
        }

}


