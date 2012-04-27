
package view.contas;

import Persistencia.contas.ContasService;
import java.sql.SQLException;
import model.Mensagem;
import model.contas.PlanoContas;

public class JanCadPlanoContas extends javax.swing.JFrame {


    private PlanoContas atual;
    
    public JanCadPlanoContas() {
        super("..:: Plano de Contas ::..");
        initComponents();
        setLocationRelativeTo(null);
    }
    
   public JanCadPlanoContas(PlanoContas a) {
        super("..:: Plano de Contas ::..");
        initComponents();
        setLocationRelativeTo(null);
        atual = a;
        carregarDados();
        campoConta.setEnabled(false);
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoConta = new javax.swing.JTextField(12);
        jLabel2 = new javax.swing.JLabel();
        campoTipo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        campoDescricao = new javax.swing.JTextField();
        bSalvar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Conta");

        campoConta.setBackground(new java.awt.Color(255, 255, 153));

        jLabel2.setText("Tipo");

        campoTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ATIVO", "PASSIVO", "CUSTO", "DESPESA", "RESULTADO" }));

        jLabel3.setText("Descrição");

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoConta, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(13, 13, 13)
                                .addComponent(campoTipo, 0, 155, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(campoDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(202, 202, 202))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(campoConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
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
                PlanoContas novo = new PlanoContas(campoConta.getText().replaceAll("\\.", ""), campoDescricao.getText().toUpperCase(), campoTipo.getSelectedItem().toString());
                
                try {
                    int id = ContasService.inserirPlanoContas(novo);
                    novo.setCodigoReduzido(id);
                    JanPlanoContas.getInstance().modelo.addPlanoContas(novo);
                    JanPlanoContas.getInstance().modelo.filtrar("");
                    Mensagem.mensagemSucesso(this, "Conta criada com sucesso");
                    
                    fechar();
                } catch (ClassNotFoundException ex) {
                    Mensagem.mensagemErroClassNotFound(this);
                } catch (SQLException ex) {
                    Mensagem.mensagemErroSQLException(this);
                    ex.printStackTrace();
                }
                
                
                
            } else {
                atual.setDescricao(campoDescricao.getText().toUpperCase());
                atual.setTipo(campoTipo.getSelectedItem().toString());
                
                try {
                    ContasService.atualizarPlanoContas(atual);
                    JanPlanoContas.getInstance().modelo.filtrar("");
                    Mensagem.mensagemSucesso(this, "Conta alterado com sucesso");
                    
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

     private void fechar() {
        JanPlanoContas.getInstance().setEnabled(true);
        JanPlanoContas.getInstance().requestFocus();
        this.dispose();
    }

    private boolean verificarDados() {
        
        if(campoDescricao.getText().equals("")){
            Mensagem.mensagemErro(this, "Digite a descrição");
            campoDescricao.requestFocus();
            return false;
        }
        
        if (atual == null) {
            if (campoConta.getText().replaceAll("\\.", "").length() > 12) {
                Mensagem.mensagemErro(this, "A conta não pode ter mais do que 12 números!");
                campoDescricao.requestFocus();
                return false;
            }
            
            int dig = campoConta.getText().replaceAll("\\.", "").length();
            switch(dig){
                case 1:
                    break;
                case 3:
                    break;
                case 5:
                    break;
                case 7:
                    break;
                case 12:
                    break;
                default:
                    Mensagem.mensagemErro(this, "Quantidade de digitos da conta inválido!");
                    campoConta.requestFocus();
                    return false;   
            }
            
            
            if(!JanPlanoContas.modelo.existeNivelSuperior(campoConta.getText().replaceAll("\\.", ""))){
                Mensagem.mensagemErro(this, "Não existe nível superior para esta conta!");
                campoConta.requestFocus();
                return false;
            }
              
            if (JanPlanoContas.modelo.getPlanoContas(campoConta.getText().replaceAll("\\.", "")) != null) {
                Mensagem.mensagemErro(this, "Esta Conta já existe");
                campoDescricao.requestFocus();
                return false;
            }
        }
        
        return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bSalvar;
    private javax.swing.JTextField campoConta;
    private javax.swing.JTextField campoDescricao;
    private javax.swing.JComboBox campoTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

    private void carregarDados() {
        campoConta.setText(atual.getConta());
        campoTipo.setSelectedItem(atual.getTipo());
        campoDescricao.setText(atual.getDescricao());
    }
}
