package com.fmn.cometd;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;  
  
public class CORSFilter implements Filter{  
  
public void init(FilterConfig arg0) throws ServletException {}  
      
public void doFilter(ServletRequest req, ServletResponse resp,  
    FilterChain chain) throws IOException, ServletException {  
          
    HttpServletResponse httpServletResponse = ((HttpServletResponse) resp);
    //httpServletResponse.addHeader("X-Frame-Options", "DENY");
    //httpServletResponse.addHeader("X-Content-Type-Options", "nosniff");
    addCorsHeader(httpServletResponse);     
    chain.doFilter(req, resp);//sends request to next resource  
          
    //System.out.println("filter is invoked after");  
    }  
    public void destroy() {}  
    
    private void addCorsHeader(HttpServletResponse response){
        //TODO: externalize the Allow-Origin
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Max-Age", "1728000");
    }
}  