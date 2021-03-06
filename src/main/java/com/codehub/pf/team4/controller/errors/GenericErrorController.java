package com.codehub.pf.team4.controller.errors;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class GenericErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "errorPages/404";
            }
            else if(statusCode == HttpStatus.FORBIDDEN.value()) {
                return "errorPages/403";
            }
        }
        return "errorPages/error";
    }

    @GetMapping("/error/access-denied")
    public String getAccessDeniedPage(){
        return "errorPages/403";
    }

    @Override
    public String getErrorPath() {
        return "errorPages/error";
    }
}
