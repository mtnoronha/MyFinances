package relatorio;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JLabel;
import relatorio.contas.RelContas;

public class GerarRelatorio implements Runnable{

    private String rel;
    private int parametro;
    private Date data1;
    private Date data2;

    public GerarRelatorio(String rel, Date data1, Date data2) {
        this.rel = rel;
        this.data1 = data1;
        this.data2 = data2;
    }
    
        public GerarRelatorio(String rel, int parametro,Date data1, Date data2) {
        this.rel = rel;
        this.parametro = parametro;
        this.data1 = data1;
        this.data2 = data2;
    }

       
    public GerarRelatorio(String rel, int parametro){
        this.rel = rel;
        this.parametro = parametro;
    }
    
    @Override
    public void run() {
        
        JDialog j = new JDialog();
        j.setLayout(new GridLayout(4, 1));
        j.add(new JLabel(" "));
        JLabel pf = new JLabel(" Por favor aguarde. ");
        pf.setFont(new Font("Dialog", Font.PLAIN, 14));
        j.add(pf);
        JLabel os = new JLabel(" O seu relatório está sendo gerado. ");
        os.setFont(new Font("Dialog", Font.PLAIN, 14)); 
        j.add(os);
        j.add(new JLabel(" "));
        j.setLocationRelativeTo(null);
        j.setTitle("..:: Gerando relatório ::..");
        j.pack();
        j.setVisible(true);
        
        
        
        if(rel.toLowerCase().equals("balancopatrimonial")){
            new RelContas().abrirBalancoPatrimonial(data1,data2);
        }else if(rel.toLowerCase().equals("dre")){
            new RelContas().abrirDRE(data1,data2);
        }else if(rel.toLowerCase().equals("lancamento")){
            new RelContas().abrirLancamento();
        }else if(rel.toLowerCase().equals("relacaopagar")){
            new RelContas().abrirContasPagar();
        }else if(rel.toLowerCase().equals("relacaoreceber")){
            new RelContas().abrirContasReceber();
        }else if(rel.toLowerCase().equals("receberatraso")){
            new RelContas().abrirContasReceberAtraso();
        }else if(rel.toLowerCase().equals("pagaratraso")){
            new RelContas().abrirContasPagarAtraso();
        }else if(rel.toLowerCase().equals("historicopadrao")){
            new RelContas().abrirHistoricoLancamento(parametro,data1,data2);
        }
        
        j.dispose();
    }
    
}
