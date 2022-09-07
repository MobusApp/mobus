package br.com.mobusapp.mobus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/Bus")
public class BusLocalizationController {


    @GetMapping("UpdateGPS")
    public void updateGPS(HttpServletRequest request, HttpServletResponse response,
                          @RequestParam String id, @RequestParam String lat, @RequestParam String lng){
        System.out.println(id);
        System.out.println(lat);
        System.out.println(lng);
    }

}
