package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Database;
import Entity.Account;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList< Account> listUser=Database.getAll();
		ArrayList< Account> subList=new ArrayList();
		
		int size=listUser.size();
		int amountUser=10;
		int maxPage=(size%amountUser==0)?size/amountUser:size/amountUser+1;
		int pageAmount=5;
		int page;
		try {
			if(request.getParameter("page").equals("fisrt")) page =1;
			else if(request.getParameter("page").equals("last")) page =maxPage;
			else page=Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			page=1;
		}
		
		System.out.println(page+" "+size);
		
		
		int realAmountUser=(page*amountUser>size)?size:page*amountUser;//set amount user if exceed real size
		System.out.println(realAmountUser);
		for(int i=page*amountUser-10;i<realAmountUser;i++) {
			subList.add(listUser.get(i));
		System.out.println(i);
		}
		request.setAttribute("subList", subList);
		
		request.setAttribute("page", page);
		request.setAttribute("maxPage", maxPage);
		request.getRequestDispatcher("show.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
