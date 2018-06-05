package Labs_OOP.prometheus._week4;

public class Sort {
    private static void sort(int[] array, Comparator comp) {
    for (int gap = array.length / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < array.length; i++) {
            int val = array[i];
            int j;
            for (j = i; j >= gap && comp.compare(array[j - gap], val) > 0; j -= gap) {
                array[j] = array[j - gap];
            }
            array[j] = val;
        }
    }
}

    public static void main(String[] args){
        int[] array = {1,5,2,4,10,6,0,3,10};
        Comparator comp = new Comparator();

        //Change your code here
        sort(array, comp);
        //Change your code here
        int[] array2 = new int[array.length];
        int k = 0;
        for (int i = array.length-1; i >= 0; i--,k++) {
            array2[k] = array[i];
        }
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i]+" ");
        }
    }
}
