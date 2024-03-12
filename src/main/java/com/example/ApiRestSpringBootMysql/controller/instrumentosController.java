package com.example.ApiRestSpringBootMysql.controller;
import com.example.ApiRestSpringBootMysql.model.InstrumentosModel;
import com.example.ApiRestSpringBootMysql.service.InstrumentosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
class InstrumentosController {

    @Autowired
    private InstrumentosService instrumentosService;

    @Operation(summary = "Obtiene todos los instrumentos", description = "Obtiene una lista de todos los instrumentos", tags = {"instrumentos"})
    @ApiResponse(responseCode = "200", description = "Lista de instrumentos")
    @GetMapping("/instrumentos")
    public List<InstrumentoModel> getAllInstrumentos() {
        return instrumentosService.getAllInstrumentos();
    }

    @Operation(summary = "Añade un instrumento",description = "Añade un nuevo instrumento a la BD", tags = {"instrumentos"})
    @ApiResponse(responseCode = "201", description = "Instrumento añadido con éxito")
    @ApiResponse(responseCode = "404", description = "Hubo un error")
    @PostMapping("/instrumentos")
    public ResponseEntity<InstrumentosModel> createInstrumento(@RequestBody InstrumentosModel instrumento) {
        InstrumentosModel createdInstrumento = instrumentosService.createInstrumento(instrumento);
        return new ResponseEntity<>(createdInstrumento, HttpStatus.CREATED);
    }

    @Operation(summary = "Obtiene un instrumento", description = "Obtiene un instrumento a partir de su ID", tags = {"instrumentos"})
    @Parameter(name = "id", description = "ID del instrumento", required = true, example = "1")
    @ApiResponse(responseCode = "200", description = "Instrumento encontrado")
    @ApiResponse(responseCode = "404", description = "Instrumento no encontrado")
    @GetMapping("/instrumentos/{id}")
    public ResponseEntity<InstrumentosModel> getInstrumentoById(@PathVariable Long id) {
        Optional<InstrumentoModel> instrumento = instrumentosService.getInstrumentoById(id);
        if (instrumento.isPresent()) {
            return new ResponseEntity(instrumento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Actualiza un instrumento", description = "Actualiza un instrumento a partir de su ID", tags = {"instrumentos"})
    @Parameter(name = "id", description = "ID del instrumento", required = true, example = "1")
    @ApiResponse(responseCode = "200", description = "Instrumento actualizado")
    @ApiResponse(responseCode = "404", description = "Instrumento no encontrado")
    @PutMapping("/instrumentos/{id}")
    public ResponseEntity<InstrumentosModel> updateInstrumento(@PathVariable Long id, @RequestBody InstrumentosModel instrumentoDetails) {
        InstrumentosModel updatedInstrumento = instrumentosService.updateInstrumento(id, instrumentoDetails);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Elimina un instrumento", description = "Elimina un instrumento a partir de su ID", tags = {"instrumentos"})
    @Parameter(name = "id", description = "ID del instrumento", required = true, example = "1")
    @ApiResponse(responseCode = "200", description = "Instrumento eliminado")
    @ApiResponse(responseCode = "404", description = "Instrumento no encontrado")
    @DeleteMapping("/instrumentos/{id}")
    public ResponseEntity<Void> deleteInstrumento(@PathVariable Long id) {
        boolean deleted = instrumentosService.deleteInstrumento(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
