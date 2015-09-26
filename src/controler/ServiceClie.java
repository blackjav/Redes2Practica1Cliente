/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.VentanaCliente;

/**
 *
 * @author javier
 */
public class ServiceClie extends Thread{
    
    private PrintWriter salidaText;
    private BufferedReader entradaText;
    private Socket socket;
    private FileOutputStream salidaFile;
    private FileInputStream entradaFile;
    private static final int PUERTO = 5000;
    
    public ServiceClie(String ip)
    {
        super("Cliente");
            try
            {
                this.socket = new Socket(ip,PUERTO);
                this.salidaText = new PrintWriter(socket.getOutputStream(),true);
                this.entradaText = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                VentanaCliente.jbConnect.setText("Cerrar Sesión");
//                System.out.println("Todo funcionando !!!!");
            }catch(IOException e){
                    JOptionPane.showMessageDialog(null, "No se ha podido establecer conexion \nVerifique la ip", "Error de conexion", JOptionPane.ERROR_MESSAGE);
            }
//            run();
        
    }
    
    @Override
    public void run()
    {
        String mensaje="";
       try {
            while(true)
            {
                mensaje= this.entradaText.readLine();
                System.out.println("Entro "+mensaje);
                VentanaCliente.txtAreaText.setText(VentanaCliente.txtAreaText.getText() + "\n" +mensaje);
            }
        } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "No se ha podido establecer conexion ciere el programa", "Error de conexion", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ServiceClie.class.getName()).log(Level.SEVERE, null, ex);
           }
        
    }
    public void enviarMsj(String mensaje)
    {
        try {
            this.salidaText = new PrintWriter(socket.getOutputStream(),true);
            System.out.println("Se va a enviar "+ mensaje);
            salidaText.println(mensaje);
        } catch (IOException ex) {
            Logger.getLogger(ServiceClie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void desconectar()
    {
        try {
            this.socket.close();
            this.entradaText.close();
            this.salidaText.close();
            VentanaCliente.jbConnect.setText("Conectar");
        } catch (IOException ex) {
            Logger.getLogger(ServiceClie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
