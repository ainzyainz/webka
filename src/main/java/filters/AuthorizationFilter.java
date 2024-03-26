package filters;

import DTO.UserDTO;
import entities.User;
import utils.roles.Roles;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "/AuthorizationFilter", urlPatterns = {"/mainPageStudent", "/updateMyself", "/read","/verifyPass"})
public class AuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();

        if (session == null) {
            res.sendRedirect(contextPath + "/signUp.jsp");
            return;
        }

        UserDTO user = (UserDTO) session.getAttribute("current");
        if (user == null) {
            res.sendRedirect(contextPath + "/signUp.jsp");
            return;
        }

        Roles role = user.getRole();
        if (role == null) {
            res.sendRedirect(contextPath + "/signUp.jsp");
            return;
        }

        if (user.getPassword().equalsIgnoreCase(session.getAttribute("password").toString()) &&
                user.getEmail().equalsIgnoreCase(session.getAttribute("email").toString())) {
            req.setAttribute("current",user);
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(contextPath + "/signUp.jsp");
        }
    }

    @Override
    public void destroy() {
    }
}
