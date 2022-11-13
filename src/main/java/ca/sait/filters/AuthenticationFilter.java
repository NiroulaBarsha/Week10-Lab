/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sait.filters;
import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author dbrai
 */
public class AuthenticationFilter implements Filter
{

                @Override
		public void doFilter( ServletRequest request, ServletResponse response,
		                FilterChain chain ) throws IOException,
		                ServletException
		{
                    String name = request.getParameter("username");
                    String pass = request.getParameter("password");
                    if (name != null && pass != null) {
               if (AuthenticationFilter.this.name.equals("admin") && AuthenticationFilter.this.pass.equals("admin")) {

                ((HttpServletResponse)response).sendRedirect("/WEB_INF/admin.jsp");
            } else {
                ((HttpServletResponse) response).sendRedirect("/WEB_INF/note.jsp");
            }
        } else {
            name = (String)((HttpServletRequest) request).getSession().getAttribute("username");

            if(name == null) {
                ((HttpServletResponse) response).sendRedirect("/WEB_INF/login.jsp");
            }
        }
        chain.doFilter(request, response);
        }
                @Override
     public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}
