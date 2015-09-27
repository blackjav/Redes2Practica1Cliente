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
import java.io.ObjectOutputStream;
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
    private ObjectOutputStream salidaFile;
    private ObjectOutputStream entradaFile;
    private static final int PUERTO = 5000;
    
    public ServiceClie(String ip)
    {
        super("Cliente");
            try
            {
                this.socket = new Socket(ip,PUERTO);
                this.salidaText = new PrintWriter(socket.getOutputStream(),true);
                this.entradaText = new BufferedReader(new InputStreamReader(socket.getInputStream()));
              //  this.salidaFile= new ObjectOutputStream(socket.getOutputStream());
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
    public void enviarArchivo(String fichero){
       try
        {
            boolean enviadoUltimo=false;
            // Se abre el fichero.
            FileInputStream fis = new FileInputStream(fichero);
            System.out.println(fichero);
            
            // Se instancia y rellena un mensaje de envio de fichero
            MensajeTomaFichero mensaje = new MensajeTomaFichero();
            mensaje.nombreFichero = fichero;
            // Se leen los primeros bytes del fichero en un campo del mensaje
            int leidos = fis.read(mensaje.contenidoFichero);
            
            // Bucle mientras se vayan leyendo datos del fichero
            while (leidos > -1)
            {
                
                // Se rellena el n�mero de bytes leidos
                mensaje.bytesValidos = leidos;
                
                // Si no se han leido el m�ximo de bytes, es porque el fichero
                // se ha acabado y este es el �ltimo mensaje
                if (leidos < MensajeTomaFichero.LONGITUD_MAXIMA)
                {
                    mensaje.ultimoMensaje = true;
                    enviadoUltimo=true;
                }
                else
                    mensaje.ultimoMensaje = false;
                
                // Se env�a por el socket
                salidaFile.writeObject(mensaje);
                
                // Si es el �ltimo mensaje, salimos del bucle.
                if (mensaje.ultimoMensaje)
                    break;
                
                // Se crea un nuevo mensaje
                mensaje = new MensajeTomaFichero();
                mensaje.nombreFichero = fichero;
                
                // y se leen sus bytes.
                leidos = fis.read(mensaje.contenidoFichero);
            }
            
            if (enviadoUltimo==false)
            {
                mensaje.ultimoMensaje=true;
                mensaje.bytesValidos=0;
                salidaFile.writeObject(mensaje);
            }
            // Se cierra el ObjectOutputStream
            salidaFile.close();
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
