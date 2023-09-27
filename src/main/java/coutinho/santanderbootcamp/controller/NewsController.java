package coutinho.santanderbootcamp.controller;

import coutinho.santanderbootcamp.domain.model.BaseItem;
import coutinho.santanderbootcamp.domain.model.News;
import coutinho.santanderbootcamp.service.BaseService;
import coutinho.santanderbootcamp.service.impl.NewsServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/news")
@Tag(name = "News", description = "Bank news about its products and events")
public class NewsController {

    @Autowired
    private NewsServiceImpl baseService;

    @GetMapping("/id/{id}")
    @Operation(description = "Get a Bank News by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "Bank News not found", content = @Content)
    })
    public ResponseEntity<BaseItem> findById(@PathVariable(name = "id")
                                             @Parameter(name = "id",
                                                     description = "Bank News ID",
                                                     example = "1") Long id) {
        BaseItem newsDb = baseService.findById(id);
        return ResponseEntity.ok(newsDb);
    }

    @GetMapping("/code/{code}")
    @Operation(description = "Get a Bank News by Code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "422", description = "Bank News code not found", content = @Content)
    })
    public ResponseEntity<BaseItem> findByCode(@PathVariable(name = "code")
                                               @Parameter(name = "code",
                                                       description = "Bank News Code",
                                                       example = "NW-001") String code) {
        BaseItem newsDb = baseService.findByCode(code);
        return ResponseEntity.ok(newsDb);

    }

    @PostMapping
    @Operation(description = "Create a Bank News")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Bank News created successfully"),
            @ApiResponse(responseCode = "422", description = "Business Exception. Please check the payload", content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error not handled", content = @Content)
    })
    public ResponseEntity<News> createNews(@RequestBody @Valid News news) {
        baseService.create(news);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(news.getId())
                .toUri();
        return ResponseEntity.created(location).body(news);
    }
}
