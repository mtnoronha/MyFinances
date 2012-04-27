/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JanRelPlanoContas.java
 *
 * Created on 17/11/2011, 15:13:47
 */
package relatorio.contas;

import java.util.Date;
import model.Mensagem;
import model.contas.HistoricoPadrao;
import relatorio.GerarRelatorio;
import view.contas.JanPesquisaHistoricoPadrao;

/**
 *
 * @author Marco
 */
public class JanRelPlanoContas extends javax.swing.JFrame {

    HistoricoPadrao historicoPadrao;
    
    /** Creates new form JanRelPlanoContas */
    public JanRelPlanoContas() {
        super("..:: Relatórios Plano de Contas ::..");
        initComponents();
        setLocationRelativeTo(null);
       campoData1.setDate(new Date(110,0,1));
       //campoData1.setEnabled(false);
       campoData2.setDate(new Date());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        campoData1 = new com.toedter.calendar.JDateChooser();
        campoData2 = new com.toedter.calendar.JDateChooser();
        bBalanco = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bDemonstrativo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        campoHistoricoPadrao = new javax.swing.JTextField();
        bProcurarHistoricoPadrao = new javax.swing.JButton();
        bFechar = new javax.swing.JButton();
        bRelacao = new javax.swing.JButton();
        bLancamentos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bBalanco.setText("Balanço Patrimonial");
        bBalanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBalancoActionPerformed(evt);
            }
        });

        jLabel1.setText("até");

        bDemonstrativo.setText("Demonstrativo do Resultado do Exercício");
        bDemonstrativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDemonstrativoActionPerformed(evt);
            }
        });

        jButton1.setText("Lançamentos por Historico Padrão");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        campoHistoricoPadrao.setBackground(new java.awt.Color(255, 255, 153));

        bProcurarHistoricoPadrao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/find.png"))); // NOI18N
        bProcurarHistoricoPadrao.setToolTipText("Procurar Histórico Padrão");
        bProcurarHistoricoPadrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bProcurarHistoricoPadraoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bDemonstrativo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bBalanco)
                    .addComponent(campoHistoricoPadrao, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(campoData1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(campoData2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(477, Short.MAX_VALUE)
                    .addComponent(bProcurarHistoricoPadrao)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campoData1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoData2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(campoHistoricoPadrao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bDemonstrativo)
                    .addComponent(bBalanco))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(bProcurarHistoricoPadrao)
                    .addContainerGap(51, Short.MAX_VALUE)))
        );

        bFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/fechar.png"))); // NOI18N
        bFechar.setText("Fechar");
        bFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFecharActionPerformed(evt);
            }
        });

        bRelacao.setText("Relação do Plano de Contas");
        bRelacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRelacaoActionPerformed(evt);
            }
        });

        bLancamentos.setText("Lançamentos");
        bLancamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLancamentosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bFechar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bRelacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bLancamentos))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bRelacao)
                    .addComponent(bLancamentos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(bFechar)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bBalancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBalancoActionPerformed
        // TODO add your handling code here:
              if(verificarDados()){
        Thread t = new Thread(new GerarRelatorio("balancopatrimonial",campoData1.getDate(),campoData2.getDate()));
        t.start();
              }
    }//GEN-LAST:event_bBalancoActionPerformed

    private void bFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_bFecharActionPerformed

    private void bRelacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRelacaoActionPerformed
        // TODO add your handling code here:
                Thread t = new Thread(new GerarRelatorio("planocontas",0));
        t.start();

    }//GEN-LAST:event_bRelacaoActionPerformed

    private void bDemonstrativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDemonstrativoActionPerformed
        // TODO add your handling code here:
              if(verificarDados()){
        Thread t = new Thread(new GerarRelatorio("dre",campoData1.getDate(),campoData2.getDate()));
        t.start();
              }

    }//GEN-LAST:event_bDemonstrativoActionPerformed

    private void bLancamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLancamentosActionPerformed
        // TODO add your handling code here:
        Thread t = new Thread(new GerarRelatorio("lancamento",0));
        t.start();
    }//GEN-LAST:event_bLancamentosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (verificarDados()) {
            if (historicoPadrao != null) {
                Thread t = new Thread(new GerarRelatorio("historicopadrao", historicoPadrao.getId(), campoData1.getDate(), campoData2.getDate()));
                t.start();
            } else {
                Mensagem.mensagemErro(this, "Escolha o Histórico padrão!");
                JanPesquisaHistoricoPadrao jan = new JanPesquisaHistoricoPadrao(this);
                jan.setVisible(true);
                this.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bProcurarHistoricoPadraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProcurarHistoricoPadraoActionPerformed
        // TODO add your handling code here:
        JanPesquisaHistoricoPadrao jan = new JanPesquisaHistoricoPadrao(this);
        jan.setVisible(true);
        this.setEnabled(false);
}//GEN-LAST:event_bProcurarHistoricoPadraoActionPerformed
    public void arrumarHistPadrao(HistoricoPadrao historicoPadrao) {
        this.historicoPadrao = historicoPadrao;
        setarHistoricoPadrao();
    }

    private void setarHistoricoPadrao() {
        campoHistoricoPadrao.setText(historicoPadrao.getDescricao());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBalanco;
    private javax.swing.JButton bDemonstrativo;
    private javax.swing.JButton bFechar;
    private javax.swing.JButton bLancamentos;
    private javax.swing.JButton bProcurarHistoricoPadrao;
    private javax.swing.JButton bRelacao;
    private com.toedter.calendar.JDateChooser campoData1;
    private com.toedter.calendar.JDateChooser campoData2;
    private javax.swing.JTextField campoHistoricoPadrao;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private boolean verificarDados() {
            try {
            java.sql.Date data = new java.sql.Date(campoData1.getDate().getTime());

        } catch (Exception e) {
            Mensagem.mensagemErro(this, "Escolha a data de inicio");
            campoData1.requestFocus();
            return false;
        }
            
            try {
            java.sql.Date data = new java.sql.Date(campoData2.getDate().getTime());

        } catch (Exception e) {
            Mensagem.mensagemErro(this, "Escolha a data de fim");
            campoData2.requestFocus();
            return false;
        }

        
        return true;
    }
}
