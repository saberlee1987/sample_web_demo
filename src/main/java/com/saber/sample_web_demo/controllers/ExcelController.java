package com.saber.sample_web_demo.controllers;

import com.saber.sample_web_demo.services.ExcelServices;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExcelController {

    private final ExcelServices excelServices;

    @GetMapping("/excel")
    public ResponseEntity writeExcel(HttpServletResponse response) {
        excelServices.writeExcel2(response);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
