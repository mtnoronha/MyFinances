package view.parceiro;

import Persistencia.parceiro.ParceirosService;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Mensagem;
import model.parceiro.Compromisso;
import model.parceiro.Endereco;

public class JanCadCompromisso extends javax.swing.JFrame {

    private Compromisso atual;
    private Endereco endAtual;

    public JanCadCompromisso() {
        super("..:: Compromisso ::..");
        initComponents();
        setLocationRelativeTo(null);
    }

    public JanCadCompromisso(Compromisso atual) {
        super("..:: Compromisso ::..");
        initComponents();
        this.atual = atual;
        setLocationRelativeTo(null);
        carregarDados();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoStatus = new javax.swing.JComboBox();
        campoPrioridade = new javax.swing.JComboBox();
        campoEnd = new javax.swing.JTextField();
        bNovoEnd = new javax.swing.JButton();
        bProcurarEnd = new javax.swing.JButton();
        campoData = new com.toedter.calendar.JDateChooser();
        campoHora = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoObs = new javax.swing.JTextArea();
        bCancelar = new javax.swing.JButton();
        bSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Status");

        jLabel2.setText("Prioridade");

        jLabel3.setText("Endereço");

        jLabel4.setText("Data");

        jLabel5.setText("Hora");

        jLabel6.setText("Obs");

        campoStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Agendado", "Concluído", "Cancelado" }));

        campoPrioridade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alta", "Normal", "Baixa" }));

        campoEnd.setEditable(false);
        campoEnd.setText("Clique em Procurar...");

        bNovoEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/add.png"))); // NOI18N
        bNovoEnd.setToolTipText("Novo Endereço");
        bNovoEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovoEndActionPerformed(evt);
            }
        });

        bProcurarEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/find.png"))); // NOI18N
        bProcurarEnd.setToolTipText("Procurar Endereço");
        bProcurarEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bProcurarEndActionPerformed(evt);
            }
        });

        campoObs.setColumns(20);
        campoObs.setRows(5);
        jScrollPane1.setViewportView(campoObs);

        bCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/cancelar.png"))); // NOI18N
        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        bSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/salvar.png"))); // NOI18N
        bSalvar.setText("Salvar");
        bSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoHora, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(campoEnd, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bProcurarEnd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bNovoEnd))
                            .addComponent(campoPrioridade, 0, 353, Short.MAX_VALUE)
                            .addComponent(campoStatus, 0, 353, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE))
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(campoEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bNovoEnd)
                    .addComponent(bProcurarEnd))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(campoData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(campoHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(bSalvar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNovoEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoEndActionPerformed
        // TODO add your handling code here:
        JanEnderecos janEnd = new JanEnderecos(this);
        janEnd.setVisible(true);
        this.setEnabled(false);

}//GEN-LAST:event_bNovoEndActionPerformed

    private void bProcurarEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProcurarEndActionPerformed
        // TODO add your handling code here:
        JanPesquisaEndereco janPesqEnd = new JanPesquisaEndereco(this);
        janPesqEnd.setVisible(true);
        this.setEnabled(false);
}//GEN-LAST:event_bProcurarEndActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        // TODO add your handling code here:
        fechar();
}//GEN-LAST:event_bCancelarActionPerformed

    private void bSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalvarActionPerformed
        // TODO add your handling code here:
        if (verificarDados()) {
            java.sql.Date data = null;

            try {
                data = new java.sql.Date(campoData.getDate().getTime());
            } catch (Exception e) {
            }


            if (atual == null) {
                //NOVO 
                try {
                    Compromisso com = new Compromisso(campoStatus.getSelectedItem().toString(), campoPrioridade.getSelectedItem().toString(), data, campoHora.getText(), endAtual, campoObs.getText());
                    int id;

                    id = ParceirosService.inserirCompromisso(com);
                    com.setId(id);

                    Mensagem.mensagemSucesso(this, "Compromisso adicionado com sucesso! ");
                    JanCompromisso.modelo.addCompromisso(com);
                    fechar();

                } catch (ClassNotFoundException ex) {
                    Mensagem.mensagemErroClassNotFound(this);
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    Mensagem.mensagemErroSQLException(this);
                    ex.printStackTrace();

                }
            } else {
                //ATUALIZAR
                try {
                    atual.setData(data);
                    atual.setEndereco(endAtual);
                    atual.setHora(campoHora.getText());
                    atual.setObs(campoObs.getText());
                    atual.setPrioridade(campoPrioridade.getSelectedItem().toString());
                    atual.setStatus(campoStatus.getSelectedItem().toString());

                    ParceirosService.atualizarCompromisso(atual);
                    Mensagem.mensagemSucesso(this, "Compromisso alterado com sucesso! ");
                    JanCompromisso.modelo.filtrar("");
                    fechar();

                } catch (SQLException ex) {
                    Mensagem.mensagemErroSQLException(this);
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    Mensagem.mensagemErroClassNotFound(this);
                    ex.printStackTrace();
                }
            }
        }
}//GEN-LAST:event_bSalvarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bNovoEnd;
    private javax.swing.JButton bProcurarEnd;
    private javax.swing.JButton bSalvar;
    private com.toedter.calendar.JDateChooser campoData;
    private javax.swing.JTextField campoEnd;
    private javax.swing.JTextField campoHora;
    private javax.swing.JTextArea campoObs;
    private javax.swing.JComboBox campoPrioridade;
    private javax.swing.JComboBox campoStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void fechar() {
        JanCompromisso.getInstance().setEnabled(true);
        JanCompromisso.getInstance().requestFocus();
        this.dispose();
    }

    private boolean verificarDados() {
        java.sql.Date data = null;

        try {
            data = new java.sql.Date(campoData.getDate().getTime());
        } catch (Exception e) {
            Mensagem.mensagemErro(this, "Escolha uma Data!");
            campoData.requestFocus();
            return false;
        }

        if (endAtual == null) {
            Mensagem.mensagemErro(this, "Selecione o endereço");
            return false;
        }

        return true;
    }

    public void arrumarEnd(Endereco endereco) {
        endAtual = endereco;
        setarEndereco();
    }

    private void setarEndereco() {
        campoEnd.setText(endAtual.getTipoEndereco() + " Bairro: " + endAtual.getBairro() + " Rua: " + endAtual.getLogradouro() + " Numero: " + endAtual.getNumero());
    }

    private void carregarDados() {
        campoData.setDate(atual.getData());
        arrumarEnd(atual.getEndereco());
        campoHora.setText(atual.getHora());
        campoObs.setText(atual.getObs());
        campoPrioridade.setSelectedItem(atual.getPrioridade());
        campoStatus.setSelectedItem(atual.getStatus());
    }
}
