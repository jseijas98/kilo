package com.example.agenteD.MultiThread;

import com.example.agenteD.Util.GenericStatement;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.SQLException;

public class IpTestVserver extends GenericStatement implements Runnable{


    GenericStatement genericStatement = new GenericStatement();
    String query = "SELECT * FROM load_balancer";
    @Override
    public void run() {

        try {
            genericStatement.createStatement(query);


            while (genericStatement.rs.next()) {

                String ip_server = genericStatement.rs.getString("ip_server");


              InetAddress direccion = InetAddress.getByName(ip_server);

                boolean status = direccion.isReachable(10000);


                System.out.println( ip_server +" "+ "¿El host es alcanzable?: " + status);

            // System.out.println("ip_server"+" "+ ip_server);
        }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } catch (IOException e) {
            System.err.println("Ocurrió un error de entrada/salida: " +
                    e.getMessage());
        }
    }
}



