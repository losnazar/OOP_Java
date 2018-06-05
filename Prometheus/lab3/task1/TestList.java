package Labs_OOP.prometheus._week3.task1;

public class TestList {
    public static void main (String[]args){
        LinkedList list = new LinkedList();
        for (int i = 0; i <5 ; i++) {
            list.add(i);
        }

//   list.printList();
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            //     list.delete(i);
//            System.out.println(list.get(i));
        }
        list.delete(-10);
        System.out.println("РОзмір "+list.size());
        System.out.println(list.get(0));

        list.printList();
    }
}

