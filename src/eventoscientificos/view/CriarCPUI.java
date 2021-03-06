/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoscientificos.view;

import eventoscientificos.controllers.CriarCPController;
import eventoscientificos.model.Empresa;
import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro
 */
public class CriarCPUI extends javax.swing.JDialog {

    private Frame framePai;
    private CriarCPController controller;

    /**
     * Creates new form CriarCPUI
     *
     * @param parent parent
     * @param modal modal
     * @param empresa empresa
     */
    public CriarCPUI(java.awt.Frame parent, boolean modal, Empresa empresa) {
        super(parent, "Criar CP", modal);
        this.controller = new CriarCPController(empresa);
        this.controller.getListaCPDefiniveisSemCPOrganizadorProponente();
        this.framePai = parent;
        setResizable(false);
        initComponents();
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(btn_selecionarSubmissivel);
        if (controller.getListaCPDefinivel().isEmpty()) {
            JOptionPane.showMessageDialog(
                    framePai,
                    "Não existem eventos ou sessões temáticas onde lhe é "
                    + "possível definir CP.",
                    "Criar CP",
                    JOptionPane.ERROR_MESSAGE);
            dispose();
        } else {
            setVisible(true);
            pack();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_listaRevisores = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_listaRevisores = new javax.swing.JList(this.controller.getModeloLista());
        btn_adicionarRevisor = new javax.swing.JButton();
        txt_IDRevisor = new javax.swing.JTextField();
        lbl_IDRevisor = new javax.swing.JLabel();
        pnl_selecionarSubmissivel = new javax.swing.JPanel();
        btn_selecionarSubmissivel = new javax.swing.JButton();
        cmb_selecionarSubmissivel = new javax.swing.JComboBox(this.controller.getListaCPDefinivel().toArray());
        btn_cancelar = new javax.swing.JButton();
        btn_criarCP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnl_listaRevisores.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Revisores"));

        jList_listaRevisores.setEnabled(false);
        jScrollPane1.setViewportView(jList_listaRevisores);

        btn_adicionarRevisor.setEnabled(false);
        btn_adicionarRevisor.setText("Adicionar Revisor");
        btn_adicionarRevisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionarRevisorActionPerformed(evt);
            }
        });

        txt_IDRevisor.setEnabled(false);

        lbl_IDRevisor.setText("Insira o ID do revisor:");

        javax.swing.GroupLayout pnl_listaRevisoresLayout = new javax.swing.GroupLayout(pnl_listaRevisores);
        pnl_listaRevisores.setLayout(pnl_listaRevisoresLayout);
        pnl_listaRevisoresLayout.setHorizontalGroup(
            pnl_listaRevisoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_listaRevisoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_listaRevisoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_listaRevisoresLayout.createSequentialGroup()
                        .addGap(0, 314, Short.MAX_VALUE)
                        .addComponent(lbl_IDRevisor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_IDRevisor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_adicionarRevisor)))
                .addContainerGap())
        );
        pnl_listaRevisoresLayout.setVerticalGroup(
            pnl_listaRevisoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_listaRevisoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_listaRevisoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_adicionarRevisor)
                    .addComponent(txt_IDRevisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_IDRevisor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_selecionarSubmissivel.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecione o evento/sessão temática"));

        btn_selecionarSubmissivel.setText("Selecionar");
        btn_selecionarSubmissivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selecionarSubmissivelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_selecionarSubmissivelLayout = new javax.swing.GroupLayout(pnl_selecionarSubmissivel);
        pnl_selecionarSubmissivel.setLayout(pnl_selecionarSubmissivelLayout);
        pnl_selecionarSubmissivelLayout.setHorizontalGroup(
            pnl_selecionarSubmissivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_selecionarSubmissivelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmb_selecionarSubmissivel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn_selecionarSubmissivel)
                .addContainerGap())
        );
        pnl_selecionarSubmissivelLayout.setVerticalGroup(
            pnl_selecionarSubmissivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_selecionarSubmissivelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_selecionarSubmissivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_selecionarSubmissivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_selecionarSubmissivel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_criarCP.setEnabled(false);
        btn_criarCP.setText("Criar CP");
        btn_criarCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_criarCPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_selecionarSubmissivel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_listaRevisores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_criarCP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_selecionarSubmissivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnl_listaRevisores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_criarCP))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_criarCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_criarCPActionPerformed
        try {
            this.controller.validarCP();

            String opcoes[] = {"Sim", "Não"};
            int resposta = JOptionPane.showOptionDialog(
                    null, "Pretende criar a CP?", "Criar CP", 0,
                    JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
            if (resposta == 0) {
                this.controller.adicionarCP();
            }
            dispose();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(
                    framePai,
                    ex.getMessage(),
                    "Criar CP",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_criarCPActionPerformed

    private void btn_adicionarRevisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionarRevisorActionPerformed
        try {
            this.controller.novoRevisor(this.txt_IDRevisor.getText());

            this.txt_IDRevisor.setText("");
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(
                    framePai,
                    "Não introduziu um ID válido.",
                    "Criar CP",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(
                    framePai,
                    ex.getMessage(),
                    "Criar CP",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_adicionarRevisorActionPerformed

    private void btn_selecionarSubmissivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selecionarSubmissivelActionPerformed
        int indice = this.cmb_selecionarSubmissivel.getSelectedIndex();

        this.controller.selecionarCPDefinivel(indice);
        this.btn_selecionarSubmissivel.setEnabled(false);
        this.cmb_selecionarSubmissivel.setEnabled(false);
        this.jList_listaRevisores.setEnabled(true);
        this.txt_IDRevisor.setEnabled(true);
        this.btn_adicionarRevisor.setEnabled(true);
        this.btn_criarCP.setEnabled(true);
        getRootPane().setDefaultButton(btn_criarCP);
    }//GEN-LAST:event_btn_selecionarSubmissivelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_adicionarRevisor;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_criarCP;
    private javax.swing.JButton btn_selecionarSubmissivel;
    private javax.swing.JComboBox cmb_selecionarSubmissivel;
    private javax.swing.JList jList_listaRevisores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_IDRevisor;
    private javax.swing.JPanel pnl_listaRevisores;
    private javax.swing.JPanel pnl_selecionarSubmissivel;
    private javax.swing.JTextField txt_IDRevisor;
    // End of variables declaration//GEN-END:variables
}
