public class FormatadorDeCEP {
    public static void main(String[] args) {
        try {
            String cepFormatado = formatarCep("68022160");
            System.out.println(cepFormatado);
        } catch (CepInvalidoException e) {
            e.printStackTrace();
        }

    }

    static String formatarCep(String cep) throws CepInvalidoException {
        if(cep.length() != 8)
            throw new CepInvalidoException();
        
            //simulando um cep formatado
            return "68.022-160";
    }
}