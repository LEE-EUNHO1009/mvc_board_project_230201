package com.eunocompany.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eunocompany.board.dao.BoardDao;
import com.eunocompany.board.dto.BoardDto;

public class BContentViewCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BoardDao dao = new BoardDao();
		BoardDto dto = dao.contentView("10");
		
		request.setAttribute("dto", dto);
	}

}
