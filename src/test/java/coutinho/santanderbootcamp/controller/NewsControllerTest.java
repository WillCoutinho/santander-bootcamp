package coutinho.santanderbootcamp.controller;

import coutinho.santanderbootcamp.domain.model.BaseItem;
import coutinho.santanderbootcamp.domain.model.News;
import coutinho.santanderbootcamp.service.impl.NewsServiceImpl;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class NewsControllerTest {

    @InjectMocks
    private NewsController newsController;

    @Mock
    private NewsServiceImpl newsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("[Unit] Find News by ID")
    public void testFindById() {
        Long id = 1L;
        News newsItem = new News("news-icon-test", "NW-test", "Test News");
        when(newsService.findById(id)).thenReturn(newsItem);

        ResponseEntity<BaseItem> response = newsController.findById(id);

        assertNotNull(newsItem, "Object 'News' should not be null");
        assertEquals(200, response.getStatusCode().value(), "Status code should be '200'");
        assertEquals(newsItem, response.getBody(), "Response body should be the same");
    }

    @Test
    @DisplayName("[Unit] Find News by Code")
    public void testFindByCode() {
        String code = "NW-Test-000";
        News newsItem = new News("news-icon-test", "NW-test-000", "Test News by Code");
        when(newsService.findByCode(code)).thenReturn(newsItem);

        ResponseEntity<BaseItem> response = newsController.findByCode(code);

        assertEquals(200, response.getStatusCode().value(), "Status code should be '200'");
        assertEquals(newsItem, response.getBody(), "Response body should be the same");
    }

    @Test
    @DisplayName("[Unit] Create Bank News")
    public void testCreateNews() {
        News news = new News("news-icon-create-test", "NW-create-test", "Create Test News");
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(news.getId())
                .toUri();

        ResponseEntity<News> response = ResponseEntity.created(location).body(news);
        when(newsService.create(news)).thenReturn(news);

        assertEquals(newsController.createNews(news).getBody(), response.getBody(), "Response body should be the same");
        assertEquals(201, response.getStatusCode().value(), "Status code should be '201'");
    }
}
