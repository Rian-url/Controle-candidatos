import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("Processo seletivo!");

        String [] candidatos = { "PELÉ", "BRUXO", "SOTELDO",  "JÃO PAULO", "GARRINCHA"};

        for(String candidato: candidatos){
            ligarCandidato(candidato);
        }

        selecionarCandidatos();
        imprimirListaSelecionados();

        analisarCandidato(1500.0);
        analisarCandidato(2300.0);
        analisarCandidato(2000.0);
    }

    static void ligarCandidato(String candidato){
        int tentativas = 1;
        boolean continuarLigando = true;
        boolean atendeu = false;

        do {

            atendeu = atender();
            continuarLigando =! true;

            if (continuarLigando){
                tentativas++;
            } else{
                System.out.println("Contato com candidato ocorreu com sucesso");
            }

        } while ( continuarLigando && tentativas < 3);

        if(atendeu) {
            System.out.println("Contatamos o candidato " + candidato + " na " + "º" + tentativas + " tentativa" );
        } else {
            System.out.println("Não conseguimos contatar o candidato " + candidato);
        }

    }

    static boolean atender(){
        return new Random().nextInt(3) == 1;
    }

    static void imprimirListaSelecionados(){

        String [] candidatos = { "PELÉ", "BRUXO", "SOTELDO",  "JÃO PAULO", "GARRINCHA"};
        System.out.println("Aqui está a lista de candidatos:");

        for (int i = 0; i < candidatos.length; i++){
            System.out.println("O " + (i+ 1) + "º" + " candidato"  + " é " + candidatos[i]);
        }

    }

     static void selecionarCandidatos(){
        String [] candidatos = {"NEYMAR", "PELÉ", "BRUXO", "SOTELDO", "BAGRA", "JÃO PAULO", "CANHÃO", "GARRINCHA"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;

        double salarioBase = 2000.0;

        while (candidatosSelecionados < candidatos.length){
           String candidato = candidatos[candidatoAtual];
           double salarioPretendido = valorPretendido();

           System.out.println("O canditado " + candidato + " solicitou o sálario de: " + salarioPretendido);

           if(salarioBase >= salarioPretendido){
            System.out.println("O candidato " + candidato + " foi selecionado!" );
            candidatosSelecionados++;
           } else {
            System.out.println("Infelizmente o candidato " + candidato + " não foi selecionado");
            candidatosSelecionados++;
           }
           candidatoAtual++;
        }
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1500.0 , 2250.0);
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;

        if ( salarioBase > salarioPretendido){
            System.out.println("LIGUE PARA O CANDIDATO");
        } else if(salarioBase == salarioPretendido){
            System.out.println("LIGUE PARA O CANDIDATO COM UMA CONTRAPROPOSTA");
        } else{
            System.out.println("AGUARDANDO O RESULTADO DO RESTANTE DOS CANDIDATOS");
        }
    }
}
