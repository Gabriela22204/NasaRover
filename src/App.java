public class App {
    enum direcoes{
        NORTE,
        LESTE,
        SUL,
        OESTE
    };    

    public static void main(String[] args) throws Exception {
        InputReader input = new InputReader();
        Plato plato = input.retornaPlato();
        while(input.temLinha()){
            Rover rover = input.RetornaRover();
            System.out.println("POSICAO INICIAL: " + rover.x + " , " + rover.y + " , " + rover.direcao);
            char[] comandos = input.retornaComandos();
            for (int i = 0; i < comandos.length; i++){
                rover.decifraComando(comandos[i], plato.limiteX, plato.limiteY);
            }
            System.out.println("POSICAO FINAL: " + rover.x + " , " + rover.y + " , " + rover.direcao);
        }
    }
}
