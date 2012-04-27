package model;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class Formatar {
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static SimpleDateFormat sdfH = new SimpleDateFormat("dd-MM-yyyy");
    private static DecimalFormat dec = new DecimalFormat("0.00");
    private static DecimalFormat format = new DecimalFormat("00000");
    
    
    public static String formatarData(Date data){
        return sdf.format(data);
    }

    public static String formatarData(java.util.Date data) {
        return sdf.format(data);
    }
    public static String formatarNumero(double n){
        return dec.format(n);
    }
    
    public static String formatarCasas(double n){
        return format.format(n);
    }

    public static String formatarDataHifem(java.util.Date date) {
        return sdfH.format(date);
    }

    public static String formatPlanoContas(String conta) {
        int digitos = conta.length();

        switch (digitos) {
            case 1:
                return conta;
            case 3:
                return algoritmoFormatar("#.##", conta);
            case 5:
                return algoritmoFormatar("#.##.##", conta);
            case 7:
                return algoritmoFormatar("#.##.##.##", conta);
            case 12:
                return algoritmoFormatar("#.##.##.##.#####", conta);
            default:
                return null;
        }
    }
    
    private static String algoritmoFormatar(String mascara,String conteudo){

            for(int i = 0; i < conteudo.length(); i++){
			mascara = mascara.replaceFirst("#", conteudo.substring(i, i + 1));
		}

		return mascara.replaceAll("#", "");

    }
}
