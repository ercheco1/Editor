package editor.principal;

import editor.principal.metodos.Metodos;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;

/**
 * @author ercheco
 * @date 07/July/2018
 */
public class Principal extends javax.swing.JFrame {

    private String ruta;
    private boolean resultado;
    Font font = new Font("Agency FB", Font.BOLD, 20);

    public Principal() {
        initComponents();
        this.desing();
    }

    private void desing() {
        this.getContentPane().setBackground(new Color(200, 0, 0));
        this.setLocationRelativeTo(null);
        txtEditor.setBackground(new Color(0, 0, 0));
        txtEditor.setForeground(Color.red);
        txtEditor.setFont(font);
    }

    private String ruta() {
        ruta = "/home/ercheco/archivo.txt";
        return ruta;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtEditor = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuAbrir = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        menuLimpiar = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtEditor.setColumns(20);
        txtEditor.setRows(5);
        jScrollPane1.setViewportView(txtEditor);

        jMenu1.setText("Archivo");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/multimedia/nuevo.png"))); // NOI18N
        jMenuItem1.setText("Nuevo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        menuAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/multimedia/abrir.png"))); // NOI18N
        menuAbrir.setText("Abrir");
        menuAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(menuAbrir);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/multimedia/guardar.png"))); // NOI18N
        jMenuItem3.setText("Guardar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/multimedia/guardar-exit.png"))); // NOI18N
        jMenuItem9.setText("Guardar & Salir");
        jMenu1.add(jMenuItem9);
        jMenu1.add(jSeparator2);

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/multimedia/cancelar.png"))); // NOI18N
        jMenuItem11.setText("Salir");
        jMenu1.add(jMenuItem11);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edición");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/multimedia/copiar.png"))); // NOI18N
        jMenuItem4.setText("Copiar");
        jMenu2.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/multimedia/cortar.png"))); // NOI18N
        jMenuItem5.setText("Cortar");
        jMenu2.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/multimedia/pegar.png"))); // NOI18N
        jMenuItem6.setText("Pegar");
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Más");

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/multimedia/refrescar.png"))); // NOI18N
        jMenuItem7.setText("Recargar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        menuLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/multimedia/limpiar.png"))); // NOI18N
        menuLimpiar.setText("Limpiar");
        menuLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLimpiarActionPerformed(evt);
            }
        });
        jMenu3.add(menuLimpiar);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/multimedia/limpiar-exit.png"))); // NOI18N
        jMenuItem10.setText("Limpiar & Salir");
        jMenu3.add(jMenuItem10);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLimpiarActionPerformed
        Metodos metodos = new Metodos();
        resultado = metodos.limpiar(this.ruta());
        if (resultado) {
            txtEditor.setText(null);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Hubo un error!!");
        }
    }//GEN-LAST:event_menuLimpiarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAbrirActionPerformed
        Metodos metodos = new Metodos();
        txtEditor.setText(metodos.abrir(this.ruta()));
    }//GEN-LAST:event_menuAbrirActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Metodos metodos = new Metodos();
        String texto = txtEditor.getText().replace("\n", "\r\n");
        resultado = metodos.guardar(ruta, texto);
        if(resultado){
            JOptionPane.showMessageDialog(rootPane, "archivo guardado");
        }else{
            JOptionPane.showMessageDialog(rootPane, "No se puede guardar el archivo");
        }
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    public void main() {
        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem menuAbrir;
    private javax.swing.JMenuItem menuLimpiar;
    private javax.swing.JTextArea txtEditor;
    // End of variables declaration//GEN-END:variables
}
