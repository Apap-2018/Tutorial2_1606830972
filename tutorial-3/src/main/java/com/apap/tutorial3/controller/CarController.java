package com.apap.tutorial3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tutorial3.model.CarModel;
import com.apap.tutorial3.service.CarService;

@Controller
public class CarController {
	@Autowired
	private CarService mobilService;
	
	@RequestMapping("/car/add")
	public String add(@RequestParam(value="id", required=true)String id, @RequestParam(value="brand", required=true)String brand, @RequestParam(value="type", required=true)String type, @RequestParam(value="price", required=true)Long price, @RequestParam(value="amount", required=true)Integer amount) {
		CarModel car =new CarModel(id,brand,type,price,amount);
		mobilService.addCar(car);
		return "add";
	}
	
	@RequestMapping("/car/view")
	public String view(@RequestParam(value="id") String id, Model model) {
		if (id.isEmpty()) {
			return "view-error";
		}
		else {
			CarModel archieve = mobilService.getCarDetail(id);
			model.addAttribute("car",archieve);
			return "view-car";
		}
	}
	
	@RequestMapping("/car/viewall")
	public String viewall(Model model) {
		List<CarModel> archieve = mobilService.getCarList();
		
		model.addAttribute("listCar",archieve);
		return "viewall-car";
	}
	
	@RequestMapping("/car/view/{id}")
	public String viewPath(@PathVariable String id, Model model) {
		String abc = "";
		if (id.equals("")) {
			return "view-error";
		}
		else {
			CarModel archieve = mobilService.getCarDetail(id);
			if (archieve == null) {
				return "view-error";
			}
			else {
				model.addAttribute("car",archieve);
				return "view-car";
			}
		}
	}
	
//	@RequestMapping(value= {"/car/view/{id}", "/car/view}"})
//	public String viewPath(@PathVariable String id, Model model) {
//		if (id.isPresent()) {
//			CarModel archieve = mobilService.getCarDetail(id);
//			if (archieve == null) {
//				return "view-error";
//			}
//			else {
//				model.addAttribute("car",archieve);
//				return "view-car";
//			}
//		}
//		
//	}
	
	@RequestMapping("/car/update/{id}/amount/{amount}")
	public String updateAmount(@PathVariable String id, @PathVariable Integer amount) {
		CarModel archieve = mobilService.getCarDetail(id);
		archieve.setAmount(amount);
		return "update";
	}
	
	@RequestMapping("/car/delete/{id}")
	public String deleteCar(@PathVariable String id) {
		List<CarModel> archieve = mobilService.getCarList();
		CarModel cari = null;
		for (CarModel car : archieve) {
			if (car.getId().equals(id)) {
				cari=car;
			}
		}
		archieve.remove(cari);
		return "delete";
	}
}
