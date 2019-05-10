package org.mingi.servlets.chap11.servlet;

import java.io.IOException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mingi.servlets.chap11.dao.Member;
import org.mingi.servlets.chap11.dao.MemberDao;
import org.mingi.servlets.chap11.dao.MemberDaoImpl;

//Members : MemberServlet -> /WEB-INF/jsp/member.jsp
@WebServlet("/members")
public class MemberListServlet extends HttpServlet {
	MemberDao memberDao = null;

	Logger logger = LogManager.getLogger();

	/**
	 * memberDao를 초기화 한다.
	 */
	@Override
	public void init() throws ServletException {
		try {
			memberDao = new MemberDaoImpl();
		} catch (NamingException e) {
			logger.error(e.getMessage());
			throw new ServletException(e.getCause());
		}
	}
//처음 접속이후에는 doPost나 doGet만 실행이된
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int page = 1;
		try { // 가져올 페이지 수
			page = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			logger.error(e.getMessage());
		}

		// 페이지 당 가져오는 행의 수다
		final int COUNT = 10;
		// 시작점
		int offset = (page - 1) * COUNT;

		List<Member> memberList = memberDao.selectAll(offset, COUNT);

		int totalCount = memberDao.countAll();

		request.setAttribute("totalCount", totalCount);
		request.setAttribute("members", memberList);
		request.getRequestDispatcher("/WEB-INF/jsp/members.jsp")
				.forward(request, response);
}
}
