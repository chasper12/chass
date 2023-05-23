package com.crud.javashastra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.javashastra.entity.Phone;
import com.crud.javashastra.repository.PhoneRepository;

@Service
public class PhoneService {
	@Autowired
	PhoneRepository repository;

	public List<Phone> findallPhone() {
		return (List<Phone>) repository.findAll();
	}

	public Phone findPhoneById(int id) {
		Optional<Phone> result = repository.findById(id);
		if (result.isPresent()) {
			return result.get();
		}
		return new Phone();
	}

	public Phone addPhone(Phone phone) {
		return repository.save(phone);
	}

	public Phone updatePhone(Phone phone) {
		Optional<Phone> result = repository.findById(phone.getId());
		Phone existing = result.get();
		existing.setUname(phone.getUname());
		existing.setSize(phone.getSize());
		existing.setColor(phone.getColor());
		existing.setQuantity(phone.getQuantity());
		return repository.save(existing);
	}

	public void deleteById(int id) {
		repository.deleteById(id);
	}

}
