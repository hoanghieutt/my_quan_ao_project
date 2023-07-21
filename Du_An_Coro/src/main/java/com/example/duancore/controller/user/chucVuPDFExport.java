package com.example.duancore.controller.user;

import com.example.duancore.entity.ChucVu;
import com.example.duancore.entity.SanPham;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class chucVuPDFExport {
    private List<ChucVu> productList;

    public chucVuPDFExport(List<ChucVu> productList){

        this.productList = productList;

    }

    public void WirteTableHeader(PdfPTable table){

        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.GRAY);
        cell.setPadding(3);//khoảng cách

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);



        cell.setPhrase(new Phrase("mã chức vụ",font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Tên chức vụ",font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Ngày tạo",font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Ngày sửa",font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Trạng thái",font));
        table.addCell(cell);

    }

    public void WirteTableData(PdfPTable table){

        for (ChucVu product : productList){


            table.addCell(product.getMaCV());
            table.addCell(product.getTenCV());
            table.addCell(String.valueOf(product.getNgayTao()));
            table.addCell(String.valueOf(product.getNgaySua()));
            table.addCell(String.valueOf(product.getTrangThai()==1?"Còn hàng":"Hết hàng"));

        }

    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {

        //tạo đối tượng
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document,response.getOutputStream());
        document.open();
        document.add(new Paragraph("List danh sách chức vụ"));
        PdfPTable table = new PdfPTable(5);//lấy file fdftable text
        table.setWidthPercentage(100);

        table.setSpacingBefore(15);

        WirteTableHeader(table);
        WirteTableData(table);

        document.add(table);

        document.close();

    }
}
