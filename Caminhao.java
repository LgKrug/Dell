public class Caminhao {
    private double precoPequeno;
    private double precoMedio;
    private double precoGrande;
    public Caminhao(){
        this.precoPequeno = 4.87;
        this.precoMedio = 11.92;
        this.precoGrande = 27.44;
    }

    public String porte(int caminhao) {
        switch(caminhao) {
            case 1: return "caminhão de pequeno porte";
            case 2: return "caminhão de médio porte";
            case 3: return "caminhão de grande porte";
            default: return "Opção invalida";
        }
    }

    public double calculaValor(int distancia, int caminhao) {
        switch(caminhao){
            case 1: return distancia*precoPequeno;
            case 2: return distancia*precoMedio;
            case 3: return distancia*precoGrande;
            default: return 0;
        }
    }
}
