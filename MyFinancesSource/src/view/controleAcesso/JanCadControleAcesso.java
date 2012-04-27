package view.controleAcesso;

import Persistencia.controleAcesso.ControleAcessoService;
import java.sql.SQLException;
import model.Mensagem;
import model.parceiro.ParceiroComercial;
import model.controleAcesso.Perfil;
import model.controleAcesso.Usuario;
import view.parceiro.JanCadParceirosComerciais;
import view.parceiro.JanParceirosComerciais;
import view.parceiro.JanPesquisaParceiro;

public class JanCadControleAcesso extends javax.swing.JFrame {

    private ParceiroComercial parceiro;
    private Usuario atual;

    public JanCadControleAcesso() {
        super("..:: Controle de Acesso ::..");
        initComponents();
        setLocationRelativeTo(null);

    }

    public JanCadControleAcesso(Usuario a) {
        super("..:: Controle de Acesso ::..");
        initComponents();
        setLocationRelativeTo(null);
        atual = a;
        carregarDados();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox21 = new javax.swing.JCheckBox();
        jCheckBox22 = new javax.swing.JCheckBox();
        jCheckBox23 = new javax.swing.JCheckBox();
        jCheckBox24 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        CampoVisualizarServico = new javax.swing.JCheckBox();
        CampoAlterarServico = new javax.swing.JCheckBox();
        CampoInserirServico = new javax.swing.JCheckBox();
        CampoDeletarServico = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        CampoVisualizarOS = new javax.swing.JCheckBox();
        CampoAlterarOS = new javax.swing.JCheckBox();
        CampoInserirOS = new javax.swing.JCheckBox();
        CampoDeletarOS = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        CampoInserirParceiro = new javax.swing.JCheckBox();
        CampoVisualizarParceiro = new javax.swing.JCheckBox();
        CampoDeletarParceiro = new javax.swing.JCheckBox();
        CampoAlterarParceiro = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        CampoInserirContasRec = new javax.swing.JCheckBox();
        CampoVisualizarContasRec = new javax.swing.JCheckBox();
        CampoDeletarContasRec = new javax.swing.JCheckBox();
        CampoAlterarContasRec = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        CampoAlterarContasPag = new javax.swing.JCheckBox();
        CampoDeletarContasPag = new javax.swing.JCheckBox();
        CampoVisualizarContasPag = new javax.swing.JCheckBox();
        CampoInserirContasPag = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        CampoDeletarLogin = new javax.swing.JCheckBox();
        CampoVisualizarLogin = new javax.swing.JCheckBox();
        CampoAlterarLogin = new javax.swing.JCheckBox();
        CampoInserirLogin = new javax.swing.JCheckBox();
        bSalvar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        CampoLogin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoFuncionario = new javax.swing.JTextField();
        bProcurar = new javax.swing.JButton();
        bNovo = new javax.swing.JButton();
        campoSenha = new javax.swing.JPasswordField();
        jPanel8 = new javax.swing.JPanel();
        campoLançamentos = new javax.swing.JCheckBox();
        campoHistorico = new javax.swing.JCheckBox();
        campoPlano = new javax.swing.JCheckBox();

        jCheckBox21.setText("Visualizar");

        jCheckBox22.setText("Alterar");

        jCheckBox23.setText("Inserir");
        jCheckBox23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox23ActionPerformed(evt);
            }
        });

        jCheckBox24.setText("Deletar");
        jCheckBox24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox24ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Serviços", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        CampoVisualizarServico.setSelected(true);
        CampoVisualizarServico.setText("Visualizar");

        CampoAlterarServico.setSelected(true);
        CampoAlterarServico.setText("Alterar");

        CampoInserirServico.setSelected(true);
        CampoInserirServico.setText("Inserir");

        CampoDeletarServico.setSelected(true);
        CampoDeletarServico.setText("Deletar");
        CampoDeletarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoDeletarServicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoVisualizarServico)
                    .addComponent(CampoInserirServico))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoAlterarServico)
                    .addComponent(CampoDeletarServico))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addComponent(CampoVisualizarServico)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(CampoInserirServico))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addComponent(CampoAlterarServico)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(CampoDeletarServico)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ordem de Serviço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        CampoVisualizarOS.setSelected(true);
        CampoVisualizarOS.setText("Visualizar");

        CampoAlterarOS.setSelected(true);
        CampoAlterarOS.setText("Alterar");

        CampoInserirOS.setSelected(true);
        CampoInserirOS.setText("Inserir");

        CampoDeletarOS.setText("Deletar");
        CampoDeletarOS.setEnabled(false);
        CampoDeletarOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoDeletarOSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoVisualizarOS)
                    .addComponent(CampoInserirOS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoAlterarOS)
                    .addComponent(CampoDeletarOS))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(CampoVisualizarOS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoInserirOS))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(CampoAlterarOS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoDeletarOS, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parceiro Comercial", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        CampoInserirParceiro.setSelected(true);
        CampoInserirParceiro.setText("Inserir");

        CampoVisualizarParceiro.setSelected(true);
        CampoVisualizarParceiro.setText("Visualizar");

        CampoDeletarParceiro.setSelected(true);
        CampoDeletarParceiro.setText("Deletar");
        CampoDeletarParceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoDeletarParceiroActionPerformed(evt);
            }
        });

        CampoAlterarParceiro.setSelected(true);
        CampoAlterarParceiro.setText("Alterar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoVisualizarParceiro)
                    .addComponent(CampoInserirParceiro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoAlterarParceiro)
                    .addComponent(CampoDeletarParceiro))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(CampoVisualizarParceiro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoInserirParceiro))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(CampoAlterarParceiro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoDeletarParceiro)))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contas a Receber", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        CampoInserirContasRec.setSelected(true);
        CampoInserirContasRec.setText("Inserir");
        CampoInserirContasRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoInserirContasRecActionPerformed(evt);
            }
        });

        CampoVisualizarContasRec.setSelected(true);
        CampoVisualizarContasRec.setText("Visualizar");

        CampoDeletarContasRec.setText("Deletar");
        CampoDeletarContasRec.setEnabled(false);
        CampoDeletarContasRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoDeletarContasRecActionPerformed(evt);
            }
        });

        CampoAlterarContasRec.setSelected(true);
        CampoAlterarContasRec.setText("Alterar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoVisualizarContasRec)
                    .addComponent(CampoInserirContasRec))
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoDeletarContasRec)
                    .addComponent(CampoAlterarContasRec))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(CampoVisualizarContasRec)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoInserirContasRec))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(CampoAlterarContasRec)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoDeletarContasRec)))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contas a Pagar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        CampoAlterarContasPag.setSelected(true);
        CampoAlterarContasPag.setText("Alterar");

        CampoDeletarContasPag.setText("Deletar");
        CampoDeletarContasPag.setEnabled(false);
        CampoDeletarContasPag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoDeletarContasPagActionPerformed(evt);
            }
        });

        CampoVisualizarContasPag.setSelected(true);
        CampoVisualizarContasPag.setText("Visualizar");
        CampoVisualizarContasPag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoVisualizarContasPagActionPerformed(evt);
            }
        });

        CampoInserirContasPag.setSelected(true);
        CampoInserirContasPag.setText("Inserir");
        CampoInserirContasPag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoInserirContasPagActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoVisualizarContasPag)
                    .addComponent(CampoInserirContasPag))
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CampoDeletarContasPag)
                    .addComponent(CampoAlterarContasPag))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(CampoVisualizarContasPag)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoInserirContasPag))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(CampoAlterarContasPag)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoDeletarContasPag)))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        CampoDeletarLogin.setText("Deletar");
        CampoDeletarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoDeletarLoginActionPerformed(evt);
            }
        });

        CampoVisualizarLogin.setText("Visualizar");

        CampoAlterarLogin.setText("Alterar");

        CampoInserirLogin.setText("Inserir");
        CampoInserirLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoInserirLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoVisualizarLogin)
                    .addComponent(CampoInserirLogin))
                .addGap(37, 37, 37)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoDeletarLogin)
                    .addComponent(CampoAlterarLogin))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoVisualizarLogin)
                    .addComponent(CampoAlterarLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoInserirLogin)
                    .addComponent(CampoDeletarLogin)))
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
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));

        jLabel2.setText("Senha");

        CampoLogin.setBackground(new java.awt.Color(255, 255, 153));
        CampoLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoLoginActionPerformed(evt);
            }
        });

        jLabel1.setText("Login");

        jLabel3.setText("Funcionário");

        campoFuncionario.setBackground(new java.awt.Color(255, 255, 153));
        campoFuncionario.setEditable(false);
        campoFuncionario.setText("Clique em Procurar...");

        bProcurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/find.png"))); // NOI18N
        bProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bProcurarActionPerformed(evt);
            }
        });

        bNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/add.png"))); // NOI18N
        bNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovoActionPerformed(evt);
            }
        });

        campoSenha.setBackground(new java.awt.Color(255, 255, 153));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(12, 12, 12)
                        .addComponent(campoFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(bProcurar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bNovo))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(CampoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(bNovo)
                    .addComponent(bProcurar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CampoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contábil", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        campoLançamentos.setSelected(true);
        campoLançamentos.setText("Lançamentos");
        campoLançamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoLançamentosActionPerformed(evt);
            }
        });

        campoHistorico.setSelected(true);
        campoHistorico.setText("Historico Padrao");

        campoPlano.setSelected(true);
        campoPlano.setText("Plano de Contas");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(campoHistorico)
                .addGap(18, 18, 18)
                .addComponent(campoPlano)
                .addGap(18, 18, 18)
                .addComponent(campoLançamentos)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoHistorico)
                    .addComponent(campoPlano)
                    .addComponent(campoLançamentos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                        .addGap(192, 192, 192))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSalvar)
                    .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CampoLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoLoginActionPerformed

    private void bProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProcurarActionPerformed
        // TODO add your handling code here:
        JanPesquisaParceiro pesq = new JanPesquisaParceiro(this, "Funcionario");
        pesq.setVisible(true);
        this.setEnabled(false);
}//GEN-LAST:event_bProcurarActionPerformed

    private void bNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoActionPerformed
        // TODO add your handling code here:
        JanCadParceirosComerciais jan = new JanCadParceirosComerciais();
        jan.setVisible(true);
}//GEN-LAST:event_bNovoActionPerformed

    private void CampoDeletarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoDeletarServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoDeletarServicoActionPerformed

    private void CampoDeletarParceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoDeletarParceiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoDeletarParceiroActionPerformed

    private void CampoDeletarOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoDeletarOSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoDeletarOSActionPerformed

    private void CampoDeletarContasPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoDeletarContasPagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoDeletarContasPagActionPerformed

    private void CampoInserirContasPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoInserirContasPagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoInserirContasPagActionPerformed

    private void CampoInserirContasRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoInserirContasRecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoInserirContasRecActionPerformed

    private void CampoDeletarContasRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoDeletarContasRecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoDeletarContasRecActionPerformed

    private void jCheckBox23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox23ActionPerformed

    private void jCheckBox24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox24ActionPerformed

    private void CampoInserirLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoInserirLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoInserirLoginActionPerformed

    private void CampoDeletarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoDeletarLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoDeletarLoginActionPerformed

    private void CampoVisualizarContasPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoVisualizarContasPagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoVisualizarContasPagActionPerformed

    private void bSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalvarActionPerformed
        // TODO add your handling code here:
        if (verificarDados()) {
            if (atual == null) {

                Usuario user = new Usuario(parceiro.getId(), CampoLogin.getText(), campoSenha.getText());
                user.addPerfil(new Perfil(parceiro.getId(), "Serviço", CampoVisualizarServico.isSelected(), CampoAlterarServico.isSelected(), CampoInserirServico.isSelected(), CampoDeletarServico.isSelected()));
                user.addPerfil(new Perfil(parceiro.getId(), "Ordem de Serviço", CampoVisualizarOS.isSelected(), CampoAlterarOS.isSelected(), CampoInserirOS.isSelected(), CampoDeletarOS.isSelected()));
                user.addPerfil(new Perfil(parceiro.getId(), "Parceiro Comercial", CampoVisualizarParceiro.isSelected(), CampoAlterarParceiro.isSelected(), CampoInserirParceiro.isSelected(), CampoDeletarParceiro.isSelected()));
                user.addPerfil(new Perfil(parceiro.getId(), "Contas a Pagar", CampoVisualizarContasPag.isSelected(), CampoAlterarContasPag.isSelected(), CampoInserirContasPag.isSelected(), CampoDeletarContasPag.isSelected()));
                user.addPerfil(new Perfil(parceiro.getId(), "Contas a Receber", CampoVisualizarContasRec.isSelected(), CampoAlterarContasRec.isSelected(), CampoInserirContasRec.isSelected(), CampoDeletarContasRec.isSelected()));
                user.addPerfil(new Perfil(parceiro.getId(), "Login", CampoVisualizarLogin.isSelected(), CampoAlterarLogin.isSelected(), CampoInserirLogin.isSelected(), CampoDeletarLogin.isSelected()));
                user.addPerfil(new Perfil(parceiro.getId(), "Plano de Contas", campoPlano.isSelected(), true,true,true));
                user.addPerfil(new Perfil(parceiro.getId(), "Historico Padrao", campoHistorico.isSelected(), true,true,true));
                user.addPerfil(new Perfil(parceiro.getId(), "Lancamento", campoLançamentos.isSelected(),true,true,true));

                Usuario recuperado = JanUsuario.getInstance().modelo.getusuarioId(user.getIdParceiro());

                if (recuperado == null) {
                    try {
                        ControleAcessoService.inserirUsuario(user);
                        JanUsuario.getInstance().modelo.addUsuario(user);
                        JanUsuario.getInstance().modelo.filtrar("");
                        Mensagem.mensagemSucesso(this, "Usuario cadastrado com sucesso");

                        fechar();
                    } catch (ClassNotFoundException ex) {
                        Mensagem.mensagemErroClassNotFound(this);
                    } catch (SQLException ex) {
                        Mensagem.mensagemErroSQLException(this);
                        ex.printStackTrace();
                    }

                } else {
                    if (recuperado.isDeletado()) {
                        int resp = Mensagem.mensagemYesNo(this, "Usuario já cadastrado. Deseja recuperá-lo?");

                        if (resp == 0) {


                            try {
                                recuperado.setDeletado(false);
                                ControleAcessoService.atualizarUsuario(recuperado);
                                JanUsuario.getInstance().modelo.filtrar("");
                                Mensagem.mensagemSucesso(this, "Usuario recuperado com sucesso.");

                                JanUsuario.getInstance().setEnabled(true);
                                JanUsuario.getInstance().requestFocus();

                                fechar();
                            } catch (ClassNotFoundException ex) {
                                Mensagem.mensagemErroClassNotFound(this);
                            } catch (SQLException ex) {
                                Mensagem.mensagemErroSQLException(this);
                                ex.printStackTrace();
                            }
                        }

                    } else {
                        Mensagem.mensagemErro(this, "Este Usuário já existe!");
                    }
                }
            } else {
                atual.setLogin(CampoLogin.getText());
                atual.setSenha(campoSenha.getText());
                for (Perfil p : atual.getPerfis()) {
                    if (p.getNomeJanela().equals("Serviço")) {
                        p.setAlterar(CampoAlterarServico.isSelected());
                        p.setDeletar(CampoDeletarServico.isSelected());
                        p.setInserir(CampoInserirServico.isSelected());
                        p.setVisualizar(CampoVisualizarServico.isSelected());
                    } else if (p.getNomeJanela().equals("Ordem de Serviço")) {
                        p.setAlterar(CampoAlterarOS.isSelected());
                        p.setDeletar(CampoDeletarOS.isSelected());
                        p.setInserir(CampoInserirOS.isSelected());
                        p.setVisualizar(CampoVisualizarOS.isSelected());
                    } else if (p.getNomeJanela().equals("Parceiro Comercial")) {
                        p.setAlterar(CampoAlterarParceiro.isSelected());
                        p.setDeletar(CampoDeletarParceiro.isSelected());
                        p.setInserir(CampoInserirParceiro.isSelected());
                        p.setVisualizar(CampoVisualizarParceiro.isSelected());
                    } else if (p.getNomeJanela().equals("Contas a Pagar")) {
                        p.setAlterar(CampoAlterarContasPag.isSelected());
                        p.setDeletar(CampoDeletarContasPag.isSelected());
                        p.setInserir(CampoInserirContasPag.isSelected());
                        p.setVisualizar(CampoVisualizarContasPag.isSelected());
                    } else if (p.getNomeJanela().equals("Contas a Receber")) {
                        p.setAlterar(CampoAlterarContasRec.isSelected());
                        p.setDeletar(CampoDeletarContasRec.isSelected());
                        p.setInserir(CampoInserirContasRec.isSelected());
                        p.setVisualizar(CampoVisualizarContasRec.isSelected());
                    } else if (p.getNomeJanela().equals("Login")) {
                        p.setAlterar(CampoAlterarLogin.isSelected());
                        p.setDeletar(CampoDeletarLogin.isSelected());
                        p.setInserir(CampoInserirLogin.isSelected());
                        p.setVisualizar(CampoVisualizarLogin.isSelected());
                    }else if(p.getNomeJanela().equals("Historico Padrao")){
                       p.setVisualizar(campoHistorico.isSelected());
                
            }else if(p.getNomeJanela().equals("Plano de Contas")){
  p.setVisualizar(campoPlano.isSelected());
            }else if(p.getNomeJanela().equals("Lancamento")){
  p.setVisualizar(campoLançamentos.isSelected());
            }
                }
                
                try {
                    ControleAcessoService.atualizarUsuario(atual);
                    JanUsuario.getInstance().modelo.filtrar("");
                    Mensagem.mensagemSucesso(this, "Usuario alterado com sucesso");

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

    private void campoLançamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoLançamentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoLançamentosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CampoAlterarContasPag;
    private javax.swing.JCheckBox CampoAlterarContasRec;
    private javax.swing.JCheckBox CampoAlterarLogin;
    private javax.swing.JCheckBox CampoAlterarOS;
    private javax.swing.JCheckBox CampoAlterarParceiro;
    private javax.swing.JCheckBox CampoAlterarServico;
    private javax.swing.JCheckBox CampoDeletarContasPag;
    private javax.swing.JCheckBox CampoDeletarContasRec;
    private javax.swing.JCheckBox CampoDeletarLogin;
    private javax.swing.JCheckBox CampoDeletarOS;
    private javax.swing.JCheckBox CampoDeletarParceiro;
    private javax.swing.JCheckBox CampoDeletarServico;
    private javax.swing.JCheckBox CampoInserirContasPag;
    private javax.swing.JCheckBox CampoInserirContasRec;
    private javax.swing.JCheckBox CampoInserirLogin;
    private javax.swing.JCheckBox CampoInserirOS;
    private javax.swing.JCheckBox CampoInserirParceiro;
    private javax.swing.JCheckBox CampoInserirServico;
    private javax.swing.JTextField CampoLogin;
    private javax.swing.JCheckBox CampoVisualizarContasPag;
    private javax.swing.JCheckBox CampoVisualizarContasRec;
    private javax.swing.JCheckBox CampoVisualizarLogin;
    private javax.swing.JCheckBox CampoVisualizarOS;
    private javax.swing.JCheckBox CampoVisualizarParceiro;
    private javax.swing.JCheckBox CampoVisualizarServico;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bNovo;
    private javax.swing.JButton bProcurar;
    private javax.swing.JButton bSalvar;
    private javax.swing.JTextField campoFuncionario;
    private javax.swing.JCheckBox campoHistorico;
    private javax.swing.JCheckBox campoLançamentos;
    private javax.swing.JCheckBox campoPlano;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox22;
    private javax.swing.JCheckBox jCheckBox23;
    private javax.swing.JCheckBox jCheckBox24;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    // End of variables declaration//GEN-END:variables

    public void arrumarFuncionario(ParceiroComercial parceiroComercial) {
        this.parceiro = parceiroComercial;
        setarFuncionario();
    }

    private void setarFuncionario() {
        if (parceiro.isFisica()) {
            campoFuncionario.setText(parceiro.getNome());
        } else {
            campoFuncionario.setText(parceiro.getNomeFantasia());
        }

    }

    private boolean verificarDados() {
        if (campoSenha.getText().equals("")) {
            Mensagem.mensagemErro(this, "Digite a senha!");
            campoSenha.requestFocus();
            return false;
        }

        if (CampoLogin.getText().equals("")) {
            Mensagem.mensagemErro(this, "Digite o Login!");
            CampoLogin.requestFocus();
            return false;
        }

        if (parceiro == null) {
            Mensagem.mensagemErro(this, "Selecione o funcionário.");
            campoFuncionario.requestFocus();
            return false;
        }

        return true;
    }

    private void carregarDados() {
        arrumarFuncionario(JanParceirosComerciais.modelo.getParceiroComercialId(atual.getIdParceiro()));
        CampoLogin.setText(atual.getLogin());
        campoSenha.setText(atual.getSenha());
        for (Perfil p : atual.getPerfil()) {
            if (p.getNomeJanela().equals("Serviço")) {
                CampoAlterarServico.setSelected(p.isAlterar());
                CampoDeletarServico.setSelected(p.isDeletar());
                CampoInserirServico.setSelected(p.isInserir());
                CampoVisualizarServico.setSelected(p.isVisualizar());
            } else if (p.getNomeJanela().equals("Ordem de Serviço")) {
                CampoAlterarOS.setSelected(p.isAlterar());
                CampoDeletarOS.setSelected(p.isDeletar());
                CampoInserirOS.setSelected(p.isInserir());
                CampoVisualizarOS.setSelected(p.isVisualizar());
            } else if (p.getNomeJanela().equals("Parceiro Comercial")) {
                CampoAlterarParceiro.setSelected(p.isAlterar());
                CampoDeletarParceiro.setSelected(p.isDeletar());
                CampoInserirParceiro.setSelected(p.isInserir());
                CampoVisualizarParceiro.setSelected(p.isVisualizar());
            } else if (p.getNomeJanela().equals("Contas a Pagar")) {
                CampoAlterarContasPag.setSelected(p.isAlterar());
                CampoDeletarContasPag.setSelected(p.isDeletar());
                CampoInserirContasPag.setSelected(p.isInserir());
                CampoVisualizarContasPag.setSelected(p.isVisualizar());
            } else if (p.getNomeJanela().equals("Contas a Receber")) {
                CampoAlterarContasRec.setSelected(p.isAlterar());
                CampoDeletarContasRec.setSelected(p.isDeletar());
                CampoInserirContasRec.setSelected(p.isInserir());
                CampoVisualizarContasRec.setSelected(p.isVisualizar());
            } else if (p.getNomeJanela().equals("Login")) {
                CampoAlterarLogin.setSelected(p.isAlterar());
                CampoDeletarLogin.setSelected(p.isDeletar());
                CampoInserirLogin.setSelected(p.isInserir());
                CampoVisualizarLogin.setSelected(p.isVisualizar());
            }else if(p.getNomeJanela().equals("Historico Padrao")){
                campoHistorico.setSelected(p.isVisualizar());
                
            }else if(p.getNomeJanela().equals("Plano de Contas")){
                campoPlano.setSelected(p.isVisualizar());
            }else if(p.getNomeJanela().equals("Lancamento")){
                 campoLançamentos.setSelected(p.isVisualizar());
            }

        }
    }

    private void fechar() {
        JanUsuario.getInstance().setEnabled(true);
        this.dispose();
    }
}
