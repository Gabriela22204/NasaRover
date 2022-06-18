import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 

public class InputReader{
    String path = "Input.txt";  
    File f;
    Scanner s;

    public InputReader(){
        this.f = new File(path);
        try{
        	this.s = new Scanner(this.f);
        }
        catch (FileNotFoundException e){
            System.out.println("Erro ao tentar encontrar o arquivo:");
            e.printStackTrace();
        }
    }

    public Rover RetornaRover(){
        int x = this.s.nextInt();
        int y = this.s.nextInt();
        App.direcoes direcao = RetornaDirecao();
        s.nextLine();
        s.nextLine(); //Feito por limitações de leitura de arquivo;
        Rover rover = new Rover(x, y, direcao);
        return rover;
    }

    public App.direcoes RetornaDirecao(){
        switch(this.s.next()){
            case "N": 
                return App.direcoes.NORTE;
            case "S":
                return App.direcoes.SUL;
            case "O": 
                return App.direcoes.OESTE;
            case "L":
                return App.direcoes.LESTE;
        }
        throw new IllegalArgumentException("Direcao nao valida");
    }

    public char[] retornaComandos(){
        String str = s.nextLine();
        char[] ch = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
        }
        //por conta da linha vazia
        if(s.hasNextLine()){
            s.nextLine();
        }
        return ch;
    }

    public boolean temLinha(){
        return s.hasNextLine();
    }

    public Plato retornaPlato(){
        int x = s.nextInt();
        int y = s.nextInt();
        Plato plato = new Plato(x, y);
        s.nextLine();
        s.nextLine(); //por conta de linhas novas no input.txt
        return plato;
    }
}