package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;






public class UserServiceTest {

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById() {
        User user = new User();
        user.setId(1L);
        when(userMapper.findById(1L)).thenReturn(user);

        User result = userService.findById(1L);
        assertEquals(1L, result.getId());
        verify(userMapper, times(1)).findById(1L);
    }

    @Test
    public void testFindAll() {
        User user1 = new User();
        user1.setId(1L);
        User user2 = new User();
        user2.setId(2L);
        List<User> users = Arrays.asList(user1, user2);
        when(userMapper.findAll()).thenReturn(users);

        List<User> result = userService.findAll();
        assertEquals(2, result.size());
        verify(userMapper, times(1)).findAll();
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setId(1L);

        userService.insert(user);
        verify(userMapper, times(1)).insert(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1L);

        userService.update(user);
        verify(userMapper, times(1)).update(user);
    }

    @Test
    public void testDelete() {
        userService.delete(1L);
        verify(userMapper, times(1)).delete(1L);
    }
}