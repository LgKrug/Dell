public class Caminhao {
    private double precoPequeno;
    private int cargaPequeno;
    private double precoMedio;
    private int cargaMedio;
    private double precoGrande;
    private int cargaGrande;
    private double quantCaminhoesPequenos;
    private double quantCaminhoesMedios;
    private double quantCaminhoesGrandes;
    public Caminhao(double precoPequeno, int cargaPequeno, double precoMedio, int cargaMedio, double precoGrande, int cargaGrande){
        this.precoPequeno = precoPequeno;
        this.cargaPequeno = cargaPequeno;
        this.precoMedio = precoMedio;
        this.cargaMedio = cargaMedio;
        this.precoGrande = precoGrande;
        this.cargaGrande = cargaGrande;
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

    public double calculaValor(int distancia, double quantCaminhao, int porteCaminhao) {
        switch(porteCaminhao){
            case 1: return distancia*precoPequeno*quantCaminhao;
            case 2: return distancia*precoMedio*quantCaminhao;
            case 3: return distancia*precoGrande*quantCaminhao;
            default: return 0;
        }
    }

    public void setQuantCaminhoes(double pesoTotal){
        double resto =0;
        quantCaminhoesGrandes = Math.floor(pesoTotal / cargaGrande); 
        resto = (pesoTotal % cargaGrande);
        if(resto > 0 && resto < 10000){
            quantCaminhoesMedios = Math.floor(resto / cargaMedio);
            resto = (resto % cargaMedio);
            if(resto > 0 && resto < 4000){
                quantCaminhoesPequenos = Math.ceil(resto / cargaPequeno);
                if(quantCaminhoesPequenos > 2){
                    quantCaminhoesPequenos = 0;
                    quantCaminhoesMedios++;
                }
            } 
        }
    }

    public double getQuantCaminhoesGrandes(){
        return quantCaminhoesGrandes;
    }

    public double getQuantCaminhoesMedios(){
        return quantCaminhoesMedios;
    }

    public double getQuantCaminhoesPequenos(){
        return quantCaminhoesPequenos;
    }
}
