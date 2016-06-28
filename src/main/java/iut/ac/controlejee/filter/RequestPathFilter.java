package iut.ac.controlejee.filter;

import iut.ac.controlejee.common.Const;
import iut.ac.controlejee.utils.Utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class RequestPathFilter
 */
@WebFilter("/RequestPathFilter")
public class RequestPathFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RequestPathFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String path = ((HttpServletRequest) request).getRequestURI();
		//Protection des URL ===> On peut utiliser Spring Security cependant ceci est une protection rapide à mettre en place.
		for(String pathProtected: Const.PROTECTED_PATH){
			if(path.contains(pathProtected) && !Utils.isAuth((HttpServletRequest) request)){
				((HttpServletResponse) response).sendRedirect("/ControleJEE/");
				request.setAttribute(Const.MESSAGE, "Vous avez été deconnecter");
			}
		}
		request.setAttribute("isAuth", Utils.isAuth((HttpServletRequest) request));
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
