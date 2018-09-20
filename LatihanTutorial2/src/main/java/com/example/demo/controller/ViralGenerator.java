package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViralGenerator {
	
	@RequestMapping("/generator")
	public String index(@RequestParam(value = "a", required = false, defaultValue = "0") String num1, @RequestParam(value = "b", required = false, defaultValue = "0") String num2, Model model) {
		int angka1 = Integer.parseInt(num1);
		int angka2 = Integer.parseInt(num2);
		String a = "hm";
		if (angka2 == 0) {
			if (angka1 == 0) {
				model.addAttribute("ape",a);
			}else {
				for (int i = 1 ; i < angka1 ; i++) {
					a += "m";
				}
				model.addAttribute("ape",a);
			}
			
		}else {		
			if (angka1 == 0) {
				for (int i = 1 ; i < angka2 ; i++) {
					a+=" hm";
				}
				model.addAttribute("ape",a);
			}else {
				String api = "";
				for(int i = 0 ; i <angka2 ; i++ ) {
					api+= " hm";
					for(int j = 1 ; j < angka1 ; j++) {
						api+="m";
					}
				}
				model.addAttribute("ape",api);
			}
		}
		model.addAttribute("angka1", angka1);
		model.addAttribute("angka2", angka2);
		return "viralgen";
	}

}
