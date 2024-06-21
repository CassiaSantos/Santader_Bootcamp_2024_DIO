import java.util.Scanner;

abstract class CofreSeguro_EncapsulamentoeAbstracao {
    protected String tipo;
    protected String metodoAbertura;

    public Cofre(String tipo, String metodoAbertura) {
        this.tipo = tipo;
        this.metodoAbertura = metodoAbertura;
    }

    public void imprimirInformacoes() {
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Metodo de abertura: " + this.metodoAbertura);
    }
}

class CofreDigital extends Cofre {
    private int senha;

    public CofreDigital(int senha) {
        super("Cofre Digital", "Senha");
        this.senha = senha;
    }

    public boolean validarSenha(int confirmacaoSenha) {
        return confirmacaoSenha == this.senha;
    }

    @Override
    public void imprimirInformacoes() {
        super.imprimirInformacoes();
        //System.out.println("Senha: " + senha);
    }
}

class CofreFisico extends Cofre {
    public CofreFisico() {
        super("Cofre Fisico", "Chave");
    }
}

public class Desafio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //System.out.print("Informe o tipo de cofre (digital/físico): ");
        String tipoCofre = scanner.nextLine();

        if (tipoCofre.equalsIgnoreCase("digital")) {
            //System.out.print("Informe a senha do cofre digital: ");
            int senha = scanner.nextInt();
            //System.out.print("Confirme a senha do cofre digital: ");
            int confirmacaoSenha = scanner.nextInt();

            CofreDigital cofreDigital = new CofreDigital(senha);
            if (senha == confirmacaoSenha) {
                //CofreDigital cofreDigital = new CofreDigital(senha);
                cofreDigital.imprimirInformacoes();
                System.out.println("Cofre aberto!");
                //
            } else {
cofreDigital.imprimirInformacoes();
                System.out.println("Senha incorreta!");
            }
        } else if (tipoCofre.equalsIgnoreCase("fisico")) {
            CofreFisico cofreFisico = new CofreFisico();
            cofreFisico.imprimirInformacoes();
        } else {
            System.out.println("Tipo de cofre inválido.");
        }

        // Fechar o scanner para evitar vazamentos de recursos
        scanner.close();
    }
}