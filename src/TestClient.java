
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;


public class TestClient {
    public static void main(String[] args) throws Exception {
        //consume a web-service (Rest API)
        //we must know the end point (url)
        //here we are getting a single json object
        //we are parsing json object using JSONObject class
        String endPoint="http://localhost:8086/REST-Demo-230/course/json/c111";
        URL url=new URL(endPoint);
        URLConnection ucon=url.openConnection();
        
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
        System.out.println("Parsing JSON String");
        JSONObject json=new JSONObject(data);
        String code=json.getString("code");
        String title=json.getString("title");
        String subject=json.getString("subject");
        JSONObject infoJson=json.getJSONObject("einfo");
        String ecode=infoJson.getString("ecode");
        String etitle=infoJson.getString("etitle");
        int ecost=infoJson.getInt("cost");
        
        
        int fees=json.getInt("fees");
        System.out.println("Course Code    : "+code);
        System.out.println("Course Title   : "+title);
        System.out.println("Course Subject : "+subject);
        System.out.println("Course Fees    : "+fees);
        System.out.println("Exam Code      : "+ecode);
        System.out.println("Exam Title     : "+etitle);
        System.out.println("Exam Cost      : "+ecost);
        
        
    }
}
