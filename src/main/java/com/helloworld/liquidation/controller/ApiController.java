package com.helloworld.liquidation.controller;


import com.helloworld.liquidation.model.Sinister;
import com.helloworld.liquidation.service.SinisterService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/areaCliente")
public class ApiController {

    private final SinisterService sinisterService;

    public ApiController(SinisterService sinisterService) {
        this.sinisterService = sinisterService;
    }

    @PostMapping("/sinister")
    public void createSinister(@RequestBody Sinister sinister, Model model){
        sinisterService.createSinister(sinister);
        model.addAttribute("sinister", "siniestro creado");
    }

    @GetMapping("/sinister/{code}")
    public Sinister getSinister(@RequestBody String code){
        return null;
    }

    @PutMapping("/sinister/update/{sinister}")
    public void updateSinister(@RequestBody Sinister sinister){
        // Fecha y riesgo no se modifican. Si la valoracion cambia, se
        // recalcula la liquidacion.



    }

    @DeleteMapping("/sinister/delete/{code}")
    public void deleteSinister(@RequestBody String code){

    }


}
