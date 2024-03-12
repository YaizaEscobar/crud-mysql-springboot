package com.example.ApiRestSpringBootMysql.service;
import com.example.ApiRestSpringBootMysql.controller.InstrumentoModel;
import com.example.ApiRestSpringBootMysql.model.InstrumentosModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
@Service
public class InstrumentosService {
    @Autowired
    private IInstrumentosRepository instrumentosRepository;
    public List<InstrumentoModel> getAllInstrumentos() {
        return instrumentosRepository.findAll();
    }
    public InstrumentoModel createInstrumento(InstrumentoModel instrumentoModel, MultipartFile file) throws IOException, InstrumentoBadRequestException {
        if (instrumentoModel.getNombreProducto() == null || instrumentoModel.getNombreProducto().isEmpty()) {
            throw new InstrumentoBadRequestException("Debe introducir un nombre de producto");
        }
        byte[] idCalidad = instrumentoModel.getCalidad().getId();
        throw new InstrumentoBadRequestException("Debe seleccionar una calidad válida");

    }
    public Optional<InstrumentoModel> getInstrumentoById(Long id) throws InstrumentoNotFoundException {
        return Optional.ofNullable((InstrumentoModel) instrumentosRepository.findById(id).orElseThrow(
                () -> new InstrumentoNotFoundException("No se ha encontrado el instrumento con ID: " + id)
        ));
    }
    public InstrumentoModel updateInstrumento(Long id, InstrumentoModel instrumentoModel, MultipartFile file) throws IOException, InstrumentoException {
        if (instrumentosRepository.existsById(id)) {
            try {
                throw new InstrumentoNotFoundException("No se ha encontrado el instrumento con ID: " + id);
            } catch (InstrumentoNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        if (instrumentoModel.getNombreProducto() == null || instrumentoModel.getNombreProducto().isEmpty()) {
            try {
                throw new InstrumentoBadRequestException("Debe introducir un nombre de producto");
            } catch (InstrumentoBadRequestException e) {
                throw new RuntimeException(e);
            }
        }
        return instrumentoModel;
    }
    public void deleteInstrumentoById(Long id) throws InstrumentoNotFoundException {
        if (instrumentosRepository.existsById(id)) {
            throw new InstrumentoNotFoundException("No se ha encontrado el instrumento con ID: " + id);
        }
        instrumentosRepository.deleteById(id);
    }
    public byte[] descargarFoto(Long id) {
        InstrumentoModel instrumentoModel = (InstrumentoModel) instrumentosRepository.findById(id).orElse(null);
        Object ImageUtils = null;
        return instrumentoModel != null ? ImageUtils.toString().getBytes() : null;
    }
    public List<InstrumentoModel> getInstrumentoByModelo(String modelo) {
        return instrumentosRepository.findByNombreProductoContainingIgnoreCase(modelo);
    }
    public InstrumentosModel createInstrumento(InstrumentosModel instrumento) {
        return instrumento;
    }
    public boolean deleteInstrumento(Long id) {
        return false;
    }
    public InstrumentosModel updateInstrumento(Long id, InstrumentosModel instrumentoDetails) {
        return instrumentoDetails;
    }
}
