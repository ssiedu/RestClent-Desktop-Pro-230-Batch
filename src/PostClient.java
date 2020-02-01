
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;


public class PostClient {
    public static void main(String[] args) throws Exception {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Couse-Code");
        String ccode=sc.next();
        System.out.println("Couse-Title");
        String ctitle=sc.next();
        System.out.println("Couse-Subject");
        String subject=sc.next();
        System.out.println("Couse-Fees");
        int fees=sc.nextInt();
        System.out.println("Exam-Code");
        String ecode=sc.next();
        System.out.println("Exam-Title");
        String etitle=sc.next();
        System.out.println("Exam-Cost");
        int ecost=sc.nextInt();
        
        JSONObject ejson=new JSONObject();
        ejson.put("ecode", ecode);
        ejson.put("etitle", etitle);
        ejson.put("cost", ecost);
        
        //creating a new json object 
        JSONObject cjson=new JSONObject();
        cjson.put("code", ccode);
        cjson.put("title", ctitle);
        cjson.put("subject",subject);
        cjson.put("fees", fees);
        cjson.put("einfo", ejson);
        String str=cjson.toString();
        
        String endPoint="http://localhost:8086/REST-Demo-230/course";
        URL url=new URL(endPoint);
        HttpURLConnection ucon=(HttpURLConnection)url.openConnection();
        ucon.setDoOutput(true);
        ucon.setDoInput(true);
        //ucon.setReq
        ucon.setRequestMethod("POST");
        ucon.setRequestProperty("Content-Type", "application/json");
        ucon.setRequestProperty("Accept", "application/json");
        //will be used to send the data to RestAPI
        OutputStream os=ucon.getOutputStream();
        os.write(str.getBytes());
        os.flush();
        os.close();
        //will be used to receive the data send by Rest API
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
