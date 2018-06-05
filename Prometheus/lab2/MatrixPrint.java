public class MatrixPrint {
    public static void main(String[] args) {
        int size = 5;
        int[][] arrD = {{0,2,3,4,0},
                {6,0,8,0,10},
                {11,12,0,14,15},
                {16,0,18,0,20},
                {0,22,23,24,0}};
        for(int i=0;i < size;i++) {
            for(int j=0; j <size;j++) {
                if(arrD[i][j]==0)
                    System.out.print(" * ");
                else if(arrD[i][j]< 10)
                    System.out.print(" "+arrD[i][j] +" ");
                else
                    System.out.print(arrD[i][j] +" ");
            }
            System.out.println();
        }
    }
}