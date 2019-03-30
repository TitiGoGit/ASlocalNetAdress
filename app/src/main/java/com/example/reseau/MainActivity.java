package com.example.reseau;

import android.net.Network;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button myButton = findViewById(R.id.button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 class Networklass {

                    public void main(String[] args) {
                        try {
                            Enumeration<NetworkInterface> list = NetworkInterface.getNetworkInterfaces();

                            while(list.hasMoreElements()){

                                NetworkInterface ni = list.nextElement();
                                Enumeration<InetAddress> listAddress = ni.getInetAddresses();

                                while(listAddress.hasMoreElements()){
                                    InetAddress address = listAddress.nextElement();
                                    showInformations(address);
                                }

                            }
                        } catch (SocketException e) {
                            e.printStackTrace();
                        } catch (UnknownHostException e) {
                            e.printStackTrace();
                        }
                    }


                    private void showInformations(InetAddress address) throws UnknownHostException {
                        System.out.println("-------------------------");
                        InetAddress local = InetAddress.getLocalHost();
                        System.out.println("Nom  : " + address.getHostName());
                        System.out.println("Nom humain: "+ local + " ne prendre en compte que le nom avavnt le \\");
                        System.out.println("Adresse : " + address.getHostAddress());
                        System.out.println("Nom canonique : " + address.getCanonicalHostName());
                        System.out.println("-------------------------");
                    }
            }

        TextView dataValu =  findViewById(R.id.dataValu);
        dataValu.setText("");


    }
    });
}
}