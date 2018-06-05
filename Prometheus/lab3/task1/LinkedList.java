package Labs_OOP.prometheus._week3.task1;

public class LinkedList {
    Node head;
    Node tail;

    int list_size;
    /* Конструктор без аргументів */
    public LinkedList() {}
    /* Додати елемент в кінець списку */
    public void add(Integer data) {
        Node new_node = new Node();
        new_node.setData(data);

    /* 4. If the Linked List is empty, then make the
           new node as head */
        if (head == null)
        {
            head = new Node();
            head.setData(data);
            return;
        }

    /* 4. This new node is going to be the last node, so
         make next of it as null */
        new_node.setNext(null);

        /* 5. Else traverse till the last node */
        Node last = head;
        while (last.getNext()!=null)
            last = last.getNext();

        /* 6. Change the next of last node */
        last.setNext(new_node);
        list_size++;
        return;
    }
    /* Отримати елемент по індексу, повертає null якщо такий елемент недоступний */
    public Integer get(int index) {
        Node temp = head;

        for(int i = 0; temp!=null&&i<index; i++) {
            temp = temp.getNext();

            // If position is more than number of elements in list
            if (temp.getData() == null) {
                return null;
            }
        }
        if (temp == null) {
            return null;
        }
        return temp.getData();
    }
    public void printList()
    {
        Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.getData()+" ");
            tnode = tnode.getNext();
        }
        System.out.println();
    }
    /* Вилучення елементу за індексом, повертає true у разі успіху або false в іншому випадку */
    public boolean delete(int index) {
        // If linked list is empty
        if (index>size()||index<=0){
            return false;
        }
        if (head == null)
            return false;

        // Store head node
        Node temp = head;

        // If head needs to be removed
        if (index == 0) {
            head = temp.getNext();
            list_size--;// Change head
            return true;
        }


        // Find previous node of the node to be deleted
        for (int i=0; temp!=null && i<index-1; i++)
            temp = temp.getNext();

        // If position is more than number of elements in list
        if (temp == null || temp.getNext() == null)
            return false;

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.getNext().getNext();
        // Unlink the deleted node from list
        temp.setNext(next);
        list_size--;
        System.out.println("Розмір списку = "+list_size);
        return true;
    }
    /*Поверта розмір списку: якщо елементів в списку нема то повертає 0 (нуль)*/
    public int size() {

        return this.list_size+1;
    }
}

