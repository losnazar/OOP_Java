package Labs_OOP.Los13;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

    public class MultiThreading {

        private static int size;
        private static double parallel_time = 0;
        private static double cont_time = 0;
        public void setSize(int size) {
            this.size = size;
        }

        public static void setParallel_time(double time) {
            MultiThreading.parallel_time += time;
        }

        public static double getCont_time() {
            return cont_time;
        }

        public static double getParallel_time() {
            return parallel_time;
        }

        public void parallel() {
            ArrayList<Integer> numbers = new ArrayList<>();
            for (int i = 0; i <size; i++) {
                numbers.add(i);
            }
            Runnable even =()->{
                System.out.println("Потік виводу парних чисел: ");
                int sum = 0;
                double end;
                double start = System.nanoTime();
                for (int i = 0; i <numbers.size() ; i++) {
                    if (numbers.get(i)%2==0){
                        sum++;
                        System.out.println("Кількість парних на даний момент " +sum + " (" + i + ")");
                        /*try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }*/
                    }
                }
                end = System.nanoTime();
                long elapsedTime= (long) (end - start);
                double seconds = (double)elapsedTime / 1000000000.0;
                setParallel_time(seconds);
                System.out.println("Кількість парних чисел: " + sum+"\n");
            };
            Runnable odd =()->{
                System.out.println("Потік виводу непарних чисел: ");
                int sum = 0;
                double end;
                double start = System.nanoTime();
                for (int i = 0; i <numbers.size() ; i++) {
                    if (numbers.get(i)%2!=0){
                        sum++;
                        System.out.println("Кількість непарних на даний момент " +sum + " (" + i + ")");

                    }
                }
                end = System.nanoTime();
                long elapsedTime= (long) (end - start);
                double seconds = (double)elapsedTime / 1000000000.0;
                setParallel_time(seconds);
                System.out.println("Кількість непарних числе: " + sum+"\n");
            };
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(even);
            executorService.execute(odd);
        }

        public static void successively(){
            ArrayList<Integer> numbers = new ArrayList<>();
            for (int i = 0; i <size; i++) {
                numbers.add(i);
            }
            System.out.println("Вивід парних чисел: ");
            int sum = 0;
            double end;
            double start = System.nanoTime();
            for (int i = 0; i <numbers.size() ; i++) {
                if (numbers.get(i)%2==0){
                    sum++;
                    System.out.println("Кількість парних на даний момент " +sum + " (" + i + ")");
                }
            }
            for (int i = 0; i <numbers.size() ; i++) {
                if (numbers.get(i)%2!=0){
                    sum++;
                    System.out.println("Кількість непарних на даний момент " +sum + " (" + i + ")");
                }
            }


            end = System.nanoTime();
            long elapsedTime= (long) (end - start);
            double seconds = (double)elapsedTime / 1000000000.0;
            cont_time = seconds;
            System.out.println("Час послідовного алгоритму: " + seconds);

        }
    }

