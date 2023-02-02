package com.eunocompany.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eunocompany.board.dao.BoardDao;


public class BDeleteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		//저장안하고 바로 넣어줘도 됨
		BoardDao dao = new BoardDao();
		dao.delete(request.getParameter("bid"));
	}

}
