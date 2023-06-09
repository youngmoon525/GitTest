package pack03.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex04_ImageStr {
	//FileInputStream , FileOutStream
	//파일( 그림 , 음원 , 영상 등 ) 에서 바이트 단위로 입출력을 하는 스트림을 의미함
	//이미지 파일을 읽어서 출력하는 행위 (ctrl +c , ctcl +v) ( IO : Input&Ouput )
	//원본 이미지를 준비해서 이미지를 읽어온 다음 => 다른이름으로 다시 출력
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("D:\\Study_java\\WorkSpace\\12.IO_FileTest\\pic.jpg");
		FileOutputStream fos = new FileOutputStream("D:\\Study_java\\WorkSpace\\12.IO_FileTest\\pic_copy2.jpg");
		int data , cnt = 0 ; // data : byte단위로 쪼개진 데이터를 하나씩 읽어와서 저장 , cnt는 몇번이나 파일을 읽는지 
		while(  (data = fis.read() ) != -1  ) { // -1 : file이 없다 , -1이 아니면 파일내부에 데이터가 있다
			cnt ++;
			System.out.println(data);// 이미지의 1px값 ( RGB )
			fos.write(data);// data값을 하나씩 누적시킨다 (write)
		}
		fos.flush();
		fos.close();
		fis.close();
		System.out.println(cnt + " 횟수만큼 접근했음 ");
		
		
	}
}
