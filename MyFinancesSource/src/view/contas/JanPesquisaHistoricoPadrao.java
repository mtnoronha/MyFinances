
package view.contas;

import model.contas.TableModelHistoricoPadrao;
import relatorio.contas.JanRelContas;
import relatorio.contas.JanRelPlanoContas;

public class JanPesquisaHistoricoPadrao extends javax.swing.JFrame {
    
JanCadContaPagar janPagar;
JanCadContaReceber janReceber;
JanRelPlanoContas janRelPlanoContas;
TableModelHistoricoPadrao modelo;
    private  JanLancamento janLan;
    
    /** Creates new form JanPesquisaHistoricoPadrao */
    public JanPesquisaHistoricoPadrao(JanRelPlanoContas jan) {
        super("..:: Pesquisar Histórico Padrão ::..");
        initComponents();
        setLocationRelativeTo(null);
        this.janRelPlanoContas = jan;
        
        modelo = JanHistoricoPadrao.getInstance().modelo;
        tabelaHist.setModel(modelo);
    }

    public JanPesquisaHistoricoPadrao(JanCadContaPagar jan) {
        super("..:: Pesquisar Histórico Padrão ::..");
        initComponents();
        setLocationRelativeTo(null);
        this.janPagar = jan;
        
        modelo = JanHistoricoPadrao.getInstance().modelo;
        tabelaHist.setModel(modelo);
    }
    
     public JanPesquisaHistoricoPadrao(JanCadContaReceber jan) {
        super("..:: Pesquisar Histórico Padrão ::..");
        initComponents();
        setLocationRelativeTo(null);
        this.janReceber = jan;
         modelo = JanHistoricoPadrao.getInstance().modelo;
         tabelaHist.setModel(modelo);
    }
     
          public JanPesquisaHistoricoPadrao(JanLancamento jan) {
        super("..:: Pesquisar Histórico Padrão ::..");
        initComponents();
        setLocationRelativeTo(null);
        this.janLan = jan;
         modelo = JanHistoricoPadrao.getInstance().modelo;
         tabelaHist.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPesquisarPor = new javax.swing.JPanel();
        campoPesqPor = new javax.swing.JTextField();
        painelTabelaPesquisa = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaHist = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        painelPesquisarPor.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar Histórico Padrão"));

        campoPesqPor.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                campoPesqPorCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout painelPesquisarPorLayout = new javax.swing.GroupLayout(painelPesquisarPor);
        painelPesquisarPor.setLayout(painelPesquisarPorLayout);
        painelPesquisarPorLayout.setHorizontalGroup(
            painelPesquisarPorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPesquisarPorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(campoPesqPor, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelPesquisarPorLayout.setVerticalGroup(
            painelPesquisarPorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPesquisarPorLayout.createSequentialGroup()
                .addComponent(campoPesqPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelTabelaPesquisa.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabelaHist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelaHist.setToolTipText("Clique no Endereço para escolhê-lo");
        tabelaHist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaHistMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaHist);

        javax.swing.GroupLayout painelTabelaPesquisaLayout = new javax.swing.GroupLayout(painelTabelaPesquisa);
        painelTabelaPesquisa.setLayout(painelTabelaPesquisaLayout);
        painelTabelaPesquisaLayout.setHorizontalGroup(
            painelTabelaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTabelaPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelTabelaPesquisaLayout.setVerticalGroup(
            painelTabelaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTabelaPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelPesquisarPor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelTabelaPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelPesquisarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(painelTabelaPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoPesqPorCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_campoPesqPorCaretUpdate
        // TODO add your handling code here:

            modelo.filtrar(campoPesqPor.getText());
            
        
}//GEN-LAST:event_campoPesqPorCaretUpdate

    private void tabelaHistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaHistMouseClicked
        // TODO add your handling code here:
        if(janPagar != null){
         janPagar.arrumarHistPadrao(modelo.getHistoricoPadrao(tabelaHist.getSelectedRow()));
        janPagar.requestFocus();
        janPagar.setEnabled(true);
        this.dispose();
        }else if(janReceber != null){
        janReceber.arrumarHistPadrao(modelo.getHistoricoPadrao(tabelaHist.getSelectedRow()));
        janReceber.requestFocus();
        janReceber.setEnabled(true);
            this.dispose();
        } else if (janLan != null) {
            janLan.arrumarHistPadrao(modelo.getHistoricoPadrao(tabelaHist.getSelectedRow()));
            janLan.requestFocus();
            janLan.setEnabled(true);
            this.dispose();
        } else if (janRelPlanoContas != null) {
            janRelPlanoContas.arrumarHistPadrao(modelo.getHistoricoPadrao(tabelaHist.getSelectedRow()));
            janRelPlanoContas.requestFocus();
            janRelPlanoContas.setEnabled(true);
            this.dispose();
        }
}//GEN-LAST:event_tabelaHistMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (janPagar != null) {
            janPagar.requestFocus();
            janPagar.setEnabled(true);
            this.dispose();
        } else if (janReceber != null) {
            janReceber.requestFocus();
            janReceber.setEnabled(true);
            this.dispose();
        } else if (janLan != null) {
            janLan.requestFocus();
            janLan.setEnabled(true);
            this.dispose();
        } else if (janRelPlanoContas != null) {
            janRelPlanoContas.requestFocus();
            janRelPlanoContas.setEnabled(true);
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoPesqPor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelPesquisarPor;
    private javax.swing.JPanel painelTabelaPesquisa;
    private javax.swing.JTable tabelaHist;
    // End of variables declaration//GEN-END:variables
}
