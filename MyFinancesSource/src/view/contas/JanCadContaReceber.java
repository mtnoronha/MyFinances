package view.contas;

import Persistencia.contas.ContasService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import model.contas.ContaParceiro;
import model.contas.ContaReceber;
import model.Formatar;
import model.contas.HistoricoPadrao;
import model.contas.Lancamento;
import model.Mensagem;
import model.parceiro.ParceiroComercial;
import model.contas.PlanoContas;
import view.parceiro.JanCadParceirosComerciais;
import view.parceiro.JanPesquisaParceiro;
import view.JanPrincipal;

public class JanCadContaReceber extends javax.swing.JFrame {

    ParceiroComercial clienteAtual;
    ContaReceber atual;
    String lembrete;
    HistoricoPadrao historicoPadrao;
    PlanoContas contaCredito;
    PlanoContas contaDebito;

    public JanCadContaReceber() {
        super("..:: Conta a receber ::..");
        initComponents();
        setLocationRelativeTo(null);
        campoData.setDate(new Date());
        campoVencimento.setDate(new Date());
        labelDataRec.setVisible(false);
        campoDataRecebimento.setVisible(false);
    }

    public JanCadContaReceber(ContaReceber a) {
        super("..:: Conta a receber ::..");
        initComponents();
        atual = a;

        setLocationRelativeTo(null);
        carregarConta();
    }

    public JanCadContaReceber(ContaReceber a, String t) {
        super("..:: Conta a receber ::..");
        initComponents();
        atual = a;
        lembrete = t;

        setLocationRelativeTo(null);
        carregarConta();
    }

    private void carregarConta() {
        this.arrumarCliente(atual.getParceiro());
        campoData.setDate(atual.getData());
        campoVencimento.setDate(atual.getVencimento());
        campoObs.setText(atual.getObs());
        campoValor.setText("" + atual.getValor());
        campoRecebido.setSelected(atual.isRecebido());
        campoData.setEnabled(false);
        campoVencimento.setEnabled(false);
        campoObs.setEnabled(false);
        campoValor.setEnabled(false);
        bProcurar.setEnabled(false);
        bNovo.setEnabled(false);
        bProcurarContaCredito.setEnabled(false);
        bProcurarHistoricoPadrao.setEnabled(false);


        if (!campoRecebido.isSelected()) {
            labelDataRec.setVisible(false);
            campoDataRecebimento.setVisible(false);

        } else {
            campoDataRecebimento.setDate(atual.getDataRecebimento());
            campoDataRecebimento.setEnabled(false);
            campoRecebido.setEnabled(false);
        }

        arrumarHistPadrao(JanHistoricoPadrao.modelo.getHistoricoPadraoId(atual.getIdHistoricoPadrao()));
        //arrumarContaDebito(JanPlanoContas.modelo.getPlanoContas(atual.getContaDebito()));
        arrumarConta(JanPlanoContas.modelo.getPlanoContas(atual.getContaCredito()));

        
        campoRecebido.requestFocus();
                    campoHistoricoPadrao.setEditable(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bNovo = new javax.swing.JButton();
        bProcurar = new javax.swing.JButton();
        campoCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        campoData = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        campoValor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoObs = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        campoVencimento = new com.toedter.calendar.JDateChooser();
        campoRecebido = new javax.swing.JCheckBox();
        labelDataRec = new javax.swing.JLabel();
        campoDataRecebimento = new com.toedter.calendar.JDateChooser();
        bSalvar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        campoIdContaDebito = new javax.swing.JTextField();
        campoDescContaDebito = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoIdContaCredito = new javax.swing.JTextField();
        campoDescContaCredito = new javax.swing.JTextField();
        bProcurarContaCredito = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        campoHistoricoPadrao = new javax.swing.JTextField();
        bProcurarHistoricoPadrao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        bNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/add.png"))); // NOI18N
        bNovo.setToolTipText("Novo Parceiro Comercial");
        bNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovoActionPerformed(evt);
            }
        });

        bProcurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/find.png"))); // NOI18N
        bProcurar.setToolTipText("Procurar Parceiro Comercial");
        bProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bProcurarActionPerformed(evt);
            }
        });

        campoCliente.setBackground(new java.awt.Color(255, 255, 153));
        campoCliente.setEditable(false);
        campoCliente.setText("Clique em Procurar e selecione o Cliente...");

        jLabel1.setText("Cliente");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da Conta"));

        jLabel6.setText("Data de entrada");

        campoData.setBackground(new java.awt.Color(255, 255, 153));

        jLabel2.setText("Valor");

        campoValor.setBackground(new java.awt.Color(255, 255, 153));

        jLabel3.setText("Observação");

        campoObs.setColumns(20);
        campoObs.setRows(5);
        jScrollPane1.setViewportView(campoObs);

        jLabel7.setText("Vencimento");

        campoVencimento.setBackground(new java.awt.Color(255, 255, 153));

        campoRecebido.setText("Recebido");
        campoRecebido.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                campoRecebidoItemStateChanged(evt);
            }
        });

        labelDataRec.setText("Data Recebimento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(28, 28, 28))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelDataRec)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoDataRecebimento, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(campoVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(campoRecebido))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(campoVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelDataRec))
                    .addComponent(campoDataRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(campoRecebido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/salvar.png"))); // NOI18N
        bSalvar.setText("Salvar");
        bSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalvarActionPerformed(evt);
            }
        });

        bCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/cancelar.png"))); // NOI18N
        bCancelar.setText("Cancelar");
        bCancelar.setMaximumSize(new java.awt.Dimension(98, 44));
        bCancelar.setMinimumSize(new java.awt.Dimension(98, 44));
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Plano de Contas"));

        jLabel4.setText("Conta Débito");

        campoIdContaDebito.setBackground(new java.awt.Color(255, 255, 153));
        campoIdContaDebito.setEditable(false);

        campoDescContaDebito.setBackground(new java.awt.Color(255, 255, 153));
        campoDescContaDebito.setEditable(false);
        campoDescContaDebito.setText("Selecione o cliente...");

        jLabel5.setText("Conta Credito");

        campoIdContaCredito.setBackground(new java.awt.Color(255, 255, 153));
        campoIdContaCredito.setEditable(false);

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

        jLabel8.setText("Histórico Padrão");

        campoHistoricoPadrao.setBackground(new java.awt.Color(255, 255, 153));

        bProcurarHistoricoPadrao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/find.png"))); // NOI18N
        bProcurarHistoricoPadrao.setToolTipText("Procurar Histórico Padrão");
        bProcurarHistoricoPadrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bProcurarHistoricoPadraoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(campoIdContaCredito, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoIdContaDebito, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoDescContaCredito, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                            .addComponent(campoDescContaDebito, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bProcurarContaCredito))
                    .addComponent(jLabel8)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(campoHistoricoPadrao, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bProcurarHistoricoPadrao)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoIdContaDebito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDescContaDebito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoIdContaCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoDescContaCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bProcurarContaCredito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoHistoricoPadrao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bProcurarHistoricoPadrao))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(bProcurar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bNovo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(bNovo)
                    .addComponent(bProcurar))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSalvar)
                    .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoActionPerformed
        // TODO add your handling code here:
        JanCadParceirosComerciais jan = new JanCadParceirosComerciais();
        jan.setVisible(true);
}//GEN-LAST:event_bNovoActionPerformed

    private void bProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProcurarActionPerformed
        // TODO add your handling code here:
        JanPesquisaParceiro pesq = new JanPesquisaParceiro(this, "Cliente");
        pesq.setVisible(true);
        this.setEnabled(false);
}//GEN-LAST:event_bProcurarActionPerformed

    private void bSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalvarActionPerformed
        // TODO add your handling code here:
        if (verificarDados()) {
            if (atual == null) {
                java.sql.Date data = null;
                java.sql.Date dataVenc = null;
                java.sql.Date dataRec = null;

                ContaReceber novo;
                try {
                    data = new java.sql.Date(campoData.getDate().getTime());
                    dataVenc = new java.sql.Date(campoVencimento.getDate().getTime());

                } catch (Exception e) {
                }

                try {
                    dataRec = new java.sql.Date(campoDataRecebimento.getDate().getTime());
                } catch (Exception e) {
                }

                novo = new ContaReceber(clienteAtual, data, Double.parseDouble(campoValor.getText().replace(",", ".")), campoObs.getText(), dataVenc, campoRecebido.isSelected(), dataRec, historicoPadrao.getId(), contaCredito.getConta(), contaDebito.getConta());


                try {
                    int id = 0;
                    id = ContasService.inserirContaReceber(novo);
                    novo.setId(id);
                    JanContaReceber.getInstance().modelo.addContaReceber(novo);
                    criarLancamento();
                    Mensagem.mensagemSucesso(this, "Conta à receber criada com sucesso!");
                    fechar();
                } catch (ClassNotFoundException ex) {
                    Mensagem.mensagemErroClassNotFound(this);
                } catch (SQLException ex) {
                    Mensagem.mensagemErroSQLException(this);
                    ex.printStackTrace();
                }
            } else {
                //atualizar

                try {
                    atual.setRecebido(campoRecebido.isSelected());
                    java.sql.Date dataRec = null;
                    try {
                        dataRec = new java.sql.Date(campoDataRecebimento.getDate().getTime());
                    } catch (Exception e) {
                    }

                    atual.setDataRecebimento(dataRec);
                    ContasService.atualizarContaReceber(atual);
                    if(atual.isRecebido()){
                    criarLancamentoFinal();
                    }
                    Mensagem.mensagemSucesso(this, "Conta atualizada com sucesso!");
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

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        fechar();
    }//GEN-LAST:event_formWindowClosing

    private void campoRecebidoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_campoRecebidoItemStateChanged
        // TODO add your handling code here:
        try{
            if (campoRecebido.isSelected()) {
                labelDataRec.setVisible(true);
                campoDataRecebimento.setDate(campoVencimento.getDate());
                campoDataRecebimento.setVisible(true);
                contaDebito = contaCredito;
                contaCredito = JanPlanoContas.modelo.getPlanoContas("101010100001");
                bProcurarContaCredito.setEnabled(false);
                setarContaDebito();
                setarContaCredito();
            } else {
                labelDataRec.setVisible(false);
                campoDataRecebimento.setVisible(false);
//                contaCredito = null;
                
                contaCredito = contaDebito;
                setarCliente();
                setarContaCredito();
//                campoIdContaCredito.setText("");
//                campoDescContaCredito.setText("");
                bProcurarContaCredito.setEnabled(true);
            }
        }catch(Exception e){
                        if (campoRecebido.isSelected()) {
                bProcurarContaCredito.setEnabled(false);
                        }else{
                bProcurarContaCredito.setEnabled(true);
                        }
        }
    }//GEN-LAST:event_campoRecebidoItemStateChanged

    private void bProcurarContaCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProcurarContaCreditoActionPerformed
        // TODO add your handling code here:
        JanPesquisaPlanoConta j = new JanPesquisaPlanoConta(this);
        j.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_bProcurarContaCreditoActionPerformed

    private void bProcurarHistoricoPadraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProcurarHistoricoPadraoActionPerformed
        // TODO add your handling code here:
        
                JanPesquisaHistoricoPadrao jan = new JanPesquisaHistoricoPadrao(this);
        jan.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_bProcurarHistoricoPadraoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bNovo;
    private javax.swing.JButton bProcurar;
    private javax.swing.JButton bProcurarContaCredito;
    private javax.swing.JButton bProcurarHistoricoPadrao;
    private javax.swing.JButton bSalvar;
    private javax.swing.JTextField campoCliente;
    private com.toedter.calendar.JDateChooser campoData;
    private com.toedter.calendar.JDateChooser campoDataRecebimento;
    private javax.swing.JTextField campoDescContaCredito;
    private javax.swing.JTextField campoDescContaDebito;
    private javax.swing.JTextField campoHistoricoPadrao;
    private javax.swing.JTextField campoIdContaCredito;
    private javax.swing.JTextField campoIdContaDebito;
    private javax.swing.JTextArea campoObs;
    private javax.swing.JCheckBox campoRecebido;
    private javax.swing.JTextField campoValor;
    private com.toedter.calendar.JDateChooser campoVencimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDataRec;
    // End of variables declaration//GEN-END:variables

    private void setarCliente() {
        if (clienteAtual.isFisica()) {
            campoCliente.setText(clienteAtual.getNome());
            arrumarContaDebito();
        } else {
            campoCliente.setText(clienteAtual.getRazaoSocial());
            arrumarContaDebito();
        }
    }

    public void arrumarCliente(ParceiroComercial parceiroComercial) {
        clienteAtual = parceiroComercial;
        setarCliente();

    }

    private boolean verificarDados() {
        if (clienteAtual == null) {
            Mensagem.mensagemErro(this, "Selecione o Cliente");
            bProcurar.requestFocus();
            return false;

        }

        try {
            java.sql.Date data = new java.sql.Date(campoData.getDate().getTime());

        } catch (Exception e) {
            Mensagem.mensagemErro(this, "Escolha a data");
            campoData.requestFocus();
            return false;
        }

        try {
            java.sql.Date data2 = new java.sql.Date(campoVencimento.getDate().getTime());

        } catch (Exception e) {
            Mensagem.mensagemErro(this, "Escolha a data do vencimento");
            campoVencimento.requestFocus();
            return false;
        }

        if (campoRecebido.isSelected()) {
            try {
                java.sql.Date data2 = new java.sql.Date(campoDataRecebimento.getDate().getTime());

            } catch (Exception e) {
                Mensagem.mensagemErro(this, "Escolha a data do recebimento");
                campoDataRecebimento.requestFocus();
                return false;
            }
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
        
          if(contaCredito == null){
            Mensagem.mensagemErro(this, "Selecione a conta a ser creditada.");
            campoIdContaCredito.requestFocus();
            return false;            
        }
        
             if(contaDebito == null){
            Mensagem.mensagemErro(this, "Selecione a conta a ser debitada.");
            campoIdContaDebito.requestFocus();
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
        
        return true;
    }

    private void fechar() {
        if (lembrete != null) {           
            JanLembretes.getInstance(JanPrincipal.alterarConta).setEnabled(true);
            JanLembretes.getInstance(JanPrincipal.alterarConta).requestFocus();
            this.dispose();
        } else {
            JanContaReceber.getInstance().modelo.filtrar("");
            JanContaReceber.getInstance().setEnabled(true);
            JanContaReceber.getInstance().requestFocus();
            this.dispose();
        }
    }
       void arrumarHistPadrao(HistoricoPadrao historicoPadrao) {
        this.historicoPadrao = historicoPadrao;
        setarHistoricoPadrao();
    }

    private void setarHistoricoPadrao() {
        campoHistoricoPadrao.setText(historicoPadrao.getDescricao());
    }

    void arrumarConta(PlanoContas planoContas) {
        this.contaCredito = planoContas;
        setarContaCredito();
    }

    private void setarContaCredito() {
        campoIdContaCredito.setText(Formatar.formatPlanoContas(contaCredito.getConta()));
        campoDescContaCredito.setText(contaCredito.getDescricao());
    }
    
    void arrumarContaDebito(PlanoContas planoContas) {
        this.contaDebito = planoContas;
        setarContaDebito();
    }

    private void setarContaDebito() {
        campoIdContaDebito.setText(Formatar.formatPlanoContas(contaDebito.getConta()));
        campoDescContaDebito.setText(contaDebito.getDescricao());
    }

    private void criarLancamento() throws ClassNotFoundException, SQLException {
        Lancamento lan = null;
        lan = new Lancamento(historicoPadrao.getId(), contaCredito.getConta(), contaDebito.getConta(), new java.sql.Date(campoData.getDate().getTime()), Double.parseDouble(campoValor.getText().replace(",", ".")));            
               
        ContasService.inserirLancamento(lan);
    }

    private void criarLancamentoFinal() throws ClassNotFoundException, SQLException {
        Lancamento lan = new Lancamento(historicoPadrao.getId(),  contaCredito.getConta(), contaDebito.getConta(), new java.sql.Date(campoDataRecebimento.getDate().getTime()), Double.parseDouble(campoValor.getText().replace(",", ".")));
        ContasService.inserirLancamento(lan);
    }

    private void arrumarContaDebito() {
         ArrayList<ContaParceiro> c;
        
        try {
            c = ContasService.getContaParceiro(clienteAtual.getId());
            
            for(ContaParceiro cp : c){   
                if(cp.getTipoDaConta().equals("Cliente")){
                arrumarContaDebito(JanPlanoContas.modelo.getPlanoContas(cp.getConta()));
                break;
                }
            }
            
        } catch (ClassNotFoundException ex) {
           Mensagem.mensagemErroClassNotFound(this);
        } catch (SQLException ex) {
            Mensagem.mensagemErroSQLException(this);
        }
    }
}
