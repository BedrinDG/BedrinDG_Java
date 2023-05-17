public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,6},{6,4,8},{7,3,1}};
        Transposition transposition = new Transposition();
        transposition.transposition(matrix);
        for(int i =0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println(transposition);

    }
}