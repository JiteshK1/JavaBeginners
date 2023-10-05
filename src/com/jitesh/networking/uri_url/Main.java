package com.jitesh.networking.uri_url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {

            URL url = new URL("http://example.org");
            BufferedReader inputStream=new BufferedReader(new InputStreamReader(url.openStream()));
            String line="";
            while (line!=null){
                line=inputStream.readLine();
                System.out.println(line);
            }
          
            inputStream.close();



//            URI uri = new URI("http://username:password@myserver:5000/catalogue/phone?os=android#samsung");

//            URI basedUri= new URI("http://username:password@myserver:5000");
//            URI uri= new URI("/catalogue/phone?os=android#samsung");
//            URI resolvedUri= basedUri.resolve(uri);
//            URL url =resolvedUri.toURL();
//            System.out.println(url);
        }
        catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
