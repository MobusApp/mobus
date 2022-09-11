package br.com.mobusapp.mobus.controller;

import br.com.mobusapp.mobus.dao.BusDao;
import br.com.mobusapp.mobus.model.Bus;
import br.com.mobusapp.mobus.model.dto.PayloadDTO;
import br.com.mobusapp.mobus.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/Bus")
public class BusLocalizationController {

    @Autowired
    private BusService service;

    @GetMapping("UpdateGPS")
    public void updateGPS(HttpServletRequest request, HttpServletResponse response,
                          @RequestParam String id, @RequestParam String lat, @RequestParam String lng){
        System.out.println(id);
        System.out.println(lat);
        System.out.println(lng);
    }

    @GetMapping("RetrieveAllGPS")
    public PayloadDTO retrieveGPS(@RequestParam String id){
        return null;
    }

}
