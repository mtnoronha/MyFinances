
package view.contas;

import Persistencia.contas.ContasService;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JLabel;
import model.Formatar;
import model.contas.HistoricoPadrao;
import model.contas.Lancamento;
import model.Mensagem;
import model.contas.PlanoContas;

public class JanLancamento extends javax.swing.JFrame {


    private PlanoContas contaCredito;
    private PlanoContas contaDebito;
    private HistoricoPadrao historicoPadrao;


    public JanLancamento() {
        super("..:: Lançamento ::..");
        initComponents();
        setLocationRelativeTo(null);
        campoData.setDate(new Date());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        campoIdContaDebito = new javax.swing.JTextField();
        campoDescContaDebito = new javax.swing.JTextField();
        campoIdContaCredito = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoDescContaCredito = new javax.swing.JTextField();
        bProcurarContaCredito = new javax.swing.JButton();
        bProcurarHistoricoPadrao = new javax.swing.JButton();
        campoHistoricoPadrao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bProcurarContaDebito = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        campoData = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        campoValor = new javax.swing.JTextField();
        bFechar = new javax.swing.JButton();
        bSalvar = new javax.swing.JButton();
        bHelp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel4.setText("Conta Débito");

        campoIdContaDebito.setBackground(new java.awt.Color(255, 255, 153));
        campoIdContaDebito.setEditable(false);

        campoDescContaDebito.setBackground(new java.awt.Color(255, 255, 153));
        campoDescContaDebito.setEditable(false);
        campoDescContaDebito.setText("Clique Em Procurar...");

        campoIdContaCredito.setBackground(new java.awt.Color(255, 255, 153));
        campoIdContaCredito.setEditable(false);

        jLabel5.setText("Conta Credito");

        campoDescContaCredito.setBackground(new java.awt.Color(255, 255, 153));
        campoDescContaCredito.setEditable(false);
        campoDescContaCredito.setText("Clique em Procurar...");

        bProcurarContaCredito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/find.png"))); // NOI18N
        bProcurarContaCredito.setToolTipText("Procurar Conta Credito");
        bProcurarContaCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bProcurarContaCreditoActionPerformed(evt);
            }
        });

        bProcurarHistoricoPadrao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/find.png"))); // NOI18N
        bProcurarHistoricoPadrao.setToolTipText("Procurar Histórico Padrão");
        bProcurarHistoricoPadrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bProcurarHistoricoPadraoActionPerformed(evt);
            }
        });

        campoHistoricoPadrao.setBackground(new java.awt.Color(255, 255, 153));

        jLabel8.setText("Histórico Padrão");

        bProcurarContaDebito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/find.png"))); // NOI18N
        bProcurarContaDebito.setToolTipText("Procurar Conta Credito");
        bProcurarContaDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bProcurarContaDebitoActionPerformed(evt);
            }
        });

        jLabel6.setText("Data");

        campoData.setBackground(new java.awt.Color(255, 255, 153));

        jLabel2.setText("Valor");

        campoValor.setBackground(new java.awt.Color(255, 255, 153));

        bFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/fechar.png"))); // NOI18N
        bFechar.setText("Fechar");
        bFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFecharActionPerformed(evt);
            }
        });

        bSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/salvar.png"))); // NOI18N
        bSalvar.setText("Salvar");
        bSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalvarActionPerformed(evt);
            }
        });

        bHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/help.png"))); // NOI18N
        bHelp.setToolTipText("Sobre contabilidade...");
        bHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHelpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12)
                        .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28)
                        .addComponent(campoValor, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(campoIdContaCredito, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoIdContaDebito, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoDescContaCredito, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                                    .addComponent(campoDescContaDebito, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bProcurarContaDebito)
                                    .addComponent(bProcurarContaCredito)))
                            .addComponent(jLabel8)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(campoHistoricoPadrao, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bProcurarHistoricoPadrao))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(bFechar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                        .addComponent(bHelp)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoIdContaDebito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoDescContaDebito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addComponent(bProcurarContaDebito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoIdContaCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoDescContaCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bProcurarContaCredito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoHistoricoPadrao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bProcurarHistoricoPadrao))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bSalvar)
                        .addComponent(bFechar))
                    .addComponent(bHelp))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bProcurarContaCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProcurarContaCreditoActionPerformed
        // TODO add your handling code here:
        JanPesquisaPlanoConta j = new JanPesquisaPlanoConta(this,"Cred");
        j.setVisible(true);
        this.setEnabled(false);
}//GEN-LAST:event_bProcurarContaCreditoActionPerformed

    private void bProcurarHistoricoPadraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProcurarHistoricoPadraoActionPerformed
        // TODO add your handling code here:
        JanPesquisaHistoricoPadrao jan = new JanPesquisaHistoricoPadrao(this);
        jan.setVisible(true);
        this.setEnabled(false);
}//GEN-LAST:event_bProcurarHistoricoPadraoActionPerformed

    private void bProcurarContaDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProcurarContaDebitoActionPerformed
        // TODO add your handling code here:
                JanPesquisaPlanoConta j = new JanPesquisaPlanoConta(this,"Deb");
        j.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_bProcurarContaDebitoActionPerformed

    private void bFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFecharActionPerformed
        // TODO add your handling code here:
        fechar();
}//GEN-LAST:event_bFecharActionPerformed

    private void bSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalvarActionPerformed
        // TODO add your handling code here:
        if (verificarDados()) {           
            int s = Mensagem.mensagemYesNo(this, "Por favor, confira os seguintes dados:\n"
                    + "Data: "+Formatar.formatarData(campoData.getDate())+"\n"                     
                    + "Conta DEBITO: "+Formatar.formatPlanoContas(contaDebito.getConta())+" - "+contaDebito.getDescricao() +"\n"
                    +  "Conta CREDITO: "+Formatar.formatPlanoContas(contaCredito.getConta())+" - "+contaCredito.getDescricao()+"\n"
                    + "Historico Padrão: "+ historicoPadrao.getDescricao()+"\n"
                    + "Valor: "+campoValor.getText());
            
            if (s == 0) {
                java.sql.Date data = new java.sql.Date(campoData.getDate().getTime());
                Lancamento novo = new Lancamento(historicoPadrao.getId(), contaCredito.getConta(), contaDebito.getConta(), data, Double.parseDouble(campoValor.getText().replaceAll(",", ".")));

                try {
                    ContasService.inserirLancamento(novo);
                    Mensagem.mensagemSucesso(this, "Lançamento realizado com sucesso!");
                    this.dispose();
                } catch (Exception e) {
                    Mensagem.mensagemErro(this, "Erro: " + e);
                    e.printStackTrace();
                }
            }
        }
}//GEN-LAST:event_bSalvarActionPerformed

    private void bHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHelpActionPerformed

        JDialog j = new JDialog();
        j.setLayout(new GridLayout(6, 1));
        //j.add(new JLabel(" "));
        JLabel os = new JLabel(" ATIVO: Debito aumenta o valor da conta e Credito diminui  ");
        os.setFont(new Font("Dialog", Font.PLAIN, 14));
        j.add(os);
       // j.add(new JLabel(" "));
        JLabel os2 = new JLabel(" PASSIVO: Debito diminui o valor da conta e Credito aumenta  ");
        os2.setFont(new Font("Dialog", Font.PLAIN, 14));
        j.add(os2);
       // j.add(new JLabel(" "));
        JLabel os3 = new JLabel(" RECEITA: Debito diminui o valor da conta e Credito aumenta  ");
        os3.setFont(new Font("Dialog", Font.PLAIN, 14));
        j.add(os3);
      //  j.add(new JLabel(" "));

        JLabel os4 = new JLabel(" DESPESA: Debito aumenta o valor da conta e Credito diminui  ");
        os4.setFont(new Font("Dialog", Font.PLAIN, 14));
        j.add(os4);
        
        JLabel os5 = new JLabel(" CUSTO: Debito aumenta o valor da conta e Credito diminui  ");
        os5.setFont(new Font("Dialog", Font.PLAIN, 14));
        j.add(os5);
        
     //   j.add(new JLabel(" "));

        j.setLocationRelativeTo(null);
        j.setTitle("..:: Contabilidade ::..");
        //j.setDefaultCloseOperation();
        j.pack();
        j.setVisible(true);
    }//GEN-LAST:event_bHelpActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bFechar;
    private javax.swing.JButton bHelp;
    private javax.swing.JButton bProcurarContaCredito;
    private javax.swing.JButton bProcurarContaDebito;
    private javax.swing.JButton bProcurarHistoricoPadrao;
    private javax.swing.JButton bSalvar;
    private com.toedter.calendar.JDateChooser campoData;
    private javax.swing.JTextField campoDescContaCredito;
    private javax.swing.JTextField campoDescContaDebito;
    private javax.swing.JTextField campoHistoricoPadrao;
    private javax.swing.JTextField campoIdContaCredito;
    private javax.swing.JTextField campoIdContaDebito;
    private javax.swing.JTextField campoValor;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables

    private void fechar() {
        this.dispose();
    }

    private boolean verificarDados() {
         try {
            java.sql.Date data = new java.sql.Date(campoData.getDate().getTime());

        } catch (Exception e) {
            Mensagem.mensagemErro(this, "Escolha a data");
            campoData.requestFocus();
            return false;
        }
                
                        try {
            double v = Double.parseDouble(campoValor.getText().replace(",", "."));
            if (v <= 0) {
                Mensagem.mensagemErro(this, "O valor da conta não pode ser menor ou igual a 0!");
                campoValor.requestFocus();
                return false;
            }
        } catch (NumberFormatException ex) {
            Mensagem.mensagemErro(this, "Digite o valor desta conta");
            campoValor.requestFocus();
            return false;
        }


        historicoPadrao = JanHistoricoPadrao.modelo.getHistoricoPadrao(campoHistoricoPadrao.getText());
        if (historicoPadrao == null) {
            try {
                historicoPadrao = new HistoricoPadrao(campoHistoricoPadrao.getText());
                int id = ContasService.inserirHistoricoPadrao(historicoPadrao);
                historicoPadrao.setId(id);
                JanHistoricoPadrao.modelo.addHistoricoPadrao(historicoPadrao);
                JanHistoricoPadrao.modelo.filtrar("");
            } catch (Exception e) {
                Mensagem.mensagemErro(this, "Erro no Histórico Padrão!");
                e.printStackTrace();
                return false;
            }
        }

        if (contaCredito == null) {
            Mensagem.mensagemErro(this, "Selecione a Conta Crédito");
            bProcurarContaCredito.requestFocus();
            return false;

        }

        if (contaDebito == null) {
                                    Mensagem.mensagemErro(this, "Selecione a Conta Débito");
            bProcurarContaCredito.requestFocus();
            return false;
        }
        return true;
    }
    
    
    void arrumarHistPadrao(HistoricoPadrao historicoPadrao) {
        this.historicoPadrao = historicoPadrao;
        setarHistoricoPadrao();
    }

    private void setarHistoricoPadrao() {
        campoHistoricoPadrao.setText(historicoPadrao.getDescricao());
    }

    void arrumarContaD(PlanoContas planoContas) {
       this.contaDebito = planoContas; 
       setarContaDebito();
    }

    private void setarContaDebito() {
        campoDescContaDebito.setText(contaDebito.getDescricao());
        campoIdContaDebito.setText(contaDebito.getConta());
    }
    
    void arrumarContaC(PlanoContas planoContas) {
        this.contaCredito = planoContas;
        setarContaCredito();
    }

    private void setarContaCredito() {
        campoIdContaCredito.setText(contaCredito.getConta());
        campoDescContaCredito.setText(contaCredito.getDescricao());
    }
}
