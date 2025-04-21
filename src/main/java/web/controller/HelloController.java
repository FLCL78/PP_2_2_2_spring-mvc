package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.services.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	@Autowired
	private CarService carService;

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}
	@GetMapping("/cars")
	public String showCarsTable(@RequestParam(value = "count", required = false) Integer count, Model model) {
		if (count == null || count >= 5) {
			model.addAttribute("cars", carService.getCars(5));
		} else {
			model.addAttribute("cars", carService.getCars(count));
		}
		return "cars";
	}
	
}