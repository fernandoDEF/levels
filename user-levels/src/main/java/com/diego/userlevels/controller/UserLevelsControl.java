package com.diego.userlevels.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diego.userlevels.entity.UserLevels;
import com.diego.userlevels.service.UserLevelsService;


@RestController
@RequestMapping("levels/userlevels")
public class UserLevelsControl {
	
	@Autowired
	private UserLevelsService userlevelsService;
	
	//create new user levels
	@PostMapping
	public ResponseEntity<?> create (@RequestBody UserLevels userlevels){
		return ResponseEntity.status(HttpStatus.CREATED).body(userlevelsService.save(userlevels));
	}
	
	//read an user levels
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long userlevelsid){
        Optional<UserLevels> oUserLevels =	userlevelsService.findById(userlevelsid);
        
        if(!oUserLevels.isPresent()) {
        	return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(oUserLevels);
	}
    //Update an user levels
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody UserLevels userLevelsDetails, @PathVariable(value = "id") Long userlevelsid){
		Optional<UserLevels> userlevels = userlevelsService.findById(userlevelsid);
		 
		if(!userlevels.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		//BeanUtils.copyProperties(userLevelsDetails, userlevels);
		userlevels.get().setName(userLevelsDetails.getName());
		userlevels.get().setLevel(userLevelsDetails.getLevel());
		userlevels.get().setProgress(userLevelsDetails.getProgress());
		userlevels.get().setEnable(userLevelsDetails.getEnable());
		return ResponseEntity.status(HttpStatus.CREATED).body(userlevelsService.save(userlevels.get()));
	}
	
    //delete an user levels
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id") Long userlevelsid){
		if(!userlevelsService.findById(userlevelsid).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		userlevelsService.deleteById(userlevelsid);
		return ResponseEntity.ok().build();
	}
	
	//read all users levels
	@GetMapping("/userAll")
	public List<UserLevels> realAll (){
		List<UserLevels> userlevels = StreamSupport
				.stream(userlevelsService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return userlevels;
    }
}
