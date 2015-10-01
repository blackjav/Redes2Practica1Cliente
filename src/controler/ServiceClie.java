/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.Color;
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
import org.apache.axis.encoding.Base64;
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
    private BufferedReader entradaText;
    private InputStreamReader entradaSocket;
    private static final int PUERTO = 5000;
    
    public ServiceClie(String ip)
    {
        super("Cliente");
            try
            {
                this.socket= new Socket(ip,PUERTO);
                out = new  ObjectOutputStream(socket.getOutputStream());
//                this.salidaText = new PrintWriter(socket.getOutputStream(),true);
                this.envio=new PrintStream(socket.getOutputStream()); 
                this.entradaSocket = new InputStreamReader(socket.getInputStream());
                this.entradaText = new BufferedReader(entradaSocket); 

                VentanaCliente.jbConnect.setText("Cerrar Sesión");
//                System.out.println("Todo funcionando !!!!");
            }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "No se ha podido establecer conexion \nVerifique la ip", "Error de conexion", 
                            JOptionPane.ERROR_MESSAGE);
            }
//            run();
        
    }
    
    @Override
    public void run()
    {
        String mensaje="";
        int i =1;
//       Hilo de espera en mensaje 
       try {
            while(true)
            {
                mensaje = entradaText.readLine();
                if(mensaje.startsWith("*Se ha aceptado el archivo con el nombre de "))
                    VentanaCliente.txtAreaText.setForeground(Color.GREEN);
                else
                    VentanaCliente.txtAreaText.setForeground(Color.RED);
                
                VentanaCliente.txtAreaText.append("\n" +mensaje);
                VentanaCliente.txtAreaText.setCaretColor(Color.red);
                VentanaCliente.jProgressBar1.setValue(i);
                i++;
            }
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se ha podido establecer conexion ciere el programa", "Error de conexion", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ServiceClie.class.getName()).log(Level.SEVERE, null, ex);
           }
        
    }
    
    public void sendFile(File archivo, int tam,String nombre,int cant) throws FileNotFoundException, IOException
    {   
        FileInputStream origen=new FileInputStream(archivo);
//        this.salidaText = new PrintWriter(socket.getOutputStream(),true);
        this.envio=new PrintStream(socket.getOutputStream());
        int len;
        int i =0;
        byte[] fileArray;
        String encoding;
        
//        Todos los datos hasta el archivo seran mandados en modo string gracias a apache axis
        envio.println(tam);
        envio.println(nombre);
        
//        Construimos el array con la longitud del archivo en bytes
        fileArray = new byte[(int) archivo.length()];
        origen.read(fileArray);
        encoding = Base64.encode(fileArray);
        envio.println(encoding);
        System.out.println(encoding);
        

    }
    public void descriptor(long tamaño) throws IOException
    {
//        Se ejecuta una vez para enviar solo el tamño del archivo y una cadena de basuara por el autofush
        this.envio=new PrintStream(socket.getOutputStream());
        envio.println("xxx");
        envio.println(tamaño);
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
