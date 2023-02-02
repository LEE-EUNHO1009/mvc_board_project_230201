package com.eunocompany.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.eunocompany.board.dto.BoardDto;

public class BoardDao {
	
	String driverName = "com.mysql.jdbc.Driver";//해당 DB의 드라이버 이름
	String url = "jdbc:mysql://localhost:3306/webdb";//DB 주소와 DB(스키마) 이름
	String user = "root";
	String pass = "1234";
	
	public void write(String btitle, String bname, String bcontent) {//글쓰기
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql="INSERT INTO mvc_board(bname, btitle, bcontent) VALUES(?,?,?)";
		
		try {
			Class.forName(driverName);//jdbc 드라이버 불러오기
			conn = DriverManager.getConnection(url, user, pass);//DB 커넥션 생성
			pstmt = conn.prepareStatement(sql);//sql 객체 생성
			pstmt.setString(1, bname);//글쓴이
			pstmt.setString(2, btitle);//글제목
			pstmt.setString(3, bcontent);//글내용
			
			pstmt.executeUpdate();//sql 실행
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public ArrayList<BoardDto> list() {//모든 글 목록 가져오기
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="SELECT * FROM mvc_board ORDER BY bid DESC";
		//글 번호의 내림차순으로 정렬한 후 모든 글이 반환 
		
		ArrayList<BoardDto> dtoList = new ArrayList<BoardDto>();
		//dto 여러개를 담을 수 있는 비어있는 리스트 선언
		
		try {
			Class.forName(driverName);//jdbc 드라이버 불러오기
			conn = DriverManager.getConnection(url, user, pass);//DB 커넥션 생성
			pstmt = conn.prepareStatement(sql);//sql 객체 생성	
			rs = pstmt.executeQuery();//sql 실행하여 반환되는 결과를 rs로 받기
			
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bdate = rs.getString("bdate");
				int bhit = rs.getInt("bhit");
				
				BoardDto dto = new BoardDto(bid, bname, btitle, bcontent, bdate, bhit);
//				dto.setBid(bid);
//				dto.setBname(bname);
//				dto.setBtitle(btitle);
//				dto.setBcontent(bcontent);
//				dto.setBdate(bdate);
//				dto.setBhit(bhit);
				
				dtoList.add(dto);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}				
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return dtoList;
		
	}
	
	public BoardDto contentView(String boardNum) {//목록에서 유저가 클릭한 글 1개만 가져오기
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="SELECT * FROM mvc_board WHERE bid=?";
		//글 번호의 내림차순으로 정렬한 후 모든 글이 반환
		
		BoardDto dto = null;
		
		try {
			Class.forName(driverName);//jdbc 드라이버 불러오기
			conn = DriverManager.getConnection(url, user, pass);//DB 커넥션 생성
			pstmt = conn.prepareStatement(sql);//sql 객체 생성	
			pstmt.setString(1, boardNum);
			
			rs = pstmt.executeQuery();//sql 실행하여 반환되는 결과를 rs로 받기
			
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bdate = rs.getString("bdate");
				int bhit = rs.getInt("bhit");
				
				dto = new BoardDto(bid, bname, btitle, bcontent, bdate, bhit);
//				dto.setBid(bid);
//				dto.setBname(bname);
//				dto.setBtitle(btitle);
//				dto.setBcontent(bcontent);
//				dto.setBdate(bdate);
//				dto.setBhit(bhit);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}				
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return dto;
		
	}
	
}