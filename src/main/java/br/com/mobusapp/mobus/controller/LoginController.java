package br.com.mobusapp.mobus.controller;


import br.com.mobusapp.mobus.model.Login;
import br.com.mobusapp.mobus.model.dto.LoginDTO;
import br.com.mobusapp.mobus.service.MobusLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/Auth")
public class LoginController {

    @Autowired
    private MobusLoginService mobusLoginService;

    @GetMapping(value = "/Login")
    public void login(HttpServletRequest request, HttpServletResponse response, @RequestBody(required = false) LoginDTO loginDTO) {
//        PayloadDTO payloadDTO = new PayloadDTO();
//
//        payloadDTO.setMessage("Conectado com sucesso!");
//        payloadDTO.setStatus(HttpStatus.OK);

        Login login = new Login();

        login.setId(1);

//        return payloadDTO;
    }
}
