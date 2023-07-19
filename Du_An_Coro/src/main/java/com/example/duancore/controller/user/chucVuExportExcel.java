package com.example.duancore.controller.user;

import com.example.duancore.entity.ChucVu;
import com.example.duancore.entity.SanPham;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;

public class chucVuExportExcel {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<ChucVu> productList;

    public chucVuExportExcel(List<ChucVu> productList) {
        this.productList = productList;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Product");

    }

    private void WriteHeaderRow(){
//All Usermodel
        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        Cell cell = row.createCell(0);
        cell.setCellValue("mã chức vụ");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("tên chức vụ");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("ngày tạo");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("ngày sửa");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue("Trạng thái");
        cell.setCellStyle(style);



    }

    private void WriteDateRow(){

        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for(ChucVu product : productList){

            Row row = sheet.createRow(rowCount++);

            Cell cell = row.createCell(0);
            cell.setCellValue(product.getMaCV());
            sheet.autoSizeColumn(0);
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue(product.getTenCV());
            sheet.autoSizeColumn(1);
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue(product.getNgayTao());
            sheet.autoSizeColumn(2);
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue(product.getNgaySua());
            sheet.autoSizeColumn(3);
            cell.setCellStyle(style);

            cell = row.createCell(4);
            cell.setCellValue(product.getTrangThai());
            sheet.autoSizeColumn(4);
            cell.setCellStyle(style);

        }

    }

    //Khi Web server đáp ứng (response) yêu cầu của HTTP request. Một response thông thường bao gồm trạng thái (status), header, blank line, và document.
    public void export(HttpServletResponse response)throws IOException {

        WriteHeaderRow();
        WriteDateRow();

        ServletOutputStream outputStream= response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

    }
}
