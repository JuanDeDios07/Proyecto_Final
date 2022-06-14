package edu.ilp.sysgailp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ilp.sysgailp.entity.Administrativo;
import edu.ilp.sysgailp.payload.RestResponse;
import edu.ilp.sysgailp.service.IAdministrativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("administrativo")
public class AdministrativoController{

    @Autowired
    private IAdministrativoService administrativoService;
    @Autowired
    private ObjectMapper objectMapper;
    //listar listaAdministartivo
    @GetMapping("/listaAdministartivo")
    public List<Administrativo> listaAdministartivo(){

        return this.administrativoService.ListaAdministrativo2022();
    }
    //lista Administartivo por cargo


    @GetMapping("/listaAdministartivo2022")
    public Administrativo listaAdministartivo(@RequestParam String codigo){

        return this.administrativoService.obtenerAdministrativoPorCodigo(codigo);
    }

    //Registrar Administrativo
    @PostMapping("/registrar")
    public RestResponse registrarAdministrativo(@RequestBody String jsonAdministrativo) throws JsonProcessingException {

        Administrativo administrativo = this.objectMapper.readValue(jsonAdministrativo, Administrativo.class);
        try {
            this.administrativoService.guardarAdministrativo(administrativo);
            return new RestResponse(HttpStatus.OK.value(),"El Administrativo se registró correctamente",administrativo);
        }catch (Exception e) {
            e.printStackTrace();
            return new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Lamentamos el inconveniente, vuelva mas tarde");
        }
    }

    //Eliminar Administrativo
    @PostMapping("/eliminar/{id}")
    public String eliminarAdministrativo(@PathVariable Long id){
        this.administrativoService.eliminarUnadministrativo(id);
        return "Registro de Administrativo eliminado correctamente";
    }

    //Actualizar Administrativo
    @PutMapping("/actualizar")
    public String actualizarAdministrativo(@RequestBody String jsonAdministrativo) throws JsonProcessingException {

        Administrativo administrativo = this.objectMapper.readValue(jsonAdministrativo, Administrativo.class);
        this.administrativoService.guardarAdministrativo(administrativo);

        return "Datos del Administrativo se actualizó correctamente";
    }

    //Listar Administrativo por nombre o apellido
    @GetMapping("/listarByAppnombre/{appnombre}")
    public List<Administrativo> listarPorApellidoNombre(@PathVariable String appnombre){
        return this.administrativoService.obteneradministrativoPorApellidoNOM(appnombre);
    }
}
