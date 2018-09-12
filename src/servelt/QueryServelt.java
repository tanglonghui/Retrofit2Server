package servelt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.User;
import util.GsonHelp;

/**
 * Servlet implementation class QueryServelt
 */
@WebServlet("/QueryServelt")
public class QueryServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryServelt() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		if (request.getParameter("str") != null) {
			String str = request.getParameter("str");
			if (str.equals("test") && str != null) {
				System.out.println("正确的str：" + str);
				PrintWriter out = response.getWriter();
				User user = new User("1", "1");
				String aa = GsonHelp.getGson().toJson(user);
				out.write(aa);
				out.flush();
				out.close();
			} else {
				System.out.println("这是一个错误的查询值" + str);
				// 网络请求时应定义一种统一的result的数据模型，以便客户端解析
				PrintWriter out = response.getWriter();
				String s = "失败";
				out.write(s);
				out.flush();
				out.close();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
