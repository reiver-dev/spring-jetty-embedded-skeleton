package ru.reiver.skel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class WelcomeController {

	@RequestMapping("welcome")
	public @ResponseBody String welcome(@RequestParam(defaultValue = "everyone") String name) {
		return "Good news, " + name;
	}
	
}
