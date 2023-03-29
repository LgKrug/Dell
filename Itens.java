public class Itens {
    private double pesoCelular;
    private double pesoGeladeira;
    private double pesoFreezer;
    private double pesoCadeira;
    private double pesoLuminaria;
    private double pesoLavaRoupa;
    public Itens(){
        this.pesoCelular = 0.5;
        this.pesoGeladeira = 60.0;
        this.pesoFreezer = 100.0;
        this.pesoCadeira = 5.0;
        this.pesoLuminaria = 0.8;
        this.pesoLavaRoupa = 120.0;
    }

    public double calculaPeso(double celular, double geladeira, double freezer, double cadeira, double luminaria, double lavaRoupa){
        return celular*pesoCelular + geladeira*pesoGeladeira + freezer*pesoFreezer + cadeira*pesoCadeira + luminaria*pesoLuminaria + lavaRoupa*pesoLavaRoupa;
    }
}
