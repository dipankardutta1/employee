package com.emample.demo.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	
	@RequestMapping(value= {"/","/login"},method=RequestMethod.GET)
	public String gotoLoginPage() {
		return "login";
	}
	
	
	@RequestMapping(value= {"/error"},method=RequestMethod.GET)
	public String errorPage() {
		return "redirect:login?denied";
	}
	
	
	@RequestMapping(value="/dashboard",method=RequestMethod.GET)
	public String validateUser(Model model,HttpSession session,Principal principal) {
		return "dashboard";
	}

}

