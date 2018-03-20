public class PracticalTask1 {
    public static void main(String[] args) {
        double a = 3;
        double b = -18;
        double c = 27;
        double x1, x2, d, D;
        d = Math.pow(b, 2) - 4 * a * c;
        D = Math.sqrt(d);
        if (d > 0) {
            if (a!=0){
                x1 = (-b+D)/(2*a);
                x2 = (-b-D)/(2*a);
                System.out.println("x1=" + x1);
                System.out.println("x2=" + x2);
            }
            else{
                x1 = x2 = 0.0;
                System.out.println("x1=" + x1);
                System.out.println("x2=" + x2);
            }
        }
        else if (d==0 & a!=0){
            x1 = x2 = (-b+D)/(2*a);
            System.out.println("x1=" +x1);
            System.out.println("x2=" +x2);
        }
        else {
            System.out.println("x1=");
            System.out.println("x2=");
        }
    }
}