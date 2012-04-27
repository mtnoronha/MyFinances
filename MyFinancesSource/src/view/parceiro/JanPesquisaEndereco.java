
package view.parceiro;

import Persistencia.parceiro.ParceirosService;
import java.sql.SQLException;
import model.Mensagem;
import model.parceiro.TableModelEnderecos;

public class JanPesquisaEndereco extends javax.swing.JFrame {

    TableModelEnderecos modelo;
    JanCadCompromisso janComp;
    

    public JanPesquisaEndereco(JanCadCompromisso jan) {
        super("..:: Pesquisar Endereço ::..");
        this.janComp = jan;
        initComponents();
        setLocationRelativeTo(null);
 
        try {
            //pegar todos os endereços
            modelo = new TableModelEnderecos(ParceirosService.buscarEnderecoAll());
            tabelaEnd.setModel(modelo);
        } catch (ClassNotFoundException ex) {
            Mensagem.mensagemErroClassNotFound(jan);
        } catch (SQLException ex) {
            Mensagem.mensagemErroSQLException(jan);
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPesquisarPor = new javax.swing.JPanel();
        rotPesquisarPor = new javax.swing.JLabel();
        campoPesq = new javax.swing.JComboBox();
        campoPesqPor = new javax.swing.JTextField();
        painelTabelaPesquisa = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEnd = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        painelPesquisarPor.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar Endereço"));

        rotPesquisarPor.setText("Pesquisar Por:");

        campoPesq.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome" }));

        campoPesqPor.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                campoPesqPorCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout painelPesquisarPorLayout = new javax.swing.GroupLayout(painelPesquisarPor);
        painelPesquisarPor.setLayout(painelPesquisarPorLayout);
        painelPesquisarPorLayout.setHorizontalGroup(
            painelPesquisarPorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPesquisarPorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rotPesquisarPor)
                .addGap(18, 18, 18)
                .addComponent(campoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(campoPesqPor, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelPesquisarPorLayout.setVerticalGroup(
            painelPesquisarPorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPesquisarPorLayout.createSequentialGroup()
                .addGroup(painelPesquisarPorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotPesquisarPor)
                    .addComponent(campoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPesqPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelTabelaPesquisa.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabelaEnd.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaEnd.setToolTipText("Clique no Endereço para escolhê-lo");
        tabelaEnd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEndMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaEnd);

        javax.swing.GroupLayout painelTabelaPesquisaLayout = new javax.swing.GroupLayout(painelTabelaPesquisa);
        painelTabelaPesquisa.setLayout(painelTabelaPesquisaLayout);
        painelTabelaPesquisaLayout.setHorizontalGroup(
            painelTabelaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTabelaPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelTabelaPesquisaLayout.setVerticalGroup(
            painelTabelaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTabelaPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
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
        if(campoPesq.getSelectedItem().equals("Nome")){
            modelo.filtrar(campoPesqPor.getText());
        }    
        
    }//GEN-LAST:event_campoPesqPorCaretUpdate

    private void tabelaEndMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEndMouseClicked
        // TODO add your handling code here:
            janComp.arrumarEnd(modelo.getEndereco(tabelaEnd.getSelectedRow()));
            janComp.requestFocus();
            janComp.setEnabled(true);
            this.dispose();
}//GEN-LAST:event_tabelaEndMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
            janComp.requestFocus();
            janComp.setEnabled(true);
        
            
    }//GEN-LAST:event_formWindowClosing

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox campoPesq;
    private javax.swing.JTextField campoPesqPor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelPesquisarPor;
    private javax.swing.JPanel painelTabelaPesquisa;
    private javax.swing.JLabel rotPesquisarPor;
    private javax.swing.JTable tabelaEnd;
    // End of variables declaration//GEN-END:variables
}
