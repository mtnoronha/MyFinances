package view.contas;

import Persistencia.contas.ContasService;
import java.sql.SQLException;
import java.util.ArrayList;
import model.contas.ContaPagar;
import model.Formatar;
import model.Mensagem;
import model.contas.TableModelContasPagar;
import java.util.Date;
import model.contas.CellRenderPagarReceber;


public class JanContaPagar extends javax.swing.JFrame {

    public static TableModelContasPagar modelo;
    private static JanContaPagar jan;
    private CellRenderPagarReceber render;

    private JanContaPagar() {
        super("..:: Contas a pagar ::..");
        initComponents();
        setLocationRelativeTo(null);

        modelo = new TableModelContasPagar();
        tabelaContasPagar.setModel(modelo);


        try {
            ArrayList<ContaPagar> lista = ContasService.preencherContasPagar();
            modelo.addListaDeContaPagar(lista);
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
        for(int i=0;i<tabelaContasPagar.getColumnCount();i++){
            tabelaContasPagar.getColumnModel().getColumn(i).setCellRenderer(render);
        }
    }
            

    public static void setarValoresPagarPago(){
        labelAPagar.setText(Formatar.formatarNumero(modelo.somar(TableModelContasPagar.A_PAGAR)));
        labelPago.setText(Formatar.formatarNumero(modelo.somar(TableModelContasPagar.PAGO)));
    }
    
    public static JanContaPagar getInstance() {
        if (jan == null) {
            jan = new JanContaPagar();
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
        tabelaContasPagar = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        campoPesquisa = new javax.swing.JTextField();
        opCliente = new javax.swing.JRadioButton();
        opDescricao = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoDataInicial = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        campoDataFinal = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        bFiltrarData = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelAPagar = new javax.swing.JLabel();
        labelPago = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
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

        tabelaContasPagar.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaContasPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaContasPagarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaContasPagar);

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

        jLabel5.setText("até");

        jLabel6.setText("De");

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
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
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
                    .addComponent(jLabel1)
                    .addComponent(campoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opCliente)
                    .addComponent(opDescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel4))
                            .addComponent(campoDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(campoDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(bFiltrarData))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("A pagar R$");

        jLabel3.setText("Pago R$");

        labelAPagar.setFont(new java.awt.Font("sansserif", 1, 12));
        labelAPagar.setText("jLabel4");

        labelPago.setFont(new java.awt.Font("sansserif", 1, 12));
        labelPago.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPago)
                            .addComponent(labelAPagar)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelAPagar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelPago))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoActionPerformed
        // TODO add your handling code here:
        JanCadContaPagar jan2 = new JanCadContaPagar();
        jan2.setVisible(true);
        this.setEnabled(false);
}//GEN-LAST:event_bNovoActionPerformed

    private void bFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_bFecharActionPerformed

    private void tabelaContasPagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaContasPagarMouseClicked

        if (evt.getClickCount() == 2) {
            JanCadContaPagar jan2 = new JanCadContaPagar(modelo.getContaPagar(tabelaContasPagar.getSelectedRow()));
            jan2.setVisible(true);
            this.setEnabled(false);
        }

}//GEN-LAST:event_tabelaContasPagarMouseClicked

    private void campoPesquisaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_campoPesquisaCaretUpdate
        // TODO add your handling code here:
        if (opCliente.isSelected()) {
            modelo.filtrar(campoPesquisa.getText());
        } else {
            modelo.filtrarObs(campoPesquisa.getText());
        }
    }//GEN-LAST:event_campoPesquisaCaretUpdate

    private void bAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAlterarActionPerformed
        // TODO add your handling code here:
        try {
            JanCadContaPagar jan2 = new JanCadContaPagar(modelo.getContaPagar(tabelaContasPagar.getSelectedRow()));
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
    private static javax.swing.JLabel labelAPagar;
    private static javax.swing.JLabel labelPago;
    private javax.swing.JRadioButton opCliente;
    private javax.swing.JRadioButton opDescricao;
    private static javax.swing.JTable tabelaContasPagar;
    // End of variables declaration//GEN-END:variables

    public void setarPermissoes(boolean alterar, boolean deletar, boolean inserir) {
        if (!inserir) {
            bNovo.setEnabled(false);
        }

        if (!alterar) {
            bAlterar.setEnabled(false);
            tabelaContasPagar.setEnabled(false);
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
