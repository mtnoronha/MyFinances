package view.parceiro;

import view.contas.JanPlanoContas;
import Persistencia.Conectar;
import Persistencia.contas.ContasService;
import Persistencia.parceiro.ParceirosService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import model.contas.ContaParceiro;
import model.parceiro.Contato;
import model.parceiro.Endereco;
import model.Formatar;
import model.Mensagem;
import model.parceiro.ParceiroComercial;
import model.contas.PlanoContas;

public class JanCadParceirosComerciais extends javax.swing.JFrame {

    private ParceiroComercial atual;
    private MaskFormatter mascaraCPF;
    private MaskFormatter mascaraCNPJ;
    private MaskFormatter mascaraRG;

    public JanCadParceirosComerciais() {
        super("..:: Novo Parceiro ::..");
        try {
            mascaraCPF = new MaskFormatter("###.###.###-##");
            mascaraRG = new MaskFormatter("AA-##.###.###");
            mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
        } catch (Exception e) {
        }
        initComponents();
        setLocationRelativeTo(null);
        painelPessoa.setEnabledAt(1, false);
        campoNome.requestFocus();
    }

    public JanCadParceirosComerciais(ParceiroComercial p) {
        super("..:: Editar Parceiro ::..");
        this.atual = p;
        try {
            mascaraCPF = new MaskFormatter("###.###.###-##");
            mascaraRG = new MaskFormatter("AA-##.###.###");
            mascaraCNPJ = new MaskFormatter("##.###.###/####-##");

        } catch (Exception e) {
        }
        initComponents();
        setLocationRelativeTo(null);
        painelPessoa.setEnabledAt(1, false);
        carregarParceiro();
    }

    public boolean verificarDados() {
        if (!(campoCliente.isSelected()) && !(campoFornecedor.isSelected()) && !(campoFuncionario.isSelected())) {
            Mensagem.mensagemErro(this, "Selecione o tipo de parceiro comercial");
            return false;
        }

        if (campoPessoa.getSelectedItem().toString().equals("Física")) {
            if (campoNome.getText().equals("")) {
                Mensagem.mensagemErro(this, "Digite o nome deste parceiro comercial");
                campoNome.requestFocus();
                return false;
            }
        } else {
            if (campoRazao.getText().equals("")) {
                Mensagem.mensagemErro(this, "Digite a razão social deste parceiro.");
                campoRazao.requestFocus();
                return false;
            }
        }

        return true;

    }

    public void carregarParceiro() {
        if (!atual.isCliente()) {
            campoCliente.setSelected(false);
        }

        if (atual.isFornecedor()) {
            campoFornecedor.setSelected(true);
        }

        if (atual.isFuncionario()) {
            campoFuncionario.setSelected(true);
        }

        campoInforAdd.setText(atual.getDadosAdicionais());

        if (atual.isFisica()) {
            campoNome.setText(atual.getNome());
            campoCPF.setText(atual.getCpf());
            campoRG.setText(atual.getRg());
            campoNascimento.setDate(atual.getDataNascimento());
        } else {
            painelPessoa.setEnabledAt(0, false);
            painelPessoa.setEnabledAt(1, true);
            painelPessoa.setSelectedIndex(1);
            campoPessoa.setSelectedIndex(1);
            campoCNPJ.setText(atual.getCnpj());
            campoRazao.setText(atual.getRazaoSocial());
            campoNomeFantasia.setText(atual.getNomeFantasia());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoPessoa = new javax.swing.JComboBox();
        campoCliente = new javax.swing.JCheckBox();
        campoFuncionario = new javax.swing.JCheckBox();
        campoFornecedor = new javax.swing.JCheckBox();
        painelPessoa = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        campoCPF = new javax.swing.JFormattedTextField(mascaraCPF);
        campoRG = new javax.swing.JFormattedTextField(mascaraRG);
        campoNascimento = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        campoRazao = new javax.swing.JTextField();
        campoNomeFantasia = new javax.swing.JTextField();
        campoCNPJ = new javax.swing.JFormattedTextField(mascaraCNPJ);
        jLabel6 = new javax.swing.JLabel();
        JScrollPane23 = new javax.swing.JScrollPane();
        campoInforAdd = new javax.swing.JTextArea();
        bSalvar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Pessoa");

        campoPessoa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Física", "Jurídica" }));
        campoPessoa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                campoPessoaItemStateChanged(evt);
            }
        });

        campoCliente.setSelected(true);
        campoCliente.setText("Cliente");

        campoFuncionario.setText("Funcionário");

        campoFornecedor.setText("Fornecedor");

        painelPessoa.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painelPessoa.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jLabel2.setText("Nome");

        jLabel3.setText("CPF");

        jLabel4.setText("RG");

        jLabel5.setText("Data Nasc.");

        campoNome.setBackground(new java.awt.Color(255, 255, 153));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoNome, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campoRG, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(campoCPF, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(campoRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(campoNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        painelPessoa.addTab("Física", jPanel4);

        jLabel7.setText("Razão Social");

        jLabel8.setText("Nome Fantasia");

        jLabel9.setText("CNPJ");

        campoRazao.setBackground(new java.awt.Color(255, 255, 153));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoRazao, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addComponent(campoNomeFantasia, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(campoRazao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(campoNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(campoCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        painelPessoa.addTab("Jurídica", jPanel5);

        jLabel6.setText("Informações Adicionais");

        campoInforAdd.setColumns(20);
        campoInforAdd.setRows(5);
        JScrollPane23.setViewportView(campoInforAdd);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(campoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(campoFuncionario)
                                .addGap(18, 18, 18)
                                .addComponent(campoCliente))
                            .addComponent(campoFornecedor))
                        .addContainerGap(86, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(painelPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(481, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoFuncionario)
                        .addComponent(campoCliente)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoFornecedor))
                .addGap(18, 18, 18)
                .addComponent(painelPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(bSalvar))
                .addGap(34, 34, 34))
        );

        jTabbedPane1.addTab("Identificação", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoPessoaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_campoPessoaItemStateChanged
        // TODO add your handling code here:
        if (campoPessoa.getSelectedItem().toString().equals("Física")) {
            painelPessoa.setEnabledAt(0, true);
            painelPessoa.setEnabledAt(1, false);
            painelPessoa.setSelectedIndex(0);
        } else {
            painelPessoa.setEnabledAt(0, false);
            painelPessoa.setEnabledAt(1, true);
            painelPessoa.setSelectedIndex(1);
        }
    }//GEN-LAST:event_campoPessoaItemStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        fechar();
    }//GEN-LAST:event_formWindowClosing

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        // TODO add your handling code here:
fechar();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalvarActionPerformed
        // TODO add your handling code here:
        if (verificarDados()) {

            java.sql.Date data = null;

            try {
                data = new java.sql.Date(campoNascimento.getDate().getTime());
            } catch (Exception e) {
            }


            if (atual == null) {
                ParceiroComercial novo;
                //novo cliente
                if (campoPessoa.getSelectedItem().toString().equals("Física")) {
                    novo = new ParceiroComercial(campoFuncionario.isSelected(), campoFornecedor.isSelected(), campoCliente.isSelected(), campoInforAdd.getText(), campoNome.getText(), campoRG.getText(), campoCPF.getText(), data);
                } else {
                    novo = new ParceiroComercial(campoFuncionario.isSelected(), campoFornecedor.isSelected(), campoCliente.isSelected(), campoInforAdd.getText(), campoCNPJ.getText(), campoRazao.getText(), campoNomeFantasia.getText());
                }

                //verificar se ele já existe...
                ParceiroComercial recuperado = JanParceirosComerciais.getInstance().modelo.getParceiroCnpjRgCpf(novo);
                if (recuperado == null) {
                    try {
                        int id = 0;
                        id = ParceirosService.inserirParceiro(novo);
                        novo.setId(id);
                        criarPlanoContas(novo);
                        JanParceirosComerciais.getInstance().modelo.addParceiroComercial(novo);
                        fechar();
                        Mensagem.mensagemSucesso(this, "Parceiro adicionado com sucesso!");
                    } catch (ClassNotFoundException ex) {
                        Mensagem.mensagemErroClassNotFound(this);
                    } catch (SQLException ex) {
                        Mensagem.mensagemErroSQLException(this);
                        ex.printStackTrace();
                    }
                } else {
                    if (recuperado.isDeletado()) {
                        int resp = Mensagem.mensagemYesNo(this, "Parceiro já cadastrado. Deseja recupera-lo?");

                        //se for SIM - YES
                        if (resp == 0) {
                            try {
                                recuperado.setDeletado(false);

                                ParceirosService.atualizarParceiro(recuperado);
                                JanParceirosComerciais.getInstance().modelo.filtrar("","All");
                                Mensagem.mensagemSucesso(this, "Parceiro recuperado com sucesso!");
                                JanParceirosComerciais.getInstance().setEnabled(true);
                                JanParceirosComerciais.getInstance().requestFocus();
                        fechar();
                            } catch (ClassNotFoundException ex) {
                                Mensagem.mensagemErroClassNotFound(this);
                            } catch (SQLException ex) {
                                Mensagem.mensagemErroSQLException(this);
                                ex.printStackTrace();
                            }

                        }
                    } else {
                        Mensagem.mensagemErro(this, "Este Parceiro já está cadastrado!");
                    }
                }



            } else {
                try {
                    //editando cliente
                    atual.setFuncionario(campoFuncionario.isSelected());
                    atual.setFornecedor(campoFornecedor.isSelected());
                    atual.setCliente(campoCliente.isSelected());
                    atual.setDadosAdicionais(campoInforAdd.getText());


                    if (campoPessoa.getSelectedItem().toString().equals("Física")) {
                        atual.setNome(campoNome.getText());
                        atual.setRg(campoRG.getText());
                        atual.setCpf(campoCPF.getText());
                        atual.setDataNascimento(data);
                        atual.setFisica(true);
                    } else {
                        atual.setCnpj(campoCNPJ.getText());
                        atual.setRazaoSocial(campoRazao.getText());
                        atual.setNomeFantasia(campoNomeFantasia.getText());
                        atual.setFisica(false);
                    }

                    ParceirosService.atualizarParceiro(atual);
                    JanParceirosComerciais.getInstance().modelo.filtrar("","All");
                    Mensagem.mensagemSucesso(this, "Parceiro alterado com sucesso!");
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPane23;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bSalvar;
    private javax.swing.JFormattedTextField campoCNPJ;
    private javax.swing.JFormattedTextField campoCPF;
    private javax.swing.JCheckBox campoCliente;
    private javax.swing.JCheckBox campoFornecedor;
    private javax.swing.JCheckBox campoFuncionario;
    private javax.swing.JTextArea campoInforAdd;
    private com.toedter.calendar.JDateChooser campoNascimento;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoNomeFantasia;
    private javax.swing.JComboBox campoPessoa;
    private javax.swing.JFormattedTextField campoRG;
    private javax.swing.JTextField campoRazao;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane painelPessoa;
    // End of variables declaration//GEN-END:variables

    private void fechar() {
        JanParceirosComerciais.getInstance().setEnabled(true);
        JanParceirosComerciais.getInstance().requestFocus();
        this.dispose();
    }


    private void criarPlanoContas(ParceiroComercial novo) throws ClassNotFoundException, SQLException {
        String nome;
        if (novo.isFisica()) {
            nome = novo.getNome().toUpperCase();
        }else{
            nome = novo.getRazaoSocial().toUpperCase();
        }
            if (novo.isCliente()) {
                int ultimo = ContasService.selecionarNum(ContasService.CLI);
                String conta = "1010201"+Formatar.formatarCasas(ultimo);
                PlanoContas novaConta = new PlanoContas(conta, nome, "ATIVO");
                int codRed = ContasService.inserirPlanoContas(novaConta);
                novaConta.setCodigoReduzido(codRed);
                JanPlanoContas.getInstance().modelo.addPlanoContas(novaConta);
                JanPlanoContas.getInstance().modelo.filtrar("");
                ContaParceiro cp = new ContaParceiro(novo.getId(), conta, "Cliente");
                ContasService.inserirContaParceiro(cp);
                
            }

            if (novo.isFornecedor()) {
                int ultimo = ContasService.selecionarNum(ContasService.FOR);
                String conta = "2010301"+Formatar.formatarCasas(ultimo);
                PlanoContas novaConta = new PlanoContas(conta, nome, "PASSIVO");
                int codRed = ContasService.inserirPlanoContas(novaConta);
                novaConta.setCodigoReduzido(codRed);
                JanPlanoContas.getInstance().modelo.addPlanoContas(novaConta);
                JanPlanoContas.getInstance().modelo.filtrar("");
                                ContaParceiro cp = new ContaParceiro(novo.getId(), conta, "Fornecedor");
                ContasService.inserirContaParceiro(cp);
            }

            if (novo.isFuncionario()) {
                int ultimo = ContasService.selecionarNum(ContasService.FUN);
                String conta = "2010302"+Formatar.formatarCasas(ultimo);
                PlanoContas novaConta = new PlanoContas(conta, nome, "PASSIVO");
                int codRed = ContasService.inserirPlanoContas(novaConta);
                novaConta.setCodigoReduzido(codRed);
                JanPlanoContas.getInstance().modelo.addPlanoContas(novaConta);
                JanPlanoContas.getInstance().modelo.filtrar("");
                ContaParceiro cp = new ContaParceiro(novo.getId(), conta, "Funcionario");
                ContasService.inserirContaParceiro(cp);
            }
        
    }
}
