package com.project1.taskmanagementsystem.controller;

import com.project1.taskmanagementsystem.dto.UserDto;
import com.project1.taskmanagementsystem.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService ;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createUser=userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUser);

    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        UserDto user=userService.getUserById(id);
        if (user != null) {
            
            return ResponseEntity.ok(user);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/username/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username){
         UserDto user= userService.getUserByUsername(username);
         if(user!=null){
             return ResponseEntity.ok(user);
         }else{
             return ResponseEntity.notFound().build();
         }
    }
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
       List<UserDto> user= userService.getAllUsers();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }


}
