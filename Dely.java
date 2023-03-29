import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.Scanner;

public class Dely {

    private int teste;
    private Distancias distancias;
    private Scanner entrada;
    private ArrayList<String> cidades;
    private Caminhao caminhao;
    private Itens itens;


    public Dely(){
        this.distancias = new Distancias();
        this.entrada = new Scanner(System.in);
        this.caminhao = new Caminhao(4.87,1000,11.92,4000,27.44,10000);
        this.cidades = new ArrayList<String>();
        this.itens = new Itens(0.5,60.0,100.0,5.0,0.8,120.0);
        cidades.add("ARACAJU");
        cidades.add("BELEM");
        cidades.add("BELO HORIZONTE");
        cidades.add("BRASILIA");
        cidades.add("CAMPO GRANDE");
        cidades.add("CUIABA");
        cidades.add("CURITIBA");
        cidades.add("FLORIANOPOLIS");
        cidades.add("FORTALEZA");
        cidades.add("GOIANIA");
        cidades.add("JOAO PESSOA");
        cidades.add("MACEIO");
        cidades.add("MANAUS");
        cidades.add("NATAL");
        cidades.add("PORTO ALEGRE");
        cidades.add("PORTO VELHO");
        cidades.add("RECIFE");
        cidades.add("RIO BRANCO");
        cidades.add("RIO DE JANEIRO");
        cidades.add("SALVADOR");
        cidades.add("SAO LUIS");
        cidades.add("SAO PAULO");
        cidades.add("TERESINA");
        cidades.add("VITORIA");
    }

    public void executar(){
        int opcao;
        
        do{
            menu();
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch(opcao){

                case 1: consultarTrecho();
                break;

                case 2: cadastraTransporte();
                break;
                    

                case 0:
                break;
            }

        }while (opcao != 0);
    }

    public void consultarTrecho(){
        String cidadePartida;
        String cidadeDestino;
        int transporte;
        int distanciaCalculada;
        double valorTransporte;
        do{
            System.out.println("Informe a cidade de partida: ");
            cidadePartida = entrada.nextLine().toUpperCase();
            if(cidadeExiste(cidadePartida) == false)
                System.out.println("Cidade não encontrada!");
            }while (cidadeExiste(cidadePartida) == false);

            do{
            System.out.println("Informe a cidade destino: ");
            cidadeDestino = entrada.nextLine().toUpperCase();
            if(cidadeExiste(cidadeDestino) == false)
                System.out.println("Cidade não encontrada!");
            }while (cidadeExiste(cidadeDestino) == false);

            do{
            System.out.println("Informe a modalidade de transporte: ");
            System.out.println("[1] Caminhão de Pequeno Porte");
            System.out.println("[2] Caminhão de Médio Porte.");
            System.out.println("[3] Caminhão de Grande Porte.");
            transporte = entrada.nextInt();
            entrada.nextLine();
            if(transporte < 1 || transporte > 3)
                System.out.println("Modalidade de transporte invalido!");
            }while (transporte < 1 || transporte > 3);

            distanciaCalculada = calculaDistancias(cidadePartida, cidadeDestino);
            valorTransporte = caminhao.calculaValor(distanciaCalculada,transporte);

            System.out.println("De " + cidadePartida + " para " + cidadeDestino + ", utilizando um " + caminhao.porte(transporte) + ", a dinstância é de " + distanciaCalculada + "km e o custo será de R$" + valorTransporte + ".");
    }

    public void cadastraTransporte(){
        String cidadePartida;
        String cidadeDestino;
        int nCelulares;
        int nGeladeiras;
        int nFreezers;
        int nCadeiras;
        int nLuminarias;
        int nLavadoraRoupas;
        double pesoTotal;
        int distanciaCalculada;
        double precoTotal;
        String stringItens;
        double precoUnitario;

        do{
            System.out.println("Informe a cidade de partida: ");
            cidadePartida = entrada.nextLine().toUpperCase();
            if(cidadeExiste(cidadePartida) == false)
                System.out.println("Cidade não encontrada!");
            }while (cidadeExiste(cidadePartida) == false);

            do{
            System.out.println("Informe a cidade destino: ");
            cidadeDestino = entrada.nextLine().toUpperCase();
            if(cidadeExiste(cidadeDestino) == false)
                System.out.println("Cidade não encontrada!");
            }while (cidadeExiste(cidadeDestino) == false);  

            do{
                System.out.println("Neste trajeto, o numero de celulares transportados é de: ");
                nCelulares = entrada.nextInt();
            }while( nCelulares < 0);

            do{
                System.out.println("Neste trajeto, o numero de geladeiras transportadas é de: ");
                nGeladeiras= entrada.nextInt();
            }while( nGeladeiras < 0);

            do{
                System.out.println("Neste trajeto, o numero de freezers transportados é de: ");
                nFreezers= entrada.nextInt();
            }while( nFreezers < 0);

            do{
                System.out.println("Neste trajeto, o numero de cadeiras transportadas é de: ");
                nCadeiras= entrada.nextInt();
            }while( nCadeiras < 0);

            do{
                System.out.println("Neste trajeto, o numero de luminárias transportadas é de: ");
                nLuminarias= entrada.nextInt();
            }while( nLuminarias < 0);

            do{
                System.out.println("Neste trajeto, o numero de lavadoras de ropas transportadas é de: ");
                nLavadoraRoupas= entrada.nextInt();
            }while( nLavadoraRoupas < 0);

            distanciaCalculada = calculaDistancias(cidadePartida, cidadeDestino);
            pesoTotal = itens.calculaPeso(nCelulares,nCadeiras,nFreezers,nCadeiras,nLuminarias,nLavadoraRoupas);
            caminhao.setQuantCaminhoes(pesoTotal);
            precoTotal = caminhao.calculaValor(distanciaCalculada, caminhao.getQuantCaminhoesPequenos(), 1 ) + 
                         caminhao.calculaValor(distanciaCalculada, caminhao.getQuantCaminhoesMedios(), 2) +
                         caminhao.calculaValor(distanciaCalculada, caminhao.getQuantCaminhoesGrandes(), 3);
            stringItens = itens.lista(nCelulares, nGeladeiras, nFreezers, nCadeiras, nLuminarias, nLavadoraRoupas);
            precoUnitario = precoTotal / (nCelulares + nGeladeiras + nFreezers + nCadeiras + nLuminarias + nLavadoraRoupas);



            System.out.printf( "De " + cidadePartida + " para " + cidadeDestino + ", a distância a ser percorrida é de " + distanciaCalculada + "km, para transporte dos produtos: " +
                             stringItens + "será necessario utilizar " + "%.0f" + " caminhões grandes, " + "%.0f" + " caminhões médios e " + "%.0f" + 
                             " caminhões pequenos, de forma a resultar no menor custo de transporte por km rodado. O valor total do transporte dos itens é R$" + "%.2f" + 
                             ", sendo R$" + "%.2f" + " é o custo unitário médio." + "\n", caminhao.getQuantCaminhoesGrandes(), 
                             caminhao.getQuantCaminhoesMedios(), caminhao.getQuantCaminhoesPequenos(), precoTotal,precoUnitario);
    }

    public int calculaDistancias(String cidade1, String cidade2){
        return distancias.retornaDistancia(cidades.indexOf(cidade1), cidades.indexOf(cidade2));
       
    }

    public boolean cidadeExiste(String cidade){
        if(cidades.contains(cidade))
            return true;
        return false;
    }

    public void menu(){
        System.out.println("=============Dely=============");
        System.out.println("[1] Consultar trecho x modalidade");
        System.out.println("[2] Cadastrar transporte");
        System.out.println("[0] Finalizar Programa");
        System.out.println("==============================");
    }

}
