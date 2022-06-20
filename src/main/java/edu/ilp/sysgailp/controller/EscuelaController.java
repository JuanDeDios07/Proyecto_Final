package edu.ilp.sysgailp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ilp.sysgailp.entity.Escuela;
import edu.ilp.sysgailp.entity.Estudiante;
import edu.ilp.sysgailp.payload.RestResponse;
import edu.ilp.sysgailp.service.IEscuelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("escuela")
public class EscuelaController {

    @Autowired
    private IEscuelaService escuelaService;
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/lista")
    public RestResponse listaEscuela(){

        List<Escuela> escuelaList = this.escuelaService.listarEscuelas();
        try{
            if (escuelaList.isEmpty()){
                return new RestResponse(HttpStatus.NO_CONTENT.value(),"No se encontraron registros");
            }else {
                return new RestResponse(HttpStatus.OK.value(),"Registro de estudiantes ubicados",escuelaList);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Lamentamos el inconveniente, vuelva mas tarde");
        }
    }

    @PostMapping("/registrar")
    public RestResponse registrarEscuela(@RequestBody String jsonEscuela) throws JsonProcessingException {

        Escuela escuela = this.objectMapper.readValue(jsonEscuela, Escuela.class);
        try {
            this.escuelaService.registraEscuela(escuela);
            return new RestResponse(HttpStatus.OK.value(),"La Escuela se registró correctamente",escuela);
        }catch (Exception e) {
            e.printStackTrace();
            return new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Lamentamos el inconveniente, vuelva mas tarde");
        }
    }
}
