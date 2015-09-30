/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.ServiceClie;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author javier
 */
public class VentanaCliente extends javax.swing.JFrame {

    /**
     * Creates new form VentanaCliente
     */
    private ServiceClie service = null;
    private boolean flag = true;
    private JFileChooser selector ;

    
    public VentanaCliente() {
        initComponents();
        jpUser.setEnabled(false);
        jbSend.setEnabled(false);
        this.setTitle("Aplicacion Cliente");
        this.setResizable(true);
        this.setLocationRelativeTo(this);
        jProgressBar1.setStringPainted(true);
        //borrar al terminar
        txtIp.setText("localhost");
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtIp = new javax.swing.JTextField();
        jbConnect = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaText = new javax.swing.JTextArea();
        jProgressBar1 = new javax.swing.JProgressBar();
        jpUser = new javax.swing.JPanel();
        jbSend = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        txtIp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIpActionPerformed(evt);
            }
        });

        jbConnect.setBackground(new java.awt.Color(0, 0, 0));
        jbConnect.setForeground(new java.awt.Color(255, 255, 255));
        jbConnect.setText("Conectar");
        jbConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConnectActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtAreaText.setEditable(false);
        txtAreaText.setColumns(20);
        txtAreaText.setRows(5);
        jScrollPane1.setViewportView(txtAreaText);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
            .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpUser.setBorder(javax.swing.BorderFactory.createTitledBorder("Mensaje"));

        jbSend.setBackground(new java.awt.Color(0, 0, 0));
        jbSend.setForeground(new java.awt.Color(255, 255, 255));
        jbSend.setText("Enviar");
        jbSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpUserLayout = new javax.swing.GroupLayout(jpUser);
        jpUser.setLayout(jpUserLayout);
        jpUserLayout.setHorizontalGroup(
            jpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUserLayout.createSequentialGroup()
                .addComponent(jbSend, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpUserLayout.setVerticalGroup(
            jpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUserLayout.createSequentialGroup()
                .addComponent(jbSend, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jLabel1.setText("Conectar a : ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jpUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 111, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIp, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbConnect)
                        .addGap(5, 5, 5))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jbConnect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIp))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Información");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");

        jMenuItem2.setText("Acerca de");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConnectActionPerformed
        
        String mensaje = txtIp.getText();
        String type = jbSend.getText();
        
        if(flag)
        {    
            if(!mensaje.isEmpty())
            {
                try
                {
//                    SOlo establecemos la conexion con el servidor
                    this.service = new ServiceClie(mensaje);
                    service.start();
                    txtIp.setEditable(false);
//                    jbConnect.setText("Cerrar Sesión");
                    jpUser.setEnabled(true);
                    jbSend.setEnabled(true);
                    this.flag = false; 
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(this, "No se ha encontrado servicio ", "Error de conexion", JOptionPane.ERROR_MESSAGE);
                }
                
            }    
            else
                JOptionPane.showMessageDialog(this, "Usted no ha ingresado una Ip  ", "Error de conexion", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
//            Esto nucna jalo 
            this.service.desconectar();
            txtIp.setEditable(true);
//            jbConnect.setText("Conectar");
            jpUser.setEnabled(false);
            jbSend.setEnabled(false);
            this.flag = true;
        }
    }//GEN-LAST:event_jbConnectActionPerformed

    private void jbSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSendActionPerformed
        
//        Creamos un filechooser para seleccionar archivos y le damos multiselection para muchos archivos 
        selector = new JFileChooser();
        selector.setMultiSelectionEnabled(true);
        int respuesta = selector.showOpenDialog(this);
        
        if (respuesta == JFileChooser.APPROVE_OPTION)
        {
            try {
                File archivos[]=selector.getSelectedFiles();
                System.out.println("Cantidad de archivosS "+archivos.length);
                jProgressBar1.setMaximum(archivos.length);
                jProgressBar1.setMinimum(0);
//                Aqui enviamos una unica vez la cantidad de archivos 
                service.descriptor(archivos.length);
                int i=1;
//                Recorremos con un forech la cantidad de los archivo y enviamos uno por uno 
                for(File f:archivos)
                {
//                    f.getName();
                    
                    System.out.println("Nombre del archivo ["+i+"]"+f.getName());
                    System.out.println("Tamaño del archivo["+i+"]:" +f.length());
                    service.sendFile(f,(int)f.length(),f.getName(),archivos.length);
                    i++;
		}
                
                
                
//                service.enviarFIles(archivoElegido,(int)archivoElegido.length() );
            } catch (Exception ex) {
                Logger.getLogger(VentanaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }//GEN-LAST:event_jbSendActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       JOptionPane.showMessageDialog(null, "Desarrollado por : \n*Mariana Ruiz Espinoza\n*F.Javier Hernández Morales ", "Colaboradores", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txtIpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIpActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JOptionPane.showMessageDialog(null, "Se debe importar la libreria apache axis 1.4 para inicar \n Dudas a : javierhm810@gmail.com", "Help?", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JButton jbConnect;
    private javax.swing.JButton jbSend;
    private javax.swing.JPanel jpUser;
    public static javax.swing.JTextArea txtAreaText;
    private javax.swing.JTextField txtIp;
    // End of variables declaration//GEN-END:variables
}
