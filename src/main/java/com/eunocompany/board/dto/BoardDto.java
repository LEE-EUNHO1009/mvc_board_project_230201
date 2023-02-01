package com.eunocompany.board.dto;
import javax.servlet.http.HttpServletResponse;

import com.eunocompany.board.command.BCommand;

public class BoardDto {
	
	private int bid; // 게시판 글번호
	private String bname; //게시판 글쓴이 이름
	private String btitle; //게시판 글제목
	private String bcontent; //게시판 글내용
	private String bdate; //게시판 글쓴 날짜 시각
	private int bhit; //게시판 해당 글의 조회수
	
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardDto(int bid, String bname, String btitle, String bcontent, String bdate, int bhit) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bdate = bdate;
		this.bhit = bhit;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public int getBhit() {
		return bhit;
	}

	public void setBhit(int bhit) {
		this.bhit = bhit;
	}

	
	
}
