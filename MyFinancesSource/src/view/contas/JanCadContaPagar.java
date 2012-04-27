package view.contas;

import Persistencia.contas.ContasService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import model.contas.ContaPagar;
import model.contas.ContaParceiro;
import model.Formatar;
import model.contas.HistoricoPadrao;
import model.contas.Lancamento;
import model.Mensagem;
import model.parceiro.ParceiroComercial;
import model.contas.PlanoContas;
import view.parceiro.JanCadParceirosComerciais;
import view.parceiro.JanPesquisaParceiro;
import view.JanPrincipal;

public class JanCadContaPagar extends javax.swing.JFrame {

    ParceiroComercial clienteAtual;
    ContaPagar atual;
    String lembrete;
    HistoricoPadrao historicoPadrao;
    PlanoContas contaDebito;
    PlanoContas contaCredito;

    
    public JanCadContaPagar() {
        super("..:: Conta a pagar ::..");
        initComponents();
        setLocationRelativeTo(null);
        campoData.setDate(new Date());
        campoVencimento.setDate(new Date());
        labelPagamento.setVisible(false);
        campoDataPagamento.setVisible(false);
    }

    public JanCadContaPagar(ContaPagar a) {
        super("..:: Conta a pagar ::..");
        initComponents();
        atual = a;
        
        setLocationRelativeTo(null);
        carregarConta();
    }
    
     public JanCadContaPagar(ContaPagar a,String t) {
        super("..:: Conta a pagar ::..");
        initComponents();
        atual = a;
        lembrete = t;
        
        setLocationRelativeTo(null);
        carregarConta();
    }
        
        private void carregarConta(){
            this.arrumarCliente(atual.getParceiro());
            campoData.setDate(atual.getData());
            campoVencimento.setDate(atual.getVencimento());
            campoObs.setText(atual.getObs());
            campoValor.setText(""+atual.getValor());
            campoPago.setSelected(atual.isPago());
            campoData.setEnabled(false);
            campoVencimento.setEnabled(false);
            campoObs.setEnabled(false);
            campoValor.setEnabled(false);
            bProcurar.setEnabled(false);
            bNovo.setEnabled(false);
            bProcurarHistoricoPadrao1.setEnabled(false);
            bProcurarContaDebito1.setEnabled(false);
            
            if(!campoPago.isSelected()){
            labelPagamento.setVisible(false);
            campoDataPagamento.setVisible(false);
            }else{
                campoDataPagamento.setDate(atual.getDataPagamento());        
                campoDataPagamento.setEnabled(false);
                campoPago.setEnabled(false);

            }
                   arrumarContaCredito(JanPlanoContas.modelo.getPlanoContas(atual.getContaCredito()));
        arrumarConta(JanPlanoContas.modelo.getPlanoContas(atual.getContaDebito()));
           arrumarHistPadrao(JanHistoricoPadrao.modelo.getHistoricoPadraoId(atual.getIdHistoricoPadrao()));

            campoPago.requestFocus();          
            campoHistoricoPadrao1.setEditable(false);
        }
                
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bNovo = new javax.swing.JButton();
        bProcurar = new javax.swing.JButton();
        campoCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bSalvar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
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
        campoPago = new javax.swing.JCheckBox();
        labelPagamento = new javax.swing.JLabel();
        campoDataPagamento = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        campoIdContaDebito1 = new javax.swing.JTextField();
        campoDescContaDebito1 = new javax.swing.JTextField();
        bProcurarContaDebito1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        campoIdContaCredito1 = new javax.swing.JTextField();
        campoDescContaCredito1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        campoHistoricoPadrao1 = new javax.swing.JTextField();
        bProcurarHistoricoPadrao1 = new javax.swing.JButton();

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
        campoCliente.setText("Clique em Procurar e selecione o Parceiro...");

        jLabel1.setText("Parceiro");

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da Conta"));

        jLabel6.setText("Data");

        campoData.setBackground(new java.awt.Color(255, 255, 153));

        jLabel2.setText("Valor");

        campoValor.setBackground(new java.awt.Color(255, 255, 153));

        jLabel3.setText("Observação");

        campoObs.setColumns(20);
        campoObs.setRows(5);
        jScrollPane1.setViewportView(campoObs);

        jLabel7.setText("Vencimento");

        campoVencimento.setBackground(new java.awt.Color(255, 255, 153));

        campoPago.setText("Pago");
        campoPago.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                campoPagoItemStateChanged(evt);
            }
        });
        campoPago.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                campoPagoPropertyChange(evt);
            }
        });

        labelPagamento.setText("Data Pagamento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelPagamento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoDataPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(campoPago))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(campoVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelPagamento))
                    .addComponent(campoDataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(campoPago))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Plano de Contas"));

        jLabel9.setText("Conta Débito");

        campoIdContaDebito1.setBackground(new java.awt.Color(255, 255, 153));
        campoIdContaDebito1.setEditable(false);

        campoDescContaDebito1.setBackground(new java.awt.Color(255, 255, 153));
        campoDescContaDebito1.setEditable(false);
        campoDescContaDebito1.setText("Clique em Procurar...");

        bProcurarContaDebito1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/find.png"))); // NOI18N
        bProcurarContaDebito1.setToolTipText("Procurar Conta Débito");
        bProcurarContaDebito1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bProcurarContaDebito1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Conta Credito");

        campoIdContaCredito1.setBackground(new java.awt.Color(255, 255, 153));
        campoIdContaCredito1.setEditable(false);

        campoDescContaCredito1.setBackground(new java.awt.Color(255, 255, 153));
        campoDescContaCredito1.setEditable(false);
        campoDescContaCredito1.setText("Selecione o Parceiro...");

        jLabel11.setText("Histórico Padrão");

        campoHistoricoPadrao1.setBackground(new java.awt.Color(255, 255, 153));

        bProcurarHistoricoPadrao1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/find.png"))); // NOI18N
        bProcurarHistoricoPadrao1.setToolTipText("Procurar Histórico Padrão");
        bProcurarHistoricoPadrao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bProcurarHistoricoPadrao1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(campoIdContaCredito1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoIdContaDebito1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoDescContaCredito1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(campoDescContaDebito1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bProcurarContaDebito1))
                    .addComponent(jLabel11)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(campoHistoricoPadrao1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bProcurarHistoricoPadrao1)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bProcurarContaDebito1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoIdContaDebito1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoDescContaDebito1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoIdContaCredito1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoDescContaCredito1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoHistoricoPadrao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bProcurarHistoricoPadrao1))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(campoCliente)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bProcurar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bNovo))
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSalvar)
                    .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        JanPesquisaParceiro pesq = new JanPesquisaParceiro(this);
        pesq.setVisible(true);
        this.setEnabled(false);
}//GEN-LAST:event_bProcurarActionPerformed

    private void bSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalvarActionPerformed
        // TODO add your handling code here:
        if (verificarDados()) {
            if(atual == null){
            java.sql.Date data = null;
            java.sql.Date dataV = null;
            java.sql.Date dataP = null;
            ContaPagar novo;
            try {
                data = new java.sql.Date(campoData.getDate().getTime());
                dataV = new java.sql.Date(campoVencimento.getDate().getTime());
            } catch (Exception e) {
            }
            
            try{
                dataP = new java.sql.Date(campoDataPagamento.getDate().getTime());
            }catch(Exception e){}
            

            novo = new ContaPagar(clienteAtual, data, Double.parseDouble(campoValor.getText().replace(",", ".")), campoObs.getText(), dataV, campoPago.isSelected(),dataP,historicoPadrao.getId(), contaCredito.getConta(), contaDebito.getConta());

            try {
                int id = 0;
                id = ContasService.inserirContaPagar(novo);
                novo.setId(id);
                JanContaPagar.getInstance().modelo.addContaPagar(novo);
                criarLancamento();
                Mensagem.mensagemSucesso(this, "Conta à pagar criada com sucesso!");
                fechar();
            } catch (ClassNotFoundException ex) {
                Mensagem.mensagemErroClassNotFound(this);
            } catch (SQLException ex) {
                Mensagem.mensagemErroSQLException(this);
                ex.printStackTrace();
            }

            }else{
                //atualizar
                java.sql.Date dataP = null;
                
                            try{
                dataP = new java.sql.Date(campoDataPagamento.getDate().getTime());
            }catch(Exception e){}
            
                
                try {                
                    atual.setPago(campoPago.isSelected());
                    atual.setDataPagamento(dataP);
                    ContasService.atualizarContaPagar(atual);
                    if (atual.isPago()) {
                        criarLancamentoFinal();
                    }
                    Mensagem.mensagemSucesso(this, "Conta atualizada com sucesso!");
                    fechar();
                } catch (ClassNotFoundException ex) {
                    Mensagem.mensagemErroClassNotFound(this);
                    ex.printStackTrace();
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

    private void campoPagoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_campoPagoPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_campoPagoPropertyChange

    private void campoPagoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_campoPagoItemStateChanged
        // TODO add your handling code here:
        try{
            if (campoPago.isSelected()) {
                labelPagamento.setVisible(true);
                campoDataPagamento.setDate(campoVencimento.getDate());
                campoDataPagamento.setVisible(true);
                contaCredito = contaDebito;
                contaDebito = JanPlanoContas.modelo.getPlanoContas("101010100001");
                bProcurarContaDebito1.setEnabled(false);
                setarContaDebito();
                setarContaCredito();
            } else {
                labelPagamento.setVisible(false);
                campoDataPagamento.setVisible(false);
//                contaCredito = null;
                
                contaDebito = contaCredito;
                setarContaDebito();
                setarCliente();
//                campoIdContaCredito.setText("");
//                campoDescContaCredito.setText("");
                bProcurarContaDebito1.setEnabled(true);
            }
        }catch(Exception e){
                        if (campoPago.isSelected()) {
                bProcurarContaDebito1.setEnabled(false);
                        }else{
                bProcurarContaDebito1.setEnabled(true);
                        }
        }

    }//GEN-LAST:event_campoPagoItemStateChanged

    private void bProcurarContaDebito1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProcurarContaDebito1ActionPerformed
        // TODO add your handling code here:
        JanPesquisaPlanoConta j = new JanPesquisaPlanoConta(this);
        j.setVisible(true);
        this.setEnabled(false);
}//GEN-LAST:event_bProcurarContaDebito1ActionPerformed

    private void bProcurarHistoricoPadrao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProcurarHistoricoPadrao1ActionPerformed
        // TODO add your handling code here:
        JanPesquisaHistoricoPadrao jan = new JanPesquisaHistoricoPadrao(this);
        jan.setVisible(true);
        this.setEnabled(false);
}//GEN-LAST:event_bProcurarHistoricoPadrao1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bNovo;
    private javax.swing.JButton bProcurar;
    private javax.swing.JButton bProcurarContaDebito1;
    private javax.swing.JButton bProcurarHistoricoPadrao1;
    private javax.swing.JButton bSalvar;
    private javax.swing.JTextField campoCliente;
    private com.toedter.calendar.JDateChooser campoData;
    private com.toedter.calendar.JDateChooser campoDataPagamento;
    private javax.swing.JTextField campoDescContaCredito1;
    private javax.swing.JTextField campoDescContaDebito1;
    private javax.swing.JTextField campoHistoricoPadrao1;
    private javax.swing.JTextField campoIdContaCredito1;
    private javax.swing.JTextField campoIdContaDebito1;
    private javax.swing.JTextArea campoObs;
    private javax.swing.JCheckBox campoPago;
    private javax.swing.JTextField campoValor;
    private com.toedter.calendar.JDateChooser campoVencimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelPagamento;
    // End of variables declaration//GEN-END:variables

    private void setarCliente() {
        if (clienteAtual.isFisica()) {
            campoCliente.setText(clienteAtual.getNome());
            
            
       
        } else {
            campoCliente.setText(clienteAtual.getRazaoSocial());
             
        }
        
        arrumarContaCredito();
    }

    public void arrumarCliente(ParceiroComercial parceiroComercial) {
        clienteAtual = parceiroComercial;
        setarCliente();

    }

    private boolean verificarDados() {
        
        if(clienteAtual == null){
            Mensagem.mensagemErro(this, "Selecione o Parceiro Comercial");
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
        
                      try{
            java.sql.Date data2 = new java.sql.Date(campoVencimento.getDate().getTime());
           
        }catch(Exception e){
            Mensagem.mensagemErro(this, "Escolha a data do vencimento"); 
            campoVencimento.requestFocus();
            return false;
        }
                      
        if (campoPago.isSelected()) {
            try {
                java.sql.Date data2 = new java.sql.Date(campoDataPagamento.getDate().getTime());

            } catch (Exception e) {
                Mensagem.mensagemErro(this, "Escolha a data do pagamento");
                campoDataPagamento.requestFocus();
                return false;
            }
        }
        
       if(contaCredito == null){
            Mensagem.mensagemErro(this, "Selecione a conta a ser creditada.");
            campoIdContaCredito1.requestFocus();
            return false;            
        }
        
             if(contaDebito == null){
            Mensagem.mensagemErro(this, "Selecione a conta a ser debitada.");
            campoIdContaDebito1.requestFocus();
            return false;            
        }
                

               historicoPadrao = JanHistoricoPadrao.modelo.getHistoricoPadrao(campoHistoricoPadrao1.getText());
        if (historicoPadrao == null) {
            try {
                historicoPadrao = new HistoricoPadrao(campoHistoricoPadrao1.getText());
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
            JanContaPagar.getInstance().modelo.filtrar("");
            JanContaPagar.getInstance().setEnabled(true);
            JanContaPagar.getInstance().requestFocus();
            this.dispose();
        }
    }

    void arrumarHistPadrao(HistoricoPadrao historicoPadrao) {
        this.historicoPadrao = historicoPadrao;
        setarHistoricoPadrao();
    }

    private void setarHistoricoPadrao() {
        campoHistoricoPadrao1.setText(historicoPadrao.getDescricao());
    }

    public void arrumarConta(PlanoContas planoContas) {
       this.contaDebito = planoContas; 
       setarContaDebito();
    }

    private void setarContaDebito() {
        campoDescContaDebito1.setText(contaDebito.getDescricao());
        campoIdContaDebito1.setText(Formatar.formatPlanoContas(contaDebito.getConta()));
    }
    
    
    public void arrumarContaCredito(PlanoContas planoContas) {
       this.contaCredito = planoContas; 
       setarContaCredito();
    }

    private void setarContaCredito() {
        campoDescContaCredito1.setText(contaCredito.getDescricao());
        campoIdContaCredito1.setText(Formatar.formatPlanoContas(contaCredito.getConta()));
    }

    private void criarLancamento() throws ClassNotFoundException, SQLException {
        Lancamento lan  = new Lancamento(historicoPadrao.getId(), contaCredito.getConta(), contaDebito.getConta(), new java.sql.Date(campoData.getDate().getTime()), Double.parseDouble(campoValor.getText().replace(",", ".")));
        ContasService.inserirLancamento(lan);
    }
    
      private void criarLancamentoFinal() throws ClassNotFoundException, SQLException {
        Lancamento lan = new Lancamento(historicoPadrao.getId(), contaCredito.getConta(),contaDebito.getConta(),  new java.sql.Date(campoDataPagamento.getDate().getTime()), Double.parseDouble(campoValor.getText().replace(",", ".")));
        ContasService.inserirLancamento(lan);
    }

    private void arrumarContaCredito() {
        ArrayList<ContaParceiro> c;
        
        try {
            c = ContasService.getContaParceiro(clienteAtual.getId());
            
            for(ContaParceiro cp : c){                
                arrumarContaCredito(JanPlanoContas.modelo.getPlanoContas(cp.getConta()));
                
                if(cp.getTipoDaConta().equals("Fornecedor")){
                    break;
                }else if(cp.getTipoDaConta().equals("Funcionario")){
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
