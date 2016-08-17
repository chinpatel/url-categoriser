package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.categoryDao;
import DAO.keywordDao;
import VO.categoryVo;
import VO.keywordVo;

/**
 * Servlet implementation class keywordsController
 */
@WebServlet("/keywordsController")
public class keywordsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public keywordsController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		load(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		categoryDao cat=new categoryDao();
		
		List ls=cat.showall();
		HttpSession session=request.getSession();
		System.out.println("hi");
		session.setAttribute("lssearch", ls);
		response.sendRedirect("addKeywords.jsp");
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long  cat=Long.parseLong(request.getParameter("cat"));
		
		String keywordName=request.getParameter("keywords");
		
		categoryVo cq=new categoryVo();
		cq.setCatId(cat);
		
		
		
		keywordVo key=new keywordVo();
		key.setKeywordName(keywordName);
		key.setCat_id(cq);
		
		
		keywordDao keyDao=new keywordDao();
		keyDao.insert(key);
		response.sendRedirect("addKeywords.jsp");
	}

}
