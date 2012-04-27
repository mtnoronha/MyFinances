package view.contas;

import Persistencia.contas.ContasService;
import java.sql.SQLException;
import model.contas.HistoricoPadrao;
import model.Mensagem;


public class JanCadHistoricoPadrao extends javax.swing.JFrame {
    private HistoricoPadrao atual;

    public JanCadHistoricoPadrao() {
        super("..:: Histórico Padrão ::..");
        initComponents();
        setLocationRelativeTo(null);
    }
    
        public JanCadHistoricoPadrao(HistoricoPadrao a) {
        super("..:: Histórico Padrão ::..");
        initComponents();
        setLocationRelativeTo(null);
        atual = a;
        carregarHistorico();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoDescricao = new javax.swing.JTextField();
        bSalvar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Descrição:");

        campoDescricao.setBackground(new java.awt.Color(255, 255, 153));

        bSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/salvar.png"))); // NOI18N
        bSalvar.setText("Salvar");
        bSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalvarActionPerformed(evt);
            }
        });

        bCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/cancelar.png"))); // NOI18N
        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(bSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalvarActionPerformed
        // TODO add your handling code here:
        if (verificarDados()) {
            if (atual == null) {
               HistoricoPadrao novo = new HistoricoPadrao(campoDescricao.getText());
               
                try {
                    int id = ContasService.inserirHistoricoPadrao(novo);
                    novo.setId(id);
                    JanHistoricoPadrao.getInstance().modelo.addHistoricoPadrao(novo);
                    JanHistoricoPadrao.getInstance().modelo.filtrar("");
                     Mensagem.mensagemSucesso(this, "Histórico Padrão criado com sucesso");
                    
                    fechar();
                } catch (ClassNotFoundException ex) {
                    Mensagem.mensagemErroClassNotFound(this);
                } catch (SQLException ex) {
                    Mensagem.mensagemErroSQLException(this);
                    ex.printStackTrace();
                }
         
                
               
            } else {
                atual.setDescricao(campoDescricao.getText());

                try {
                    ContasService.atualizarHistoricoPadrao(atual);
                    JanHistoricoPadrao.getInstance().modelo.filtrar("");
                     Mensagem.mensagemSucesso(this, "Histórico Padrão alterado com sucesso");
                    
                    fechar();
                } catch (ClassNotFoundException ex) {
                    Mensagem.mensagemErroClassNotFound(this);
                } catch (SQLException ex) {
                    Mensagem.mensagemErroSQLException(this);
                    ex.printStackTrace();
                }
                
            }
        }
}//GEN-LAST:event_bSalvarActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        // TODO add your handling code here:
        fechar();
}//GEN-LAST:event_bCancelarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bSalvar;
    private javax.swing.JTextField campoDescricao;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    private void carregarHistorico() {
        campoDescricao.setText(atual.getDescricao());
    }

    private void fechar() {
        JanHistoricoPadrao.getInstance().setEnabled(true);
        JanHistoricoPadrao.getInstance().requestFocus();
        this.dispose();
    }

    private boolean verificarDados() {
        if(campoDescricao.getText().equals("")){
            Mensagem.mensagemErro(this, "Digite a descrição");
            campoDescricao.requestFocus();
            return false;
        }
        
        if(JanHistoricoPadrao.getInstance().modelo.getHistoricoPadrao(campoDescricao.getText()) != null){
            Mensagem.mensagemErro(this, "Este Histórico Padrão já existe");
            campoDescricao.requestFocus();
            return false;
        }
        
        return true;
    }
}
