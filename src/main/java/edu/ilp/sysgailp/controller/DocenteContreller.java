package edu.ilp.sysgailp.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ilp.sysgailp.entity.Docente;
import edu.ilp.sysgailp.payload.RestResponse;
import edu.ilp.sysgailp.service.IEDocenteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("docente")
public class DocenteContreller {
    @Autowired
    private IEDocenteServicio docenteServicio;
    @Autowired
    private ObjectMapper objectMapper;

    //listar docente
    @GetMapping("/listadocentes")
    public List<Docente> listadocentes(){
        return this.docenteServicio.ListaDocente2022();
    }
    //listar docente por curso
    @GetMapping("/lista")
    public RestResponse listaDocente(@RequestParam String curso){
        List<Docente> docenteList = this.docenteServicio.listaDocentes(curso);
        try{
            if (docenteList.isEmpty()){
                return new RestResponse(HttpStatus.NO_CONTENT.value(),"No se encontraron registros");
            }else {
                return new RestResponse(HttpStatus.OK.value(),"Registro de Docente ubicados",docenteList);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Lamentamos el inconveniente, vuelva mas tarde");
        }
    }
    //Registrar docente
    @PostMapping("/registrar")
    public RestResponse registrarDocente(@RequestBody String jsonDocente) throws JsonProcessingException {

        Docente docente = this.objectMapper.readValue(jsonDocente, Docente.class);
        try {
            this.docenteServicio.guardarDocente(docente);
            return new RestResponse(HttpStatus.OK.value(),"El Docente se registró correctamente",docente);
        }catch (Exception e) {
            e.printStackTrace();
            return new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Lamentamos el inconveniente, vuelva mas tarde");
        }
    }
    //Eliminar docente
    @PostMapping("/eliminar/{id}")
    public String eliminarDocente(@PathVariable Long id){
        this.docenteServicio.eliminarUnDocente(id);
        return "Registro de Docente eliminado correctamente";
    }
    //Actualizar Docente
    @PutMapping("/actualizar")
    public String actualizarDocente(@RequestBody String jsonDocente) throws JsonProcessingException {

        Docente docente = this.objectMapper.readValue(jsonDocente, Docente.class);
        this.docenteServicio.guardarDocente(docente);

        return "Datos del Docente se actualizó correctamente";
    }

    //Listar Docetepor nombre o apellido
    @GetMapping("/listarByAppnombre/{appnombre}")
    public List<Docente> listarPorApellidoNombre(@PathVariable String appnombre){
        return this.docenteServicio.obtenerDocentePorApellidoNOM(appnombre);
    }
}
