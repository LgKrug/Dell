public class Itens {
    private double pesoCelular;
    private double pesoGeladeira;
    private double pesoFreezer;
    private double pesoCadeira;
    private double pesoLuminaria;
    private double pesoLavaRoupa;
    public Itens(double pesoCelular, double pesoGeladeira, double pesoFreezer, double pesoCadeira, double pesoLuminaria, double pesoLavaRoupa){
        this.pesoCelular = pesoCelular;
        this.pesoGeladeira = pesoGeladeira;
        this.pesoFreezer = pesoFreezer;
        this.pesoCadeira = pesoCadeira;
        this.pesoLuminaria = pesoLuminaria;
        this.pesoLavaRoupa = pesoLavaRoupa;
    }

    public double calculaPeso(double celular, double geladeira, double freezer, double cadeira, double luminaria, double lavaRoupa){
        return celular*pesoCelular + geladeira*pesoGeladeira + freezer*pesoFreezer + cadeira*pesoCadeira + luminaria*pesoLuminaria + lavaRoupa*pesoLavaRoupa;
    }

    public String lista(int celular, int geladeira, int freezer, int cadeira, int luminaria, int lavaRoupa){
        String aux = "";
        if(celular > 0)
            aux = "Celular; ";
        if(geladeira > 0)
            aux = aux + "Geladeira; ";
        if(freezer > 0)
            aux = aux + "Freezer; ";
        if(cadeira > 0)
            aux = aux + "Cadeira; ";
        if(luminaria > 0)
            aux = aux + "Luminaria; ";
        if(lavaRoupa > 0)
            aux = aux + "Lavadora de Roupas; ";
        return aux;
    }
}
