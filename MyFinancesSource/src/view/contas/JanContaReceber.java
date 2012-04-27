
package view.contas;

import Persistencia.contas.ContasService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import model.contas.ContaReceber;
import model.Formatar;

import model.Mensagem;
import model.contas.CellRenderPagarReceber;
import model.contas.TableModelContasReceber;

public class JanContaReceber extends javax.swing.JFrame {

    public static TableModelContasReceber modelo;
    private static JanContaReceber jan;
    private  CellRenderPagarReceber render;

        
    private JanContaReceber() {
        super("..:: Contas a Receber ::..");
        initComponents();
        setLocationRelativeTo(null);
        
        modelo = new TableModelContasReceber();
        tabelaContasReceber.setModel(modelo);
        

        try {
            ArrayList<ContaReceber> lista = ContasService.preencherContasReceber();
            modelo.addListaDeContaReceber(lista);
            modelo.filtrar("");
        } catch (ClassNotFoundException ex) {
            Mensagem.mensagemErroClassNotFound(this);
        } catch (SQLException ex) {
            Mensagem.mensagemErroSQLException(this);
            ex.printStackTrace();
        }
        
        campoDataFinal.setDate(new Date());
        campoDataInicial.setDate(new Date());
        
   
        render = new CellRenderPagarReceber();
        renderizar();
        
    }
    
    public void renderizar(){
        for(int i=0;i<tabelaContasReceber.getColumnCount();i++){
            tabelaContasReceber.getColumnModel().getColumn(i).setCellRenderer(render);
        }
    }

    public static void setarValoresReceberRecebido(){
        labelAReceber.setText(Formatar.formatarNumero(modelo.somar(TableModelContasReceber.A_RECEBER)));
        labelRecebido.setText(Formatar.formatarNumero(modelo.somar(TableModelContasReceber.RECEBIDO)));
    }
    
    public static JanContaReceber getInstance(){
        if(jan == null){
            jan = new JanContaReceber();
        }

        return jan;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        g1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        bNovo = new javax.swing.JButton();
        bFechar = new javax.swing.JButton();
        bAlterar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaContasReceber = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        campoPesquisa = new javax.swing.JTextField();
        opCliente = new javax.swing.JRadioButton();
        opDescricao = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoDataInicial = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        campoDataFinal = new com.toedter.calendar.JDateChooser();
        bFiltrarData = new javax.swing.JButton();
        labelRecebido = new javax.swing.JLabel();
        labelAReceber = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/novo.png"))); // NOI18N
        bNovo.setText("Novo");
        bNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovoActionPerformed(evt);
            }
        });

        bFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/fechar.png"))); // NOI18N
        bFechar.setText("Fechar");
        bFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFecharActionPerformed(evt);
            }
        });

        bAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/editar.png"))); // NOI18N
        bAlterar.setText("Alterar");
        bAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bNovo)
                .addGap(18, 18, 18)
                .addComponent(bAlterar)
                .addGap(18, 18, 18)
                .addComponent(bFechar)
                .addContainerGap(332, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bNovo)
                    .addComponent(bAlterar)
                    .addComponent(bFechar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelaContasReceber.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaContasReceber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaContasReceberMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaContasReceber);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        campoPesquisa.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                campoPesquisaCaretUpdate(evt);
            }
        });

        g1.add(opCliente);
        opCliente.setSelected(true);
        opCliente.setText("Parceiro");

        g1.add(opDescricao);
        opDescricao.setText("Observação");

        jLabel1.setText("Filtrar");

        jLabel4.setText("Filtrar por Data");

        jLabel6.setText("De");

        jLabel5.setText("até");

        bFiltrarData.setText("Filtrar");
        bFiltrarData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFiltrarDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(campoPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(opCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(opDescricao))
                    .addComponent(bFiltrarData))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opCliente)
                    .addComponent(opDescricao)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(campoDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(campoDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4)
                    .addComponent(bFiltrarData))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelRecebido.setFont(new java.awt.Font("sansserif", 1, 12));
        labelRecebido.setText("jLabel5");

        labelAReceber.setFont(new java.awt.Font("sansserif", 1, 12));
        labelAReceber.setText("jLabel4");

        jLabel3.setText("Recebido R$");

        jLabel2.setText("A receber R$");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelRecebido)
                            .addComponent(labelAReceber)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelAReceber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelRecebido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoActionPerformed
        // TODO add your handling code here:
        JanCadContaReceber jan2 = new JanCadContaReceber();
        jan2.setVisible(true);
        this.setEnabled(false);
}//GEN-LAST:event_bNovoActionPerformed

    private void bFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_bFecharActionPerformed

    private void tabelaContasReceberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaContasReceberMouseClicked
        if (evt.getClickCount() == 2) {
            JanCadContaReceber jan2 = new JanCadContaReceber(modelo.getContaReceber(tabelaContasReceber.getSelectedRow()));
            jan2.setVisible(true);
            this.setEnabled(false);
        }
}//GEN-LAST:event_tabelaContasReceberMouseClicked

    private void campoPesquisaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_campoPesquisaCaretUpdate
        // TODO add your handling code here:
        if(opCliente.isSelected()){
            modelo.filtrar(campoPesquisa.getText());
        }else{
            modelo.filtrarObs(campoPesquisa.getText());
        }
    }//GEN-LAST:event_campoPesquisaCaretUpdate

    private void bAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAlterarActionPerformed
        // TODO add your handling code here:
        try {
            JanCadContaReceber jan2 = new JanCadContaReceber(modelo.getContaReceber(tabelaContasReceber.getSelectedRow()));
            jan2.setVisible(true);
            this.setEnabled(false);
        } catch (ArrayIndexOutOfBoundsException e) {
            Mensagem.mensagemErro(jan, "Selecione a Conta");
        }
}//GEN-LAST:event_bAlterarActionPerformed

    private void bFiltrarDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFiltrarDataActionPerformed
        // TODO add your handling code here:
        if(verificarDadosFiltrarData()){
            modelo.filtrarData(campoDataInicial.getDate(), campoDataFinal.getDate());
        }
}//GEN-LAST:event_bFiltrarDataActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code
    }//GEN-LAST:event_formFocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
                campoPesquisa.setText("");
        modelo.filtrar("");       
    }//GEN-LAST:event_formWindowGainedFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAlterar;
    private javax.swing.JButton bFechar;
    private javax.swing.JButton bFiltrarData;
    private javax.swing.JButton bNovo;
    private com.toedter.calendar.JDateChooser campoDataFinal;
    private com.toedter.calendar.JDateChooser campoDataInicial;
    private javax.swing.JTextField campoPesquisa;
    private javax.swing.ButtonGroup g1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JLabel labelAReceber;
    private static javax.swing.JLabel labelRecebido;
    private javax.swing.JRadioButton opCliente;
    private javax.swing.JRadioButton opDescricao;
    private static javax.swing.JTable tabelaContasReceber;
    // End of variables declaration//GEN-END:variables

    public void setarPermissoes(boolean alterar, boolean deletar, boolean inserir) {                
        if(!inserir){
            bNovo.setEnabled(false);
        }
        
        if (!alterar) {
            bAlterar.setEnabled(false);
            tabelaContasReceber.setEnabled(false);           
        }
        
    }
    
    private boolean verificarDadosFiltrarData() {
          
        try {
            java.sql.Date data = new java.sql.Date(campoDataInicial.getDate().getTime());

        } catch (Exception e) {
            Mensagem.mensagemErro(this, "Escolha a data inicial");
            campoDataInicial.requestFocus();
            return false;
        }

        try {
            java.sql.Date data = new java.sql.Date(campoDataFinal.getDate().getTime());
        } catch (Exception e) {
            Mensagem.mensagemErro(this, "Escolha a data final");
            campoDataFinal.requestFocus();
            return false;
        }
       
        return true;
    }
}
