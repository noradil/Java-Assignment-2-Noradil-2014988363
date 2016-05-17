/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @Nor Adil Ali - 2014988363 / CS078 Advanced Network Programming
 */
import java.io.*;
import javax.net.ssl.*;

public class SecureClient
{
  public static void main(String[] args) throws Exception
  {
      //Setting truststore
    System.setProperty("javax.net.ssl.trustStore", "naa.store");
      
          //Returns. SocketFactory
            SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslsocket = (SSLSocket) sslsocketfactory.createSocket("localhost", 1234); 
     
     // reading from keyboard (keyRead object)
     BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
                              
     // sending to client (pwrite object)
     OutputStream ostream = sslsocket.getOutputStream(); 
     PrintWriter pwrite = new PrintWriter(ostream, true);
                     
     // receiving from server ( receiveRead  object)
     InputStream istream = sslsocket.getInputStream();
     BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
 
     System.out.println("Start the chitchat, type and press Enter key");
 
     String receiveMessage, sendMessage;               
     while(true)
     {
        sendMessage = keyRead.readLine();  // keyboard reading
        pwrite.println(sendMessage);       // sending to server
        pwrite.flush();                    // flush the data
        if((receiveMessage = receiveRead.readLine()) != null) //receive from server
        {
            System.out.println(receiveMessage); // displaying at DOS prompt
        }         
      }               
    }                    
}         