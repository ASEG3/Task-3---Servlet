import java.io.*;
import java.util.HashMap;

import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet extends HttpServlet{

	HashMap<String, String> currentFiles = new HashMap<String, String>();
	private static final long serialVersionUID = 1L;
	private static final String filePath = "../";
	
	//You guys need to send a POST request to the servers IP followed by /Servlet
	
	
	public void init(){
		
		//search for files in the file path directory
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		PrintWriter output = response.getWriter();
		String file = findFile(request.getParameter("MAC"),new File(filePath));
		if(file != null){
			
		} else {
			
		}
		output.println("200 OK");
		output.close();
		output.flush();
		
		
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
			
		doPost(request, response);
	}
	
	
	public void destroy(){
		//do nothing
	}
	
	
	public String findFile(String name, File file){
		File[] list = file.listFiles();
		if(list!= null){
			
			for(File f: list){
				if(f.isDirectory()){
					findFile(name, f);
				} else if(name.equalsIgnoreCase(f.getName())){
					return f.toString();
				}
			}
			
		} else {
			return null;
		}
		return null;
	}



}