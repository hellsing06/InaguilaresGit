package sv.com.institucion.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sv.com.institucion.entidades.Usuario;
import sv.com.institucion.utils.CustomUtils;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		Usuario user = (Usuario) ((HttpServletRequest)req).getSession().getAttribute("usuario");
		 String loginURL = ((HttpServletRequest)req).getContextPath() + "/login.xhtml";
		 System.out.println(loginURL);
	    if (user == null || CustomUtils.isEmpty(user.getUsuario()) && !((HttpServletRequest) req).getRequestURI().equals(loginURL)) {       
	        ((HttpServletResponse) res).sendRedirect(loginURL);	        
	    } else {
	        chain.doFilter(req, res);
	    }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
