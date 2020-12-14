public class Tamagoshi{
    private int energiaMax, fomeMax, limpezaMax;
    private int energia, fome, limpeza;
    private int diamantes;
    private int idade;
    private boolean vivo;

    public Tamagoshi(int energiaMax, int fomeMax, int limpezaMax){
        this.energiaMax = energiaMax;
        this.energia = energiaMax;

        this.fomeMax = fomeMax;
        this.fome=fomeMax;

        this.limpezaMax = limpezaMax;
        this.limpeza=limpezaMax;

        this.diamantes=0;
        this.idade = 1;
        this.vivo = true;
    }

    private void setEnergia(int energia){
        if(!estaVivo()){
            return;
        }
        this.energia = energia;
        if(energia > this.energiaMax)
            this.energia = this.energiaMax;
        if(energia<=0){
            System.out.println("Seu bichinho foi pro céu ver se tem pão");
            this.vivo = false;
        }
    }

    private void setFome(int fome){
        if(!estaVivo()){
            return;
        }
        this.fome = fome;
        if(fome > this.fomeMax)
            this.fome = this.fomeMax;
        if(fome <= 0){
            System.out.println("Seu bichinho foi pro céu ver se tem pão");
            this.vivo = false;
        }
    } 

    private void setLimpeza(int limpeza){
        if(!estaVivo()){
            return;
        }
        this.limpeza = limpeza;
        if(limpeza > this.limpeza)
            this.limpeza = this.limpezaMax;
        if(limpeza <= 0){
            System.out.println("Seu bichinho foi pro céu ver se tem pão");
            this.vivo = false;
        }
    } 

    public int getEnergia() {
        return this.energia;
    }
    public int getFome() {
        return this.fome;
    }
    public int getEnergiaMax() {
        return this.energiaMax;
    }

    public int getDiamantes() {
        return this.diamantes;
    }
    public int getLimpeza() {
        return this.limpeza;
    }
    public int getFomeMax() {
        return this.fomeMax;
    }
    public int getLimpezaMax() {
        return this.limpezaMax;
    }
    public int getIdade() {
        return this.idade;
    }
    public boolean estaVivo(){
        if(!vivo){
            System.out.println("Seu tamagoshi foi ver se no céu tem pão!!");
            return false;
        }
        return true;
    }

    // O comando "$play" altera em -2 energia, -1 saciedade, -3 limpeza, +1 diamante, +1 idade.
    public void brincar(){
        if(!estaVivo()){
            return;
        }
        
        this.setEnergia(getEnergia()-2);
        this.setFome(getFome()-1);
        this.setLimpeza(getLimpeza()-3);
        this.diamantes++;
        this.idade++;
    }
    // O Comando "$eat" altera em -1 a energia, +4 a saciedade, -2 a limpeza, +0 diamantes,  +1 a idade.
    public void comer(){
        if(!estaVivo()){
            return;
        }
        this.setEnergia(getEnergia()-1);
        this.setFome(getFome()+4);
        this.setLimpeza(getLimpeza()-2);
        this.idade++;
    }
    // O Comando "$sleep" aumenta energia até o máximo e idade aumenta do número de turnos que o pet dormiu. 
    //Os outros atributos permanecem inalterados.
    //Para dormir, precisa ter perdido pelo menos 5 unidades de energia
    public void neneca(){
        if(!estaVivo()){
            return;
        }
        
        if(this.energiaMax - this.energia < 5)
            return;
        this.setEnergia(getEnergiaMax());
        this.idade++;
    }
    //O comando "$clean" alteram em -3 energia, -1 na saciedade, MAX na limpeza, +0 diamantes, +2 na idade.
    public void banho(){
        if(!estaVivo()){
            return;
        }
        this.setEnergia(getEnergia()-3);
        this.setFome(getFome()-1);
        this.setLimpeza(getLimpezaMax());
        this.idade += 2;
    }
    
    public String toString() {
        //E:20/20, S:10/10, L:15/15, D:0, I:0
        String saida = "| Energia:" + this.energia + "/" + this.energiaMax  
                    + " | Saciedade:" + this.fome + "/" + this.fomeMax  
                    + " | Limpeza:" + this.limpeza + "/" + this.limpezaMax 
                    + " | Diamantes:" + this.diamantes
                    + " | Idade:" + this.idade + " |";
        
        return saida;
    }
}

