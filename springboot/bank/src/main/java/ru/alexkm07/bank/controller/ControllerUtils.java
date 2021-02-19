package ru.alexkm07.bank.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ControllerUtils {
    static Model getErrors(BindingResult bindingResult, Model model) {

        for(FieldError fieldError:bindingResult.getFieldErrors()){
            model.addAttribute(fieldError.getField()+"Error",fieldError.getDefaultMessage());
        }

        return model;
    }
}
