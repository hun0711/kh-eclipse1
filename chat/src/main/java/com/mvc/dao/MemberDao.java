package com.mvc.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import com.util.MyBatisCommonFactory;
public class MemberDao {
	//log4j모듈 활용해서 로그출력 - 날짜와 시간, 클래스명, 라인번호, 링크
	//System.out.print()대신에 사용함
	Logger logger = Logger.getLogger(MemberDao.class);
	//DAO클래스와 오라클 서버 사이에 MyBatis Layer에 필요한 설정 내용을 담은 공통코드
	//member.xml의 물리적인 위치와 오라클서버의 정보가 담긴 MyBatisConfig.xml의
	//정보를 IO로 읽어오는 코드가 포함됨
	//MyBatis는 쿼리문을 xml문서에 따로 관리한다
	//Java로 관리할때 보다 컴파일을 하지 않아도 되고 버전 관리에도 효과적임
	MyBatisCommonFactory mcf = new MyBatisCommonFactory();
	
	public Map<String, Object> login(Map<String, Object> pMap){
		Map<String, Object> rmap = null;
		//MyBatisConfig.xml문서를 통해 스캔한 오라클 서버 정보를 연결통로 확보
		SqlSessionFactory sqlSessionFactory = null;
		//위에서 SqlSessionFactory 생성되면 쿼리문을 요청하는 selectOne메소드가
		//그 메소드를 제공하는 클래스 및 commit, rollback 지원
		SqlSession sqlSession = null;
		try {
			//공통코드에서 연결통로 확보
			sqlSessionFactory = mcf.getSqlSessionFactory();
			//연결 통로 확보로 생성된 객체로 SqlSession로딩하기
			sqlSession = sqlSessionFactory.openSession();
			//pMap.put("mem_id", "tomato");
			//pMap.put("mem_pw", "123");
			rmap = sqlSession.selectOne("login", pMap);
			logger.info(rmap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rmap;
	}
	//단일 테스트
	public static void main(String args[]) {
		MemberDao mDao = new MemberDao();
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("mem_id","tomato");
		pMap.put("mem_pw","123");
		Map<String, Object> rMap = mDao.login(pMap);
		System.out.println(rMap);
	}
}