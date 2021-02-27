package ru.alexkm07.bank.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ControllerUtils {
    static Model getErrors(BindingResult bindingResult, Model model) {

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            model.addAttribute(fieldError.getField() + "Error", fieldError.getDefaultMessage());
        }

        return model;
    }


    static String dateToString(Date date, String pattern){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);

    }

}

