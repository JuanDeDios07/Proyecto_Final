package edu.ilp.sysgailp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ilp.sysgailp.entity.Persona;
import edu.ilp.sysgailp.payload.RestResponse;
import edu.ilp.sysgailp.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persona")
public class PersonaController {

    @Autowired
    private IPersonaService personaService;
    @Autowired
    private ObjectMapper objectMapper;

    //listar listaPersona
    @GetMapping("/listaPersona")
    public List<Persona> listaPersona(){

        return this.personaService.ListaPersona2022();
    }

    //lista Persona por cargo

    @GetMapping("/listaPersona2022")
    public Persona listaPersona(@RequestParam String codigo){

        return this.personaService.obtenerPersonaPorCodigo(codigo);
    }

    //Registrar Persona
    @PostMapping("/registrar")
    public RestResponse registrarPersona(@RequestBody String jsonPersona) throws JsonProcessingException {

        Persona persona = this.objectMapper.readValue(jsonPersona, Persona.class);
        try {
            this.personaService.guardarPersona(persona);
            return new RestResponse(HttpStatus.OK.value(),"La Persona se registró correctamente",persona);
        }catch (Exception e) {
            e.printStackTrace();
            return new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Lamentamos el inconveniente, vuelva mas tarde");
        }
    }

    //Eliminar Persona
    @PostMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id){
        this.personaService.eliminarUnaPersona(id);
        return "Registro de Persona eliminado correctamente";
    }

    //Actualizar Persona
    @PutMapping("/actualizar")
    public String actualizarPersona(@RequestBody String jsonPersona) throws JsonProcessingException {

        Persona persona = this.objectMapper.readValue(jsonPersona, Persona.class);
        this.personaService.guardarPersona(persona);

        return "Datos de la Persona se actualizó correctamente";
    }

    //Listar Persona por nombre o apellido
    @GetMapping("/listarByAppnombre/{appnombre}")
    public List<Persona> listarPorApellidoNombre(@PathVariable String appnombre){
        return this.personaService.obtenerPersonaPorApellidoNOM(appnombre);
    }
}
