package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.categoryVo;
import VO.keywordVo;

import DAO.categoryDao;
import DAO.keywordDao;

/**
 * Servlet implementation class mainController
 */
@WebServlet("/mainController")
public class mainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public mainController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		String s=match(request,response);
		
		HttpSession session = request.getSession();
		session.setAttribute("print", s);
		
		System.out.println(s);
		response.sendRedirect("UrlFilter.jsp");
		
		/*long l=Long.valueOf(s);
		
		categoryVo catName=new categoryVo();
		catName.setCatId(l);
		
		keywordVo a=new keywordVo();
		a.setCat_id(catName);
		
		categoryDao catDao=new categoryDao();
		List nameCat=catDao.searchCat(catName);
		System.out.println(nameCat);
		HttpSession sss=request.getSession();
		sss.setAttribute("cc", nameCat);
		response.sendRedirect("sitePurpose.jsp");
		*/
		
		
	}

	protected String match(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		String q=null;
		Map myMap = new HashMap();
		
		String keyword = "";
		int size = 0;
		
		try 
		{

			keywordDao d = new keywordDao();
			List ls = d.showall();
			/*keywordVo v=new keywordVo();*/
			 
			 /*System.out.println(v.getKeywordName());*/
			
			String s = request.getParameter("website");
			URL url = new URL("http://" + "" + s + "/");
			
			URLConnection urlConnection = url.openConnection();
			Map<String, List<String>> headers = urlConnection.getHeaderFields();
			Set<Map.Entry<String, List<String>>> entrySet = headers.entrySet();
			
			/* List ls= */
			for (Map.Entry<String, List<String>> entry : entrySet) 
			{
				String headerName = entry.getKey();
				System.out.println("Header Name:" + headerName);
				List<String> headerValues = entry.getValue();
				
				for (String value : headerValues) 
				{
					System.out.print("Header value:" + value);
				}
				System.out.println();
				System.out.println();
			}
			
			InputStream inputStream = urlConnection.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			
			String line = bufferedReader.readLine();
			categoryVo categoryVO=null;
			
			while (line != null) 
			{
				System.out.println(line);
				
				line = bufferedReader.readLine();

				for (Iterator iterator = ls.iterator(); iterator.hasNext();) 
				{
					keywordVo str = (keywordVo) iterator.next();
					//System.out.println(str.getKeywordName());
					

					if (line != null && line.contains(str.getKeywordName())) 
					{
						/*
						categoryVO= str.getCat_id();
						q=categoryVO.getCatName();
						*/
						
						Integer i = myMap.get(str.getKeywordName())==null?0:(Integer)myMap.get(str.getKeywordName());
						i++;
						
						myMap.put(str.getKeywordName(),i);
						
						if(size < Integer.parseInt(myMap.get(str.getKeywordName()).toString()))
						{
							keyword = str.getKeywordName();
							size = Integer.parseInt(myMap.get(str.getKeywordName()).toString());
							
							categoryVO= str.getCat_id();
							q=categoryVO.getCatName();
							
						}
						
						System.out.println("KEYWORD::"+str.getKeywordName());
						System.out.println("size::::::"+myMap.get(str.getKeywordName()));
						
					}

				}

			}
			bufferedReader.close();
		} 
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
		
		
		HttpSession ss=request.getSession();
		ss.setAttribute("value", myMap);
	
		return q;
		//return keyword;
	}


}
