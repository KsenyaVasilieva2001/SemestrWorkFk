package ru.kpfu.itis.skatingblog.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.skatingblog.SkatingBlogApplication;


@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ModelAndView postException() {
        return new ModelAndView("500");
    }


/*
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(Exception.class)
    public ModelAndView notFoundException() {
        return  new ModelAndView("error_page");
    }

*/
    @ExceptionHandler(RuntimeException.class)
    public void postRuntimeException(SkatingBlogApplication exception) {
        log.error(exception.toString());
    }



}

