package coutinho.santanderbootcamp.controller;

import static coutinho.santanderbootcamp.controller.exception.ExceptionMessages.*;

import coutinho.santanderbootcamp.controller.exception.GlobalExceptionHandler;
import coutinho.santanderbootcamp.domain.model.Account;
import coutinho.santanderbootcamp.domain.model.Card;
import coutinho.santanderbootcamp.domain.model.User;
import coutinho.santanderbootcamp.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    private User user;
    private Long id;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        id = 1L;
        user = new User("Test Name",
                new Account("010101-0",
                        "0001",
                        new BigDecimal("99999.99"),
                        new BigDecimal("99999.99")),
                new Card("0000 0000 0000 0000",
                        new BigDecimal("100000")),
                Arrays.asList("FT-001", "FT-002"),
                Arrays.asList("NW-001", "NW-002"));
    }

    @Test
    @DisplayName("[Unit] Find User by Id")
    public void testFindById() {
        when(userService.findById(id)).thenReturn(user);

        ResponseEntity<User> response = userController.findById(id);

        assertEquals(200, response.getStatusCode().value(), "Status code should be '200'");
        assertEquals(user, response.getBody(), "Response body should be the same");
    }

    @Test
    public void testCreateUser() {
        when(userService.create(user)).thenReturn(user);

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        ResponseEntity<User> response = userController.createUser(user);

        assertEquals(201, response.getStatusCode().value(), "Status code should be '201'");
        assertEquals(user, response.getBody());
    }

    @Test
    public void testDeleteUser() {
        ResponseEntity<Object> response = userController.deleteUser(id);

        verify(userService, times(1)).delete(id);
        assertEquals(200, response.getStatusCode().value(), "Status code should be '200'");
        assertEquals("Deleted successfully", response.getBody());
    }
}