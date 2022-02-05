/**
 * 
 */
package com.abvert.web;

import java.io.File;


import com.abvert.web.verticle.MainVerticle;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.core.logging.SLF4JLogDelegateFactory;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

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
            }else {
                //logger.error("服务端部署失败---" + res.cause());
            }
        });
    }
}
