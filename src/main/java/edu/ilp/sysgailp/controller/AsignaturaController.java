package edu.ilp.sysgailp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ilp.sysgailp.entity.Asignatura;
import edu.ilp.sysgailp.entity.Escuela;
import edu.ilp.sysgailp.payload.RestResponse;
import edu.ilp.sysgailp.service.IAsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("asignatura")
public class AsignaturaController {
    @Autowired
    private IAsignaturaService asignaturaService
            ;
    @Autowired
    private ObjectMapper objectMapper;

    //listar Asignatura
    //@GetMapping("/listaAsignatura")
    //public List<Asignatura> listaAsignatura(){
       // return this.asignaturaService.ListaAsignatura2022();
   // }

    //listar Asignatura por curso
    @GetMapping("/listaAsignatura2022")
    public Asignatura listaAsignatura2022(@RequestParam String codigo){

        return this.asignaturaService.obtenerAsignaturaPorCodigo(codigo);
    }

    //Registrar Asignatura
    @PostMapping("/registrar")
    public RestResponse registrarAsignatura(@RequestBody String jsonAsignatura) throws JsonProcessingException {

        Asignatura asignatura = this.objectMapper.readValue(jsonAsignatura, Asignatura.class);
        try {
            this.asignaturaService.guardarAsignatura(asignatura);
            return new RestResponse(HttpStatus.OK.value(),"La Asignatura se registró correctamente",asignatura);
        }catch (Exception e) {
            e.printStackTrace();
            return new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Lamentamos el inconveniente, vuelva mas tarde");
        }
    }

    //Eliminar Asignatura
    @PostMapping("/eliminar/{id}")
    public String eliminarAsignatura(@PathVariable Long id){
        this.asignaturaService.eliminarUnaAsignatura(id);
        return "Registro de Asignatura eliminado correctamente";
    }

    //Actualizar Asignatura
    @PutMapping("/actualizar")
    public String actualizarAsignatura(@RequestBody String jsonAsignatura) throws JsonProcessingException {

        Asignatura asignatura = this.objectMapper.readValue(jsonAsignatura, Asignatura.class);
        this.asignaturaService.guardarAsignatura(asignatura);

        return "Datos del Asignatura se actualizó correctamente";
    }

    //lista de asignatura 001

    @GetMapping("/lista01")
    public RestResponse listaAsignatura(){

        List<Asignatura> asignaturaList = this.asignaturaService.listarAsignatura();
        try{
            if (asignaturaList.isEmpty()){
                return new RestResponse(HttpStatus.NO_CONTENT.value(),"No se encontraron registros");
            }else {
                return new RestResponse(HttpStatus.OK.value(),"Registro de estudiantes ubicados",asignaturaList);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Lamentamos el inconveniente, vuelva mas tarde");
        }
    }
}
