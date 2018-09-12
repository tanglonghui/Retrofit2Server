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
 * Servlet implementation class UploadUserServelt
 */
@WebServlet("/UploadUserServelt")
public class UploadUserServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadUserServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//设置响应的内容及编码格式
		response.setContentType("application/json; charset=utf-8");
		//创建一个StringBuffer来拼接字符传
		StringBuffer str=new StringBuffer();
		//创建一个输入流 接收传入的字符串(获取请求主体)
		BufferedReader reader=request.getReader();
		String line=null;
		while((line=reader.readLine())!=null) {
			str.append(line);
		}
		System.out.println("有访问且gson的值为"+str);
		User check=GsonHelp.getGson().fromJson(str.toString(), User.class);
		if(check.getUsername().equals("1")) {
			 PrintWriter out = response.getWriter();  
			 User user=new User("1","1"); 
			 String aa=GsonHelp.getGson().toJson(user);
			 		 out.write(aa);
					 out.flush();  
				     out.close(); 
		}else {
			PrintWriter out = response.getWriter();  
			 String s="失败";
			 out.write(s);
			 out.flush();  
		     out.close(); 
		}
	}
	

}
