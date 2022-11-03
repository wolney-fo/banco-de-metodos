package validarCPF;


public class testarCPF {

    public static boolean testaCPF(String cpf){
        double soma = 0;
        double resto;

        cpf = retiraCaracteresInvalidos(cpf);

        if (cpf.length() != 11){
            return false;
        }

        if (allCharactersSame(cpf)) {
            return false;
        }

        for (int i=1; i<=9; i++) {
            soma += Integer.parseInt(Character.toString(cpf.charAt(i-1))) * (11 - i);
        }
        
        resto = (soma * 10) % 11;
        if ((resto == 10) || (resto == 11)) {
            resto = 0;
        }

        if (resto != Integer.parseInt(Character.toString(cpf.charAt(9)))) {
            return false;
        }

        soma = 0;

        for (int i=1; i<=10; i++) {
            soma += Integer.parseInt(Character.toString(cpf.charAt(i-1))) * (12 - i);
        }

        resto = (soma * 10) % 11;
        if ((resto == 10) || (resto == 11)) {
            resto = 0;
        }

        if (resto != Integer.parseInt(Character.toString(cpf.charAt(10)))) {
            return false;
        }

        return true;
    }


    public static String retiraCaracteresInvalidos(String s){
        s = s.replace(".", "");
        s = s.replace("-", "");
        s = s.replace(" ", "");
        return s;
    }


    static boolean allCharactersSame(String s){
        for (int i = 1; i < s.length(); i++)
            if (s.charAt(i) != s.charAt(0))
                return false;
        return true;
    }
}
