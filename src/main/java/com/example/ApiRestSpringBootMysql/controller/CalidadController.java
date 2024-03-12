package com.example.ApiRestSpringBootMysql.controller;
import com.example.ApiRestSpringBootMysql.model.CalidadModel;
import com.example.ApiRestSpringBootMysql.service.CalidadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1")
public class CalidadController {
    @Autowired
    private CalidadService calidadService;
    @Operation(summary = "Obtiene todas las calidades", description = "Obtiene una lista de todas las calidades", tags = {"calidades"})
    @ApiResponse(responseCode = "200", description = "Lista de calidades")
    @GetMapping("/calidades")
    public List<CalidadModel> getAllCalidades() {
        return calidadService.getAllCalidades();
    }

    @Operation(summary = "Obtiene una calidad", description = "Obtiene una calidad a partir de su ID", tags = {"calidades"})
    @Parameter(name = "id", description = "ID de la calidad", required = true, example = "1")
    @ApiResponse(responseCode = "200", description = "Calidad encontrada")
    @ApiResponse(responseCode = "404", description = "Calidad no encontrada")
    @GetMapping("/calidades/{id}")
    public ResponseEntity<CalidadModel> getCalidadById(@PathVariable Long id) {
        Optional<CalidadModel> optionalCalidadModel = calidadService.getCalidadById(id);

        return optionalCalidadModel.map(calidadModel -> new ResponseEntity<>(calidadModel, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
