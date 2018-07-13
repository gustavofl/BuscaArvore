/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.ControllerArvore;
import model.arvore.Node;
import model.exceptions.NodeJaExisteException;
import model.exceptions.NomeInvalidoException;

/**
 *
 * @author gustavo
 */
public class TelaAlterarNode extends javax.swing.JDialog {
	
	private ControllerArvore controller;
	private String nomeNode;

    /**
     * Creates new form AddNode
     */
    public TelaAlterarNode(java.awt.Frame parent, boolean modal, String nomeNode) {
        super(parent, modal);
        this.controller = ControllerArvore.getInstance();
        this.nomeNode = nomeNode;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomeNodeField = new javax.swing.JTextField();
        comboPaiNode = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        paiAtual = new javax.swing.JLabel();
        nomeAtual = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Nó");
        
        Node node = controller.getNode(nomeNode);

        jLabel1.setText("Novo nome:");
        
        nomeNodeField.setText(node.getNome());

        jLabel2.setText("Novo pai:");

        comboPaiNode.setModel(new javax.swing.DefaultComboBoxModel<>());
        ArrayList<Node> listaNodes = controller.getListaNodesComRestricao(nomeNode);
        for (Node n : listaNodes) {
        	comboPaiNode.addItem(n.getNome());
		}
        if(node.getPai() != null)
        	comboPaiNode.setSelectedItem(node.getPai().getNome());
        else
        	comboPaiNode.invalidate();

        jLabel3.setText("Pai atual:");

        if(node.getPai() != null)
        	paiAtual.setText(node.getPai().getNome());
        else
        	paiAtual.setText("---");

        jLabel4.setText("Nome atual:");
        
        nomeAtual.setText(node.getNome());

        cancelButton.setText("Cancelar");
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelButtonMouseClicked(evt);
            }
        });

        okButton.setText("OK");
        okButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                okButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboPaiNode, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeNodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paiAtual)
                    .addComponent(nomeAtual))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelButton)
                .addGap(18, 18, 18)
                .addComponent(okButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nomeAtual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(paiAtual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeNodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboPaiNode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        nomeNodeField.getAccessibleContext().setAccessibleName("nomeNode");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okButtonMouseClicked
        try {
			controller.alterarNode(nomeNode, nomeNodeField.getText(), (String) comboPaiNode.getSelectedItem());
		} catch (NomeInvalidoException e) {
			// e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage(), "Nome Invalido", JOptionPane.ERROR_MESSAGE);
		} catch (NodeJaExisteException e) {
			// e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage(), "No ja existe", JOptionPane.ERROR_MESSAGE);
		}
        this.getParent().repaint();
        this.dispose();
    }//GEN-LAST:event_okButtonMouseClicked

    private void cancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_cancelButtonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> comboPaiNode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel nomeAtual;
    private javax.swing.JTextField nomeNodeField;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel paiAtual;
    // End of variables declaration//GEN-END:variables
}
