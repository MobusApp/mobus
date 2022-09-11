package br.com.mobusapp.mobus.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;

@Getter
@Setter
public class PayloadDTO {

    private String message;
    private HttpStatus status = HttpStatus.OK;
    private Object obj;


    public static PayloadDTO returnError(HttpServletResponse response, HttpStatus status, String message){
        response.setStatus(status.value());
        PayloadDTO ret = new PayloadDTO();
        ret.setStatus(status);
        ret.setMessage(message);

        return ret;
    }

    public static PayloadDTO returnSuccess(String message, Object object) {
        PayloadDTO ret = new PayloadDTO();
        ret.setMessage(message);
        ret.setObj(object);
        return ret;
    }
}
