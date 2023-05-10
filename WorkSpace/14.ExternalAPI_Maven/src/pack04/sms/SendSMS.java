package pack04.sms;

import java.util.HashMap;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class SendSMS {
	public static void main(String[] args) {
        //Git-hub 샘플 : https://github.com/coolsms/coolsms-java-examples/
		//github예제가 interface와 여러 class로 분리를 해놔서 현재는 보기가 힘듬. 
		
		final String APIKEY = "NCSOCQPJMQS8HLRP";
		final String APISECRET = "E3N6GL8TI0BO7ETKLCGSN1XVEPFGJ5FK";
		
		Message sms = new Message(APIKEY, APISECRET);
		
		HashMap<String, String> params = new HashMap<>();
		params.put("to", "01079972725");
		params.put("from", "01079972725");
		params.put("type", "SMS");// SMS , LMS ,MMS ...
		params.put("text", "문자 자바로 보내기 테스트중");
		params.put("app_version", "JAVA SDK v1.2");
		
		try {
			JSONObject obj =  sms.send(params);
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
