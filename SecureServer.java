/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @ Nor Adil Ali - 2014988363 / CS078 Advanced Network Programming
 */
import java.io.*;
import javax.net.ssl.*;

public class SecureServer
{
  public static void main(String[] args) throws Exception
  {
      //Setting store file naa.store as SSL Keystore for this program
      System.setProperty("javax.net.ssl.keyStore", "naa.store");
        System.setProperty("javax.net.ssl.keyStorePassword", "password");
      
       //Setting the Certificate used by a Java SSL Server Socket 
      SSLServerSocketFactory sslserversocketfactory =
                    (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket sslserversocket =
                    (SSLServerSocket) sslserversocketfactory.createServerSocket(1234);
          
            //Print statement
            System.out.println("Server ready for chatting");
           
            // Create SSLSocket by accepting connections
            SSLSocket sslsocket = (SSLSocket) sslserversocket.accept();
      
            
      // reading from keyboard (keyRead object)
      BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
	                     
      // sending to client (pwrite object)
      OutputStream ostream = sslsocket.getOutputStream(); 
      PrintWriter pwrite = new PrintWriter(ostream, true);
 
       // receiving from server ( receiveRead  object)
      InputStream istream = sslsocket.getInputStream();
      BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
 
      String receiveMessage, sendMessage;               
      
      while(true)
      {
        if((receiveMessage = receiveRead.readLine()) != null)  
        {
           System.out.println(receiveMessage);         
        }         
        sendMessage = keyRead.readLine(); 
        pwrite.println(sendMessage);             
        pwrite.flush();
      }               
    }                    
} 
