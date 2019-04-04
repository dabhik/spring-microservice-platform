/**
 * 
 */
package com.deloitte.msplatform.adminservice.controller;

import javax.annotation.Resource;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author abhidas
 *
 */
@RestController
@RefreshScope
@RequestMapping(value = "/admin")
public class MessageController {
	
	@Resource
	Environment env;
	
	@GetMapping("/message")
    public String displayEnvMessage() {
		String msg = env.getProperty("system.custom.message","BLANK");
		System.out.println("system.custom.message: "+msg);
        return msg;
    }
}
