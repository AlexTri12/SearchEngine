/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Model.XMLDoc;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/**
 *
 * @author specter2k11
 */
public class ResultLinePanel extends javax.swing.JPanel {

    int docNumber, mode;
    String lastQuery;
    /**
     * Creates new form ResultLinePanel
     */
    public ResultLinePanel(int targetDoc, String lastQuery, int mode) {
        this.docNumber = targetDoc;
        this.lastQuery = lastQuery;
        this.mode = mode;
        initComponents();
        XMLDoc doc = new XMLDoc(targetDoc);
        titleLabel.setText(doc.getTitle());
        String bodyPreview = doc.getBody();
        if(bodyPreview.length() > 400){
            bodyPreview = bodyPreview.substring(0,397);
            bodyPreview = bodyPreview + "...";
        }
        bodyTextArea.setText(bodyPreview);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        bodyTextArea = new javax.swing.JTextArea();

        titleLabel.setText("Document Title");

        bodyTextArea.setEditable(false);
        bodyTextArea.setColumns(20);
        bodyTextArea.setLineWrap(true);
        bodyTextArea.setRows(5);
        bodyTextArea.setWrapStyleWord(true);
        bodyTextArea.setRequestFocusEnabled(false);
        bodyTextArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bodyTextAreaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bodyTextArea)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bodyTextArea, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bodyTextAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bodyTextAreaMouseClicked
        DocumentPanel docPanel = new DocumentPanel(docNumber,lastQuery,mode);
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        parentFrame.getContentPane().remove(this);
        parentFrame.setContentPane(docPanel);
        parentFrame.repaint();
        parentFrame.validate();
    }//GEN-LAST:event_bodyTextAreaMouseClicked
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea bodyTextArea;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}