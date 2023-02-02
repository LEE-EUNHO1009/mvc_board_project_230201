package com.eunocompany.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.eunocompany.board.dto.BoardDto;

public class BoardDao {
	
	String driverName = "com.mysql.jdbc.Driver"; // 해당 DB의 드라이버 이름
	String url = "jdbc:mysql://localhost:3306/webdb"; //DB 주소와 DB(스키마) 이름
	String user="root";
	String pass = "1234";
	
	public void write(String btitle, String bname, String bcontent) { //글쓰기 메서드
		
		Connection conn = null;
		PreparedStatement pstmt=null;
		
		String sql="INSERT INTO mvc_board(bname,btitle,bcontent) VALUES(?,?,?)"; //순서는 상관없음
		
		try {
			Class.forName(driverName); //jdbc 드라이버 불러오기
			conn= DriverManager.getConnection(url,user,pass); //DB 커넥션 생성
			pstmt = conn.prepareStatement(sql); //sql 객체 생성
			pstmt.setString(1, bname); //글쓴이
			pstmt.setString(2, btitle); //글제목
			pstmt.setString(3, bcontent); //글내용
			
			pstmt.executeUpdate(); //sql 실행
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt !=null) {//순서가 작은 것부터 닫아야 함
					pstmt.close(); 
				}if(conn !=null) {
					conn.close(); 
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	public ArrayList<BoardDto> list() { //모든 글 목록 가져오기 메서드
		
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM mvc_board ORDER BY bid DESC"; //글 번호의 내림차순으로 정렬한 후 모든 글이 반환
		//몽땅 다 가져올거니까 where 조건 필요없음/ 정렬-오름차순, 내림차순(역순정렬)
		
		ArrayList<BoardDto> dtoList= new ArrayList<BoardDto>(); 
		//dto 여러 개 담을 수 있는 비어있는 리스트 선언
		
		try {
			Class.forName(driverName); //jdbc 드라이버 불러오기
			conn= DriverManager.getConnection(url,user,pass); //DB 커넥션 생성
			pstmt = conn.prepareStatement(sql); //sql 객체 생성
			rs=pstmt.executeQuery(); //sql 실행하여 반환되는 결과를 rs로 받기

			while(rs.next()) { //여섯 개의 레코드를 빼서 임시로 저장하고 있는 것
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bdate = rs.getString("bdate");
				int bhit = rs.getInt("bhit");
				
				BoardDto dto=new BoardDto(bid, bname, btitle, bcontent, bdate, bhit);
//				dto.setBid(bid);
//				dto.setBname(bname);
//				dto.setBtitle(btitle);
//				dto.setBcontent(bcontent);
//				dto.setBdate(bdate);
//				dto.setBhit(bhit);
				
				dtoList.add(dto); //dto가 4개 완성되어있는 게 만들어짐, 맵핑
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt !=null) {//순서가 작은 것부터 닫아야 함
					pstmt.close(); 
				}if(conn !=null) {
					conn.close(); 
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//여기서 리턴 해줘야함
		return dtoList;
	}
	
}
