import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;

public class Dely {

    private int teste;
    private Distancias distancias;
    private String matrizString = "0;2079;1578;1652;2765;2775;2595;2892;1183;1848;611;294;5215;788;3296;4230;501;4763;1855;356;1578;2187;1142;1408\n" +
    "2079;0;2824;2120;2942;2941;3193;3500;1610;2017;2161;2173;5298;2108;3852;4397;2074;4931;3250;2100;806;2933;947;3108\n" +
    "1578;2824;0;716;1453;1594;1004;1301;2528;906;2171;1854;3951;2348;1712;3050;2061;3584;434;1372;2738;586;2302;524\n" +
    "1650;2140;741;0;1134;1133;1366;1673;2200;209;2245;1930;3490;2422;2027;2589;2135;3123;1148;1446;2157;1015;1789;1239\n";
    
    public Dely(){
        this.teste = 0;
        this.distancias = new Distancias(matrizString);
    }

    public void executar(){
        
        distancias.imprimirMatriz();
    }

}
