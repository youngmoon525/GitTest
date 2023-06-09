package pack05.email;

import java.net.URL;
import java.util.Scanner;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {
	public static void main(String[] args) {
	
		
	}
	//1. 단순하게 텍스트만 있는 이메일 : SimpleEmail
	//2. 첨부파일이나 url등으로 이미지가 있는 이메일 : MultiPartEmail
	//3. 모든 기능을 가지고 html 태그까지 사용가능한 이메일 : HtmlEmail
	public void sendSimple() {
		SimpleEmail mail = new SimpleEmail();
		//smtp.naver.com
		mail.setHostName("smtp.naver.com");
		mail.setCharset("utf-8");//한글깨짐방지
		mail.setDebug(true);//오류를 찾아서 개발을 하고있는 과정인지.
		
		mail.setAuthentication("youngmoon525", "");
		mail.setSSLOnConnect(true);
		///==============고정 어떤메일을 쓰든 smtp서버와 smtp서버를 이용할수있는고객인증
		
		//송신인
		try {
			mail.setFrom("youngmoon525@naver.com" , "한울KYMFROM");
			mail.addTo("youngmoon525@naver.com", "한울KYMTO");//여러개하면 여러명한테전송
			mail.setSubject("회원가입 축하 메세지 ");
			mail.setMsg(" 내용 입니다 ~");
			
			//mail객체가 모든 정보를 가지고 전송할준비를 마침. ↑
			mail.send();
			
			
		} catch (EmailException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Email오류 아닌거" +e.getMessage());
		}
		
		
		
		
	}

	public void sendMulti() {
		MultiPartEmail mail = new MultiPartEmail();
		//smtp.naver.com
		mail.setHostName("smtp.naver.com");
		mail.setCharset("utf-8");//한글깨짐방지
		mail.setDebug(true);//오류를 찾아서 개발을 하고있는 과정인지.
		
		mail.setAuthentication("youngmoon525", "");
		mail.setSSLOnConnect(true);
		///==============고정 어떤메일을 쓰든 smtp서버와 smtp서버를 이용할수있는고객인증
		
		//송신인
		try {
			mail.setFrom("youngmoon525@naver.com" , "한울KYMFROM");
			mail.addTo("youngmoon525@naver.com", "한울KYMTO");//여러개하면 여러명한테전송
			mail.addTo("alkdjfalk@naver.com", "한울KYMTO");//여러개하면 여러명한테전송
			mail.setSubject("회원가입 축하 메세지 ");
			Scanner sc = new Scanner(System.in);
			System.out.println("메일 내용을 입력하세요.");
			String msg = sc.nextLine();
			mail.setMsg(msg);
			
			EmailAttachment file = new EmailAttachment();
			file.setPath("D:\\Study_java\\WorkSpace\\12.IO_FileTest\\pic.jpg");
			//이미지 파일 경로를 넣어줌.(경로를 찾을수없습니다 오류나오면 주석할꺼임
			mail.attach(file);//메일에 파일추가
			
			file = new EmailAttachment();
			file.setURL( new URL("https://www.digimonmasters.com/images/header/visual_bg_dig02.png"));
			mail.attach(file);
			
			
			
			
			
			//mail객체가 모든 정보를 가지고 전송할준비를 마침. ↑
			mail.send();
			
			
		} catch (EmailException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Email오류 아닌거" +e.getMessage());
		}
		
		
		
		
	}
	
	public void sendHtml() {
		HtmlEmail mail = new HtmlEmail();
		//smtp.naver.com
		mail.setHostName("smtp.naver.com");
		mail.setCharset("utf-8");//한글깨짐방지
		mail.setDebug(true);//오류를 찾아서 개발을 하고있는 과정인지.
		
		mail.setAuthentication("youngmoon525", "pw");
		mail.setSSLOnConnect(true);
		///==============고정 어떤메일을 쓰든 smtp서버와 smtp서버를 이용할수있는고객인증
		
		//송신인
		try {
			mail.setFrom("youngmoon525@naver.com" , "한울KYMFROM");
			mail.addTo("youngmoon525@naver.com", "한울KYMTO");//여러개하면 여러명한테전송
			mail.addTo("alkdjfalk@naver.com", "한울KYMTO");//여러개하면 여러명한테전송
			mail.setSubject("회원가입 축하 메세지 ");
			
			//메일의 내용이 일반 글자가 아니라 html형태로 보낼꺼이기때문에 바꿈.
			StringBuffer msg = new StringBuffer();//"A" , "A" +"B"
			msg.append("<html>");//
			msg.append("<body>");
			//html String으로 만들기 경연대회
			msg.append("<a> hi </a>");
			
			msg.append("</body>");
			msg.append("</html>");
			
			mail.setHtmlMsg(msg.toString());
			
			
			
			
			EmailAttachment file = new EmailAttachment();
			file.setPath("D:\\Study_java\\WorkSpace\\12.IO_FileTest\\pic.jpg");
			//이미지 파일 경로를 넣어줌.(경로를 찾을수없습니다 오류나오면 주석할꺼임
			mail.attach(file);//메일에 파일추가
			
			file = new EmailAttachment();
			file.setURL( new URL("https://www.digimonmasters.com/images/header/visual_bg_dig02.png"));
			mail.attach(file);
			
			
			
			
			
			//mail객체가 모든 정보를 가지고 전송할준비를 마침. ↑
			mail.send();
			
			
		} catch (EmailException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Email오류 아닌거" +e.getMessage());
		}
		
		
		
		
	}
	
}
