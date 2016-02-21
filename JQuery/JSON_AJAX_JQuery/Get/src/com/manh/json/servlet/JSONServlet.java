package com.manh.json.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.manh.json.Article;

public class JSONServlet extends HttpServlet
{
	//private static final long serialVersionUID = 1L;
	List<Article> articles = new LinkedList<Article>();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		String	title=request.getParameter("title");
		String	url=request.getParameter("url");
		String	categories=request.getParameter("categories");
		String	tags=request.getParameter("tags");
		// 1. get received JSON data from request
       
        response.setContentType("application/text");            
        PrintWriter article=response.getWriter();
        article.write(title);
        article.write(url);
        article.write(categories);
        article.write(tags);
        // 5. Add article to List<Article>
     }
}
