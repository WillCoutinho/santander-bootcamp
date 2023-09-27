package coutinho.santanderbootcamp.controller;

import coutinho.santanderbootcamp.domain.model.BaseItem;
import coutinho.santanderbootcamp.domain.model.Feature;
import coutinho.santanderbootcamp.service.BaseService;
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
@RequestMapping("/feature")
@Tag(name = "Bank Features")
public class FeatureController {

    @Autowired
    private BaseService baseService;

    @GetMapping("/id/{id}")
    @Operation(description = "Get a Feature by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "Feature not found", content = @Content)
    })
    public ResponseEntity<BaseItem> findById(@PathVariable(name = "id")
                                             @Parameter(name = "id",
                                                     description = "Feature ID",
                                                     example = "1") Long id) {
        BaseItem featureDb = baseService.findById(id);
        return ResponseEntity.ok(featureDb);

    }

    @GetMapping("/code/{code}")
    @Operation(description = "Get a Feature by Code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "Feature not found", content = @Content)
    })
    public ResponseEntity<BaseItem> findByCode(@PathVariable(name = "code")
                                               @Parameter(name = "code",
                                                       description = "Feature Code",
                                                       example = "FT-001") String code) {
        BaseItem featureDb = baseService.findByCode(code);
        return ResponseEntity.ok(featureDb);

    }

    @PostMapping
    @Operation(description = "Create a Bank Feature")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Feature created successfully"),
            @ApiResponse(responseCode = "422", description = "Business Exception. Please check the payload", content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error not handled", content = @Content)
    })
    public ResponseEntity<BaseItem> createFeature(@RequestBody @Valid Feature feature) {
        baseService.create(feature);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(feature.getId())
                .toUri();
        return ResponseEntity.created(location).body(feature);
    }
}
