package ru.practicum.ewm.users;

import ru.practicum.ewm.users.dto.NewUserRequest;
import ru.practicum.ewm.users.dto.UserDto;

import java.util.List;

public interface UserServiceInt {

    UserDto addUser(NewUserRequest newUserRequest);

    List<UserDto> getUsers(List<Long> userIds, Integer from, Integer size);

    void deleteUser(Long userId);

}
