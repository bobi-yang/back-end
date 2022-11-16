package cn.pzhuweb.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet Filter implementation class RootFilter
 */
@WebFilter("/success.jsp")
public class RootFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public RootFilter() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpServletRequest request2 = (HttpServletRequest) request;
		HttpServletResponse response2 = (HttpServletResponse) response;
		System.out.println("正在检测你的行为！");
		if (request2.getSession().getAttribute("ok") == null) {
			request2.getSession().setAttribute("error", "<script>alert('你没有登录，请先登录！');</script>");
			response2.sendRedirect("error.jsp");
		} else {
			chain.doFilter(request, response);
		}


	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
