public class ShellSort {
    public static void main(String[] args) {
        int[] array = {30, 2, 10, 4, 6};
        int length = array.length;
        int tempo;
        for (int d = length / 2; d >= 1; d /= 2) {
            for (int i = d; i < length; i++) {
                for (int j = 0; j < length && j + d < length; j++) {
                    if (array[j] > array[i]) {
                        tempo = array[i];
                        array[i] = array[j];
                        array[j] = tempo;
                    }
                }
            }
        }
        for (int i = 0; i < length; i++)
            System.out.print(array[i] + " ");
    }
}
