package view.parceiro;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.parceiro.TableModelEnderecos;
import Persistencia.Conectar;
import Persistencia.parceiro.ParceirosService;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.text.MaskFormatter;
import model.parceiro.Endereco;
import model.Mensagem;
import model.parceiro.ParceiroComercial;

public class JanEnderecos extends javax.swing.JFrame {

    private ParceiroComercial parceiro;
    private static TableModelEnderecos modelo;
    private MaskFormatter mascaraCEP;
    private Endereco atual;
    private JanCadCompromisso janComp;

    public JanEnderecos(ParceiroComercial atual) {
        super("..:: Endereços ::..");
        this.parceiro = atual;

        try {
            mascaraCEP = new MaskFormatter("#####-###");
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

        if (parceiro.getEnderecos().size() > 0) {
            modelo = new TableModelEnderecos(parceiro.getEnderecos());
        } else {
            modelo = new TableModelEnderecos();
        }

        tabelaEndereco.setModel(modelo);
        
        try {
            // TODO add your handling code here:
            campoCidade.removeAllItems();
            ArrayList<String> cidades = ParceirosService.preencherCidade(campoEstado.getSelectedItem().toString());
            
            for(String cid : cidades){
                campoCidade.addItem(cid);
            }
            
        }  catch (ClassNotFoundException ex) {
            Mensagem.mensagemErroClassNotFound(this);
        } catch (SQLException ex) {
            Mensagem.mensagemErroSQLException(this);
            ex.printStackTrace();
        }
    }
    
        public JanEnderecos(JanCadCompromisso janComp) {
        super("..:: Endereços ::..");
        this.janComp = janComp;

        try {
            mascaraCEP = new MaskFormatter("#####-###");
        } catch (Exception e) {
        }
        
        
        initComponents();
        setLocationRelativeTo(null);
        bSalvar.setEnabled(false);
        bAlterar.setEnabled(false);
        bExcluir.setEnabled(false);
        visibilidade(false);

        parceiroAtual.setVisible(false);
        try {
            modelo = new TableModelEnderecos(ParceirosService.buscarEnderecoAll());
                    tabelaEndereco.setModel(modelo);
        } catch (ClassNotFoundException ex) {
            Mensagem.mensagemErroClassNotFound(this);
            ex.printStackTrace();
        } catch (SQLException ex) {
            Mensagem.mensagemErroSQLException(this);
            ex.printStackTrace();
        }

        
        try {
            // TODO add your handling code here:
            campoCidade.removeAllItems();
            ArrayList<String> cidades = ParceirosService.preencherCidade(campoEstado.getSelectedItem().toString());
            
            for(String cid : cidades){
                campoCidade.addItem(cid);
            }
            
        }  catch (ClassNotFoundException ex) {
            Mensagem.mensagemErroClassNotFound(this);
        } catch (SQLException ex) {
            Mensagem.mensagemErroSQLException(this);
            ex.printStackTrace();
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        bExcluir = new javax.swing.JButton();
        bAlterar = new javax.swing.JButton();
        bNovo = new javax.swing.JButton();
        bFechar = new javax.swing.JButton();
        bSalvar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campoEstado = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        campoCidade = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        campoBairro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoLogradouro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        campoComplemento = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campoNumero = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        campoCEP = new javax.swing.JFormattedTextField(mascaraCEP);
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEndereco = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        parceiroAtual = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));

        jLabel1.setText("Tipo de Endereço");

        campoNome.setBackground(new java.awt.Color(255, 255, 153));

        jLabel2.setText("Estado");

        campoEstado.setBackground(new java.awt.Color(255, 255, 153));
        campoEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "São", "SP", "SE", "TO" }));
        campoEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                campoEstadoItemStateChanged(evt);
            }
        });

        jLabel3.setText("Cidade");

        campoCidade.setBackground(new java.awt.Color(255, 255, 153));
        campoCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Bairro");

        campoBairro.setBackground(new java.awt.Color(255, 255, 153));

        jLabel5.setText("Logradouro");

        campoLogradouro.setBackground(new java.awt.Color(255, 255, 153));

        jLabel6.setText("Complemento");

        jLabel7.setText("Numero");

        campoNumero.setBackground(new java.awt.Color(255, 255, 153));

        jLabel11.setText("CEP");

        campoCEP.setBackground(new java.awt.Color(255, 255, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNome, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCidade, 0, 425, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoLogradouro, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(campoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(campoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(campoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelaEndereco.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEnderecoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaEndereco);

        jLabel13.setText("Endereços para o parceiro:");

        parceiroAtual.setFont(new java.awt.Font("sansserif", 1, 12));
        parceiroAtual.setText(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(parceiroAtual))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (janComp == null) {
            JanParceirosComerciais.getInstance().setEnabled(true);
            this.dispose();
        } else {
            janComp.setEnabled(true);
            janComp.requestFocus();

        }
    }//GEN-LAST:event_formWindowClosing

    private void bExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirActionPerformed
        // TODO add your handling code here:
        try {
            atual.setDeletado(true);
            ParceirosService.atualizarEndereco(atual);            
            modelo.removeEndereco(atual);
            parceiro.getEnderecos().remove(atual);
        } catch (ClassNotFoundException ex) {
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

    private void bAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAlterarActionPerformed
        // TODO add your handling code here:
        if (verificarDados()) {
            try {
                atual.setTipoEndereco(campoNome.getText());
                atual.setEstado(campoEstado.getSelectedItem().toString());
                atual.setCidade(campoCidade.getSelectedItem().toString());
                atual.setBairro(campoBairro.getText());
                atual.setCep(campoCEP.getText());
                atual.setLogradouro(campoLogradouro.getText());
                atual.setComplemento(campoComplemento.getText());
                atual.setNumero(Integer.parseInt(campoNumero.getText()));
                ParceirosService.atualizarEndereco(atual);
                bAlterar.setEnabled(false);
                bExcluir.setEnabled(false);
                visibilidade(false);
                limparDados();
                Mensagem.mensagemSucesso(this, "Endereço alterado com sucesso");
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
        if (janComp == null) {
            JanParceirosComerciais.getInstance().setEnabled(true);
            this.dispose();
        } else {
            janComp.setEnabled(true);
            janComp.requestFocus();

        }
        this.dispose();
}//GEN-LAST:event_bFecharActionPerformed

    private void bSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalvarActionPerformed
        // TODO add your handling code here:
        if (verificarDados()) {
            try {
                Endereco novo = new Endereco(campoNome.getText(), campoBairro.getText(), campoLogradouro.getText(), campoComplemento.getText(), campoCEP.getText(), campoEstado.getSelectedItem().toString(), campoCidade.getSelectedItem().toString(), Integer.parseInt(campoNumero.getText()));
                int id;
                id = ParceirosService.inserirEndereco(novo);
                novo.setId(id);
                
                modelo.addEndereco(novo);

                                if (janComp == null) {
                    ParceirosService.inserirRelacaoEndereco(id, parceiro.getId());
                    parceiro.addEndereco(novo);
                }

            } catch (ClassNotFoundException ex) {
                Mensagem.mensagemErroClassNotFound(this);
            } catch (SQLException ex) {
                Mensagem.mensagemErroSQLException(this);
                ex.printStackTrace();
            }

            bSalvar.setEnabled(false);
            visibilidade(false);
            limparDados();
            Mensagem.mensagemSucesso(this, "Endereço salvo com sucesso");
        }
    }//GEN-LAST:event_bSalvarActionPerformed

    private void tabelaEnderecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEnderecoMouseClicked
        // TODO add your handling code here:
        atual = modelo.getEndereco(tabelaEndereco.getSelectedRow());
        carregarDados();
        bAlterar.setEnabled(true);
        bExcluir.setEnabled(true);
        bSalvar.setEnabled(false);
        visibilidade(true);
}//GEN-LAST:event_tabelaEnderecoMouseClicked

    private void campoEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_campoEstadoItemStateChanged
        try {
            // TODO add your handling code here:
            campoCidade.removeAllItems();
            ArrayList<String> cidades = ParceirosService.preencherCidade(campoEstado.getSelectedItem().toString());
            
            for(String cid : cidades){
                campoCidade.addItem(cid);
            }
            

        }  catch (ClassNotFoundException ex) {
            Mensagem.mensagemErroClassNotFound(this);
        } catch (SQLException ex) {
            Mensagem.mensagemErroSQLException(this);
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_campoEstadoItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAlterar;
    private javax.swing.JButton bExcluir;
    private javax.swing.JButton bFechar;
    private javax.swing.JButton bNovo;
    private javax.swing.JButton bSalvar;
    private javax.swing.JTextField campoBairro;
    private javax.swing.JFormattedTextField campoCEP;
    private javax.swing.JComboBox campoCidade;
    private javax.swing.JTextField campoComplemento;
    private javax.swing.JComboBox campoEstado;
    private javax.swing.JTextField campoLogradouro;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoNumero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel parceiroAtual;
    private javax.swing.JTable tabelaEndereco;
    // End of variables declaration//GEN-END:variables

    private void visibilidade(boolean b) {
        campoBairro.setEnabled(b);
        campoCEP.setEnabled(b);
        campoEstado.setEnabled(b);
        campoCidade.setEnabled(b);
        campoComplemento.setEnabled(b);
        campoLogradouro.setEnabled(b);
        campoNome.setEnabled(b);
        campoNumero.setEnabled(b);
    }

    private void carregarDados() {
        campoBairro.setText(atual.getBairro());
        campoCEP.setText(atual.getCep());
        campoEstado.setSelectedItem(atual.getEstado());
        campoComplemento.setText(atual.getComplemento());
        campoLogradouro.setText(atual.getLogradouro());
        campoNome.setText(atual.getTipoEndereco());
        campoNumero.setText("" + atual.getNumero());
        campoCidade.setSelectedItem(atual.getCidade());
    }

    private boolean verificarDados() {
        if (campoNome.getText().equals("")) {
            Mensagem.mensagemErro(this, "Digite o tipo do endereço\nEx.: Cobrança, Entrega, Filial, Matriz");
            campoNome.requestFocus();
            return false;
        }

        if (campoBairro.getText().equals("")) {
            Mensagem.mensagemErro(this, "Digite o bairro");
            campoBairro.requestFocus();
            return false;
        }

        if (campoCEP.getText().equals("     -   ")) {
            Mensagem.mensagemErro(this, "Digite o CEP");
            campoCEP.requestFocus();
            return false;
        }

        if (campoLogradouro.getText().equals("")) {
            Mensagem.mensagemErro(this, "Digite o logradouro");
            campoLogradouro.requestFocus();
            return false;
        }

        try {
            Integer.parseInt(campoNumero.getText());
        } catch (NumberFormatException e) {
            Mensagem.mensagemErro(this, "Digite um número válido");
            campoNumero.requestFocus();
            return false;
        }
        return true;

    }

    private void limparDados() {
        campoBairro.setText("");
        campoCEP.setText("");
        campoEstado.setSelectedIndex(0);
        campoComplemento.setText("");
        campoLogradouro.setText("");
        campoNome.setText("");
        campoNumero.setText("");
    }

    public static TableModelEnderecos getModel() {
        return modelo;
    }
}
