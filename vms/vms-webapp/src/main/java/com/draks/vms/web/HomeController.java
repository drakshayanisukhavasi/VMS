package com.draks.vms.web;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.draks.vms.exception.TechnicalException;

@Controller
public class HomeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Value("${draks.vms.version}")
    private String version;
    @Value("${draks.vms.web.hostname}")
    private String hostname;
    @Value("${draks.vms.web.port}")
    private String port;
    @Value("${draks.vms.web.context}")
    private String context;
    @Value("${draks.vms.web.ssl}")
    private boolean ssl;
   
   
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView privateCtrl(Principal principal, ModelMap model) throws TechnicalException {
        return processController(principal, model);
    }  
    @RequestMapping(
            value = { 
                    "{path:(?!doc|resources|webjars|wro|api|public|sso).*$}", 
                    "{path:(?!doc|resources|webjars|wro|api|public|sso).*$}/**" }, 
            method = RequestMethod.GET)
    public ModelAndView privateCtrl(Principal principal, ModelMap model, @PathVariable(value = "path")String path) throws TechnicalException {
        return processController(principal, model);
    }   
    
    private ModelAndView processController(Principal principal, ModelMap model) {
        LOGGER.trace("privateCtrl");
  
        model.put("version"                     , version);
        model.put("hostname"                    , hostname);
        model.put("context"                     , context);
        model.put("port"                        , port);
        model.put("ssl"                         , ssl);
     
        return new ModelAndView("index", model);
    }

}
