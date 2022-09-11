package br.com.mobusapp.mobus.controller;

import br.com.mobusapp.mobus.model.Bus;
import br.com.mobusapp.mobus.model.dto.BusDTO;
import br.com.mobusapp.mobus.service.BusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Bus")
public class BusLocalizationController {

    private static Logger LOGGER = LoggerFactory.getLogger(BusLocalizationController.class);

    public static List<BusDTO> listaEstatica = new ArrayList<>();
    public static Integer integer = 0;

    @Autowired
    private BusService service;

    @GetMapping("UpdateGPS")
    public void updateGPS(HttpServletResponse response,
                          @RequestParam String id, @RequestParam String lat, @RequestParam String lng) {
        try{
            service.updateGPS(id, lat, lng);
        }catch (Exception e){
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            LOGGER.error(e.getMessage(),e);
        }
    }

    @GetMapping("RetrieveAllGPS")
    public List<BusDTO> retrieveAllGPS(HttpServletResponse response) {
        try{
            return service.findAll();
        }catch (Exception e){
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            LOGGER.error(e.getMessage(),e);
            return null;
        }
    }

    @GetMapping("RetrieveGPS")
    public BusDTO retrieveGPS(HttpServletResponse response, @RequestParam String id) {
        try {
            if(listaEstatica.size() == 0){
                listaEstatica = service.findAll();;
            }
            BusDTO retorno = listaEstatica.get(integer);
            integer++;
            if(integer > 2){
                integer = 0;
            }
            return retorno;



//            return service.findById(id);
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            LOGGER.error(e.getMessage(),e);
            return null;
        }
    }

}
