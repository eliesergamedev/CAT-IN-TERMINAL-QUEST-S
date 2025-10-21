import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class RPG {
    // Nome do Jogo
    public static String gameName = "CAT IN TERMINAL QUEST'S";

    // Códigos ANSI para cores
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    
    // Sistema para input de dados pelo terminal
    public static Scanner scanner = new Scanner(System.in);
    public static Console console = System.console();

    public static String optionMenu;
    public static int optionSelected;

    // Controlador de primeira vez que o jogador ataca
    public static boolean firstAttack = true;

    // Criação do personagem principal do jogo
    public static String playerName = "Cat";
    public static String playerLabelIdle = "😾(Cat): ";
    public static String playerLabelHappy = "😺(Cat): ";
    public static String playerLabelSmile = "😸(Cat): ";
    public static String playerLabelLovely = "😻(Cat): ";
    public static String playerLabelTrusting = "😼(Cat): ";
    public static String playerLabelSad = "😿(Cat): ";
    public static String playerLabelSurprised = "🙀(Cat): ";
    public static String playerArmorEquipped = "Armadura: Nenhuma";
    public static String playerWeaponEquipped = "Arma: Nenhuma";
    public static String playerBootsEquipped = "Botas: Nenhuma";
    public static String playerHelmetEquipped = "Capacete: Nenhum";
    public static String playerShieldEquipped = "Escudo: Nenhum";
    public static String playerGlovesEquipped = "Luvas: Nenhuma";
    public static final int playerHealthBase = 20; // Vida base do jogador
    public static int playerHealthMax = playerHealthBase; // Vida máxima do jogador
    public static int playerHealth = playerHealthMax; // Vida atual do jogador
    public static int playerAgility = 4;
    public static int playerLuck = 3;
    public static int playerAttack = 4;
    public static int playerDefense = 3;
    public static int level = 1;
    public static int playerExp = 0;
    public static int playerMoney = 0;
    public static int playerArmor = 0; // Defesa extra da armadura equipada
    public static int playerWeapon = 0; // Ataque extra da arma equipada
    public static int playerBoots = 0; // Agilidade extra das botas equipadas
    public static int playerHelmet = 0; // Defesa extra do capacete equipado
    public static int playerShield = 0; // Defesa extra do escudo equipado
    public static int playerGloves = 0; // Ataque extra das luvas equip
    public static int playerFoods = 0; // Número inicial de poções de cura
    public static int playerLimitFoods = 2; // Limite de poções de cura que o jogador pode carregar
    
    // Array para experiência necessária para cada nível (níveis 1 a 99)
    public static int[] playerExpLevelUp = new int[100];

    // Criação das armas e armaduras do jogo: variáveis constantes
    public static final String[] armorsCommon = {"🦺 Armadura de Couro", "🦺 Armadura de Ferro", "🦺 Armadura de Aco", "🦺 Armadura Magica"};
    public static final String[] weaponsCommon = {"🗡 Espada de Madeira", "🗡 Espada de Ferro", "🗡 Espada de Aco", "🗡 Espada Magica"};
    public static final String[] bootsCommon = {"👢 Botas de Couro", "👢 Botas de Ferro", "👢 Botas de Aco", "👢 Botas Magicas"};
    public static final String[] helmetsCommon = {"🪖 Capacete de Couro", "🪖 Capacete de Ferro", "🪖 Capacete de Aco", "🪖 Capacete Magico"};
    public static final String[] shieldsCommon = {"🛡 Escudo de Madeira", "🛡 Escudo de Ferro", "🛡 Escudo de Aco", "🛡 Escudo Magico"};
    public static final String[] glovesCommon = {"🧤 Luvas de Couro", "🧤 Luvas de Ferro", "🧤 Luvas de Aco", "🧤 Luvas Magicas"};
    public static final String[] armorsRare = {"🦺 Armadura de Dragao", "🦺 Armadura de Fenix", "🦺 Armadura de Grifo", "🦺 Armadura do Vampiro"};
    public static final String[] weaponsRare = {"🗡 Espada do Dragao", "🗡 Espada da Fenix", "🗡 Espada do Grifo", "🗡 Espada do Vampiro"};
    public static final String[] bootsRare = {"👢 Botas do Dragao", "👢 Botas da Fenix", "👢 Botas do Grifo", "👢 Botas do Vampiro"};
    public static final String[] helmetsRare = {"🪖 Capacete do Dragao", "🪖 Capacete da Fenix", "🪖 Capacete do Grifo", "🪖 Capacete do Vampiro"};
    public static final String[] shieldsRare = {"🛡 Escudo do Dragao", "🛡 Escudo da Fenix", "🛡 Escudo do Grifo", "🛡 Escudo do Vampiro"};
    public static final String[] glovesRare = {"🧤 Luvas do Dragao", "🧤 Luvas da Fenix", "🧤 Luvas do Grifo", "🧤 Luvas do Vampiro"};
    public static final String[] armorsEpic = {"🦺 Armadura do Imperador", "🦺 Armadura do Rei dos Titans", "🦺 Armadura do Senhor dos Dragoes", "🦺 Armadura do Anjo Renascido"};
    public static final String[] weaponsEpic = {"🗡 Espada do Imperador", "🗡 Espada do Rei dos Titans", "🗡 Espada do Senhor dos Dragoes", "🗡 Espada do Anjo Renascido"};
    public static final String[] bootsEpic = {"👢 Botas do Imperador", "👢 Botas do Rei dos Titans", "👢 Botas do Senhor dos Dragoes", "👢 otas do Anjo Renascido"};
    public static final String[] helmetsEpic = {"🪖 Capacete do Imperador", "🪖 Capacete do Rei dos Titans", "🪖 Capacete do Senhor dos Dragoes", "🪖 Capacete do Anjo Renascido"};
    public static final String[] shieldsEpic = {"🛡 Escudo do Imperador", "🛡 Escudo do Rei dos Titans", "🛡 Escudo do Senhor dos Dragoes", "🛡 Escudo do Anjo Renascido"};
    public static final String[] glovesEpic = {"🧤 Luvas do Imperador", "🧤 Luvas do Rei dos Titans", "🧤 Luvas do Senhor dos Dragões", "🧤 Luvas do Anjo Renascido"};

    // Valor de cura da poção
    public static final int foodHealAmount = 5;

    // Criação dos inimigos do jogo: variáveis constantes
    
    // Ork Dog
    public static final String orkDogName = "Ork Dog";
    public static final String orkDogLabel = "🐶(Ork Dog): ";
    public static final int orkDogHealth = 10;
    public static final int orkDogAttack = 5;
    public static final int orkDogDefense = 2;
    public static final int orkDogExp = 51;
    public static final int orkDogMoney = 10;
    public static final int orkDogAgility = 2;

    public static void initializeExpList() {
        // Inicializa o array de experiência necessária para cada nível
        playerExpLevelUp[1] = 50; // Nível 1
        for (int i = 2; i < playerExpLevelUp.length; i++) {
            /*  
                A variável i, nesse caso vai simular o nível do jogador.
                Fazendo percorrer o array, de forma que simule a evolução do personagem para realizar o cálculo da EXP necessária para cada nível.
            */
            playerExpLevelUp[i] = (int)(playerExpLevelUp[1] * (Math.pow(i, 2))); // Fórmula Quadrática. Para calcular a EXP necessária de cada nível.
        }
    }

    public static void store() {
        String optionStore;
        int optionSelectedStore;

        System.out.println("\n" + YELLOW + "---------------------- LOJA DO JOGO ----------------------------");
        System.out.println("Bem-vindo a loja! O que voce gostaria de comprar?");
        System.out.println("1. Comida (5 moedas) 🍣 +" + foodHealAmount);
        System.out.println("2. Bolsa de comida: +1 espaco para pocoes (10 moedas) 🎒");
        System.out.println("3. Sair da Loja 🚪");
        System.out.println("----------------------------------------------------------------" + RESET);

        optionStore = msgInteractive("Digite o número da opção desejada: ");
        optionSelectedStore = Integer.parseInt(optionStore);

        switch (optionSelectedStore) {
            case 1:
                if (playerMoney >= 5 && playerFoods < playerLimitFoods) {
                    playerMoney -= 5;
                    playerFoods++;
                    System.out.println(GREEN + "Voce comprou uma pocao de cura! Agora voce tem " + playerFoods + " pocao(oes) de cura." + RESET);
                    System.out.println(GREEN + "Dinheiro restante: " + playerMoney + " moedas." + RESET);
                } else if (playerFoods > playerLimitFoods) {
                    System.out.println(RED + "Voce ja esta com o inventario cheio de poções de cura!" + RESET);
                } else {
                    System.out.println(RED + "Voce nao tem dinheiro suficiente para comprar uma pocao de cura!" + RESET);
                }
                store();
                break;
            case 2:
                if (playerMoney >= 10) {
                    playerMoney -= 10;
                    playerLimitFoods++;
                    System.out.println(GREEN + "Voce comprou uma bolsa de pocoes! Agora voce pode carregar " + playerLimitFoods + " pocoes de cura." + RESET);
                    System.out.println(GREEN + "Dinheiro restante: " + playerMoney + " moedas." + RESET);
                } else {
                    System.out.println(RED + "Voce nao tem dinheiro suficiente para comprar uma bolsa de pocoes!" + RESET);
                }
                store();
                break;
            case 3:
                System.out.println(YELLOW + "Saindo da loja..." + RESET);
                break;
            default:
                System.out.println(RED + "Opcao invalida. Selecione uma das opcoes validas." + RESET);
                store();
                break;
        }
    }

    public static void useFood() {
        if (playerFoods > 0) {
            playerFoods--;
            playerHealth += foodHealAmount;
            if (playerHealth > playerHealthMax) {
                playerHealth = playerHealthMax; // Garante que a vida não ultrapasse o máximo
            }
            System.out.println(GREEN + "Voce usou uma comida e recuperou " + foodHealAmount + " de vida!" + RESET);
            System.out.println(GREEN + "Vida atual: " + playerHealth + RESET);
            System.out.println(GREEN + "Comidas restantes: " + playerFoods + RESET);
        } else {
            System.out.println(RED + "Voce nao tem nenhuma comida na sua bolsa!" + RESET);
        }
    }

    public static void explorer() throws InterruptedException {
        Random rand = new Random();
        double rollParam = Math.pow(rand.nextDouble(), 0.5); // Gera um número aleatório entre 0.0 e 1.0, com raiz quadrada para aumentar a chance de valores mais altos
        int attrValue = (int) Math.round(playerLuck * 2 * rollParam); // Calcula o bônus com base na sorte do jogador e no número aleatório
        int roll = rand.nextInt(15); // Gera um número aleatório entre 0 e 14
        int itemType = rand.nextInt(6); // Gera um número aleatório entre 0 e 5 para determinar o tipo de item encontrado
        
        // TROCAR ITEM
        char choice = 'x';
        String armorCommon = armorsCommon[rand.nextInt(4)];
        String weaponCommon = weaponsCommon[rand.nextInt(4)];
        String bootCommon = bootsCommon[rand.nextInt(4)];
        String helmetCommon = helmetsCommon[rand.nextInt(4)];
        String shieldCommon = shieldsCommon[rand.nextInt(4)];
        String gloveCommon = glovesCommon[rand.nextInt(4)];
        String armorRare = armorsRare[rand.nextInt(4)];
        String weaponRare = weaponsRare[rand.nextInt(4)];
        String bootRare = bootsRare[rand.nextInt(4)];
        String helmetRare = helmetsRare[rand.nextInt(4)];
        String shieldRare = shieldsRare[rand.nextInt(4)];
        String gloveRare = glovesRare[rand.nextInt(4)];
        String armorEpic = armorsEpic[rand.nextInt(4)];
        String weaponEpic = weaponsEpic[rand.nextInt(4)];
        String bootEpic = bootsEpic[rand.nextInt(4)];
        String helmetEpic = helmetsEpic[rand.nextInt(4)];
        String shieldEpic = shieldsEpic[rand.nextInt(4)];
        String gloveEpic = glovesEpic[rand.nextInt(4)];

        System.out.println("🐈 Explorando o local...");
        pause();
        System.out.println("🐈 Vasculhando as coisas...");
        pause();
        System.out.println("🐈 Acho que encontrei alguma coisa...");
        pause();

        if (roll >= 3 && roll <= 4) {
            if (playerFoods <= playerLimitFoods) {
                playerFoods++;
                System.out.println(CYAN + "🍣 Voce encontrou comida!" + RESET);
                System.out.println(CYAN + "🍣 Comida na bolsa: " + playerFoods + RESET);
                System.out.println(CYAN + "💖 Voce pode usar a comida para recuperar " + foodHealAmount + " de vida durante a sua aventura!" + RESET);
            } else {
                System.out.println(YELLOW + "😺 Voce encontrou uma poção de cura, mas ja está com o inventário cheio!" + RESET);
            }
        } else if (roll >= 5 && roll <= 9) {
            System.out.println(YELLOW + "😺 Voce encontrou " + attrValue + " moedas!" + RESET);
            playerMoney += attrValue;
            System.out.println(YELLOW + "💰 Dinheiro atual: " + playerMoney + " moedas." + RESET);
        } else if (roll >= 10 && roll <= 12) {
            System.out.println(GREEN + "😸 Voce encontrou um item comum!" + RESET);
            // Lógica para adicionar o item comum ao inventário
            pause();
            
            switch (itemType) {
                case 0:
                    System.out.println(GREEN + "Voce encontrou uma armadura!" + RESET);
                    System.out.println(GREEN + "Tipo do item: Armadura 🦺" + RESET);
                    System.out.println(GREEN + "Nome do item: " + armorCommon + RESET);
                    System.out.println(GREEN + "Defesa extra: " + "+" + attrValue + RESET);
                    System.out.println();
                    System.out.println(YELLOW + "Item atual: " + playerArmorEquipped + " (Defesa: +" + playerArmor + ")" + RESET);
                    
                    try {
                        choice = msgInteractive("Deseja pegar/trocar o item? (s/n)").charAt(0);
                    } catch (Exception e) {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }
                    
                    if (!String.valueOf(choice).toLowerCase().equals("s")) {
                        System.out.println(YELLOW + "Voce decidiu nao pegar o item." + RESET);
                        break;
                    } else if (String.valueOf(choice).toLowerCase().equals("s")) {
                        playerDefense -= playerArmor; // Remove a defesa do item atual
                        System.out.println(GREEN + "Voce decidiu pegar o item." + RESET);
                        playerArmor = attrValue;
                        playerDefense += playerArmor;
                        playerArmorEquipped = armorCommon;
                        System.out.println(GREEN + "Tipo do item: Armadura 🦺" + RESET);
                        System.out.println(GREEN + "Nome do item: " + playerArmorEquipped + RESET);
                        System.out.println(GREEN + "Defesa extra: " + "+" + playerArmor + RESET);
                        statusPlayer();
                    } else {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    break;
                case 1:
                    System.out.println(GREEN + "Voce encontrou uma arma!" + RESET);
                    System.out.println(GREEN + "Tipo do item: Arma 🗡" + RESET);
                    System.out.println(GREEN + "Nome do item: " + weaponCommon + RESET);
                    System.out.println(GREEN + "Ataque extra: " + "+" + attrValue + RESET);
                    System.out.println();
                    System.out.println(YELLOW + "Item atual: " + playerWeaponEquipped + " (Ataque: +" + playerWeapon + ")" + RESET);

                    try {
                        choice = msgInteractive("Deseja pegar/trocar o item? (s/n)").charAt(0); 
                    } catch (Exception e) {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    if (!String.valueOf(choice).toLowerCase().equals("s")) {
                        System.out.println(YELLOW + "Voce decidiu nao pegar o item." + RESET);
                        break;
                    } else if (String.valueOf(choice).toLowerCase().equals("s")) {
                        playerAttack -= playerWeapon; // Remove o ataque do item atual
                        System.out.println(GREEN + "Voce decidiu pegar o item." + RESET);
                        playerWeapon = attrValue;
                        playerAttack += playerWeapon;
                        playerWeaponEquipped = weaponCommon;
                        System.out.println(GREEN + "Tipo do item: Arma 🗡" + RESET);
                        System.out.println(GREEN + "Nome do item: " + playerWeaponEquipped + RESET);
                        System.out.println(GREEN + "Ataque extra: " + "+" + playerWeapon + RESET);
                        statusPlayer();
                    } else {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    break;
                case 2:
                    System.out.println(GREEN + "Voce encontrou uma bota!" + RESET);
                    System.out.println(GREEN + "Tipo do item: Botas 👢" + RESET);
                    System.out.println(GREEN + "Nome do item: " + bootCommon + RESET);
                    System.out.println(GREEN + "Agilidade extra: " + "+" + attrValue + RESET);
                    System.out.println();
                    System.out.println(YELLOW + "Item atual: " + playerBootsEquipped + " (Agilidade: +" + playerBoots + ")" + RESET);

                    try {
                        choice = msgInteractive("Deseja pegar/trocar o item? (s/n)").charAt(0); 
                    } catch (Exception e) {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    if (!String.valueOf(choice).toLowerCase().equals("s")) {
                        System.out.println(YELLOW + "Voce decidiu nao pegar o item." + RESET);
                        break;
                    } else if (String.valueOf(choice).toLowerCase().equals("s")) {
                        playerAgility -= playerBoots; // Remove a agilidade do item atual
                        System.out.println(GREEN + "Voce decidiu pegar o item." + RESET);
                        playerBoots = attrValue;
                        playerAgility += playerBoots;
                        playerBootsEquipped = bootCommon;
                        System.out.println(GREEN + "Tipo do item: Botas 👢" + RESET);
                        System.out.println(GREEN + "Nome do item: " + playerBootsEquipped + RESET);
                        System.out.println(GREEN + "Agilidade extra: " + "+" + playerBoots + RESET);
                        statusPlayer();
                    } else {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    break;
                case 3:
                    System.out.println(GREEN + "Voce encontrou um capacete!" + RESET);
                    System.out.println(GREEN + "Tipo do item: Capacete 🪖" + RESET);
                    System.out.println(GREEN + "Nome do item: " + helmetCommon + RESET);
                    System.out.println(GREEN + "Defesa extra: " + "+" + attrValue + RESET);
                    System.out.println();
                    System.out.println(YELLOW + "Item atual: " + playerHelmetEquipped + " (Defesa: +" + playerHelmet + ")" + RESET);

                    try {
                        choice = msgInteractive("Deseja pegar/trocar o item? (s/n)").charAt(0); 
                    } catch (Exception e) {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    if (!String.valueOf(choice).toLowerCase().equals("s")) {
                        System.out.println(YELLOW + "Voce decidiu nao pegar o item." + RESET);
                        break;
                    } else if (String.valueOf(choice).toLowerCase().equals("s")) {
                        playerDefense -= playerHelmet; // Remove a defesa do item atual
                        System.out.println(GREEN + "Voce decidiu pegar o item." + RESET);
                        playerHelmet = attrValue;
                        playerDefense += playerHelmet;
                        playerHelmetEquipped = helmetCommon;
                        System.out.println(GREEN + "Tipo do item: Capacete 🪖" + RESET);
                        System.out.println(GREEN + "Nome do item: " + playerHelmetEquipped + RESET);
                        System.out.println(GREEN + "Defesa extra: " + "+" + playerHelmet + RESET);
                        statusPlayer();
                    } else {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    break;
                case 4:
                    System.out.println(GREEN + "Voce encontrou um escudo!" + RESET);
                    System.out.println(GREEN + "Tipo do item: Escudo 🛡" + RESET);
                    System.out.println(GREEN + "Nome do item: " + shieldCommon + RESET);
                    System.out.println(GREEN + "Defesa extra: " + "+" + attrValue + RESET);
                    System.out.println();
                    System.out.println(YELLOW + "Item atual: " + playerShieldEquipped + " (Defesa: +" + playerShield + ")" + RESET);

                    try {
                        choice = msgInteractive("Deseja pegar/trocar o item? (s/n)").charAt(0); 
                    } catch (Exception e) {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    if (!String.valueOf(choice).toLowerCase().equals("s")) {
                        System.out.println(YELLOW + "Voce decidiu nao pegar o item." + RESET);
                        break;
                    } else if (String.valueOf(choice).toLowerCase().equals("s")) {
                        playerDefense -= playerShield; // Remove a defesa do item atual
                        System.out.println(GREEN + "Voce decidiu pegar o item." + RESET);
                        playerShield = attrValue;
                        playerDefense += playerShield;
                        playerShieldEquipped = shieldCommon;
                        System.out.println(GREEN + "Tipo do item: Escudo 🛡" + RESET);
                        System.out.println(GREEN + "Nome do item: " + playerShieldEquipped + RESET);
                        System.out.println(GREEN + "Defesa extra: " + "+" + playerShield + RESET);
                        statusPlayer();
                    } else {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    break;
                case 5:
                    System.out.println(GREEN + "Voce encontrou uma luva!" + RESET);
                    System.out.println(GREEN + "Tipo do item: Luvas 🧤" + RESET);
                    System.out.println(GREEN + "Nome do item: " + gloveCommon + RESET);
                    System.out.println(GREEN + "Ataque extra: " + "+" + attrValue + RESET);
                    System.out.println();
                    System.out.println(YELLOW + "Item atual: " + playerGlovesEquipped + " (Ataque: +" + playerGloves + ")" + RESET);

                    try {
                        choice = msgInteractive("Deseja pegar/trocar o item? (s/n)").charAt(0); 
                    } catch (Exception e) {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    if (!String.valueOf(choice).toLowerCase().equals("s")) {
                        System.out.println(YELLOW + "Voce decidiu nao pegar o item." + RESET);
                        break;
                    } else if (String.valueOf(choice).toLowerCase().equals("s")) {
                        playerAttack -= playerGloves; // Remove o ataque do item atual
                        System.out.println(GREEN + "Voce decidiu pegar o item." + RESET);
                        playerGloves = attrValue;
                        playerAttack += playerGloves;
                        playerGlovesEquipped = gloveCommon;
                        System.out.println(GREEN + "Tipo do item: Luvas 🧤" + RESET);
                        System.out.println(GREEN + "Nome do item: " + playerGlovesEquipped + RESET);
                        System.out.println(GREEN + "Ataque extra: " + "+" + playerGloves + RESET);
                        statusPlayer();
                    } else {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }
                    
                    break;
            }
        } else if (roll == 13) {
            System.out.println(BLUE + "😻 Voce encontrou um item raro!" + RESET);
            // Lógica para adicionar o item raro ao inventário
            pause();

            switch (itemType) {
                case 0:
                    System.out.println(BLUE + "Tipo do item: Armadura 🦺" + RESET);
                    System.out.println(BLUE + "Nome do item: " + armorRare + RESET);
                    System.out.println(BLUE + "Defesa extra: " + "+" + attrValue * 2 + RESET);
                    System.out.println();
                    System.out.println(YELLOW + "Item atual: " + playerArmorEquipped + " (Defesa: +" + playerArmor + ")" + RESET);

                    try {
                        choice = msgInteractive("Deseja pegar/trocar o item? (s/n)").charAt(0); 
                    } catch (Exception e) {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    if (!String.valueOf(choice).toLowerCase().equals("s")) {
                        System.out.println(YELLOW + "Voce decidiu nao pegar o item." + RESET);
                        break;
                    } else if (String.valueOf(choice).toLowerCase().equals("s")) {
                        playerDefense -= playerArmor; // Remove a defesa do item atual
                        System.out.println(BLUE + "Voce decidiu pegar o item." + RESET);
                        playerArmor = attrValue * 2;
                        playerDefense += playerArmor;
                        playerArmorEquipped = armorsRare[rand.nextInt(4)];
                        System.out.println(BLUE + "Tipo do item: Armadura 🦺" + RESET);
                        System.out.println(BLUE + "Nome do item: " + playerArmorEquipped + RESET);
                        System.out.println(BLUE + "Defesa extra: " + "+" + playerArmor + RESET);
                        statusPlayer();
                    } else {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }   

                    break;
                case 1:
                    System.out.println(BLUE + "Tipo do item: Arma 🗡" + RESET);
                    System.out.println(BLUE + "Nome do item: " + weaponRare + RESET);
                    System.out.println(BLUE + "Ataque extra: " + "+" + attrValue * 2 + RESET);
                    System.out.println();
                    System.out.println(YELLOW + "Item atual: " + playerWeaponEquipped + " (Ataque: +" + playerWeapon + ")" + RESET);

                    try {
                        choice = msgInteractive("Deseja pegar/trocar o item? (s/n)").charAt(0); 
                    } catch (Exception e) {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    if (!String.valueOf(choice).toLowerCase().equals("s")) {
                        System.out.println(YELLOW + "Voce decidiu nao pegar o item." + RESET);
                        break;
                    } else if (String.valueOf(choice).toLowerCase().equals("s")) {
                        playerAttack -= playerWeapon; // Remove o ataque do item atual
                        System.out.println(BLUE + "Voce decidiu pegar o item." + RESET);
                        playerWeapon = attrValue * 2;
                        playerAttack += playerWeapon;
                        playerWeaponEquipped = weaponsRare[rand.nextInt(4)];
                        System.out.println(BLUE + "Tipo do item: Arma 🗡" + RESET);
                        System.out.println(BLUE + "Nome do item: " + playerWeaponEquipped + RESET);
                        System.out.println(BLUE + "Ataque extra: " + "+" + playerWeapon + RESET);
                        statusPlayer();
                    } else {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    break;
                case 2:
                    System.out.println(BLUE + "Tipo do item: Botas 👢" + RESET);
                    System.out.println(BLUE + "Nome do item: " + bootRare + RESET);
                    System.out.println(BLUE + "Agilidade extra: " + "+" + attrValue * 2 + RESET);
                    System.out.println();
                    System.out.println(YELLOW + "Item atual: " + playerBootsEquipped + " (Agilidade: +" + playerBoots + ")" + RESET);

                    try {
                        choice = msgInteractive("Deseja pegar/trocar o item? (s/n)").charAt(0); 
                    } catch (Exception e) {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    if (!String.valueOf(choice).toLowerCase().equals("s")) {
                        System.out.println(YELLOW + "Voce decidiu nao pegar o item." + RESET);
                        break;
                    } else if (String.valueOf(choice).toLowerCase().equals("s")) {
                        playerAgility -= playerBoots; // Remove a agilidade do item atual
                        System.out.println(BLUE + "Voce decidiu pegar o item." + RESET);
                        playerBoots = attrValue * 2;
                        playerAgility += playerBoots;
                        playerBootsEquipped = bootsRare[rand.nextInt(4)];
                        System.out.println(BLUE + "Tipo do item: Botas 👢" + RESET);
                        System.out.println(BLUE + "Nome do item: " + playerBootsEquipped + RESET);
                        System.out.println(BLUE + "Agilidade extra: " + "+" + playerBoots + RESET);
                        statusPlayer();
                    } else {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    break;
                case 3:
                    System.out.println(BLUE + "Tipo do item: Capacete 🪖" + RESET);
                    System.out.println(BLUE + "Nome do item: " + helmetRare + RESET);
                    System.out.println(BLUE + "Defesa extra: " + "+" + attrValue * 2 + RESET);
                    System.out.println();
                    System.out.println(YELLOW + "Item atual: " + playerHelmetEquipped + " (Defesa: +" + playerHelmet + ")" + RESET);

                    try {
                        choice = msgInteractive("Deseja pegar/trocar o item? (s/n)").charAt(0); 
                    } catch (Exception e) {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    if (!String.valueOf(choice).toLowerCase().equals("s")) {
                        System.out.println(YELLOW + "Voce decidiu nao pegar o item." + RESET);
                        break;
                    } else if (String.valueOf(choice).toLowerCase().equals("s")) {
                        playerDefense -= playerHelmet; // Remove a defesa do item atual
                        System.out.println(BLUE + "Voce decidiu pegar o item." + RESET);
                        playerHelmet = attrValue * 2;
                        playerDefense += playerHelmet;
                        playerHelmetEquipped = helmetsRare[rand.nextInt(4)];
                        System.out.println(BLUE + "Tipo do item: Capacete 🪖" + RESET);
                        System.out.println(BLUE + "Nome do item: " + playerHelmetEquipped + RESET);
                        System.out.println(BLUE + "Defesa extra: " + "+" + playerHelmet + RESET);
                        statusPlayer();
                    } else {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    break;
                case 4:
                    System.out.println(BLUE + "Tipo do item: Escudo 🛡" + RESET);
                    System.out.println(BLUE + "Nome do item: " + shieldRare + RESET);
                    System.out.println(BLUE + "Defesa extra: " + "+" + attrValue * 2 + RESET);
                    System.out.println();
                    System.out.println(YELLOW + "Item atual: " + playerShieldEquipped + " (Defesa: +" + playerShield + ")" + RESET);

                    try {
                        choice = msgInteractive("Deseja pegar/trocar o item? (s/n)").charAt(0); 
                    } catch (Exception e) {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    if (!String.valueOf(choice).toLowerCase().equals("s")) {
                        System.out.println(YELLOW + "Voce decidiu nao pegar o item." + RESET);
                        break;
                    } else if (String.valueOf(choice).toLowerCase().equals("s")) {
                        playerDefense -= playerShield; // Remove a defesa do item atual
                        System.out.println(BLUE + "Voce decidiu pegar o item." + RESET);
                        playerShield = attrValue * 2;
                        playerDefense += playerShield;
                        playerShieldEquipped = shieldsRare[rand.nextInt(4)];
                        System.out.println(BLUE + "Tipo do item: Escudo 🛡" + RESET);
                        System.out.println(BLUE + "Nome do item: " + playerShieldEquipped + RESET);
                        System.out.println(BLUE + "Defesa extra: " + "+" + playerShield + RESET);
                        statusPlayer();
                    } else {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    break;
                case 5:
                    System.out.println(BLUE + "Tipo do item: Luvas 🧤" + RESET);
                    System.out.println(BLUE + "Nome do item: " + gloveRare + RESET);
                    System.out.println(BLUE + "Ataque extra: " + "+" + attrValue * 2 + RESET);
                    System.out.println();
                    System.out.println(YELLOW + "Item atual: " + playerGlovesEquipped + " (Ataque: +" + playerGloves + ")" + RESET);

                    try {
                        choice = msgInteractive("Deseja pegar/trocar o item? (s/n)").charAt(0); 
                    } catch (Exception e) {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    if (!String.valueOf(choice).toLowerCase().equals("s")) {
                        System.out.println(YELLOW + "Voce decidiu nao pegar o item." + RESET);
                        break;
                    } else if (String.valueOf(choice).toLowerCase().equals("s")) {
                        playerAttack -= playerGloves; // Remove o ataque do item atual
                        System.out.println(BLUE + "Voce decidiu pegar o item." + RESET);
                        playerGloves = attrValue * 2;
                        playerAttack += playerGloves;
                        playerGlovesEquipped = glovesRare[rand.nextInt(4)];
                        System.out.println(BLUE + "Tipo do item: Luvas 🧤" + RESET);
                        System.out.println("Nome do item: " + playerGlovesEquipped + RESET);
                        System.out.println(BLUE + "Ataque extra: " + "+" + playerGloves + RESET);
                        statusPlayer();
                    } else {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    break;
            }
        } else if (roll == 14) {
            System.out.println(PURPLE + "😼 Uau! Voce encontrou um item épico!" + RESET);
            // Lógica para adicionar o item épico ao inventário
            pause();

            switch (itemType) {
                case 0:
                    System.out.println(PURPLE + "Voce encontrou uma armadura!" + RESET);
                    System.out.println(PURPLE + "Tipo do item: Armadura 🦺" + RESET);
                    System.out.println(PURPLE + "Nome do item: " + armorEpic + RESET);
                    System.out.println(PURPLE + "Defesa extra: " + "+" + attrValue * 3 + RESET);
                    System.out.println();
                    System.out.println(YELLOW + "Item atual: " + playerArmorEquipped + " (Defesa: +" + playerArmor + ")" + RESET);

                    try {
                        choice = msgInteractive("Deseja pegar/trocar o item? (s/n)").charAt(0); 
                    } catch (Exception e) {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    if (!String.valueOf(choice).toLowerCase().equals("s")) {
                        System.out.println(YELLOW + "Voce decidiu nao pegar o item." + RESET);
                        break;
                    } else if (String.valueOf(choice).toLowerCase().equals("s")) {
                        playerDefense -= playerArmor; // Remove a defesa do item atual
                        System.out.println(PURPLE + "Voce decidiu pegar o item." + RESET);
                        playerArmor = attrValue * 3;
                        playerDefense += playerArmor;
                        playerArmorEquipped = armorsEpic[rand.nextInt(4)];
                        System.out.println(PURPLE + "Tipo do item: Armadura 🦺" + RESET);
                        System.out.println(PURPLE + "Nome do item: " + playerArmorEquipped + RESET);
                        System.out.println(PURPLE + "Defesa extra: " + "+" + playerArmor + RESET);
                        statusPlayer();
                    } else {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    break;
                case 1:
                    System.out.println(PURPLE + "Tipo do item: Arma 🗡" + RESET);
                    System.out.println(PURPLE + "Nome do item: " + weaponEpic + RESET);
                    System.out.println(PURPLE + "Ataque extra: " + "+" + attrValue * 3 + RESET);
                    System.out.println();
                    System.out.println(YELLOW + "Item atual: " + playerWeaponEquipped + " (Ataque: +" + playerWeapon + ")" + RESET);

                    try {
                        choice = msgInteractive("Deseja pegar/trocar o item? (s/n)").charAt(0); 
                    } catch (Exception e) {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    if (!String.valueOf(choice).toLowerCase().equals("s")) {
                        System.out.println(YELLOW + "Voce decidiu nao pegar o item." + RESET);
                        break;
                    } else if (String.valueOf(choice).toLowerCase().equals("s")) {
                        playerAttack -= playerWeapon; // Remove o ataque do item atual
                        System.out.println(PURPLE + "Voce decidiu pegar o item." + RESET);
                        playerWeapon = attrValue * 3;
                        playerAttack += playerWeapon;
                        playerWeaponEquipped = weaponsEpic[rand.nextInt(4)];
                        System.out.println(PURPLE + "Tipo do item: Arma 🗡" + RESET);
                        System.out.println(PURPLE + "Nome do item: " + playerWeaponEquipped + RESET);
                        System.out.println(PURPLE + "Ataque extra: " + "+" + playerWeapon + RESET);
                        statusPlayer();
                    } else {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    break;
                case 2:
                    System.out.println(PURPLE + "Tipo do item: Botas 👢" + RESET);
                    System.out.println(PURPLE + "Nome do item: " + bootEpic + RESET);
                    System.out.println(PURPLE + "Agilidade extra: " + "+" + attrValue * 3 + RESET);
                    System.out.println();
                    System.out.println(YELLOW + "Item atual: " + playerBootsEquipped + " (Agilidade: +" + playerBoots + ")" + RESET);

                    try {
                        choice = msgInteractive("Deseja pegar/trocar o item? (s/n)").charAt(0); 
                    } catch (Exception e) {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    if (!String.valueOf(choice).toLowerCase().equals("s")) {
                        System.out.println(YELLOW + "Voce decidiu nao pegar o item." + RESET);
                        break;
                    } else if (String.valueOf(choice).toLowerCase().equals("s")) {
                        playerAgility -= playerBoots; // Remove a agilidade do item atual
                        System.out.println(PURPLE + "Voce decidiu pegar o item." + RESET);
                        playerBoots = attrValue * 3;
                        playerAgility += playerBoots;
                        playerBootsEquipped = bootsEpic[rand.nextInt(4)];
                        System.out.println(PURPLE + "Tipo do item: Botas 👢" + RESET);
                        System.out.println(PURPLE + "Nome do item: " + playerBootsEquipped + RESET);
                        System.out.println(PURPLE + "Agilidade extra: " + "+" + playerBoots + RESET);
                        statusPlayer();
                    } else {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    break;
                case 3:
                    System.out.println(PURPLE + "Tipo do item: Capacete 🪖" + RESET);
                    System.out.println(PURPLE + "Nome do item: " + helmetEpic + RESET);
                    System.out.println(PURPLE + "Defesa extra: " + "+" + attrValue * 3 + RESET);
                    System.out.println();
                    System.out.println(YELLOW + "Item atual: " + playerHelmetEquipped + " (Defesa: +" + playerHelmet + ")" + RESET);

                    try {
                        choice = msgInteractive("Deseja pegar/trocar o item? (s/n)").charAt(0); 
                    } catch (Exception e) {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    if (!String.valueOf(choice).toLowerCase().equals("s")) {
                        System.out.println(YELLOW + "Voce decidiu nao pegar o item." + RESET);
                        break;
                    } else if (String.valueOf(choice).toLowerCase().equals("s")) {
                        playerDefense -= playerHelmet; // Remove a defesa do item atual
                        System.out.println(PURPLE + "Voce decidiu pegar o item." + RESET);
                        playerHelmet = attrValue * 3;
                        playerDefense += playerHelmet;
                        playerHelmetEquipped = helmetsEpic[rand.nextInt(4)];
                        System.out.println(PURPLE + "Tipo do item: Capacete 🪖" + RESET);
                        System.out.println(PURPLE + "Nome do item: " + playerHelmetEquipped + RESET);
                        System.out.println(PURPLE + "Defesa extra: " + "+" + playerHelmet + RESET);
                        statusPlayer();
                    } else {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    break;
                case 4:
                    System.out.println(PURPLE + "Tipo do item: Escudo 🛡" + RESET);
                    System.out.println(PURPLE + "Nome do item: " + shieldEpic + RESET);
                    System.out.println(PURPLE + "Defesa extra: " + "+" + attrValue * 3 + RESET);
                    System.out.println();
                    System.out.println(YELLOW + "Item atual: " + playerShieldEquipped + " (Defesa: +" + playerShield + ")" + RESET);

                    try {
                        choice = msgInteractive("Deseja pegar/trocar o item? (s/n)").charAt(0); 
                    } catch (Exception e) {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    if (!String.valueOf(choice).toLowerCase().equals("s")) {
                        System.out.println(YELLOW + "Voce decidiu nao pegar o item." + RESET);
                        break;
                    } else if (String.valueOf(choice).toLowerCase().equals("s")) {
                        playerDefense -= playerShield; // Remove a defesa do item atual
                        System.out.println(PURPLE + "Voce decidiu pegar o item." + RESET);
                        playerShield = attrValue * 3;
                        playerDefense += playerShield;
                        playerShieldEquipped = shieldsEpic[rand.nextInt(4)];
                        System.out.println(PURPLE + "Tipo do item: Escudo 🛡" + RESET);
                        System.out.println(PURPLE + "Nome do item: " + playerShieldEquipped + RESET);
                        System.out.println(PURPLE + "Defesa extra: " + "+" + playerShield + RESET);
                        statusPlayer();
                    } else {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    break;
                case 5:
                    System.out.println(PURPLE + "Tipo do item: Luvas 🧤" + RESET);
                    System.out.println(PURPLE + "Nome do item: " + gloveEpic + RESET);
                    System.out.println(PURPLE + "Ataque extra: " + "+" + attrValue * 3 + RESET);
                    System.out.println();
                    System.out.println(YELLOW + "Item atual: " + playerGlovesEquipped + " (Ataque: +" + playerGloves + ")" + RESET);

                    try {
                        choice = msgInteractive("Deseja pegar/trocar o item? (s/n)").charAt(0); 
                    } catch (Exception e) {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    if (!String.valueOf(choice).toLowerCase().equals("s")) {
                        System.out.println(YELLOW + "Voce decidiu nao pegar o item." + RESET);
                        break;
                    } else if (String.valueOf(choice).toLowerCase().equals("s")) {
                        playerAttack -= playerGloves; // Remove o ataque do item atual
                        System.out.println(PURPLE + "Voce decidiu pegar o item." + RESET);
                        playerGloves = attrValue * 3;
                        playerAttack += playerGloves;
                        playerGlovesEquipped = glovesEpic[rand.nextInt(4)];
                        System.out.println(PURPLE + "Tipo do item: Luvas 🧤" + RESET);
                        System.out.println("Nome do item: " + playerGlovesEquipped + RESET);
                        System.out.println(PURPLE + "Ataque extra: " + "+" + playerGloves + RESET);
                        statusPlayer();
                    } else {
                        System.out.println(RED + "Entrada invalida. Por favor, digite 's' para sim ou 'n' para nao." + RESET);
                        System.out.println(RED + "Infelizmente, voce perdeu o item..." + RESET);
                        explorer();
                    }

                    break;
            }
        } else {
            System.out.println(RED + "😿 Infelizmente, Voce não encontrou nada dessa vez." + RESET);
        }
    }

    public static void confirmDialog() {
        System.out.println("Precione ENTER para continuar...");
        scanner.nextLine(); // Espera o usuário pressionar ENTER
    }
    
    
    public static void levelUp() {
        int controller = 2; // Controlador de pontos para distribuir
        String infoLevelUp = "";
        int choice;

        // Programar o sistema de level up, por escolha do jogador
        level++;
        playerHealth = playerHealthMax; // Restaura a vida do jogador ao subir de nível

        System.out.println(CYAN + "✨Parabéns!✨ Voce subiu para o nível " + level + "!😻" + RESET);

        while (controller > 0) {
            System.out.println("Voce tem " + controller + " pontos de atributos para distribuir.");
            choice = Integer.parseInt(msgInteractive("Escolha um atributo para aumentar:\n1. Vida (+5)\n2. Ataque (+2)\n3. Defesa (+2)\n4. Agilidade (+2)\n5. Sorte (+1)\nDigite o número da opção desejada: "));
            // Deve mostrar os atributos que o jogador pode aumentar e seus valores, no momento que atingir o level up
            switch(choice) {
                case 1:
                    System.out.println(GREEN + "Voce escolheu aumentar sua Vida." + RESET);
                    playerHealthMax += 5;
                    playerHealth = playerHealthMax; // Restaura a vida ao aumentar o máximo
                    infoLevelUp += "+5 de Vida\n";
                    System.out.println("Sua vida agora é: " + playerHealth);
                    break;
                case 2:
                    System.out.println(BLUE + "Voce escolheu aumentar seu Ataque." + RESET);
                    playerAttack += 2;
                    infoLevelUp += "+2 de Ataque\n";
                    System.out.println("Seu ataque agora é: " + playerAttack);
                    break;
                case 3:
                    System.out.println(PURPLE + "Voce escolheu aumentar sua Defesa." + RESET);
                    playerDefense += 2;
                    infoLevelUp += "+2 de Defesa\n";
                    System.out.println("Sua defesa agora é: " + playerDefense);
                    break;
                case 4:
                    System.out.println(YELLOW + "Voce escolheu aumentar sua Sorte." + RESET);
                    playerLuck += 1;
                    infoLevelUp += "+1 de Sorte\n";
                    System.out.println("Sua sorte agora é: " + playerLuck);
                    break;
                case 5:
                    System.out.println(YELLOW + "Voce escolheu aumentar sua Sorte." + RESET);
                    playerLuck += 2;
                    infoLevelUp += "+2 de Agilidade\n";
                    System.out.println("Sua agilidade agora é: " + playerLuck);
                break;
                default:
                    System.out.println(RED + "Opção inválida. Nenhum atributo foi aumentado." + RESET);
                    controller++; // Não conta essa tentativa
                    break;
            }
            controller--;
        }

        System.out.println(YELLOW + "\nSeus atributos aumentaram:" + RESET);
        System.out.println(BLUE + infoLevelUp + RESET);
        statusPlayer();
    }


    public static void pause() throws InterruptedException {
        Thread.sleep(3000);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String msgInteractive(String message) {
        return console.readLine(YELLOW + message + RESET);
    }

    public static void start() throws InterruptedException {
        // Limpa o terminal
        clearScreen();

        // Inicializa a lista de experiência(banco de dados, simulado com array)
        initializeExpList();
        
        // Menu inicial
        System.out.println(GREEN + "-------------------"+gameName+"----------------" + RESET);
        System.out.println(GREEN + "#                                                        #" + RESET);
        System.out.println(GREEN + "#                                                        #" + RESET);
        System.out.println(GREEN + "#                                                        #" + RESET);
        System.out.println(GREEN + "#                         1.COMEÇAR                      #" + RESET);
        System.out.println(GREEN + "#                         2.SAIR                         #" + RESET);
        System.out.println(GREEN + "#                                                        #" + RESET);
        System.out.println(GREEN + "#                                                        #" + RESET);
        System.out.println(GREEN + "#                                                        #" + RESET);
        System.out.println(GREEN + "----------------------------------------------------------" + RESET);

        // Leitura da opção do menu
        optionMenu = msgInteractive("Digite o número da opção desejada: ");
        optionSelected = Integer.parseInt(optionMenu);

        switch (optionSelected) {
            case 1:
                clearScreen();
                System.out.println(GREEN + "-------------------"+gameName+"----------------" + RESET);
                System.out.println(GREEN + "#                                                        #" + RESET);
                System.out.println(GREEN + "#                                                        #" + RESET);
                System.out.println(GREEN + "#                                                        #" + RESET);
                System.out.println(BLUE + "# >>>>>>>>>>>>>>>>>>>>>>> 1.COMEÇAR <<<<<<<<<<<<<<<<<<<< #" +  RESET);
                System.out.println(GREEN + "#                         2.SAIR                         #" + RESET);
                System.out.println(GREEN + "#                                                        #" + RESET);
                System.out.println(GREEN + "#                                                        #" + RESET);
                System.out.println(GREEN + "#                                                        #" + RESET);
                System.out.println(GREEN + "----------------------------------------------------------" + RESET);
                System.out.println();
                System.out.println(playerLabelTrusting + "QUE A AVENTURA COMECE!");
                System.out.println();
                break;
            case 2:
                clearScreen();
                System.out.println(GREEN + "-------------------"+gameName+"----------------" + RESET);
                System.out.println(GREEN + "#                                                        #" + RESET);
                System.out.println(GREEN + "#                                                        #" + RESET);
                System.out.println(GREEN + "#                                                        #" + RESET);
                System.out.println(GREEN + "#                         1.COMEÇAR                      #" + RESET);
                System.out.println(BLUE  + "# >>>>>>>>>>>>>>>>>>>>>>> 2.SAIR <<<<<<<<<<<<<<<<<<<<<<< #" + RESET);
                System.out.println(GREEN + "#                                                        #" + RESET);
                System.out.println(GREEN + "#                                                        #" + RESET);
                System.out.println(GREEN + "#                                                        #" + RESET);
                System.out.println(GREEN + "----------------------------------------------------------" + RESET);
                System.out.println();
                System.out.println(RED + "GAME OVER!" + RESET);
                System.out.println();
                System.exit(0);
                break;
            default:
                System.out.println(RED + "Opção inválida. Selecione uma das opções válidas." + RESET);
                pause();
                start();
                break;
        }
    }

    public static void statusPlayer() {
        System.out.println("\n" + CYAN + "------------------ INVENTÁRIO DO JOGADOR ------------------");
        System.out.println("Inventário do Jogador:");
        System.out.println("Nome: " + playerName);
        System.out.println("✨ Nível: " + level);
        System.out.println("🌟 Experiência: " + playerExp + "/" + playerExpLevelUp[level]);
        System.out.println(RED + "❤" + CYAN + "  Vida: " + playerHealth);
        System.out.println("⚔  Ataque: " + playerAttack);
        System.out.println("🛡  Defesa: " + playerDefense);
        System.out.println("💨 Agilidade: " + playerAgility);
        System.out.println("🎲 Sorte: " + playerLuck);
        System.out.println("💰 Dinheiro: " + playerMoney + " moedas");
        System.out.println("🍣 Poções de Cura: " + playerFoods + "/" + playerLimitFoods);
        System.out.println("\nEquipamentos:");
        System.out.println(" - " + playerArmorEquipped + " (Defesa: +" + playerArmor + ")");
        System.out.println(" - " + playerWeaponEquipped + " (Ataque: +" + playerWeapon + ")");
        System.out.println(" - " + playerBootsEquipped + " (Agilidade: +" + playerBoots + ")");
        System.out.println(" - " + playerHelmetEquipped + " (Defesa: +" + playerHelmet + ")");
        System.out.println(" - " + playerShieldEquipped + " (Defesa: +" + playerShield + ")");
        System.out.println(" - " + playerGlovesEquipped + " (Ataque: +" + playerGloves + ")");
        System.out.println("-----------------------------------------------------------" + RESET + "\n");
    }

    public static void hudPlayer() {
        System.out.println("\n" + CYAN + "------------------ STATUS DO JOGADOR ------------------");
        System.out.println("Status do Jogador:");
        System.out.println("Nome: " + playerName);
        System.out.println(RED + "❤" + CYAN + " Vida: " + playerHealth);
        System.out.println("⚔ Ataque: " + playerAttack);
        System.out.println("🛡 Defesa: " + playerDefense);
        System.out.println("-------------------------------------------------------" + RESET + "\n");
    }

    public static void statusEnemy(String enemyName, int enemyHealth, int enemyAttack, int enemyDefense, int enemyAgility) {
        System.out.println("\n" + RED + "------------------ STATUS DO INIMIGO ------------------");
        System.out.println("Status do Inimigo:");
        System.out.println("Nome: " + enemyName);
        System.out.println("❤ Vida: " + enemyHealth);
        System.out.println("⚔ Ataque: " + enemyAttack);
        System.out.println("🛡 Defesa: " + enemyDefense);
        System.out.println("-------------------------------------------------------" + RESET + "\n");
    }

    public static int menuBattle() {
        String optionBattle;
        int optionSelectedBattle;

        System.out.println("\n" + YELLOW + "---------------------- MENU DE BATALHA ----------------------");
        System.out.println("Escolha uma ação:");
        System.out.println("1. Atacar ⚔");
        System.out.println("2. Defender 🛡");
        System.out.println("3. Inventário 🎒");
        System.out.println("4. Comida 🍣");
        System.out.println("5. Fugir 💨");
        System.out.println("--------------------------------------------------------------" + RESET);

        optionBattle = msgInteractive("Digite o número da ação desejada: ");
        optionSelectedBattle = Integer.parseInt(optionBattle);

        return optionSelectedBattle;       
    }

    public static void battle(String enemyName, int enemyHealth, int enemyAttack, int enemyDefense, int enemyAgility, int enemyExp, int enemyMoney) {
        Random random = new Random();
        double roll = random.nextDouble(); // Gera um número aleatório entre 0.0 e 1.0
        double chanceAttack = (double) playerAgility / (playerAgility + enemyAgility); // Calcula a chance de acerto com base na agilidade
        double chanceSkip = (double) (playerAgility * 1.2) / (playerAgility + enemyAgility); // Calcula a chance de fuga com base na agilidade, com um bônus de 20% para o jogador

        hudPlayer();
        statusEnemy(enemyName, enemyHealth, enemyAttack, enemyDefense, enemyAgility);
        
        // Lógica de batalha aqui
        switch (menuBattle()) {
            case 1:
                System.out.println(playerLabelTrusting + "Vou atacar!");
                // Lógica de ataque aqui
                if (firstAttack) {
                    firstAttack = false;
                    
                    if (roll <= chanceAttack) {
                        System.out.println(GREEN + "Acertou! Voce causou um ataque ao adversário!" + RESET);
                        enemyHealth -= playerAttack > enemyDefense ? (playerAttack - enemyDefense) : 0; // Garante que o dano mínimo seja 0

                        if (enemyHealth <= 0) {
                            System.out.println(GREEN + "Voce derrotou " + enemyName + "!" + RESET);
                            playerExp += enemyExp;
                            playerMoney += enemyMoney;
                            System.out.println(GREEN + "Voce ganhou " + enemyExp + " de experiência e " + enemyMoney + " moedas!" + RESET);
                            
                            if (playerExp >= playerExpLevelUp[level]) {
                                levelUp();
                            } else {
                                statusPlayer();
                            }
                        } else {
                            battle(enemyName, enemyHealth, enemyAttack, enemyDefense,enemyAgility, enemyExp, enemyMoney);
                        }
                    } else {
                        System.out.println(RED + "Errou! O inimigo esquivou do seu ataque!" + RESET);

                        playerHealth -= enemyAttack > playerDefense ? (enemyAttack - playerDefense) : 0; // Garante que o dano mínimo seja 0
                        System.out.println(RED + enemyName + " contra-atacou e causou dano em Voce!" + RESET);

                        if (playerHealth <= 0) {
                            System.out.println(RED + "Voce foi derrotado por " + enemyName + "!" + RESET);
                            System.out.println(RED + "GAME OVER!" + RESET);
                            System.exit(0);
                        } else {
                            battle(enemyName, enemyHealth, enemyAttack, enemyDefense,enemyAgility, enemyExp, enemyMoney);
                        }
                    }

                } else {
                    System.out.println(GREEN + "Acertou! Voce causou um ataque ao adversário!💥" + RESET);
                    enemyHealth -= playerAttack > enemyDefense ? (playerAttack - enemyDefense) : 0; // Garante que o dano mínimo seja 0

                    if (enemyHealth <= 0) {
                        System.out.println(GREEN + "Voce derrotou " + enemyName + "!" + RESET);
                        playerExp += enemyExp;
                        playerMoney += enemyMoney;
                        System.out.println(GREEN + "Voce ganhou " + enemyExp + " de experiência e " + enemyMoney + " moedas!" + RESET);
                        
                        if (playerExp >= playerExpLevelUp[level]) {
                            levelUp();
                        } else {
                            statusPlayer();
                        }
                    } else {
                        playerHealth -= enemyAttack > playerDefense ? (enemyAttack - playerDefense) : 0; // Garante que o dano mínimo seja 0
                        System.out.println(RED + enemyName + " contra-atacou e causou dano em Voce!" + RESET);
                        
                        if (playerHealth <= 0) {
                            System.out.println(RED + "Voce foi derrotado por " + enemyName + "!" + RESET);
                            System.out.println(RED + "GAME OVER!" + RESET);
                            System.exit(0);
                        } else {
                            battle(enemyName, enemyHealth, enemyAttack, enemyDefense,enemyAgility, enemyExp, enemyMoney);
                        }
                    }
                }
                break;
            case 2:
                System.out.println(playerLabelIdle + "Vou me defender!🛡");
                // Lógica de defesa aqui
                playerHealth -= enemyAttack > playerDefense ? (enemyAttack - playerDefense) : 0; // Garante que o dano mínimo seja 0
                System.out.println(RED + enemyName + " atacou e causou " + (enemyAttack > playerDefense ? (enemyAttack - playerDefense) : 0) + " de dano em Voce!" + RESET);
                battle(enemyName, enemyHealth, enemyAttack, enemyDefense,enemyAgility, enemyExp, enemyMoney);
                break;
            case 3:
                System.out.println();
                System.out.println(playerLabelHappy + "Vou ver meu inventário!🎒");
                // Lógica de inventário aqui
                statusPlayer();
                confirmDialog();
                battle(enemyName, enemyHealth, enemyAttack, enemyDefense,enemyAgility, enemyExp, enemyMoney);
                break;
            case 4:
                System.out.println("---------------------- USAR COMIDA ----------------------");
                System.out.println("🍣 Comida = " + playerFoods + "\n");
                System.out.println("1. Sim " + GREEN + "✔" + RESET);
                System.out.println("2. Não ❌");
                System.out.println("----------------------------------------------------------");
                int useFoodOption = Integer.parseInt(msgInteractive("Selecione a opcao desejada: "));
                
                switch(useFoodOption) {
                    case 1:
                        useFood();
                        battle(enemyName, enemyHealth, enemyAttack, enemyDefense,enemyAgility, enemyExp, enemyMoney);
                        break;
                    case 2:
                        System.out.println(YELLOW + "Voce decidiu não usar comida." + RESET);
                        battle(enemyName, enemyHealth, enemyAttack, enemyDefense,enemyAgility, enemyExp, enemyMoney);
                        break;
                    default:
                        System.out.println(RED + "Opção inválida. Tente novamente." + RESET);
                        battle(enemyName, enemyHealth, enemyAttack, enemyDefense,enemyAgility, enemyExp, enemyMoney);
                        break;
                }
                break;
            case 5:
                System.out.println(playerLabelSurprised + "Preciso fugir!");
                // Lógica de fuga aqui
                if (roll <= chanceSkip) {
                    System.out.println(GREEN + "Voce conseguiu fugir de " + enemyName + "!" + RESET);
                } else {
                    System.out.println(RED + "Voce não conseguiu fugir!" + RESET);
                    playerHealth -= enemyAttack > playerDefense ? (enemyAttack - playerDefense) : 0; // Garante que o dano mínimo seja 0
                    System.out.println(RED + enemyName + " atacou e causou " + (enemyAttack > playerDefense ? (enemyAttack - playerDefense) : 0) + " de dano em Voce!" + RESET);
                    
                    if (playerHealth <= 0) {
                        System.out.println(RED + "Voce foi derrotado por " + enemyName + "!" + RESET);
                        System.out.println(RED + "GAME OVER!" + RESET);
                        System.exit(0);
                    } else {
                        battle(enemyName, enemyHealth, enemyAttack, enemyDefense,enemyAgility, enemyExp, enemyMoney);
                    }
                }
                break;
            default:
                System.out.println(RED + "Opção inválida. Tente novamente." + RESET);
                menuBattle();
                break;
        }
    }

    public static void forestScene(String name) {
        System.out.println("               /\\        /\\        /\\ ");
        System.out.println("              /**\\      /**\\      /**\\");
        System.out.println("             /****\\    /****\\    /****\\");
        System.out.println("            /      \\  /      \\  /      \\");
        System.out.println("           /   **   \\/   **   \\/   **   \\");
        System.out.println("          /______________________________\\");
        System.out.println("              ||        ||        ||");
        System.out.println("              ||        ||        ||");
        System.out.println();
        System.out.println("        v v v v v v v v v v v v v v v v v v v v");
        System.out.println("       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("            Voce está na floresta "+name+".");
        System.out.println();
        System.out.println("               (ouça o vento e os grilos... ♫)");
    }
    
    public static void main(String[] args) throws InterruptedException {
        start();
        pause();

        battle("Slime Verde", 15, 5, 2, 3, 20, 10);
        
        System.out.println();
        System.out.println("Cat é um gato aventureiro que vive em uma pequena vila.");
        System.out.println("Ele adora explorar lugares novos e enfrentar desafios.");
        System.out.println("Um dia, ele decide partir em uma grande aventura pela floresta.");
        System.out.println();
        
        System.out.println(playerLabelTrusting + "Estou pronto para a aventura!");
        pause();
        System.out.println(playerLabelIdle + "Estava escutando os humanos aqui de casa, falando esses dias sobre uma floresta misteriosa...");
        pause();
        System.out.println(playerLabelHappy + "Dizem que lá existem criaturas perigosas, mas também muitos tesouros escondidos!");
        pause();
        System.out.println(playerLabelIdle + "Eu preciso ir até lá e descobrir o que há de verdade nisso tudo!");
        pause();
        System.out.println();

        System.out.println("Jerry(dono da casa onde vive cat), resolve ir ao super mercado para fazer as compras da semana.");
        System.out.println("Porém, ao sair de casa, ele percebe que esqueceu a carteira.");
        System.out.println("Ao entrar em casa, acaba deixando a porta aberta. Afinal, seria apenas um instante.");
        System.out.println("Cat, que estava na janela, pensando em como poderia dar um jeito de escapar de casa, vê a oportunidade perfeita.");
        System.out.println("Ele aproveita que Jerry está distraído e sai correndo pela porta aberta.");
        pause();
        System.out.println();
        System.out.println("               (o silência da rua noturna... ☁🌑)");
        System.out.println();
        pause();
        System.out.println("Cat corre o mais rápido que pode, sem olhar para trás, quando derrepente se depara na virada da última rua com a casa de um cão muito feroz.");
        System.out.println("O cão late ferozmente, e Cat percebe que não tem mais como voltar para casa.");
        System.out.println();
        pause();

        System.out.println(orkDogLabel + "GRRRRRRRR! Quem é Voce e o que está fazendo na minha rua?");
        pause();
        System.out.println(playerLabelSurprised + "Eu... eu sou o Cat. Estou a caminho da floresta.");
        pause();
        System.out.println(playerLabelIdle + "Eu só queria passar por aqui, não quero briga.");
        pause();
        System.out.println(playerLabelLovely + "Dizem que essa floresta é cheia de mistérios fantásticos!");
        pause();
        System.out.println(orkDogLabel + "Hmph! Voce parece um gato fraco. Não vai durar nada na floresta.");
        pause();
        System.out.println(orkDogLabel + "Quando Voce entrar na floresta, irá encontrar um universo paralelo cheio de perigos.");
        pause();
        System.out.println(playerLabelSurprised + "Um universo paralelo? Sério?");
        pause();
        System.out.println(orkDogLabel + "Sim, e eu sou o guardião dessa floresta. Se quiser passar, terá que me enfrentar!");
        pause();
        System.out.println(orkDogLabel + "Somente assim, Voce provará ser digno de entrar na floresta.");
        pause();
        System.out.println(playerLabelTrusting + "Muito bem, eu aceito o desafio!");
    }
}