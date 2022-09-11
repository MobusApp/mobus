package br.com.mobusapp.mobus.controller;

import br.com.mobusapp.mobus.model.dto.BusDTO;
import br.com.mobusapp.mobus.model.dto.PayloadDTO;
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
import java.util.List;

@RestController
@RequestMapping("/Bus")
public class BusLocalizationController {

    private static Logger LOGGER = LoggerFactory.getLogger(BusLocalizationController.class);

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
    public PayloadDTO RetrieveAllGPS(HttpServletResponse response) {
        try{
            List<BusDTO> buses = service.findAll();
            return PayloadDTO.returnSuccess("Dados resgatados com sucesso!",buses);
        }catch (Exception e){
            LOGGER.error(e.getMessage(),e);
            return PayloadDTO.returnError(response,HttpStatus.INTERNAL_SERVER_ERROR,
                    "Ocorreu um erro ao buscar os dados: " + e.getMessage());
        }
    }

    @GetMapping("RetrieveGPS")
    public PayloadDTO RetrieveGPS(HttpServletResponse response, @RequestParam String id) {
        PayloadDTO payloadDTO = new PayloadDTO();
        try {
            payloadDTO.setMessage("Dados resgatados com sucesso!");
            BusDTO bus = service.findById(id);
            payloadDTO.setObj(bus);
            return payloadDTO;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(),e);
            return PayloadDTO.returnError(response,HttpStatus.INTERNAL_SERVER_ERROR,
                    "Ocorreu um erro ao buscar a localização: " + e.getMessage());
        }
    }

}
