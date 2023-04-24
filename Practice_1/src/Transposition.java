public class Transposition {
    int[][] newMatrix;
    public int[][] transposition(int[][] x){
        newMatrix = new int[x[0].length][x.length];
        for(int i = 0; i < x[0].length; i++){
            for(int j = 0; j < x.length; j++){
                newMatrix[i][j] = x[j][i];
            }
        }
        return newMatrix;
    }
    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        for (int[] i : newMatrix) {
            for (int j = 0; j < newMatrix[0].length; j++) {
                print.append(i[j]).append(" ");
            }
            print.append("\n");
        }
        return print.toString();
    }
}
