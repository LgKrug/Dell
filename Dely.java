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
        //Set dos preços e carga dos caminhões
        this.caminhao = new Caminhao(4.87,1000,11.92,4000,27.44,10000);
        this.cidades = new ArrayList<String>();
        //Set dos pesos dos itens 
        this.itens = new Itens(0.5,60.0,100.0,5.0,0.8,120.0);
        //Adiciona as cidades ao ArrayList<> de cidades
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

    //Executa a aplicação
    public void executar(){
        int opcao;
        
        do{
            //Exibe o menu e espera o uuario a escolher uma opção
            menu();
            opcao = entrada.nextInt();
            entrada.nextLine();

            //Executa a opcao escolhida
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

    //Executa a funcionalidade 1: Consultar trechos x modalidade
    public void consultarTrecho(){
        String cidadePartida;
        String cidadeDestino;
        int transporte;
        int distanciaCalculada;
        double valorTransporte;

        //Cadastra a cidade de partida e exibe mensagem de erro caso a cidade não seja reconhecida 
        do{
            System.out.println("Informe a cidade de partida: ");
            cidadePartida = entrada.nextLine().toUpperCase();
            if(cidadeExiste(cidadePartida) == false)
                System.out.println("Cidade não encontrada!");
        }while (cidadeExiste(cidadePartida) == false);
        //Cadastra a cidade destino e exibe mensagem de erro caso a cidade não seja reconhecida 
        do{
            System.out.println("Informe a cidade destino: ");
            cidadeDestino = entrada.nextLine().toUpperCase();
            if(cidadeExiste(cidadeDestino) == false)
                System.out.println("Cidade não encontrada!");
        }while (cidadeExiste(cidadeDestino) == false);

        //Exibe um menu onde é possivel selecionar a modalidade de transporte e alerta caso a modalidade de transporte selecionada seja invalida
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

        //Guarda na variavel distanciaCalculada a distancia entre as duas cidades
        distanciaCalculada = calculaDistancias(cidadePartida, cidadeDestino);
        //Guarda na variavel valorTransporte o preço total deste transporte
        valorTransporte = caminhao.calculaValor(distanciaCalculada,transporte);
        //Exibe na tela a mensagem final da funcionalidade 1
        System.out.println("De " + cidadePartida + " para " + cidadeDestino + ", utilizando um " + caminhao.porte(transporte) + ", a dinstância é de " + distanciaCalculada + "km e o custo será de R$" + valorTransporte + ".");
    }

    //Executa a funcionalidade 2: Cadastrar transporte
    public void cadastraTransporte(){
        String cidadePartida;
        String cidadeDestino;
        int nCelulares;
        int nGeladeiras;
        int nFreezers;
        int nCadeiras;
        int nLuminarias;
        int nLavadoraRoupas;
        int nCelularesDescarregados;
        int nGeladeirasDescarregadas;
        int nFreezersDescarregados;
        int nCadeirasDescarregadas;
        int nLuminariasDescarregadas;
        int nLavadoraRoupasDescarregadas;
        double pesoTotal;
        int distanciaCalculada;
        double precoTotal;
        String stringItens;
        double precoUnitario;
        String confirmacaoParada;

        //Cadastra a cidade de partida e exibe mensagem de erro caso a cidade não seja reconhecida 
        do{
            System.out.println("Informe a cidade de partida: ");
            cidadePartida = entrada.nextLine().toUpperCase();
            if(cidadeExiste(cidadePartida) == false)
                System.out.println("Cidade não encontrada!");
        }while (cidadeExiste(cidadePartida) == false);
        //Cadastra a cidade destino e exibe mensagem de erro caso a cidade não seja reconhecida 
        do{
            System.out.println("Informe a cidade destino: ");
            cidadeDestino = entrada.nextLine().toUpperCase();
            if(cidadeExiste(cidadeDestino) == false)
                System.out.println("Cidade não encontrada!");
        }while (cidadeExiste(cidadeDestino) == false);  
        //Cadastra o numero de itens transportados e não deixa o usuario colocar numeros invalidos
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
            entrada.nextLine();
        }while( nLavadoraRoupas < 0);

        //Guarda na variavel distanciaCalculada a distancia entre as duas cidades
        distanciaCalculada = calculaDistancias(cidadePartida, cidadeDestino);
        //Guarda na variavel pesoTotal o o peso de todos os itens selecionado
        pesoTotal = itens.calculaPeso(nCelulares,nCadeiras,nFreezers,nCadeiras,nLuminarias,nLavadoraRoupas);
        //Calcula a quantidade ideal de caminhões necessarios para o transporte 
        caminhao.setQuantCaminhoes(pesoTotal);
        //Guarda na variavel precoTotal o valor total deste transporte
        precoTotal = caminhao.calculaValor(distanciaCalculada, caminhao.getQuantCaminhoesPequenos(), 1 ) + 
                     caminhao.calculaValor(distanciaCalculada, caminhao.getQuantCaminhoesMedios(), 2) +
                     caminhao.calculaValor(distanciaCalculada, caminhao.getQuantCaminhoesGrandes(), 3);
         //Guarda na variavel stringItens o nome dos itens que serão transportados 
        stringItens = itens.lista(nCelulares, nGeladeiras, nFreezers, nCadeiras, nLuminarias, nLavadoraRoupas);
        //Guarda na variavel precoUnitario a divisao entre o preço total e a quantidade de itens 
        precoUnitario = precoTotal / (nCelulares + nGeladeiras + nFreezers + nCadeiras + nLuminarias + nLavadoraRoupas);

        //Exibe na tela a mensagem das informações deste transporte
        System.out.printf( "De " + cidadePartida + " para " + cidadeDestino + ", a distância a ser percorrida é de " + distanciaCalculada + "km, para transporte dos produtos: " +
                         stringItens + "será necessario utilizar " + "%.0f" + " caminhões grandes, " + "%.0f" + " caminhões médios e " + "%.0f" + 
                         " caminhões pequenos, de forma a resultar no menor custo de transporte por km rodado. O valor total do transporte dos itens é R$" + "%.2f" + 
                         ", sendo R$" + "%.2f" + " é o custo unitário médio." + "\n", caminhao.getQuantCaminhoesGrandes(), 
                         caminhao.getQuantCaminhoesMedios(), caminhao.getQuantCaminhoesPequenos(), precoTotal,precoUnitario);

        System.out.println("Haverá mais uma parada?");
        confirmacaoParada = entrada.nextLine().toUpperCase();

        if(confirmacaoParada.equals("SIM")){
            do{
                System.out.println("Informe a cidade da próxima parada: ");
                cidadePartida = entrada.nextLine().toUpperCase();
                if(cidadeExiste(cidadePartida) == false)
                    System.out.println("Cidade não encontrada!");
            }while (cidadeExiste(cidadePartida) == false);

            do{
                System.out.println("Nesta parada, o numero de celulares descarregados foi de: ");
                nCelularesDescarregados = entrada.nextInt();
            }while( nCelularesDescarregados < 0);

            do{
                System.out.println("Nesta parada, o numero de geladeiras descarregadas foi de: ");
                nGeladeirasDescarregadas= entrada.nextInt();
            }while( nGeladeirasDescarregadas < 0);

            do{
                System.out.println("Nesta parada, o numero de freezers descarregados foi de: ");
                nFreezersDescarregados= entrada.nextInt();
            }while( nFreezersDescarregados < 0);

            do{
                System.out.println("Nesta parada, o numero de cadeiras descarregadas foi de: ");
                nCadeirasDescarregadas= entrada.nextInt();
            }while( nCadeirasDescarregadas < 0);

            do{
                System.out.println("Nesta parada, o numero de luminarias descarregadas foi de: ");
                nLuminariasDescarregadas= entrada.nextInt();
            }while( nLuminariasDescarregadas < 0);

            do{
                System.out.println("Nesta parada, o numero de lavadoras de roupa descarregadas foi de: ");
                nLavadoraRoupasDescarregadas= entrada.nextInt();
                entrada.nextLine();
            }while( nLavadoraRoupasDescarregadas < 0);

            nCelulares = nCelulares - nCelularesDescarregados;
            nGeladeiras = nGeladeiras - nGeladeirasDescarregadas;
            nFreezers = nFreezers - nFreezersDescarregados;
            nCadeiras = nCadeiras - nCadeirasDescarregadas;
            nLuminarias = nLuminarias - nLuminariasDescarregadas;
            nLavadoraRoupas = nLavadoraRoupas - nLavadoraRoupasDescarregadas;

            distanciaCalculada = calculaDistancias(cidadeDestino, cidadePartida);
        pesoTotal = itens.calculaPeso(nCelulares,nCadeiras,nFreezers,nCadeiras,nLuminarias,nLavadoraRoupas);
        caminhao.setQuantCaminhoes(pesoTotal);
        precoTotal = caminhao.calculaValor(distanciaCalculada, caminhao.getQuantCaminhoesPequenos(), 1 ) + 
                     caminhao.calculaValor(distanciaCalculada, caminhao.getQuantCaminhoesMedios(), 2) +
                     caminhao.calculaValor(distanciaCalculada, caminhao.getQuantCaminhoesGrandes(), 3);
        stringItens = itens.lista(nCelulares, nGeladeiras, nFreezers, nCadeiras, nLuminarias, nLavadoraRoupas);
        precoUnitario = precoTotal / (nCelulares + nGeladeiras + nFreezers + nCadeiras + nLuminarias + nLavadoraRoupas);
        System.out.printf( "De " + cidadeDestino + " para " + cidadePartida+ ", a distância a ser percorrida é de " + distanciaCalculada + "km, para transporte dos produtos: " +
                         stringItens + "será necessario utilizar " + "%.0f" + " caminhões grandes, " + "%.0f" + " caminhões médios e " + "%.0f" + 
                         " caminhões pequenos, de forma a resultar no menor custo de transporte por km rodado. O valor total do transporte dos itens é R$" + "%.2f" + 
                         ", sendo R$" + "%.2f" + " é o custo unitário médio." + "\n", caminhao.getQuantCaminhoesGrandes(), 
                         caminhao.getQuantCaminhoesMedios(), caminhao.getQuantCaminhoesPequenos(), precoTotal,precoUnitario);
            
        }
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
