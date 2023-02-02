package com.eunocompany.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eunocompany.board.command.BCommand;
import com.eunocompany.board.command.BContentViewCommand;
import com.eunocompany.board.command.BListCommand;
import com.eunocompany.board.command.BWriteCommand;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();//컨택스트 패스만 분리하여 저장
		String command = uri.substring(conPath.length());
		
		BCommand bCommand= null;
		
		System.out.println("command : "+command);
		
		String viewPage = null;//view의 이름
		
		if(command.equals("/writeForm.do")) {
			viewPage ="/write_form.jsp";
		}else if(command.equals("/write.do")){
			
			//BWriteCommand bCommand=new BWriteCommand(); 와 같은 거임(아래거)
			bCommand=new BWriteCommand();
			bCommand.execute(request, response);
			
			viewPage = "/list.do";
		}else if(command.equals("/list.do")) {
			
			bCommand=new BListCommand();
			bCommand.execute(request, response);
			
			viewPage = "/board_list.jsp";
		}else if(command.equals("/contentView.do")) {
			
			bCommand=new BContentViewCommand();
			bCommand.execute(request, response);
			
			viewPage = "/content_view.jsp";
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	      dispatcher.forward(request, response);
	}

}