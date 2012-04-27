/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Sv {
        public static File arq = new File("run.bin");
    public static ObjectOutputStream writer;
    public static ObjectInputStream reader;
    
    
    public static void salvar(Run r) {
        try {

            writer = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream(arq)));
            writer.writeObject(r);

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
            Mensagem.mensagemErro(null, "Erro crítico código 1. Entrar em contato com o administrador do sistema.");
        }
    }
    
        //idem AKA desSerializar
    public static Run abrir() throws Exception {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            reader = new ObjectInputStream(new GZIPInputStream(new FileInputStream(arq)));
            Run este;
            este = (Run) reader.readObject();


            
            if(!sdf.format(este.dataAnterior).equals(sdf.format(new Date()))){
                este.contador++;
            }
            este.dataAnterior = new Date();  
            reader.close();
            return este;
    }
}
