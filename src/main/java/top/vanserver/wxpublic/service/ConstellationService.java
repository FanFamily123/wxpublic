package top.vanserver.wxpublic.service;

import com.sun.deploy.net.URLEncoder;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

@Service
public class ConstellationService {
    String constellation= URLEncoder.encode("射手座","UTF-8");

    String appid="e4ba599ffb4806a8a2ebf1b50655a400";

    String httpUrl = "https://api.shenjian.io/constellation/today/";

    //String httpArg = "appid="+appid+"&constellation="+constellation;
    String httpArg ;
    String jsonResult = request(httpUrl, httpArg);

    public ConstellationService() throws UnsupportedEncodingException {
    }

//System.out.println(jsonResult);

    public String recode(String constName) throws Exception {
        constellation=URLEncoder.encode(constName,"UTF-8");
        String httpArg = "appid="+appid+"&constellation="+constellation;
        String realslt=request(httpUrl,httpArg);
        return  realslt;
    }

    public static String request(String httpUrl, String httpArg) {

        BufferedReader reader = null;

        String result = null;

        StringBuffer sbf = new StringBuffer();

        httpUrl = httpUrl + "?" + httpArg;

        try {

            URL url = new URL(httpUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            connection.setRequestProperty("charset", "utf-8");

            connection.setRequestProperty("Accept-Encoding", "gzip");

            connection.connect();

            InputStream is = new GZIPInputStream(connection.getInputStream());

            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String strRead = null;

            while ((strRead = reader.readLine()) != null) {

                sbf.append(strRead);

                sbf.append("\r\n");

            }

            reader.close();

            result = sbf.toString();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return result;

    }


}
