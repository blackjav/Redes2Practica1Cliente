/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
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
public class ServiceClie extends Thread implements Serializable{
    
    private PrintWriter salidaText;
    private Socket socket;
    private ObjectOutputStream out;
    private FileInputStream file;//Aqui va la ruta
    private PrintStream envio;
    private static final int PUERTO = 5000;
    
    public ServiceClie(String ip)
    {
        super("Cliente");
            try
            {
                this.socket= new Socket(ip,PUERTO);
                out = new  ObjectOutputStream(socket.getOutputStream());
                this.salidaText = new PrintWriter(socket.getOutputStream(),true);
                this.envio=new PrintStream(socket.getOutputStream());             
                VentanaCliente.jbConnect.setText("Cerrar Sesión");
//                System.out.println("Todo funcionando !!!!");
            }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "No se ha podido establecer conexion \nVerifique la ip", "Error de conexion", JOptionPane.ERROR_MESSAGE);
            }
//            run();
        
    }
    
    @Override
    public void run()
    {
        String tamaño="";
        String nombre="";
       try {
//            while(true)
//            {
//                 
// 
//            }
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se ha podido establecer conexion ciere el programa", "Error de conexion", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ServiceClie.class.getName()).log(Level.SEVERE, null, ex);
           }
        
    }
    public void sendFile(File archivo, int tam) throws FileNotFoundException, IOException
    {   
        FileInputStream origen=new FileInputStream(archivo);
        envio.flush();
        byte[] buffer = new byte[1024];
        int len;
        salidaText.println("HOla");
        int i =0;
        while((len=origen.read(buffer))>0) {
                this.envio=new PrintStream(socket.getOutputStream()); 
                envio.write(buffer,0,len);
                envio.close();
                System.out.println("Entro "+i);
                i++;
        }
    }
   
    public void desconectar()
    {
        try {
            this.socket.close();
            this.salidaText.close();
            VentanaCliente.jbConnect.setText("Conectar");
        } catch (IOException ex) {
            Logger.getLogger(ServiceClie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
