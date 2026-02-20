package com.saber.sample_web_demo.services;

import com.spire.xls.FileFormat;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.UUID;

@Service
public class ExcelServices {
    public void writeExcel(HttpServletResponse response) {
        List<String> titles = List.of(
                "Id", "FirstName", "LaseName", "Age"
        );
        Object[][] data = {
                {1000, "saber", "azizi", 37},
                {1100, "bruce", "lee", 33},
                {1200, "jackie", "chan", 70},
                {1300, "jet", "li", 61},};

        Workbook workbook = new Workbook();
        workbook.createEmptySheets(1);
        workbook.setActiveSheetIndex(1);

        Worksheet sheet = workbook.createEmptySheet();
        sheet.isRightToLeft(true);
        //  Worksheet sheet = workbook.getWorksheets().get(0);
        sheet.setName("saber 23");


        sheet.insertRow(1);
        int col = 1;
        for (String title : titles) {
            sheet.setCellValue(1, col, title);
            col++;
        }
        int rowNum = 2;
        for (Object[] datum : data) {
            sheet.insertRow(rowNum);
            col = 1;
            for (Object o : datum) {
                sheet.setCellValue(rowNum, col, o.toString());
                col++;
            }
            rowNum++;
        }

        workbook.protect("saber66", true, true);

        try {
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=data1.xls");
            ServletOutputStream outputStream = response.getOutputStream();
            workbook.saveToStream(outputStream, FileFormat.Xlsb2010);
//            workbook.saveToStream();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }


//        workbook.saveToFile("test4.xlsx");
        System.out.println("excel successfully .............");
    }

    public void writeExcel2(HttpServletResponse response) {
        List<String> titles = List.of(
                "Id", "FirstName", "LaseName", "Age"
        );
        Object[][] data = {
                {1000, "saber", "azizi", 37},
                {1100, "bruce", "lee", 33},
                {1200, "jackie", "chan", 70},
                {1300, "jet", "li", 61},};
        try (SXSSFWorkbook workbook = new SXSSFWorkbook()) {
            var sheet = workbook.createSheet("saber66");
            CellStyle cellStyle = getCellStyle(workbook);
            sheet.setRightToLeft(true);
//            sheet.groupColumn();
            int rowIndex = 0;
            int col = 0;
            var row = sheet.createRow(rowIndex);
            row.setRowStyle(cellStyle);
            SXSSFCell cell = row.createCell(col);
            cell.setCellValue("this is test.saber aiziz is java developer.i love iran");
            cell.setCellStyle(cellStyle);
            cell.getCellStyle().setWrapText(true);
            cell.getCellStyle().setAlignment(HorizontalAlignment.CENTER);
            XSSFColor xssfColor = new XSSFColor(Color.CYAN, new DefaultIndexedColorMap());
            cell.getCellStyle().setFillForegroundColor(xssfColor);
//            sheet.groupColumn(col, titles.size());
//            for (int i = 1; i < titles.size(); i++) {
//                cell = row.createCell(i);
//                cell.setCellValue("");
//                cell.setCellStyle(cellStyle);
//            }

            CellRangeAddress cellAddresses = new CellRangeAddress(rowIndex, rowIndex, 0, titles.size() + 5);
            sheet.addMergedRegion(cellAddresses);


            rowIndex++;
            row = sheet.createRow(rowIndex);
            row.setRowStyle(cellStyle);
            for (String title : titles) {
                cell = row.createCell(col);
                cell.setCellValue(title);
                cell.setCellStyle(cellStyle);
                col++;
            }
            rowIndex++;
            for (Object[] datum : data) {
                row = sheet.createRow(rowIndex);
                row.setRowStyle(cellStyle);
                col = 0;
                for (Object o : datum) {
                    cell = row.createCell(col);
                    cell.setCellValue(o.toString());
                    cell.setCellStyle(cellStyle);
                    col++;
                }
                rowIndex++;
            }

            sheet.enableLocking();
            sheet.lockInsertColumns(true);
            sheet.lockInsertRows(true);
            sheet.lockObjects(true);

//            DataValidation dataValidation = new XSSFDataValidation()
//            sheet.addValidationData();
            ServletOutputStream outputStream = response.getOutputStream();
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=data_".concat(UUID.randomUUID().toString()).concat(".xlsx"));
            workbook.write(outputStream);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("excel successfully .............");
    }


    private CellStyle getCellStyle(SXSSFWorkbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setLocked(true);
//        cellStyle.setFont();
        return cellStyle;
    }
}
//Protecting the file with password
//try(
//POIFSFileSystem fs=new POIFSFileSystem()) {
//EncryptionInfo info=new EncryptionInfo(EncryptionMode.agile);
//Encryptor enc=info.getEncryptor();
//    enc.confirmPassword("satl");
//    try(OPCPackage opc=OPCPackage.open(new File("file.xlsx"), PackageAccess.READ_WRITE);
//OutputStream os=enc.getDataStream(fs)) {
//        opc.save(os);
//    }
//            try (FileOutputStream fos=new FileOutputStream("file.xlsx")){
//        fs.writeFilesystem(fos);
//    }
//            }catch (Exception e){
//        e.printStackTrace();
//}