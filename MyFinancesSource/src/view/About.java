package view;

public class About extends javax.swing.JFrame {


    public About() {
        super("Sobre...");
        initComponents();
        setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("<html> <head>   \t </head> <body>  \t<div>   <b><font size=\"14pt\"><span>My Finances</span></font></b><br>&#160;&#160; Software    desenvolvido com o intuito de ajudar nossos clientes com v&#225;rias    atividadades<br>durante sua rotina, e controlar sua finan&#231;as. Este    programa possui cadastros de contatos </div> <div>   (parceiros comerciais), compromissos, contole de acesso (usu&#225;rios). al&#233;m    de toda base </div> <div>   para controlar suas finan&#231;as(Plano de contas, Hist&#243;rico Padr&#227;o,    Lan&#231;amentos). Contas </div> <div>   &#224; pagar e a receber, lembretes de contas e de seus compromissos.<br><br><b><font size=\"14pt\"><span>Desenvolvimento</span></font></b><br>&#160;&#160;&#160;    Software desenvolvido por <i><span>Marco T&#250;lio Jacovine Noronha</span></i>    &lt;<font color=\"rgb(0, 0, 205)\"><span>mtnoronha7@gmail.com</span></font>&gt;,<br>como    ferramenta auxiliar da <i><span>Nortev Solutions</span></i> &lt;<u><font color=\"rgb(0, 0, 205)\"><a href=\"http://www.nortev.net63.net/\"><span>http://www.nortev.net63.net/</span></a></font></u>&gt;.<br><br><b><font size=\"14pt\"><span>Licen&#231;a</span></font></b><br>&#160;&#160;&#160;    Este software &#233; freeware e est&#225; livre para&#160; distribu&#237;&#231;&#227;o. Este programa    n&#227;o cont&#233;m nenhum tipo<br>de garantia. O risco e os problemas    causados pelo seu uso s&#227;o por conta do usu&#225;rio. Projeto Open </div> <div>   Source dispon&#237;vel em: &lt;<u><font color=\"rgb(0, 0, 205)\"><a href=\"https://github.com/mtnoronha/MyFinances\"><span>https://github.com/mtnoronha/MyFinances</span></a></font></u>&gt;. </div>  </body> </html>");

        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
