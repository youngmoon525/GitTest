package kym;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import customer.CustomerVO;

public class KymDAO {
	public void test() {
		String resource = "mybatis/conn.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory =
		  new SqlSessionFactoryBuilder().build(inputStream);
		
		try (SqlSession session = sqlSessionFactory.openSession()) {
			  //int dualInt = session.selectOne("Kym.dual");//Kym.dual
			  //session.method(-> .insert , update , delete , selectOne , selectList )
			  //selectOne . selectList
			  //데이터 한건 , 여러건 조회
			  //selectOne("")=> parameter ( statement ) 
			  //mapper namespace.id
			  //System.out.println("mybatis를 통해 select : " + dualInt);
			//vo : getter & setter를 만들면 자동으로 되는것은 bean(Spring 객체 만들때만 사용됨)
			//KymVO vo = session.selectOne("kym.voselect");
			//System.out.println("==");
			//List<KymVO> voList = session.selectList("kym.listselect");
			//System.out.println("리스트 사이즈 : " + voList.size());
			
			//파라메터의 전송은 단 하나의 객체만 가능하다 => String , int , ArrayList,HashMap..
			
			//메소드가 같은이름으로 여러개 정의된것 : 메소드 오버 , '로딩'? 라이딩?
			// $ , # <= 
			// $ 표시는 ex) vo를 파라메터로 넘기면 vo에 값을 그대로 출력(조건으로 사용)
			//         where id = field1 (x) field1이라는 컬럼이 없기때문에 오류
			// # 표시는 데이터 타입에 맞춰서 처리가 된다. 
			//			where id = 'field1' (o) 값 비교이기때문에 오류 x
			
			// 파라메터는 어떤타입이든 상관없지만 하나만 전송할수있음.(Parameter Object)
			// 변수를 여러개 가지고있는 클래스를 만든다(구조가 DB와같은것==>VO,DTO 활용)
			//String data = session.selectOne("kym.selectwhere1", 1);
			//System.out.println(data);
			//Customer VO 만들기 <- 
			//CustomerVO vo = new CustomerVO();
			//vo.setId(1);
			//vo.setName("NAME");
//			
//			List< CustomerVO > list = session.selectList("kym.selectwhere3" , 2);
//			System.out.println(list);
//			for (CustomerVO vo : list) {
//				System.out.println(vo.getId() + vo.getName() + vo.getEmail());
//			}
			//CustomerVO 3건을 받고 내용을 console창에 출력해보기.
			// 3건의 조건은 id가 2보다 큰 데이터 3건 이상 selectwhere3
			
			//내가 VO를 가지고있지않음.
			//PLAYER_NUM, PLAYER_NAME, TABLE KOREA
			// 7 , '손흥민'
			// HashMap<K, V> <= Key , Value 둘다 클래스타입 가능
			// ArrayList< E <= >
			HashMap<String, Object> params = new HashMap<>();
			params.put("num",7);
			params.put("pname", "손흥민");
			
			String playerName = session.selectOne("kym.mapselect" , params );
			System.out.println(playerName);
			
			//콘솔예시 ↓
			// 3 이름 이메일
			// 4 이름 이메일
			// 5 이름 이메일
			
			//Project 임시로 Test로 만들고 mybatis환경구축하고,
			//hr테이블 정보 조회하기 연습
			
		}
	}
}
