package com.example.ConsoleCapture;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Cesar Ricardo.
 * @clase: JavaPing.java
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class ManejoComandoPing{

    private static final String COMANDO = "ping";
    private static final String ESPACIO = " ";
    private static final String IP_HOST = "www.google.com";

    /**
     * main
     * @param argumentos
     */
    public static void main( String[] argumentos ){

        ManejoComandoPing javaPing = new ManejoComandoPing();

        String IP = null;
        String otroIP = IP_HOST;

//Validación Previa.
        if( argumentos.length > 0 ){
            IP = argumentos[ 0 ]; //Desde consola (DOS, UNIX, LINUX).
        }
        else{
            if( (otroIP.equalsIgnoreCase( "" )) ){
                IP = "localhost"; //HardCode.
            }
            else{
                IP = otroIP;
            }
        }

//Validacion IP.
        javaPing.validarPingIP( IP );
    }

    /**
     * validarPingIP
     * @param IP
     */
    public void validarPingIP( String IP ){

        String mensaje = null;
        String pingCMD = COMANDO + ESPACIO + IP;

        try{
            Runtime ejecuta = Runtime.getRuntime();
            Process proceso = ejecuta.exec( pingCMD );

            InputStreamReader entrada = new InputStreamReader( proceso.getInputStream() );
            BufferedReader buffer = new BufferedReader( entrada );

            String linea = "";

            for( ;(linea = buffer.readLine() ) != null; ){
                System.out.println( linea );
                mensaje += linea;
            }

            buffer.close();
        }
        catch( IOException e ){
            System.out.println( e );
        }
        catch( Exception e ){
            System.out.println( e );
        }
    }
}