package view.parceiro;

import model.parceiro.TableModelContatos;
import Persistencia.parceiro.ParceirosService;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import model.parceiro.Contato;
import model.Mensagem;

import model.parceiro.ParceiroComercial;

public class JanContatos extends javax.swing.JFrame {

    private ParceiroComercial parceiro;
    private MaskFormatter mascaraTel1;
    private MaskFormatter mascaraTel2;
    private MaskFormatter mascaraTel3;
    private MaskFormatter mascaraCel;
    private MaskFormatter mascaraFax;
    private TableModelContatos modelo;
    private Contato atual;

    public void carregarDados() {
        campoCel.setText(atual.getCel());
        campoEmail.setText(atual.getEmail());
        campoFax.setText(atual.getFax());
        campoMSN.setText(atual.getMsn());
        campoNome.setText(atual.getNome());
        campoTel1.setText(atual.getTel1());
        campoTel2.setText(atual.getTel2());
        campoTel3.setText(atual.getTel3());
        campoRamal1.setText(atual.getRamal1());
        campoRamal2.setText(atual.getRamal2());
        campoRamal3.setText(atual.getRamal3());
        campoSkype.setText(atual.getSkype());
    }

    public void visibilidade(boolean t) {
        campoCel.setEnabled(t);
        campoEmail.setEnabled(t);
        campoFax.setEnabled(t);
        campoMSN.setEnabled(t);
        campoNome.setEnabled(t);
        campoTel1.setEnabled(t);
        campoTel2.setEnabled(t);
        campoTel3.setEnabled(t);
        campoRamal1.setEnabled(t);
        campoRamal2.setEnabled(t);
        campoRamal3.setEnabled(t);
        campoSkype.setEnabled(t);
    }

    public boolean verificarDados() {
        if (campoNome.getText().equals("")) {
            Mensagem.mensagemErro(this, "Digite o nome do contato");
            campoNome.requestFocus();

            return false;
        }
        return true;
    }

    public void limparDados() {
        campoCel.setText("");
        campoEmail.setText("");
        campoFax.setText("");
        campoMSN.setText("");
        campoNome.setText("");
        campoTel1.setText("");
        campoTel2.setText("");
        campoTel3.setText("");
        campoRamal1.setText("");
        campoRamal2.setText("");
        campoRamal3.setText("");
        campoSkype.setText("");
    }

    public JanContatos(ParceiroComercial parceiro) {
        super("..:: Contatos ::..");
        this.parceiro = parceiro;

        try {
            mascaraTel1 = new MaskFormatter("(##)####-####");
            mascaraTel2 = new MaskFormatter("(##)####-####");
            mascaraTel3 = new MaskFormatter("(##)####-####");
            mascaraCel = new MaskFormatter("(##)####-####");
            mascaraFax = new MaskFormatter("(##)####-####");

        } catch (Exception e) {
        }

        initComponents();
        setLocationRelativeTo(null);
        bSalvar.setEnabled(false);
        bAlterar.setEnabled(false);
        bExcluir.setEnabled(false);
        visibilidade(false);

        if (parceiro.isFisica()) {
            parceiroAtual.setText(parceiro.getNome());
        } else {
            parceiroAtual.setText(parceiro.getRazaoSocial());
        }

        if (parceiro.getContatos().size() > 0) {
            modelo = new TableModelContatos(parceiro.getContatos());
        } else {
            modelo = new TableModelContatos();
        }

        tabelaContato.setModel(modelo);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaContato = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campoTel1 = new javax.swing.JFormattedTextField(mascaraTel1);
        jLabel3 = new javax.swing.JLabel();
        campoRamal1 = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        campoTel2 = new javax.swing.JFormattedTextField(mascaraTel2);
        campoRamal2 = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoTel3 = new javax.swing.JFormattedTextField(mascaraTel3);
        jLabel7 = new javax.swing.JLabel();
        campoRamal3 = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        campoCel = new javax.swing.JFormattedTextField(mascaraCel);
        jLabel9 = new javax.swing.JLabel();
        campoFax = new javax.swing.JFormattedTextField(mascaraFax);
        jLabel10 = new javax.swing.JLabel();
        campoEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        campoMSN = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        campoSkype = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        bExcluir = new javax.swing.JButton();
        bAlterar = new javax.swing.JButton();
        bNovo = new javax.swing.JButton();
        bFechar = new javax.swing.JButton();
        bSalvar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        parceiroAtual = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tabelaContato.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaContato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaContatoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaContato);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));

        jLabel1.setText("Nome do Contato");

        campoNome.setBackground(new java.awt.Color(255, 255, 153));

        jLabel2.setText("Telefone 1");

        jLabel3.setText("Ramal");

        jLabel4.setText("Telefone 2");

        jLabel5.setText("Ramal");

        jLabel6.setText("Telefone 3");

        jLabel7.setText("Ramal");

        jLabel8.setText("Celular");

        jLabel9.setText("FAX");

        jLabel10.setText("Email");

        jLabel11.setText("MSN");

        jLabel12.setText("Skype");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoTel3, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(campoCel, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(campoFax, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoRamal3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoTel2, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoTel1)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoRamal1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoRamal2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoMSN, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(campoSkype, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(campoTel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(campoRamal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(campoTel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(campoRamal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(campoSkype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(campoTel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(campoRamal3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(campoCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(campoFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(campoMSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/excluir.png"))); // NOI18N
        bExcluir.setText("Excluir");
        bExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluirActionPerformed(evt);
            }
        });

        bAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/editar.png"))); // NOI18N
        bAlterar.setText("Alterar");
        bAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAlterarActionPerformed(evt);
            }
        });

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

        bSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/salvar.png"))); // NOI18N
        bSalvar.setText("Salvar");
        bSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(bNovo)
                .addGap(18, 18, 18)
                .addComponent(bSalvar)
                .addGap(18, 18, 18)
                .addComponent(bAlterar)
                .addGap(18, 18, 18)
                .addComponent(bExcluir)
                .addGap(18, 18, 18)
                .addComponent(bFechar)
                .addGap(53, 53, 53))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bFechar)
                    .addComponent(bExcluir)
                    .addComponent(bAlterar)
                    .addComponent(bNovo)
                    .addComponent(bSalvar))
                .addContainerGap())
        );

        jLabel13.setText("Contatos para o parceiro:");

        parceiroAtual.setFont(new java.awt.Font("sansserif", 1, 12));
        parceiroAtual.setText(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(parceiroAtual)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(parceiroAtual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        JanParceirosComerciais.getInstance().setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void bNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoActionPerformed
        // TODO add your handling code here:
        bSalvar.setEnabled(true);
        bAlterar.setEnabled(false);
        bExcluir.setEnabled(false);
        limparDados();
        visibilidade(true);


    }//GEN-LAST:event_bNovoActionPerformed

    private void bFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFecharActionPerformed
        // TODO add your handling code here:
        JanParceirosComerciais.getInstance().setEnabled(true);
        this.dispose();
}//GEN-LAST:event_bFecharActionPerformed

    private void tabelaContatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaContatoMouseClicked
        // TODO add your handling code here:
        atual = modelo.getContato(tabelaContato.getSelectedRow());
        carregarDados();
        bAlterar.setEnabled(true);
        bExcluir.setEnabled(true);
        bSalvar.setEnabled(false);
        visibilidade(true);
    }//GEN-LAST:event_tabelaContatoMouseClicked

    private void bAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAlterarActionPerformed
        // TODO add your handling code here:
        if (verificarDados()) {
            try {
                atual.setNome(campoNome.getText());
                atual.setCel(campoCel.getText());
                atual.setEmail(campoEmail.getText());
                atual.setFax(campoFax.getText());
                atual.setMsn(campoMSN.getText());
                atual.setRamal1(campoRamal1.getText());
                atual.setRamal2(campoRamal2.getText());
                atual.setRamal3(campoRamal3.getText());
                atual.setSkype(campoSkype.getText());
                atual.setTel1(campoTel1.getText());
                atual.setTel2(campoTel2.getText());
                atual.setTel3(campoTel3.getText());
                ParceirosService.atualizarContato(atual);
                bAlterar.setEnabled(false);
                bExcluir.setEnabled(false);
                visibilidade(false);
                limparDados();
                Mensagem.mensagemSucesso(this, "Contato alterado com sucesso");
                modelo.filtrar("");
                bNovo.requestFocus();
            } catch (ClassNotFoundException ex) {
                Mensagem.mensagemErroClassNotFound(this);
            } catch (SQLException ex) {
                Mensagem.mensagemErroSQLException(this);
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_bAlterarActionPerformed
    
    private void bExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirActionPerformed
        // TODO add your handling code here:
               
        try{        
            ParceirosService.deletarContato(atual);    
            modelo.removeContato(atual);               
        }catch (ClassNotFoundException ex) {
            Mensagem.mensagemErroClassNotFound(this);
        } catch (SQLException ex) {
            Mensagem.mensagemErroSQLException(this);
            ex.printStackTrace();
        }
        
        bAlterar.setEnabled(false);
        bExcluir.setEnabled(false);
        visibilidade(false);
        limparDados();
        bNovo.requestFocus();
    }//GEN-LAST:event_bExcluirActionPerformed

    private void bSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalvarActionPerformed
        // TODO add your handling code here:
        if (verificarDados()) {

            try {
                Contato novo = new Contato(campoNome.getText(), campoEmail.getText(), campoSkype.getText(), campoMSN.getText(), campoFax.getText(), campoTel1.getText(), campoTel2.getText(), campoTel3.getText(), campoCel.getText(), campoRamal1.getText(), campoRamal2.getText(), campoRamal3.getText());
                int id;
                id = ParceirosService.inserirContato(novo);
                novo.setId(id);
                ParceirosService.inserirRelacaoContato(id, parceiro.getId());
                modelo.addContato(novo);
                parceiro.addContato(novo);
                Mensagem.mensagemSucesso(this, "Contato adicionado com sucesso");
            } catch (ClassNotFoundException ex) {
                Mensagem.mensagemErroClassNotFound(this);
            } catch (SQLException ex) {
                Mensagem.mensagemErroSQLException(this);
                ex.printStackTrace();
            }
            
            bSalvar.setEnabled(false);
            visibilidade(false);
            limparDados();
        }

    }//GEN-LAST:event_bSalvarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAlterar;
    private javax.swing.JButton bExcluir;
    private javax.swing.JButton bFechar;
    private javax.swing.JButton bNovo;
    private javax.swing.JButton bSalvar;
    private javax.swing.JFormattedTextField campoCel;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JFormattedTextField campoFax;
    private javax.swing.JTextField campoMSN;
    private javax.swing.JTextField campoNome;
    private javax.swing.JFormattedTextField campoRamal1;
    private javax.swing.JFormattedTextField campoRamal2;
    private javax.swing.JFormattedTextField campoRamal3;
    private javax.swing.JTextField campoSkype;
    private javax.swing.JFormattedTextField campoTel1;
    private javax.swing.JFormattedTextField campoTel2;
    private javax.swing.JFormattedTextField campoTel3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel parceiroAtual;
    private javax.swing.JTable tabelaContato;
    // End of variables declaration//GEN-END:variables
}
