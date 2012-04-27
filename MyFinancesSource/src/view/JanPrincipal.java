package view;

import view.contas.JanLembretes;
import view.parceiro.JanParceirosComerciais;
import view.controleAcesso.JanUsuario;
import view.contas.JanHistoricoPadrao;
import view.contas.JanContaReceber;
import view.contas.JanPlanoContas;
import view.contas.JanContaPagar;
import view.contas.JanLancamento;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.parceiro.ParceiroComercial;
import model.controleAcesso.Perfil;
import model.Run;
import model.controleAcesso.Usuario;
import com.towel.swing.img.JImagePanel;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import model.Mensagem;
import model.Sv;
import relatorio.GerarRelatorio;
import relatorio.contas.JanRelContas;
import relatorio.contas.JanRelPlanoContas;
import view.contas.JanFluxoConta;
import view.parceiro.JanCompromisso;
import view.parceiro.JanCompromissoHoje;

public class JanPrincipal extends javax.swing.JFrame {

    Usuario userLogado;
    public Run r;
    public static  boolean alterarConta = false;
    public static  boolean alterarOS = false;
    
    public JanPrincipal(Usuario u) {
        super("..:: Principal ::.. ");
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        userLogado = u;
        //table model compartilhado, tem que ser criado por fins de segurança
        JanParceirosComerciais.getInstance();
        JanContaPagar.getInstance();
        JanContaReceber.getInstance();
        JanHistoricoPadrao.getInstance();
        JanPlanoContas.getInstance();
        JanCompromisso.getInstance();
                

        ParceiroComercial a = JanParceirosComerciais.getInstance().modelo.getParceiroComercialId(userLogado.getIdParceiro());
        String texto;
        if (a.isFisica()) {
            texto = a.getNome();
        } else {
            texto = a.getRazaoSocial();
        }

        campoNomeFunc.setText(texto);

        try {
            r = Sv.abrir();

            if (!r.analisar()) {
                campoDiasRestantes.setText("Sistema expirado!");
                travarSistema();
            } else {
                campoDiasRestantes.setText("Expira em: " + r.getDataExpiracao());
                setarPermissoes();
                lembretes();
                compromissoHj();
            }
        } catch (Exception ex) {
            campoDiasRestantes.setText("ERRO!");
            ex.printStackTrace();
            travarSistema();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoNomeFunc = new javax.swing.JLabel();
        campoDiasRestantes = new javax.swing.JLabel();
        painelImagem = new JImagePanel(loadImage("/imagem/principal.png"));
        jMenuBar1 = new javax.swing.JMenuBar();
        mCadastro = new javax.swing.JMenu();
        itemParceiroComercial = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        smAdmistrativo = new javax.swing.JMenu();
        itemPlanoContas = new javax.swing.JMenuItem();
        itemHistoricoPadrao = new javax.swing.JMenuItem();
        itemLancamento = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        itemUsuarios = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        itemCompromissos = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        mFinanceiro = new javax.swing.JMenu();
        itemContasPagar = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        itemContasReceber = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        itemFluxo = new javax.swing.JMenuItem();
        mRelatorios = new javax.swing.JMenu();
        menuFinanceiro = new javax.swing.JMenu();
        itemRelPlanoContas = new javax.swing.JMenuItem();
        itemRelContas = new javax.swing.JMenuItem();
        mUtili = new javax.swing.JMenu();
        subLembrete = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        itemCompromissoHJ = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        itemSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setText("F1 - Parceiros");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel5.setText("F4 - Contas à Pagar");

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel6.setText("F5 - Contas à Receber");

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel7.setText("F6 - Lembretes de Contas ");

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel9.setText("F8 - Compromissos de HJ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addContainerGap(412, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Logado como:");

        campoNomeFunc.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        campoNomeFunc.setText("jLabel2");

        campoDiasRestantes.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        campoDiasRestantes.setText("jLabel3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(campoNomeFunc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 905, Short.MAX_VALUE)
                .addComponent(campoDiasRestantes)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoNomeFunc)
                    .addComponent(campoDiasRestantes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painelImagemLayout = new javax.swing.GroupLayout(painelImagem);
        painelImagem.setLayout(painelImagemLayout);
        painelImagemLayout.setHorizontalGroup(
            painelImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        painelImagemLayout.setVerticalGroup(
            painelImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 147, Short.MAX_VALUE)
        );

        mCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/add.png"))); // NOI18N
        mCadastro.setText("Cadastro");

        itemParceiroComercial.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itemParceiroComercial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/cadFornecedor.png"))); // NOI18N
        itemParceiroComercial.setText("Parceiros Comerciais");
        itemParceiroComercial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemParceiroComercialActionPerformed(evt);
            }
        });
        mCadastro.add(itemParceiroComercial);
        mCadastro.add(jSeparator4);

        smAdmistrativo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/admin.png"))); // NOI18N
        smAdmistrativo.setText("Administrativo");

        itemPlanoContas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/planoContas.png"))); // NOI18N
        itemPlanoContas.setText("Plano de Contas");
        itemPlanoContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPlanoContasActionPerformed(evt);
            }
        });
        smAdmistrativo.add(itemPlanoContas);

        itemHistoricoPadrao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/histpadrao.png"))); // NOI18N
        itemHistoricoPadrao.setText("Histórico Padrão");
        itemHistoricoPadrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemHistoricoPadraoActionPerformed(evt);
            }
        });
        smAdmistrativo.add(itemHistoricoPadrao);

        itemLancamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/lancamento.png"))); // NOI18N
        itemLancamento.setText("Lançamentos");
        itemLancamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLancamentoActionPerformed(evt);
            }
        });
        smAdmistrativo.add(itemLancamento);
        smAdmistrativo.add(jSeparator2);

        itemUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/group.png"))); // NOI18N
        itemUsuarios.setText("Usuários");
        itemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemUsuariosActionPerformed(evt);
            }
        });
        smAdmistrativo.add(itemUsuarios);

        mCadastro.add(smAdmistrativo);
        mCadastro.add(jSeparator5);

        itemCompromissos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/clock_add.png"))); // NOI18N
        itemCompromissos.setText("Compromissos");
        itemCompromissos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCompromissosActionPerformed(evt);
            }
        });
        mCadastro.add(itemCompromissos);
        mCadastro.add(jSeparator10);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/backup.png"))); // NOI18N
        jMenuItem2.setText("Backup");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mCadastro.add(jMenuItem2);

        jMenuBar1.add(mCadastro);

        mFinanceiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/financeiro.png"))); // NOI18N
        mFinanceiro.setText("Financeiro");

        itemContasPagar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        itemContasPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/pagar.png"))); // NOI18N
        itemContasPagar.setText("Contas à Pagar");
        itemContasPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemContasPagarActionPerformed(evt);
            }
        });
        mFinanceiro.add(itemContasPagar);
        mFinanceiro.add(jSeparator6);

        itemContasReceber.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        itemContasReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/receber.png"))); // NOI18N
        itemContasReceber.setText("Contas à Receber");
        itemContasReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemContasReceberActionPerformed(evt);
            }
        });
        mFinanceiro.add(itemContasReceber);
        mFinanceiro.add(jSeparator7);

        itemFluxo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/fluxoCaixa.png"))); // NOI18N
        itemFluxo.setText("Fluxo (Carteira)");
        itemFluxo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFluxoActionPerformed(evt);
            }
        });
        mFinanceiro.add(itemFluxo);

        jMenuBar1.add(mFinanceiro);

        mRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/relatorios.png"))); // NOI18N
        mRelatorios.setText("Relatórios");

        menuFinanceiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/financeiro.png"))); // NOI18N
        menuFinanceiro.setText("Financeiro");

        itemRelPlanoContas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/planoContas.png"))); // NOI18N
        itemRelPlanoContas.setText("Plano de Contas");
        itemRelPlanoContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRelPlanoContasActionPerformed(evt);
            }
        });
        menuFinanceiro.add(itemRelPlanoContas);

        itemRelContas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/financeiro.png"))); // NOI18N
        itemRelContas.setText("Contas");
        itemRelContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRelContasActionPerformed(evt);
            }
        });
        menuFinanceiro.add(itemRelContas);

        mRelatorios.add(menuFinanceiro);

        jMenuBar1.add(mRelatorios);

        mUtili.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/utili.png"))); // NOI18N
        mUtili.setText("Utilitários");
        mUtili.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mUtiliActionPerformed(evt);
            }
        });

        subLembrete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        subLembrete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/financeiro.png"))); // NOI18N
        subLembrete.setText("Lembretes de Contas");
        subLembrete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subLembreteActionPerformed(evt);
            }
        });
        mUtili.add(subLembrete);
        mUtili.add(jSeparator3);

        itemCompromissoHJ.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        itemCompromissoHJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/clock.png"))); // NOI18N
        itemCompromissoHJ.setText("Compromissos Hoje");
        itemCompromissoHJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCompromissoHJActionPerformed(evt);
            }
        });
        mUtili.add(itemCompromissoHJ);
        mUtili.add(jSeparator9);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/date.png"))); // NOI18N
        jMenuItem1.setText("Calendário");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mUtili.add(jMenuItem1);

        jMenuBar1.add(mUtili);

        jMenu1.setText("Ajuda");

        jMenuItem3.setText("Ajuda");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        itemSobre.setText("Sobre");
        itemSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSobreActionPerformed(evt);
            }
        });
        jMenu1.add(itemSobre);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemParceiroComercialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemParceiroComercialActionPerformed
        // TODO add your handling code here:
        JanParceirosComerciais.getInstance().setVisible(true);
    }//GEN-LAST:event_itemParceiroComercialActionPerformed

    private void itemContasReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemContasReceberActionPerformed
        // TODO add your handling code here:
        JanContaReceber.getInstance().modelo.filtrar("");
        JanContaReceber.getInstance().setVisible(true);
    }//GEN-LAST:event_itemContasReceberActionPerformed

    private void itemContasPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemContasPagarActionPerformed
        // TODO add your handling code here:
        JanContaPagar.getInstance().modelo.filtrar("");
        JanContaPagar.getInstance().setVisible(true);

    }//GEN-LAST:event_itemContasPagarActionPerformed

    private void itemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemUsuariosActionPerformed
        // TODO add your handling code here:
        JanUsuario.getInstance().setVisible(true);
    }//GEN-LAST:event_itemUsuariosActionPerformed

    private void mUtiliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mUtiliActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_mUtiliActionPerformed

    private void subLembreteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subLembreteActionPerformed
        // TODO add your handling code here:
                JanLembretes.getInstance(alterarConta).setVisible(true);
    }//GEN-LAST:event_subLembreteActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JanCalendario a = new JanCalendario();
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Sv.salvar(r);
    }//GEN-LAST:event_formWindowClosing

    private void itemHistoricoPadraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemHistoricoPadraoActionPerformed
        // TODO add your handling code here:
        JanHistoricoPadrao.getInstance().setVisible(true);
    }//GEN-LAST:event_itemHistoricoPadraoActionPerformed

    private void itemPlanoContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPlanoContasActionPerformed
        // TODO add your handling code here:
        JanPlanoContas.getInstance().setVisible(true);
    }//GEN-LAST:event_itemPlanoContasActionPerformed

    private void itemLancamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLancamentoActionPerformed
        // TODO add your handling code here:
        JanLancamento j = new JanLancamento();
        j.setVisible(true);
    }//GEN-LAST:event_itemLancamentoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        JanBackup j = new JanBackup();
        j.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void itemFluxoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFluxoActionPerformed
        // TODO add your handling code here:
        JanFluxoConta f = new JanFluxoConta("101010100001");
        f.setVisible(true);
    }//GEN-LAST:event_itemFluxoActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        
        if(JanLembretes.getInstance(alterarConta).isVisible()){
            JanLembretes.getInstance(alterarConta).requestFocus();
        }
        
        if(JanCompromissoHoje.getInstance().isVisible()){
            JanCompromissoHoje.getInstance().requestFocus();
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void itemRelPlanoContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRelPlanoContasActionPerformed
        // TODO add your handling code here:
        JanRelPlanoContas j = new JanRelPlanoContas();
        j.setVisible(true);

    }//GEN-LAST:event_itemRelPlanoContasActionPerformed

    private void itemCompromissoHJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCompromissoHJActionPerformed
        // TODO add your handling code here:
        JanCompromissoHoje.getInstance().setVisible(true);
    }//GEN-LAST:event_itemCompromissoHJActionPerformed

    private void itemCompromissosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCompromissosActionPerformed
        // TODO add your handling code here:
        JanCompromisso.getInstance().setVisible(true);
    }//GEN-LAST:event_itemCompromissosActionPerformed

    private void itemRelContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRelContasActionPerformed
        // TODO add your handling code here:
        JanRelContas j = new JanRelContas();
        j.setVisible(true);
}//GEN-LAST:event_itemRelContasActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        Mensagem.mensagemErro(this, "Ainda não foi implementado.");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void itemSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSobreActionPerformed
        // TODO add your handling code here
        new About().setVisible(true);
    }//GEN-LAST:event_itemSobreActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel campoDiasRestantes;
    private javax.swing.JLabel campoNomeFunc;
    private javax.swing.JMenuItem itemCompromissoHJ;
    private javax.swing.JMenuItem itemCompromissos;
    private javax.swing.JMenuItem itemContasPagar;
    private javax.swing.JMenuItem itemContasReceber;
    private javax.swing.JMenuItem itemFluxo;
    private javax.swing.JMenuItem itemHistoricoPadrao;
    private javax.swing.JMenuItem itemLancamento;
    private javax.swing.JMenuItem itemParceiroComercial;
    private javax.swing.JMenuItem itemPlanoContas;
    private javax.swing.JMenuItem itemRelContas;
    private javax.swing.JMenuItem itemRelPlanoContas;
    private javax.swing.JMenuItem itemSobre;
    private javax.swing.JMenuItem itemUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenu mCadastro;
    private javax.swing.JMenu mFinanceiro;
    private javax.swing.JMenu mRelatorios;
    private javax.swing.JMenu mUtili;
    private javax.swing.JMenu menuFinanceiro;
    private javax.swing.JPanel painelImagem;
    private javax.swing.JMenu smAdmistrativo;
    private javax.swing.JMenuItem subLembrete;
    // End of variables declaration//GEN-END:variables

    private void setarPermissoes() {
        for (Perfil p : userLogado.getPerfis()) {
            if (p.getNomeJanela().equals("Parceiro Comercial")) {
                if (!p.isVisualizar()) {
                    itemParceiroComercial.setEnabled(false);
                } else {
                    JanParceirosComerciais.getInstance().setarPermissoes(p.isAlterar(), p.isDeletar(), p.isInserir());
                    
                }
            } else if (p.getNomeJanela().equals("Contas a Pagar")) {
                if (!p.isVisualizar()) {
                    itemContasPagar.setEnabled(false);
                    itemFluxo.setEnabled(false);
                } else {
                    if(p.isAlterar()){
                        alterarConta = true;
                    }
                    JanContaPagar.getInstance().setarPermissoes(p.isAlterar(), p.isDeletar(), p.isInserir());
                }
            } else if (p.getNomeJanela().equals("Contas a Receber")) {
                if (!p.isVisualizar()) {
                    itemContasReceber.setEnabled(false);
                    itemFluxo.setEnabled(false);
                } else {
                    if(p.isAlterar()){
                        alterarConta = true;
                    }
                    JanContaReceber.getInstance().setarPermissoes(p.isAlterar(), p.isDeletar(), p.isInserir());
                }
            } else if (p.getNomeJanela().equals("Login")) {
                if (!p.isVisualizar()) {
                    itemUsuarios.setEnabled(false);
                } else {
                    JanUsuario.getInstance().setarPermissoes(p.isAlterar(), p.isDeletar(), p.isInserir());
                }
            }else if(p.getNomeJanela().equals("Historico Padrao")){
                if(!p.isVisualizar()){
                  itemHistoricoPadrao.setEnabled(false);                      
                }
                
            }else if(p.getNomeJanela().equals("Plano de Contas")){
                if(!p.isVisualizar()){
                  itemPlanoContas.setEnabled(false);                      
                }
            }else if(p.getNomeJanela().equals("Lancamento")){
                if(!p.isVisualizar()){
                  itemLancamento.setEnabled(false);                      
                }
            }
        }
    }

    private void travarSistema() {
        mCadastro.setEnabled(false);
        mFinanceiro.setEnabled(false);
        mRelatorios.setEnabled(false);
        mUtili.setEnabled(false);
    }

    private BufferedImage loadImage(String file) {
        BufferedImage a = null;
        try {
            a = ImageIO.read(getClass().getResourceAsStream(file));
        } catch (IOException ex) {
            Logger.getLogger(JanPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    private void lembretes() {
        JanLembretes.getInstance(alterarConta);
        if(JanContaPagar.modelo.getRowCount() > 0 || JanContaReceber.modelo.getRowCount() > 0){
            JanLembretes.getInstance(alterarConta).setVisible(true);
            JanLembretes.getInstance(alterarConta).requestFocus();
        }
    }


    private void compromissoHj() {
        JanCompromissoHoje.getInstance();
        if(JanCompromisso.modelo.getRowCount() > 0){
            JanCompromissoHoje.getInstance().setVisible(true);
            JanCompromissoHoje.getInstance().requestFocus();
        }
    }
}
