package logging;

import javax.servlet.annotation.WebFilter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest; // Додайте цей імпорт
import java.io.IOException;

@WebFilter("/*")
public class LoggingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        // Ініціалізація фільтру
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Виведення інформації про запит
        System.out.println("URL: " + request.getServletContext().getContextPath() + ((HttpServletRequest) request).getRequestURI());
        System.out.println("Headers:");
        request.getParameterMap().forEach((key, value) ->
                System.out.println(key + ": " + String.join(", ", value)));

        // Продовження ланцюга фільтрів та обробка запиту
        chain.doFilter(request, response);
    }

    public void destroy() {
        // Завершення фільтру
    }
}


