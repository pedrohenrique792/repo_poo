import java.util.Scanner;

public class Tamagoshimain {
    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        Tamagoshi tamagoshi = new Tamagoshi(69,69,69);
        while(true){
            String menu_principal = "Digite o comando que você quer executar:\n"
                                    +"-1)    Brincar: Digite brincar        \n"
                                    +"-2)    Comer: Digite comer            \n"
                                    +"-3)    Tomar banho: Digite banho       \n"
                                    +"-4)    Dormir: Digite dormir          \n"
                                    +"-5)    Mostar: Digite mostrar         \n"
                                    +"-6)    Sair: Digite sair          \n\n\n>";
            System.out.print(menu_principal);
            String linha = scanf.nextLine(); 
            String[] ui = linha.split(" ");
            if(ui[0].equals("sair")){
                break;
            }else if(ui[0].equals("brincar")){
                tamagoshi.brincar();
            }else if(ui[0].equals("comer")){
                tamagoshi.comer();
            }else if(ui[0].equals("banho")){
                tamagoshi.banho();
            }else if(ui[0].equals("dormir")){
                tamagoshi.neneca();
            }else if(ui[0].equals("mostrar")){
                System.out.println(tamagoshi);
            }else
                System.out.println("Opção inválida");
        }

        scanf.close();
    }
}
