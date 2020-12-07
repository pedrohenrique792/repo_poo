import java.util.Scanner;
import java.util.Random;

public class Calango {
    private static Scanner scanf = new Scanner(System.in);
    int bucho; //atributos
    int maxBucho;
    int nPatas;
    int hearts;
    int heartsMax;
    int atk;
    int level;
    boolean vivo;

    //mesmo nome da classe = sombreamento de variavel
    Calango(int bucho, int maxBucho, int nPatas, int heartsMax,int atk, int level){ //parametros
        this.bucho = bucho;
        this.maxBucho = maxBucho;
        this.nPatas = nPatas;
        this.heartsMax = heartsMax;
        this.hearts = heartsMax;
        this.atk = atk;
        this.level = level;
        this.vivo = true;
    }

    void comer(int bucho){
        if(!this.vivo){
            return;
        }
        this.bucho += bucho;
        if(this.bucho < this.maxBucho){
            System.out.println("Preciso comer mais para evoluir!!");
        }
        while(this.bucho >= this.maxBucho && this.bucho>=5){
            System.out.println("Comi até ficar saciado!!!");
            System.out.println("Congratulations! Your Calango has evolved a level!!!");
            this.maxBucho += 5; 
            this.bucho -=5;
            this.level++;
            this.atk += 2;
            this.hearts +=5;
            this.heartsMax +=5;
        }
    }

    void shape(){
        if(!this.vivo){
            return;
        }
        if(this.nPatas < 2){
            System.out.println("Estou impossibilitado de meter o shape!!!");
            return;
        }
        if(this.bucho > 0){
            while(this.bucho > 0){
                this.bucho -= 2;
                System.out.println("Birl!!!");
            }
            this.atk += 2;
            this.hearts += 5;
            this.heartsMax += 5;
            this.maxBucho +=5 ;
            return;
        }
        System.out.println("Estou muito cansado e nao posso treinar ;-;");
    }

    void receberAtaque(int atk){
        if(!this.vivo){
            return;
        }
        if(nPatas > 0){
            nPatas -= 1;
            //System.out.println("Ouch! Perdi uma pata");
        }
        hearts -= atk;
        if(hearts <= 0){
            this.vivo = false;
            this.hearts = 0;
            System.out.println("Morri x-x\n\n");
        }else
            System.out.println("Sua hearts: " + hearts+"\n\n");
    }

    int atacar(){
        Random rand2 = new Random();
        if(!this.vivo){
            return 0;
        }
        if(nPatas > 0){
            int rand = rand2.nextInt(this.level*this.atk)+1;
            if(rand <= 0)
                rand = 1;
            return (int) rand;
            
        }
        else if(nPatas <= 0){
            System.out.println("Você não tem patas suficientes pra atacar!!");
            return 0;
        }
        return 0;
    }
    void easter(){
        for(int i =0; i<5000;i++){
            this.atk += 2;
            this.hearts += 5;
            this.heartsMax += 5;
            this.bucho +=5 ;
            this.maxBucho +=5 ;
            this.level ++;
        }
    }
    void regenerar(){
        if(!this.vivo){
            this.bucho = 0;
            this.maxBucho = 20;
            this.nPatas = 4;
            this.hearts = 4;
            this.heartsMax = 4;
            this.atk = 4;
            this.level = 1;
            System.out.println("O paladino não vai gostar nada disso!");
            return;
        }
        if(nPatas == 4){
            System.out.println("Perfeição maior, desconheço!!");
        }else if(hearts < heartsMax){

            int aux = heartsMax - hearts;

            if(bucho >= aux){
                hearts = heartsMax;
                bucho-=aux;
                System.out.println("Me sinto revigorado!");
                if(bucho>=5){
                    nPatas ++;
                    bucho -= 5;
                    System.out.println("Opa! Recuperei uma pata!");
                }
            }else{
                hearts+=bucho;
                bucho=0;
            }
        }
        else if (bucho >= 5){
            nPatas += 1;
            bucho -= 5;
            System.out.println("Opa! Recuperei uma pata!");
        }else{
            System.out.println("Nao tenho energia suficiente para me recuperar");
        }
    }

    public String toString() {
        return "Bucho: " + bucho + "/" + maxBucho + " Patas: " + nPatas + " heartss: " + 
        hearts+"/"+ heartsMax + " Ataque: " + atk + " Nivel: " + level;
    }
    
    public static void menu(){
        System.out.print("------------- Centro de treinamento de pokelangos -------------\n\n\n\n\n\n\n\n");
        Calango deadlango = new Calango(0,20,4,4,1,1);
        Calango ronaldinho = new Calango(999999,9999999,20,9999999,9999999,9999999);
        while(true){
            String menu_principal = "Digite o comando que você quer executar:\n"
                                    +"-1)    Lutar: Digite lutar        \n"
                                    +"-2)    Comer: Digite comer        \n"
                                    +"-3)    Meter o shape: Digite shape\n"
                                    +"-4)    Regenerar: Digite regenerar\n"
                                    +"-5)    Mostar: Digite mostrar     \n"
                                    +"-6)    Sair: Digite sair          \n\n\n>";
            System.out.print(menu_principal);
            String linha = scanf.nextLine(); 
            String[] ui = linha.split(" ");
            if(ui[0].equals("sair")){
                break;
            }else if(ui[0].equals("comer")){
                System.out.print("Digite quanto O calango encheu o bucho: ");
                deadlango.comer(scanf.nextInt());
                clearBuffer(scanf);
            }
            else if(ui[0].equals("lutar")){
                Calango.vemProX1(deadlango, ronaldinho);
            }
            else if(ui[0].equals("shape")){
                deadlango.shape();
            }
            else if(ui[0].equals("regenerar")){
                deadlango.regenerar();
            }
            else if(ui[0].equals("mostrar")){
                System.out.println(deadlango);
            }
            else{
                System.out.println("Opção inválida");
            }
        }
    }//99999

    public static void vemProX1(Calango deadlango, Calango ronaldinho){
        System.out.println("------------- X1 Criminoso de Pokelangos -------------");
        System.out.println("Deadlango eu escolho você!!!");
        System.out.println("Seu inimigo é o Ronaldinho!!! Quem será que vence essa luta??");
        //System.out.println(""); 
        String menu_luta = "Escolha uma ação:\n"
                    + "-Atacar)    Digite atacar\n"
                    + "-Defender)  Digite defender\n"
                    + "-Regenerar) Digite regenerar\n"
                    + "-Fugir)     Digite fugir\n\n>";     
        while(deadlango.vivo && ronaldinho.vivo){
            System.out.println("Dead lango |"+deadlango+"\nRonaldinho | "+ronaldinho);
            System.out.print(menu_luta);
            String linha = scanf.nextLine();
            String[] ui = linha.split(" ");
            Random rand = new Random();
            //Random rand2 = new Random();

            if(ui[0].equals("atacar")){
                if(rand.nextInt(10) >= 8){
                    int atacar = deadlango.atacar();
                    if(atacar > 0){
                        System.out.println("*Bonk*");
                        System.out.println("O Ronaldinho sofreu " + atacar + " de dano");
                        ronaldinho.receberAtaque(atacar);
                    }
                    

                    int atacar_ronaldinho = ronaldinho.atacar();

                    if(atacar_ronaldinho > 0){
                        System.out.println("Tão deixando a gente sonhar!!!");
                        System.out.println("O Ronaldinho te causou " + atacar_ronaldinho + " de dano");   
                        deadlango.receberAtaque(atacar_ronaldinho);
                    }

                }
                else{
                    if(rand.nextInt(10)>=6){
                            System.out.println("O Ronaldinho te DIBROU");
                    }
                    else{
                        int atacar = deadlango.atacar();
                        if(atacar > 0){
                            System.out.println("Tão deixando a gente sonhar!!!");
                            System.out.println("O Ronaldinho sofreu " + atacar + " de dano");
                            ronaldinho.receberAtaque(atacar);
                        }

                    }
                }               
            }
            else if(ui[0].equals("defender")){
                if(rand.nextInt(10) >= 6)
                    System.out.println("O Ronaldinho foi DIBRADO!!");
                else{
                    int atacar_ronaldinho = ronaldinho.atacar();
                    if(atacar_ronaldinho > 0){
                        System.out.println("VOCÊ FOI DIBRADO!!!!");
                        System.out.println("Você não conseguiu se defender e sofreu " + atacar_ronaldinho+ "de dano");
                        deadlango.receberAtaque(atacar_ronaldinho);
                    }
                } 
                
            }
            else if(ui[0].equals("regenerar")){
                if(rand.nextInt(10) >= 5){
                    deadlango.regenerar();
                    int atacar_ronaldinho = ronaldinho.atacar();
                    if(atacar_ronaldinho > 0){
                        System.out.println("Tão deixando a gente sonhar!!!");
                        System.out.println("O Ronaldinho te causou " + atacar_ronaldinho + "de dano");
                        deadlango.receberAtaque(atacar_ronaldinho);
                    }
                }else{
                    deadlango.regenerar();
                    System.out.println("O ronaldinho está descansando pros próximos DIBRES");
                }
            }
            else if(ui[0].equals("fugir")){
                if(rand.nextInt(10) >= 6){
                    System.out.println("Você dibrou o dibrador!!");
                }
                else{
                    int atacar_ronaldinho = ronaldinho.atacar();
                    if(atacar_ronaldinho > 0){
                        System.out.println("Tão deixando a gente sonhar!!!");
                        System.out.println("O Ronaldinho te causou " + atacar_ronaldinho + "de dano");
                        deadlango.receberAtaque(atacar_ronaldinho);
                    }
                }
            }
            else{
                System.out.println("Opção invalida!!");
            }
        }
        if(!deadlango.vivo){
            System.out.println("Perdemo!");
            System.out.println("Deadlango foi derrubado, mas já já sua super-regeneração vai o curar");
        }
        else{
            System.out.println("Ronaldinho foi de Base!!");
            System.out.println("Press F no chat;-;");
            String linha = scanf.nextLine();
            String[] ui = linha.split(" ");
            if(ui[0].equals("F")){
                deadlango.easter();
            }
        }
    }

    public static void main(String[] args) {
        
        //referencia      = criando objeto
        //     bucho,maxbucho,patas,heartss,atk,lvl
        //Calango deadlango = new Calango(0,20,4,4,4,1,1);
        Calango.menu();
        //Calango deadlango = new Calango(0,20,4,4,1,1);
        //Calango ronaldinho = new Calango(999999,9999999,20,9999999,9999999,9999999);
        //for(int i = 0; i<100; i++){
        //    int int atacar_ronaldinho = ronaldinho.atacar();
        //    int int atacar_ronaldinho = ronaldinho.atacar();
        //    if(atacar > 0){
        //        System.out.println("VOCÊ FOI DIBRADO!!!!");
         //       System.out.println("Você não conseguiu se defender e sofreu " + atacar+ " de dano");
        //        deadlango.receberAtaque(atacar);
        //    }
        //}
        scanf.close();
        
    }

    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}