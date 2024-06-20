package com.spring.springBootProject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.boot.web.servlet.error.ErrorController;

@Controller
@ResponseBody
public class testController implements ErrorController{
    private final static String PATH = "/error";
    @RequestMapping(PATH)
    @ResponseBody
    public String getErrorPath() {
        // TODO Auto-generated method stub
        return "No Mapping Found";
    }

    
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return "First step";
	}
}


