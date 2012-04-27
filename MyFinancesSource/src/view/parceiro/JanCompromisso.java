package view.parceiro;

import Persistencia.parceiro.ParceirosService;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Mensagem;
import model.parceiro.TableModelCompromisso;

public class JanCompromisso extends javax.swing.JFrame {

    private static JanCompromisso jan;
    public static TableModelCompromisso modelo;
    
    private JanCompromisso() {
        super("..:: Compromissos ::..");
        initComponents();
        setLocationRelativeTo(null);
        try {
            modelo = new TableModelCompromisso(ParceirosService.preencherCompromissos());
            tabelaCompromisso.setModel(modelo);
        } catch (ClassNotFoundException ex) {
            Mensagem.mensagemErroClassNotFound(jan);
            ex.printStackTrace();
        } catch (SQLException ex) {
            Mensagem.mensagemErroSQLException(jan);
            ex.printStackTrace();
        }
    }

    public static JanCompromisso getInstance(){
        if(jan == null){
            jan = new JanCompromisso();
        }
        
        return jan;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoOP = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        campoPesquisa = new javax.swing.JTextField();
        opStatus = new javax.swing.JRadioButton();
        opPrioridade = new javax.swing.JRadioButton();
        opObs = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCompromisso = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        bNovo = new javax.swing.JButton();
        bAlterar = new javax.swing.JButton();
        bExcluir = new javax.swing.JButton();
        bFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtrar"));

        campoPesquisa.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                campoPesquisaCaretUpdate(evt);
            }
        });

        grupoOP.add(opStatus);
        opStatus.setSelected(true);
        opStatus.setText("Status");
        opStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opStatusActionPerformed(evt);
            }
        });

        grupoOP.add(opPrioridade);
        opPrioridade.setText("Prioridade");

        grupoOP.add(opObs);
        opObs.setText("Observação");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(campoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(opStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opPrioridade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opObs)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opStatus)
                    .addComponent(opPrioridade)
                    .addComponent(opObs))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelaCompromisso.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaCompromisso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCompromissoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaCompromisso);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/novo.png"))); // NOI18N
        bNovo.setText("Novo");
        bNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovoActionPerformed(evt);
            }
        });

        bAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/editar.png"))); // NOI18N
        bAlterar.setText("Alterar");
        bAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAlterarActionPerformed(evt);
            }
        });

        bExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/excluir.png"))); // NOI18N
        bExcluir.setText("Excluir");
        bExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluirActionPerformed(evt);
            }
        });

        bFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/fechar.png"))); // NOI18N
        bFechar.setText("Fechar");
        bFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFecharActionPerformed(evt);
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
                .addComponent(bExcluir)
                .addGap(18, 18, 18)
                .addComponent(bFechar)
                .addContainerGap(269, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bNovo)
                    .addComponent(bAlterar)
                    .addComponent(bExcluir)
                    .addComponent(bFechar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoPesquisaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_campoPesquisaCaretUpdate
        // TODO add your handling code here:
        if (opStatus.isSelected()) {
            modelo.filtrarStatus(campoPesquisa.getText());
        } else if (opPrioridade.isSelected()) {
            modelo.filtrar(campoPesquisa.getText());
        } else if (opObs.isSelected()) {
            modelo.filtrarObs(campoPesquisa.getText());
        }
        
}//GEN-LAST:event_campoPesquisaCaretUpdate

    private void tabelaCompromissoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCompromissoMouseClicked
        // TODO add your handling code here:
        try{
            if (evt.getClickCount() == 2) {
                JanCadCompromisso jan = new JanCadCompromisso(modelo.getCompromisso(tabelaCompromisso.getSelectedRow()));
                jan.setVisible(true);
                this.setEnabled(false);
            }
        }catch(Exception e){}
}//GEN-LAST:event_tabelaCompromissoMouseClicked

    private void bNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoActionPerformed
        // TODO add your handling code here:
        JanCadCompromisso jan = new JanCadCompromisso();
        jan.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_bNovoActionPerformed

    private void bAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAlterarActionPerformed
        // TODO add your handling code here:
        try {
            JanCadCompromisso jan = new JanCadCompromisso(modelo.getCompromisso(tabelaCompromisso.getSelectedRow()));
            jan.setVisible(true);
            this.setEnabled(false);
        } catch (ArrayIndexOutOfBoundsException e) {
            Mensagem.mensagemErro(this, "Selecione um compromisso!");
        }
}//GEN-LAST:event_bAlterarActionPerformed

    private void bExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirActionPerformed
        // TODO add your handling code here:
        int s = Mensagem.mensagemYesNo(jan, "Tem certeza que deseja excluir este compromisso?");
        if(s==0){
            try {
                ParceirosService.deletarCompromisso(modelo.getCompromisso(tabelaCompromisso.getSelectedRow()));
                modelo.removeCompromisso(modelo.getCompromisso(tabelaCompromisso.getSelectedRow()));
                modelo.filtrar("");
            } catch (ArrayIndexOutOfBoundsException e) {
                            Mensagem.mensagemErro(this, "Selecione um compromisso!");
            } catch (ClassNotFoundException ex) {
                Mensagem.mensagemErroClassNotFound(this);
                ex.printStackTrace();
            } catch (SQLException ex) {
                Mensagem.mensagemErroSQLException(this);
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_bExcluirActionPerformed

    private void bFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_bFecharActionPerformed

    private void opStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opStatusActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        campoPesquisa.setText("");
        modelo.filtrar("");
    }//GEN-LAST:event_formWindowGainedFocus

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAlterar;
    private javax.swing.JButton bExcluir;
    private javax.swing.JButton bFechar;
    private javax.swing.JButton bNovo;
    private javax.swing.JTextField campoPesquisa;
    private javax.swing.ButtonGroup grupoOP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton opObs;
    private javax.swing.JRadioButton opPrioridade;
    private javax.swing.JRadioButton opStatus;
    private javax.swing.JTable tabelaCompromisso;
    // End of variables declaration//GEN-END:variables
}
