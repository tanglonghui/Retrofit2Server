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

/**
 * Servlet implementation class TableServelt
 */
@WebServlet("/TableServelt")
public class TableServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TableServelt() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 设置两个对象的编码格式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 设置响应的内容及编码格式
		response.setContentType("application/json; charset=utf-8");
		// 处理表单方式
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("表单数据为：账号：" + username + "  密码：" + password);
		if (username.equals("1") && password.equals("1")) {
			PrintWriter out = response.getWriter();
			User user = new User("1", "1");
			Gson gson = new Gson();
			out.println(gson.toJson(user));
			out.flush();
			out.close();
		}
	}

}
