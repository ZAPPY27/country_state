package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.CountryVo;
import VO.StateVo;
import DAO.CsDao;


/**
 * Servlet implementation class CsController
 */
@WebServlet("/CsController")
public class CsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String flag=request.getParameter("flag");
		if(flag.equals("searchc")){
			searchc(request,response);
		}
		if(flag.equals("searchc2")){
			searchc2(request,response);
		}
		if(flag.equals("searchs")){
			searchs(request,response);
		}	
		
	}

	private void searchs(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		StateVo vo=new StateVo();
		CsDao d=new CsDao();
		List ls = d.search(vo);
		HttpSession session= request.getSession();
		session.setAttribute("data", ls);
		response.sendRedirect("viewstate.jsp");
	}

	private void searchc2(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String stateid=request.getParameter("id");
		String statename=request.getParameter("statename");
		String countryname=request.getParameter("countryname");
		String countryid=request.getParameter("countryid");
		HttpSession session= request.getSession();

		session.setAttribute("stateid",stateid);
		session.setAttribute("statename",statename);
		session.setAttribute("countryname",countryname);
		session.setAttribute("countryid",countryid);
		CountryVo vo=new CountryVo();
		CsDao d=new CsDao();
		List ls = d.search(vo);
        System.out.println(ls);

//		HttpSession session= request.getSession();
		session.setAttribute("data", ls);
		response.sendRedirect("edit.jsp");

	}

	private void searchc(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		CountryVo vo=new CountryVo();
		CsDao d=new CsDao();
		List ls = d.search(vo);
        System.out.println(ls);

		HttpSession session= request.getSession();
		session.setAttribute("data", ls);
		response.sendRedirect("State.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String flag=request.getParameter("flag");
		if(flag.equals("update")){
			update(request,response);
		}
		if(flag.equals("adds")){
			adds(request,response);
		}
		if(flag.equals("addc")){
			addc(request,response);
		}
	
	}

	private void addc(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String countryname=request.getParameter("Cn");
		CountryVo vo=new CountryVo();
		vo.setCountryname(countryname);
		CsDao d=new CsDao();
		d.add(vo);
		StateVo vo1=new StateVo();
		response.sendRedirect("Add.jsp");
	}

	private void adds(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String statename=request.getParameter("sn");
		String countryname=request.getParameter("countryname");
		Integer ci=Integer.parseInt(countryname);
		StateVo vos=new StateVo();
		CountryVo co=new CountryVo();
		
		vos.setStatename(statename);
		co.setId(ci);
		vos.setV(co);
		CsDao d=new CsDao();
		d.adds(vos);
		response.sendRedirect("viewstate.jsp");
		// TODO Auto-generated method stub
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String statename=request.getParameter("stateName");
		String stateid=request.getParameter("stateid");
		String countryid=request.getParameter("countryId");
		Integer ci=Integer.parseInt(countryid);

		Integer id=Integer.parseInt(stateid);

		StateVo vos=new StateVo();
		vos.setId(id);
		vos.setStatename(statename);
		CountryVo co=new CountryVo();
		co.setId(ci);
		vos.setV(co);
		CsDao d=new CsDao();
		d.update(vos);
		try {
			response.sendRedirect("Add.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	
}
