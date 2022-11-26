import br.com.system.mochila.Mochila;
import br.com.system.mochila.Pocao;
import br.com.system.mochila.Pokebola;
import br.com.system.pokemon.Genero;
import br.com.system.pokemon.Movimento;
import br.com.system.pokemon.Pokemon;
import br.com.system.pokemon.Tipo;
import br.com.system.treinador.Ginasio;
import br.com.system.treinador.Insignia;
import br.com.system.treinador.LiderDeGinasio;
import br.com.system.treinador.TreinadorComum;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Tipo agua = new Tipo("Água");
        Tipo fogo = new Tipo("Fogo");
        Tipo planta = new Tipo("Planta");
        Tipo eletrico = new Tipo("Elétrico");
        Tipo terra = new Tipo("Terra");
        Tipo normal = new Tipo("Normal");
        Tipo lutador = new Tipo("Lutador");
        Tipo voador = new Tipo("Voador");
        Tipo pedra = new Tipo("Pedra");

        // Fraqueza | Forte tipo agua
        agua.getFracoContra().add(planta);
        agua.getForteContra().add(fogo);

        // Fraqueza | Forte tipo fogo
        fogo.getFracoContra().add(agua);
        fogo.getForteContra().add(planta);

        // Fraqueza | Forte tipo planta
        planta.getFracoContra().add(fogo);
        planta.getForteContra().add(agua);

        // Fraqueza | Forte tipo eletrico
        eletrico.getFracoContra().add(terra);
        eletrico.getForteContra().add(agua);

        // Fraqueza | Forte tipo terra
        terra.getFracoContra().add(agua);
        terra.getForteContra().add(eletrico);

        // Fraqueza | Forte tipo normal;
        normal.getFracoContra().add(lutador);

        // Fraqueza | Forte tipo Lutador;
        lutador.getForteContra().add(normal);
        lutador.getFracoContra().add(voador);

        // Fraqueza | Forte tipo voador
        voador.getFracoContra().add(eletrico);
        voador.getForteContra().add(lutador);
        voador.getForteContra().add(planta);

        // Fraqueza | Forte tipo pedra
        pedra.getFracoContra().add(agua);
        pedra.getFracoContra().add(planta);
        pedra.getForteContra().add(fogo);
        pedra.getForteContra().add(voador);


        // Movimentos agua
        Movimento bolha = new Movimento("Bolhas", 40, "Um spray de bolhas incontáveis é lançado no Pokémon adversário.", agua, 40);
        Movimento surfar = new Movimento("Surfar", 90, "O usuário ataca tudo ao seu redor inundando seus arredores com uma onda gigante.", agua, 15);
        Movimento hidroBomba = new Movimento("Hidro Bomba", 110, "O alvo é atingido por um grande volume de água lançado sob grande pressão.", agua, 5);
        Movimento pistolaDagua = new Movimento("Pistola D'agua", 40, "O alvo é atingido com um forte tiro de água.", agua, 25);

        // Movimentos fogo
        Movimento socoDeFogo = new Movimento("Soco de Fogo", 75, "O alvo é perfurado com um punho de fogo. Isso também pode deixar o alvo queimado.", fogo, 15);
        Movimento lancaChamas = new Movimento("Lança-Chamas", 90, "O alvo é queimado com uma intensa explosão de fogo.", fogo, 15);
        Movimento explosaoIncendiaria = new Movimento("Explosão Incendiária", 110, "O alvo é atacado com uma explosão intensa de fogo que tudo consome.", fogo, 5);
        Movimento brasa = new Movimento("Brasa", 40, "O alvo é atacado com pequenas chamas.", fogo, 25);

        // Movimentos planta
        Movimento absorver = new Movimento("Absorver", 20, "Um ataque de drenagem de nutrientes.", planta, 25);
        Movimento raioSolar = new Movimento("Raio Solar", 120, "Lança um feixe solar.", planta, 10);
        Movimento folhaNavalha = new Movimento("Folha Navalha", 55, "Folhas de gume afiado são lançadas para cortar o Pokémon adversário.", planta, 25);
        Movimento gigaDreno = new Movimento("Giga Dreno", 75, "Um ataque de drenagem de nutrientes.", planta, 10);

        // Movimentos eletrico
        Movimento trovao = new Movimento("Trovão", 110, "Um impiedoso raio é lançado no alvo para infligir danos.", eletrico, 10);
        Movimento socoDeTrovao = new Movimento("Soco de Trovão", 75, "O alvo é socado com um punho eletrificado.", eletrico, 15);
        Movimento raio = new Movimento("Raio", 90, "Uma forte explosão elétrica atinge o alvo.", eletrico, 15);
        Movimento faisca = new Movimento("Faísca", 65, "O usuário lança uma investida eletricamente carregada no alvo.", eletrico, 20);

        // Movimentos terra
        Movimento terremoto = new Movimento("Terremoto", 100, "O usuário desencadeia um terremoto que atinge todos os Pokémon ao seu redor.", terra, 10);
        Movimento bombaDeLama = new Movimento("bombaDeLama", 65, "O usuário lança uma bola de lama compacta para atacar.", terra, 10);
        Movimento tiroDeLama = new Movimento("TiroDeLama", 55, "O usuário ataca lançando um pouco de lama no alvo.", terra, 15);
        Movimento poderDaTerra = new Movimento("Poder Da Terra", 90, "O usuário faz o solo sob o alvo explodir com força.", terra, 10);

        // Movimentos normal
        Movimento pancadaCorporal = new Movimento("Pancada Corporal", 85, "O usuário cai sobre o alvo com todo o peso de seu corpo.", normal, 15);
        Movimento hiperRaio = new Movimento("Hiper Raio", 100, "O alvo é atacado com um poderoso feixe.", normal, 5);
        Movimento megaSoco = new Movimento("Mega Soco", 80, "O alvo é golpeado por um soco desferido com força muscular.", normal, 20);
        Movimento investida = new Movimento("Investida", 40, "Um ataque físico no qual o usuário investe e bate no alvo com todo o corpo.", normal, 35);

        // Movimentos lutador
        Movimento chuteDuplo = new Movimento("Chute Duplo", 60, "O alvo é chutado rapidamente duas vezes seguidas usando os dois pés.", lutador, 30);
        Movimento chuteDePuloAlto = new Movimento("Chute De Pulo Alto", 80, "O alvo é atacado com uma joelhada em um salto.", lutador, 10);
        Movimento quebraTijolos = new Movimento("Quebra-Tijolos", 75, "O usuário ataca com um corte rápido.", lutador, 15);
        Movimento explosaoFocalizada = new Movimento("Explosao Focalizada", 120,"O usuário aumenta seu foco mental e libera seu poder.", lutador, 5);

        // Movimentos voador
        Movimento lufadaDeVento = new Movimento("Lufada De Vento", 40,"Uma rajada de vento é chicoteada pelas asas e lançada no alvo para causar danos.", voador, 35);
        Movimento ataqueDeAsa = new Movimento("Ataque de Asa", 60, "O alvo é atingido com asas grandes e imponentes, bem abertas para infligir danos.", voador, 35);
        Movimento explosaoAerea = new Movimento("Explosão Aérea", 100, "Um vórticd de ar é disparado contra o alvo para infligir danos.", voador, 5);
        Movimento asDosAres = new Movimento("Ás dos Ares", 60, "O usuário confunde o alvo com a velocidade e então corta.", voador, 20);

        // Movimentos pedra
        Movimento lancamentoDeRocha = new Movimento("Lançamento De Rocha", 50, "O usuário pega e joga uma pequena pedra no alvo para atacar.", pedra, 15);
        Movimento deslizeDePedras = new Movimento("Deslize de Pedras", 75, "Pedras grandes são arremessadas contra o Pokémon adversário para infligir danos.", pedra, 10);
        Movimento explosaoDeRocha = new Movimento("Explosão de Rocha", 125, "O usuário arremessa pedras duras no alvo.", pedra, 10);
        Movimento tumbaDeRochas = new Movimento("Tumba de Rochas", 60, "Pedras são arremessadas contra o alvo.", pedra, 15);


        // Tipos pokemon Charizard
        Pokemon charizard = new Pokemon("Charizard", 225, Genero.MASCULINO, Arrays.asList(fogo, voador));
        charizard.aprenderMovimento(investida);
        charizard.aprenderMovimento(lancaChamas);
        charizard.aprenderMovimento(explosaoIncendiaria);
        charizard.aprenderMovimento(explosaoAerea);

        // Tipos Pokemon Venosauro
        Pokemon venosauro = new Pokemon("Venosauro", 245, Genero.FEMININO, Collections.singletonList(planta));
        venosauro.aprenderMovimento(investida);
        venosauro.aprenderMovimento(raioSolar);
        venosauro.aprenderMovimento(folhaNavalha);
        venosauro.aprenderMovimento(gigaDreno);

        // Tipos Pokemon Blastoise
        Pokemon blastoise = new Pokemon("Blastoise", 300, Genero.MASCULINO, Collections.singletonList(agua));
        blastoise.aprenderMovimento(investida);
        blastoise.aprenderMovimento(hidroBomba);
        blastoise.aprenderMovimento(surfar);
        blastoise.aprenderMovimento(pistolaDagua);

        // Tipos Pokemon pikachu
        Pokemon pikachu = new Pokemon("Pikachu", 215, Genero.MASCULINO, Collections.singletonList(eletrico));
        pikachu.aprenderMovimento(investida);
        pikachu.aprenderMovimento(raio);
        pikachu.aprenderMovimento(trovao);
        pikachu.aprenderMovimento(faisca);

        // Tipos Pokemon onix
        Pokemon onix = new Pokemon("Onix", 200, Genero.MASCULINO, Collections.singletonList(pedra));
        onix.aprenderMovimento(investida);
        onix.aprenderMovimento(explosaoDeRocha);
        onix.aprenderMovimento(lancamentoDeRocha);
        onix.aprenderMovimento(deslizeDePedras);

        // Tipos Pokemon dugtrio
        Pokemon dugtrio = new Pokemon("Dugtrio", 200, Genero.FEMININO, Collections.singletonList(terra));
        dugtrio.aprenderMovimento(investida);
        dugtrio.aprenderMovimento(terremoto);
        dugtrio.aprenderMovimento(tiroDeLama);
        dugtrio.aprenderMovimento(poderDaTerra);

        // Tipos Pokemon pidgeot
        Pokemon pidgeot = new Pokemon("Pidgeot", 200, Genero.MASCULINO, Arrays.asList(normal, voador));
        pidgeot.aprenderMovimento(investida);
        pidgeot.aprenderMovimento(asDosAres);
        pidgeot.aprenderMovimento(ataqueDeAsa);
        pidgeot.aprenderMovimento(lufadaDeVento);

        // Tipos Pokemon hitmonchan
        Pokemon hitmonchan = new Pokemon("Hitmonchan", 250, Genero.FEMININO, Collections.singletonList(lutador));
        hitmonchan.aprenderMovimento(socoDeFogo);
        hitmonchan.aprenderMovimento(socoDeTrovao);
        hitmonchan.aprenderMovimento(explosaoFocalizada);
        hitmonchan.aprenderMovimento(quebraTijolos);

        // Tipos Pokemon Snorlax
        Pokemon snorlax = new Pokemon("Snorlax", 350, Genero.MASCULINO, Collections.singletonList(normal));
        snorlax.aprenderMovimento(terremoto);
        snorlax.aprenderMovimento(hiperRaio);
        snorlax.aprenderMovimento(pancadaCorporal);
        snorlax.aprenderMovimento(deslizeDePedras);


        List<Pokemon> pokemons = Arrays.asList(charizard, venosauro, blastoise, pikachu, onix, dugtrio, pidgeot, hitmonchan, snorlax);


        // Ginasio
        Ginasio ginasioDePedra = new Ginasio("Ginásio de Pedra");
        Insignia insigniaDePedra = new Insignia("Insígnia De Pedra", "é uma pedra", ginasioDePedra);
        ginasioDePedra.setInsignia(insigniaDePedra);

        // Poções
        Pocao superPotion = new Pocao("Super Potion", 70);
        Pocao megaPotion = new Pocao("Mega Potion", 110);

        // Pokebolas
        Pokebola superBall = new Pokebola("SuperBall", 2.0);
        Pokebola megaBall = new Pokebola("Mega Ball", 3.0);

        Mochila mochilaDoAsh = new Mochila(15);
        Mochila mochilaDoLeon = new Mochila(10);
        Mochila mochilaDoBrock = new Mochila(20);

        Pokemon[] pokemonsDoBrock = {onix, pidgeot, pikachu, snorlax, hitmonchan, charizard, blastoise, venosauro};
        Pokemon[] pokemonsDoAsh = {pikachu, venosauro, charizard, blastoise};


        TreinadorComum ash = new TreinadorComum("Ash", 10, Genero.MASCULINO, mochilaDoAsh);
        TreinadorComum leon = new TreinadorComum("Leon", 12, Genero.MASCULINO, mochilaDoLeon);


        LiderDeGinasio brock = new LiderDeGinasio("Brock", 15, Genero.MASCULINO, mochilaDoBrock, pokemonsDoBrock);
        ginasioDePedra.setDoador(brock);
        brock.setGinasio(ginasioDePedra);


        // Início do programa
        final boolean TRUE = true;
        final Scanner SCANNER = new Scanner(System.in);

        //int opcaoTreinadorComum = opcoesTreinadorComum(SCANNER, TRUE);

    }

    public static int opcoesTreinadorComum(Scanner sc, boolean loop) {

        int resposta = 0;

        while (loop) {
            System.out.println(
                    "[1] - Procurar Pokemon\n" +
                            "[2] - Procurar Treinador\n" +
                            "[3] - Combater Líder de Ginásio\n\n" +
                            "[4] - Sair do programa\n\n>> "
            );

            resposta = sc.nextInt();

            if (resposta > 0 && resposta < 5) {
                loop = false;
            } else {
                System.err.println("Inválido! Informe corretamente!");
            }
        }

        return resposta;
    }
}
