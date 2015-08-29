package com.baohua.jsonrpc;

import com.googlecode.jsonrpc4j.JsonRpcServer;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author $id$
 */
public class JsonRpcServlet extends HttpServlet {

    private JsonRpcMethods jsonRpcMethods;
    private JsonRpcServer jsonRpcServer;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        // TODO: jsonrpc GET!
        response.getWriter().print("please POST!");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        this.jsonRpcServer.handle(request, response);
    }

    @Override
    public String getServletInfo() {
        return "JsonRPC 2.0 Servlet!";
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.jsonRpcMethods = new JsonRpcMethodsImpl();
        this.jsonRpcServer = new JsonRpcServer(jsonRpcMethods, JsonRpcMethods.class);
    }

}
