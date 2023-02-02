package com.eunocompany.board.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eunocompany.board.dao.BoardDao;
import com.eunocompany.board.dto.BoardDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BoardDao dao = new BoardDao();
		
		ArrayList<BoardDto> dtoList = dao.list();//DB의 모든 글을 ArrayList 형태로 반환하는 메서드 호출
		
		request.setAttribute("dtoList", dtoList);//request 객체에 모든 글이 저장된 리스트를 싣기
	}

}