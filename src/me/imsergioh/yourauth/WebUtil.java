package me.imsergioh.yourauth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class WebUtil {

    public static String readURL(String link){
        String webString = "";
        try {
            URL url = new URL(link);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                webString += inputLine+"\n";
            in.close();
        } catch (Exception e){return "ERROR";}
        return webString;
    }

}
