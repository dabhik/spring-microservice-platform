/**
 * 
 */
package com.deloitte.msplatform.adminservice.controller;

import javax.annotation.Resource;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author abhidas
 *
 */
@Controller
@RefreshScope
@RequestMapping(value = "/message")
public class MessageController {
	
	@Resource
	Environment env;
	
	@GetMapping(value = "/health")
    public String displayEnvMessage() {
		String msg = env.getProperty("system.health.message");
		System.out.println("system.health.message: "+msg);
        return msg;
    }
}
