package model;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Run implements Serializable{

            
    public int contador = 1,max;
    public Date dataAnterior,dataExpiracao;
    

    
    public boolean analisar(){
        if(contador > max){
            return false;
        }
        
        if(dataExpiracao.after(dataAnterior)){
            return true;
        }else{
            return false;
        }
    }

    public String getDataExpiracao() {
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(dataExpiracao);
    }   
}
