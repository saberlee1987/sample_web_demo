package com.saber.sample_web_demo.controllers;

import com.saber.sample_web_demo.services.ExcelServices;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/rest")
public class ExcelController {

    private final ExcelServices excelServices;

    @GetMapping("/excel")
    public ResponseEntity writeExcel(HttpServletResponse response) {
        excelServices.writeExcel2(response);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @PostMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadFile(@RequestParam MultipartFile multipartFile) {

        System.out.println("file name is "+ multipartFile.getOriginalFilename());
        excelServices.uploadExcelFile(multipartFile);
    }
}
