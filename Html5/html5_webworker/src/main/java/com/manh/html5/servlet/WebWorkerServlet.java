package com.manh.html5.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported=false,urlPatterns={"/WebWorkerServlet"},loadOnStartup=1,displayName="WebWorkerServlet")
public class WebWorkerServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response)throws ServletException, IOException 
	{
		response.setContentType("text/event-stream");
		response.setCharacterEncoding("UTF-8");
	 
		PrintWriter writer = response.getWriter();

		for (int i = 0; i < 20; i++) {

			writer.write("data: "+ System.currentTimeMillis() +"\n\n");
			writer.flush();
		
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}
		writer.close();
		
	}	
	@Override
	public void init() throws ServletException 
	{
		System.out.println(2);
	}
}
