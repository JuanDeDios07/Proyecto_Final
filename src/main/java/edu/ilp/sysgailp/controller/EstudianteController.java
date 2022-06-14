package edu.ilp.sysgailp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ilp.sysgailp.entity.Escuela;
import edu.ilp.sysgailp.entity.Estudiante;
import edu.ilp.sysgailp.payload.RestResponse;
import edu.ilp.sysgailp.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("estudiante")
public class EstudianteController {

    @Autowired
    private IEstudianteService estudianteService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/registrar")
    public RestResponse registrarEstudiante(@RequestBody String jsonEstudiante) throws JsonProcessingException {

        Estudiante estudiante = this.objectMapper.readValue(jsonEstudiante, Estudiante.class);
        try {
            this.estudianteService.guardarEstudiante(estudiante);
            return new RestResponse(HttpStatus.OK.value(),"El estudiante se registró correctamente",estudiante);
        }catch (Exception e) {
            e.printStackTrace();
            return new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Lamentamos el inconveniente, vuelva mas tarde");
        }
    }

    @GetMapping("/lista")
    public RestResponse listaEstudiantes(@RequestParam Escuela idescuela){
        List<Estudiante> estudianteList = this.estudianteService.listaEstudiante(idescuela);
        try{
            if (estudianteList.isEmpty()){
                return new RestResponse(HttpStatus.NO_CONTENT.value(),"No se encontraron registros");
            }else {
                return new RestResponse(HttpStatus.OK.value(),"Registro de estudiantes ubicados",estudianteList);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Lamentamos el inconveniente, vuelva mas tarde");
        }
    }

    @GetMapping("/listaPage")
    public Page<Estudiante> listaEstudiantesPage(@RequestParam Escuela idescuela, @RequestParam int pagina){

        Pageable page = PageRequest.of(pagina,2);

        return this.estudianteService.listaEstudianteByPagina(page,idescuela);
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable Long id){
        this.estudianteService.eliminarUnEstudiante(id);
        return "Registro de estudiante eliminado correctamente";
    }

    @GetMapping("/buscar/{coddni}")
    public Estudiante buscarEstudiante(@PathVariable String coddni){
        return this.estudianteService.obtenerEstudiante(coddni);
    }

    @GetMapping("/listarByAppnombre/{appnombre}")
    public List<Estudiante> listarPorApellidoNombre(@PathVariable String appnombre){
        return this.estudianteService.obtenerEstudiantePorApellidoNOM(appnombre);
    }

    @PutMapping("/actualizar")
    public String actualizarEstudiante(@RequestBody String jsonEstudiante) throws JsonProcessingException {

        Estudiante estudiante = this.objectMapper.readValue(jsonEstudiante, Estudiante.class);
        this.estudianteService.guardarEstudiante(estudiante);

        return "Datos del estudiante se actualizó correctamente";
    }

    //listar estudiantes
    @GetMapping("/listaestudiante")
    public List<Estudiante> listaestudiante(){
        return this.estudianteService.ListaEstudiantes();
    }
}
