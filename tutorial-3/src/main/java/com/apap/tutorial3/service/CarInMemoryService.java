package com.apap.tutorial3.service;
import java.util.List;
import java.util.ArrayList;

import com.apap.tutorial3.model.CarModel;

import org.springframework.stereotype.Service;

@Service
public class CarInMemoryService implements CarService{
	private List<CarModel> archieveCar;
	
	public CarInMemoryService() {
		archieveCar = new ArrayList<>();
	}
	
	@Override
	public void addCar(CarModel car) {
		archieveCar.add(car);
	}
	
	@Override
	public List<CarModel> getCarList(){
		return archieveCar;
	}
	
	@Override
	public CarModel getCarDetail(String id) {
		CarModel cm = null;
		for(CarModel car : archieveCar) {
			if (car.getId().equals(id)) {
				cm = car;
			}
		}
//		for (int i = 0; i < archieveCar.size(); i++) {
//			cm = archieveCar.get(i);
//			if (cm.getId().equals(id)) {
//				break;
//			} 
//		}
		return cm;
		
	}

}
