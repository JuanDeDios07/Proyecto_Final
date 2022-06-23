package edu.ilp.sysgailp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ilp.sysgailp.entity.Docente;
import edu.ilp.sysgailp.entity.Escuela;
import edu.ilp.sysgailp.entity.fichaMatricula;
import edu.ilp.sysgailp.payload.RestResponse;
import edu.ilp.sysgailp.service.IFicha_MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ficha_matricula")
public class Ficha_MatriculaController {
    @Autowired
    private IFicha_MatriculaService fichaMatriculaService;
    @Autowired
    private ObjectMapper objectMapper;

    //listar Ficha Matricula
   // @GetMapping("/listaFichaM")
    //public List<fichaMatricula> listaFichasMatricula() {
       // return this.fichaMatriculaService.ListaFichaMatricula2022();
    //}

    //listar docente por semestre
    @GetMapping("/lista")
    public RestResponse listaFichaM(@RequestParam String semestre) {
        List<fichaMatricula> FichaMList = this.fichaMatriculaService.listaFichas(semestre);
        try {
            if (FichaMList.isEmpty()) {
                return new RestResponse(HttpStatus.NO_CONTENT.value(), "No se encontraron registros");
            } else {
                return new RestResponse(HttpStatus.OK.value(), "Registro de Ficha-Matricula ubicados", FichaMList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Lamentamos el inconveniente, vuelva mas tarde");
        }
    }


    //Registrar Ficha de Matricula
    @PostMapping("/registrar")
    public RestResponse registrarFichaM(@RequestBody String jsonFichaM) throws JsonProcessingException {

        fichaMatricula fichaMatricula = this.objectMapper.readValue(jsonFichaM, fichaMatricula.class);
        try {
            this.fichaMatriculaService.guardarFicha(fichaMatricula);
            return new RestResponse(HttpStatus.OK.value(), "La Ficha-Matricula se registró correctamente", fichaMatricula);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Lamentamos el inconveniente, vuelva mas tarde");
        }
    }

    //Eliminar Ficha matricula
    @PostMapping("/eliminar/{id}")
    public String eliminarFicha(@PathVariable Long id) {
        this.fichaMatriculaService.eliminarFichaM(id);
        return "Registro de Fichas eliminado correctamente";
    }

    //Actualizar Ficha de matricula
    @PutMapping("/actualizar")
    public String actualizarFichaM(@RequestBody String jsonFichaM) throws JsonProcessingException {

        fichaMatricula fichaMatricula = this.objectMapper.readValue(jsonFichaM, fichaMatricula.class);
        this.fichaMatriculaService.guardarFicha(fichaMatricula);

        return "Datos dela Ficha-Matricula se actualizó correctamente";
    }

    //Listar Ficha-M semestre o matricula
    @GetMapping("/listarBySemestreM/{appnombre}")
    public List<fichaMatricula> listarPorSemestreMatricula(@PathVariable String appnombre){
       return this.fichaMatriculaService.obtenerFichaPorSemestreMatricula(appnombre);
    }

    //lista de ficha de matricula 001

    @GetMapping("/lista001")
    public RestResponse listaFichaMatricula(){

        List<fichaMatricula> FMatriculaList = this.fichaMatriculaService.listarFichaMatricula01();
        try{
            if (FMatriculaList.isEmpty()){
                return new RestResponse(HttpStatus.NO_CONTENT.value(),"No se encontraron registros");
            }else {
                return new RestResponse(HttpStatus.OK.value(),"Registro de estudiantes ubicados",FMatriculaList);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Lamentamos el inconveniente, vuelva mas tarde");
        }
    }
}
