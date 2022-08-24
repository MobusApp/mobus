package br.com.mobusapp.mobus.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class PayloadDTO {

    private String message;
    private HttpStatus status;
    private Object object;
}
