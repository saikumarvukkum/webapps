package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get print writer
   		PrintWriter pw=res.getWriter();
   		//content type
   		res.setContentType("text/html");
   		//get data from form
   		String ss=req.getParameter("txtname");
   		String eng=req.getParameter("engine");
   		String url=null;
   		if(eng.equalsIgnoreCase("google")) {
   			url="https://www.google.com/search?q="+ss;
   		}
   		else if (eng.equalsIgnoreCase("bing")) {
			url="https://www.bing.com/search?q="+ss;
		}
   		else {
   			url="https://in.search.yahoo.com/search?p="+ss;
   		}
   		//send redirection
   		res.sendRedirect(url);
   		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
