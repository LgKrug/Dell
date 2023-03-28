import java.util.Scanner;

public class Distancias {
    private int[][] matriz;

    public Distancias(String matrizString) {
        Scanner scanner = new Scanner(matrizString);
        int linhas = matrizString.split("\n").length;
        int colunas = matrizString.split("\n")[0].split(";").length;
        matriz = new int[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            String linha = scanner.nextLine();
            String[] valores = linha.split(";");
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = Integer.parseInt(valores[j]);
            }
        }
    }

    public void imprimirMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}