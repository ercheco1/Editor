package editor.principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * @author Erik Guzman
 * @date 07/July/2018
 */
public class Principal extends javax.swing.JFrame {

    private File archivo;
    private FileInputStream abrir;
    private FileOutputStream cerrar;

    Font font = new Font("Agency FB", Font.BOLD, 20);

    public Principal() {
        initComponents();
        this.desing();
    }

    private void desing() {
        this.getContentPane().setBackground(new Color(200, 0, 0));
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/editor/multimedia/Editor.png")));
        this.setTitle("Editor de Texto");
        panelLadito.setBackground(new Color(0 ,0 ,0));
        txtEditor.setBackground(new Color(0, 0, 0));
        txtEditor.setForeground(Color.red);
        txtEditor.setFont(font);
        txtEditor.setEnabled(false);
        btnGuardar.setForeground(Color.red);
        btnLimpiar.setForeground(Color.red);
    }

    private void Mostrar(File archivo) {
        String cadena, contenedor = "";
        try {
            FileReader leer = new FileReader(archivo);
            BufferedReader bufer = new BufferedReader(leer);

            while ((cadena = bufer.readLine()) != null) {
                contenedor += (cadena + "\n");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
        txtEditor.setText(contenedor);
    }

    private void Guardar() {
        String nuevo;
        try {
            this.Limpiar();
            FileWriter copia = new FileWriter(archivo);

            nuevo = txtEditor.getText().replace("\n", "\r\n");

            PrintWriter pw = new PrintWriter(copia);
            pw.print(nuevo);
            copia.close();
            this.Mostrar(archivo);
            JOptionPane.showMessageDialog(rootPane, "archivo guardado");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }

    private void Limpiar() {
        try {
            FileWriter escribir = new FileWriter(archivo);
            BufferedWriter bufer = new BufferedWriter(escribir);
            bufer.write("");
            bufer.close();
            escribir.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }

    private void Abrir() {
        JFileChooser selecionar = new JFileChooser();
        if (selecionar.showDialog(rootPane, "Abrir archivo") == JFileChooser.APPROVE_OPTION) {
            archivo = selecionar.getSelectedFile();
            if (archivo.canRead()) {
                if (archivo.getName().endsWith("txt")) {
                    try {
                        abrir = new FileInputStream(archivo);
                        txtEditor.setEnabled(true);
                        this.Mostrar(archivo);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Extención de archivo incorrecta");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Error no se puede leer el archivo");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "No seleccionaste nada");
        }

    }

    private String Datos(File archivo, String contenido) {
        String resultado = null;
        try {
            cerrar = new FileOutputStream(archivo);
            byte[] bytes = contenido.getBytes();
            cerrar.write(bytes);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
        return resultado;
    }

    private void Nuevo() {
        JFileChooser seleccionar = new JFileChooser();
        if (seleccionar.showDialog(rootPane, "Guardar el archivo") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionar.getSelectedFile();
            if (archivo.getName().endsWith("txt")) {
                String contenido = txtEditor.getText();
                String resultado = this.Datos(archivo, contenido);
                this.Mostrar(archivo);
                txtEditor.setEnabled(true);
                JOptionPane.showMessageDialog(rootPane, "Archivo creado ");
            }else{
                JOptionPane.showMessageDialog(rootPane, "Ingresa el archivo con la extencion txt");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "No seleccionaste la ubicacion");
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtEditor = new javax.swing.JTextArea();
        panelLadito = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuAbrir = new javax.swing.JMenuItem();
        menuGuardar = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuCopear = new javax.swing.JMenuItem();
        menuCortar = new javax.swing.JMenuItem();
        menuPegar = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        menuLimpiar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtEditor.setColumns(20);
        txtEditor.setRows(5);
        jScrollPane1.setViewportView(txtEditor);

        panelLadito.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/multimedia/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/multimedia/limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout panelLaditoLayout = new javax.swing.GroupLayout(panelLadito);
        panelLadito.setLayout(panelLaditoLayout);
        panelLaditoLayout.setHorizontalGroup(
            panelLaditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLaditoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelLaditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiar)
                    .addComponent(btnGuardar))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        panelLaditoLayout.setVerticalGroup(
            panelLaditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLaditoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpiar)
                .addContainerGap(338, Short.MAX_VALUE))
        );

        jMenu1.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/multimedia/nuevo.png"))); // NOI18N
        jMenuItem1.setText("Nuevo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        menuAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        menuAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/multimedia/abrir.png"))); // NOI18N
        menuAbrir.setText("Abrir");
        menuAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(menuAbrir);

        menuGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        menuGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/multimedia/guardar.png"))); // NOI18N
        menuGuardar.setText("Guardar");
        menuGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(menuGuardar);
        jMenu1.add(jSeparator2);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/multimedia/cancelar.png"))); // NOI18N
        jMenuItem11.setText("Salir");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edición");

        menuCopear.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menuCopear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/multimedia/copiar.png"))); // NOI18N
        menuCopear.setText("Copiar");
        menuCopear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCopearActionPerformed(evt);
            }
        });
        jMenu2.add(menuCopear);

        menuCortar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menuCortar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/multimedia/cortar.png"))); // NOI18N
        menuCortar.setText("Cortar");
        menuCortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCortarActionPerformed(evt);
            }
        });
        jMenu2.add(menuCortar);

        menuPegar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        menuPegar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/multimedia/pegar.png"))); // NOI18N
        menuPegar.setText("Pegar");
        menuPegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPegarActionPerformed(evt);
            }
        });
        jMenu2.add(menuPegar);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Más");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/multimedia/refrescar.png"))); // NOI18N
        jMenuItem7.setText("Recargar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        menuLimpiar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        menuLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/multimedia/limpiar.png"))); // NOI18N
        menuLimpiar.setText("Limpiar");
        menuLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLimpiarActionPerformed(evt);
            }
        });
        jMenu3.add(menuLimpiar);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLadito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(panelLadito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLimpiarActionPerformed
        this.Limpiar();
        txtEditor.setText(null);
    }//GEN-LAST:event_menuLimpiarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.Nuevo();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAbrirActionPerformed
        txtEditor.setText(null);
        this.Abrir();
    }//GEN-LAST:event_menuAbrirActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void menuGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGuardarActionPerformed
        this.Guardar();
    }//GEN-LAST:event_menuGuardarActionPerformed

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/multimedia/guardar-exit.png")));
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/multimedia/guardar.png")));
    }//GEN-LAST:event_btnGuardarMouseExited

    private void btnLimpiarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseEntered
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/multimedia/limpiar-exit.png")));

    }//GEN-LAST:event_btnLimpiarMouseEntered

    private void btnLimpiarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseExited
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/multimedia/limpiar.png")));
    }//GEN-LAST:event_btnLimpiarMouseExited

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        this.Guardar();
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        this.Limpiar();
        txtEditor.setText(null);
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¿Estas Seguro de eliminar este registro?", "Confirmar", 2);
        if (confirmacion == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void menuCopearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCopearActionPerformed
        txtEditor.copy();
    }//GEN-LAST:event_menuCopearActionPerformed

    private void menuCortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCortarActionPerformed
        txtEditor.cut();
    }//GEN-LAST:event_menuCortarActionPerformed

    private void menuPegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPegarActionPerformed
        txtEditor.paste();  
    }//GEN-LAST:event_menuPegarActionPerformed

    public void main() {
        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JLabel btnLimpiar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem menuAbrir;
    private javax.swing.JMenuItem menuCopear;
    private javax.swing.JMenuItem menuCortar;
    private javax.swing.JMenuItem menuGuardar;
    private javax.swing.JMenuItem menuLimpiar;
    private javax.swing.JMenuItem menuPegar;
    private javax.swing.JPanel panelLadito;
    private javax.swing.JTextArea txtEditor;
    // End of variables declaration//GEN-END:variables
}
