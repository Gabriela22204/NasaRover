public class Rover {
    public int x, y;
    public App.direcoes direcao;

    public Rover(int x, int y, App.direcoes direcao){
        this.x = x;
        this.y = y;
        this.direcao = direcao;
    }
    
    public void move(int limitex, int limitey){
        if(this.direcao == App.direcoes.NORTE || this.direcao == App.direcoes.SUL){
            if(this.direcao == App.direcoes.NORTE){
                if(this.y == limitey){
                    System.out.println("O rover nao pode mais andar para o NORTE! Ja esta no limite!");
                }
                else{
                    this.y++; 
                }
            }
            else{
                if (this.y == 0){
                    System.out.println("O rover nao pode andar para O SUL! Ja esta no limite!");
                }
                else{
                    this.y--;
                }
            }
        }
        if(this.direcao == App.direcoes.LESTE || this.direcao == App.direcoes.OESTE){
            if(this.direcao == App.direcoes.LESTE){
                if(this.x == limitex){
                    System.out.println("O rover nao pode mais andar para o LESTE! Ja esta no limite!");
                }
                else{
                    this.x++; 
                }
            }
            else{
                if(this.x == 0){
                    System.out.println("O rover nao pode andar para O OESTE! Ja esta no limite!");
                }
                else{
                    this.x--;
                }
            }
        }
    }

    public void rotaciona(char virar){ 
        int direcaoAtual = this.direcao.ordinal();
        if(virar == 'E'){ 
            //Como é sentido anti-horário, pode ir para menos de 0. Caso ocorra, fazer loop para o valor máximo.
            if(direcaoAtual == 0){
                this.direcao = App.direcoes.values()[3];
            }
            else{
                this.direcao = App.direcoes.values()[(direcaoAtual - 1) % 4];
            }
        }
        if(virar == 'D'){
            //Cálculo do valor ordenal de direções (1= norte, 2= leste, 3= sul, 4= oeste)
            this.direcao = App.direcoes.values()[(direcaoAtual + 1) % 4];
        }
    }

    public void decifraComando(char comando, int x, int y){
        if (comando == 'M'){
            this.move(x, y);
        }
        if (comando == 'E' || comando == 'D'){
            this.rotaciona(comando);
        }
    }
}
