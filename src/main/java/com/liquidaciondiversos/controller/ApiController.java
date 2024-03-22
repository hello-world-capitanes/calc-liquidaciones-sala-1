package com.liquidaciondiversos.controller;

import com.liquidaciondiversos.model.Client;
import com.liquidaciondiversos.model.Sinister;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/areaCliente")
public class ApiController {


    @PostMapping("/sinister")
    public Sinister createSinister(@RequestBody Sinister sinister){

    }

    @GetMapping("/sinister/{code}")
    public Sinister getSinister(@RequestBody String code){

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
