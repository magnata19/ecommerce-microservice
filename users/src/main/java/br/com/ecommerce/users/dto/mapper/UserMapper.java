package br.com.ecommerce.users.dto.mapper;

import br.com.ecommerce.users.dto.UserCreateDto;
import br.com.ecommerce.users.dto.UserResponseDto;
import br.com.ecommerce.users.entity.User;
import org.modelmapper.ModelMapper;

public class UserMapper {

  public static User toUser (UserCreateDto dto) {
    return new ModelMapper().map(dto, User.class);
  }

  public static UserResponseDto toResponseDto (User user) {
    return new ModelMapper().map(user, UserResponseDto.class);
  }
}
