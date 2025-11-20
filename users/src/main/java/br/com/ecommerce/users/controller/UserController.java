package br.com.ecommerce.users.controller;

import br.com.ecommerce.users.dto.UserCreateDto;
import br.com.ecommerce.users.dto.UserResponseDto;
import br.com.ecommerce.users.dto.mapper.UserMapper;
import br.com.ecommerce.users.entity.User;
import br.com.ecommerce.users.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping
  public ResponseEntity<UserResponseDto> createUser(@RequestBody UserCreateDto userCreateDto) {
    User user = userService.createUser(UserMapper.toUser(userCreateDto));
    URI uri = UriComponentsBuilder.fromPath("/{id}").buildAndExpand(
        user.getId()).toUri();
    return ResponseEntity.created(uri).body(UserMapper.toResponseDto(user));
  }

  @GetMapping
  public ResponseEntity<Page<UserResponseDto>> getAllUsers(@PageableDefault(size = 10, page = 0) Pageable pageable) {
    Page<UserResponseDto> mappedUsers = userService.getAllUsers(pageable).map(
            user -> UserMapper.toResponseDto(user));
    return ResponseEntity.ok(mappedUsers);
  }
}
