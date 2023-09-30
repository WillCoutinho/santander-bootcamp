package coutinho.santanderbootcamp.controller;

import coutinho.santanderbootcamp.domain.model.BaseItem;
import coutinho.santanderbootcamp.domain.model.Feature;
import coutinho.santanderbootcamp.domain.model.News;
import coutinho.santanderbootcamp.service.impl.FeatureServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FeatureControllerTest {

    @InjectMocks
    private FeatureController featureController;

    @Mock
    private FeatureServiceImpl featureService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("[Unit] Find Feature by ID")
    public void testFindById() {
        Long id = 1L;
        Feature featureItem = new Feature("feature-icon-test", "FT-test", "Test Feature");
        when(featureService.findById(id)).thenReturn(featureItem);

        ResponseEntity<BaseItem> response = featureController.findById(id);

        assertEquals(200, response.getStatusCode().value());
        assertEquals(featureItem, response.getBody());
    }

    @Test
    @DisplayName("[Unit] Find Feature by Code")
    public void testFindByCode() {
        String code = "FT-Test-000";
        Feature featureItem = new Feature("feature-icon-test", "FT-Test-000", "Test Feature");
        when(featureService.findByCode(code)).thenReturn(featureItem);

        ResponseEntity<BaseItem> response = featureController.findByCode(code);

        assertEquals(200, response.getStatusCode().value(), "Status code should be '200'");
        assertEquals(featureItem, response.getBody(), "Response body should be the same");
    }

    @Test
    @DisplayName("[Unit] Create Bank Features")
    public void testCreateFeature() {
        Feature feature = new Feature("feature-icon-test", "FT-test", "Test Feature");
        when(featureService.create(feature)).thenReturn(feature);

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(feature.getId())
                .toUri();

        ResponseEntity<Feature> response = ResponseEntity.created(location).body(feature);

        assertEquals(201, response.getStatusCode().value(), "Status code should be '201'");
        assertEquals(feature, response.getBody(), "Response body should be the same");
    }
}