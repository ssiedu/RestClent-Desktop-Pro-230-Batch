
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class DeleteClient {
    public static void main(String[] args) throws Exception {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Couse-Code");
        String code=sc.next();
        String endPoint="http://localhost:8086/REST-Demo-230/course/"+code;
        URL url=new URL(endPoint);
        HttpURLConnection ucon=(HttpURLConnection)url.openConnection();
        ucon.setDoOutput(true);
        ucon.setDoInput(true);
        //ucon.setReq
        ucon.setRequestMethod("DELETE");
        ucon.setRequestProperty("Content-Type", "application/json");
        ucon.setRequestProperty("Accept", "application/json");
        //will be used to send the data to RestAPI
        InputStream inputStream=ucon.getInputStream();
        //InputStream is ByteBasedSteam
        //Using InputStreamReader we are converting ByteBased to CharacterBased
        InputStreamReader reader=new InputStreamReader(inputStream);
        //We are creating BufferedReader object to read line-by-line
        BufferedReader br=new BufferedReader(reader);
        StringBuffer sb=new StringBuffer();
        while(true){
            String line=br.readLine();
            if(line==null)break;
            sb.append(line);
        }
        String data=sb.toString();
        System.out.println(data);
        inputStream.close();
        
        
        
    }    
}
