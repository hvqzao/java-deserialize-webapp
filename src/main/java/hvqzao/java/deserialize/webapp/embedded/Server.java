package hvqzao.java.deserialize.webapp.embedded;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

public class Server {

	public static void main(String[] args) throws Exception {

		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.WARNING);
		
		Tomcat tomcat = new Tomcat();
		tomcat.setBaseDir("target/tmp/");
		Connector connector = tomcat.getConnector();
		connector.setProperty("port", "8000");
		//connector.setProperty("address", "127.0.0.1");
		
		String webappDirLocation = "src/main/resources/webapp/";
		StandardContext ctx = (StandardContext) tomcat.addWebapp("", new File(webappDirLocation).getAbsolutePath());

		// Declare an alternative location for your "WEB-INF/classes" dir, Servlet 3.0 annotation will work
		File classes = new File("target/classes");
		WebResourceRoot resources = new StandardRoot(ctx);
		resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", classes.getAbsolutePath(), "/"));
		ctx.setResources(resources);

		System.out.println("Running...");		
		tomcat.start();
		tomcat.getServer().await();

	}

}
