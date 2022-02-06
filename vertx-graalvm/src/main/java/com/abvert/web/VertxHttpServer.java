/**
 * 
 */
package com.abvert.web;


import java.util.concurrent.TimeUnit;

import com.abvert.web.verticle.MainVerticle;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.Router;

/**
 * @date Feb 5, 2022 8:24:41 PM
 *
 * @author 大鱼
 *
 */
public class VertxHttpServer {

	//private static final Logger logger = LoggerFactory.getLogger(VertxHttpServer.class);

    public static void main(String[] args){
    	
    	
		
    	
        VertxOptions vertxOptions = new VertxOptions();
        Vertx vertx = Vertx.vertx(vertxOptions);
        
        //部署http服务器
        vertx.deployVerticle(MainVerticle.class.getName(),
                new DeploymentOptions().setInstances(VertxOptions.DEFAULT_EVENT_LOOP_POOL_SIZE), res -> {
            if(res.succeeded()){
                //logger.warn("服务端部署成功----");
            	System.out.println("服务端部署成功----");
            }else {
                //logger.error("服务端部署失败---" + res.cause());
            	System.out.println("服务端部署失败---" + res.cause());
            }
        });
        /*
        HttpServerOptions options = new HttpServerOptions().setIdleTimeout(10000)
				.setIdleTimeoutUnit(TimeUnit.MILLISECONDS).setTcpKeepAlive(true).setSsl(false);

        HttpServer httpServer = vertx.createHttpServer(options);

		Router router = Router.router(vertx);
		
		router.route("/hello").handler(rc -> {
			//log.info("Got hello request");
			rc.response().end("World");
		});
		
		httpServer.requestHandler(router).listen(8080, asyncResult -> {
			if (asyncResult.failed()) {
				System.out.println("start server failed! " + asyncResult.cause());
			} else {
				System.out.println("start server success!");
			}
		});*/
    }
}
