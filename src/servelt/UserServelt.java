package servelt;

import java.io.BufferedReader;
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
 * Servlet implementation class userServer
 */
@WebServlet("/UserServelt")
public class UserServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServelt() {
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
		// 统一请求响应 格式设置
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		// 模拟token信息验证  getHeader("token")获得请求头中的token信息
		if (request.getHeader("token").equals("1433223")) {
			System.out.println("正确的token信息" + request.getHeader("token"));
			// 成功则响应一个User
			PrintWriter out = response.getWriter();
			User user = new User("1", "1");
			String aa = GsonHelp.getGson().toJson(user);
			out.write(aa);
			out.flush();
			out.close();
		} else {
			System.out.println("错误的token信息" + request.getHeader("token"));
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 统一请求响应 格式设置
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		// 模拟token信息验证  getHeader("token")获得请求头中的token信息
		if (request.getHeader("token").equals("1433223")) {
			System.out.println("正确的token信息" + request.getHeader("token"));
			// 成功则响应一个User
			PrintWriter out = response.getWriter();
			User user = new User("1", "1");
			String aa = GsonHelp.getGson().toJson(user);
			out.write(aa);
			out.flush();
			out.close();
		} else {
			System.out.println("错误的token信息" + request.getHeader("token"));
		}
	}

}
