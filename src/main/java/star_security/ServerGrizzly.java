/*
 * Copyright (c) 2021.
 * All Intellectual Property Rights to this File/Digital Product belong to the @Author
 * @PriyadarshiChaudhuri. Contact priyadarshi.c@gmail.com for enquiries.
 * This File maybe used for Non-commercial purpose only with Credits and link to GitHub repository.
 */

package star_security;


import org.apache.cxf.transport.servlet.CXFServlet;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.NetworkListener;
import org.glassfish.grizzly.servlet.ServletRegistration;
import org.glassfish.grizzly.servlet.WebappContext;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ServerGrizzly {
    public static final String BASE_URI = "http://127.0.0.1:8080/myuaasv2";

    public static void main(String[] args) throws IOException {
        Path currPath = Paths.get("");
        String s = currPath.toAbsolutePath().toString();
        //System.getProperty("local.base.dir", s.replaceAll("\\\\", "/"));
        //System.out.println(System.getProperty("local.base.dir"));
        System.out.println(s);
        HttpServer server = getServer();


    }

    public static HttpServer getServer() throws IOException {
        HttpServer server = new HttpServer();
        NetworkListener listener = new NetworkListener("grizzly", "localhost", 9999);
        server.addListener(listener);

        WebappContext ctx = new WebappContext("ctx", "/myuaasv2");
        final ServletRegistration reg = ctx.addServlet("spring", new CXFServlet());
        reg.addMapping("/");
        ctx.addListener("org.springframework.web.context.ContextLoaderListener");
        ctx.deploy(server);
        server.start();
        return server;
    }

}
