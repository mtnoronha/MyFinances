package model;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Mensagem {
 
    public static void mensagemErroClassNotFound(Component e){
                JOptionPane.showMessageDialog(e, "Erro: ClassNotFound\n", "Erro referente ao banco de dados", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void mensagemErroSQLException(Component e){
                JOptionPane.showMessageDialog(e, "Erro: SQL\n", "Erro referente ao banco de dados", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void mensagemSucesso(Component e,String msg) {
        JOptionPane.showMessageDialog(e, msg, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void mensagemErro(Component e,String msg) {
        JOptionPane.showMessageDialog(e, msg, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void mensagemAvisa(Component e,String msg){
        JOptionPane.showMessageDialog(e, msg, "Aviso", JOptionPane.WARNING_MESSAGE);
    }
    
    public static int mensagemYesNo(Component e,String msg){
        int resp;
        resp = JOptionPane.showConfirmDialog(e, msg, "Confirmação", JOptionPane.YES_NO_OPTION);        
        return resp;
        
    }
    
      public static String mensagemInput(String msg, String titulo, Component e) {
        Object resp = null;

        resp = JOptionPane.showInputDialog(e, msg, titulo, JOptionPane.OK_OPTION);

        return resp.toString();
    }
    
}
