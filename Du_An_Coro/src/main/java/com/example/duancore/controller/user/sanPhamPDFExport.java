package com.example.duancore.controller.user;


import com.example.duancore.entity.SanPham;
import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class sanPhamPDFExport {

    private List<SanPham> productList;

    public sanPhamPDFExport(List<SanPham> productList){

        this.productList = productList;

    }

    public void WirteTableHeader(PdfPTable table){

        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.GRAY);
        cell.setPadding(3);//khoảng cách

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);



        cell.setPhrase(new Phrase("Hình ảnh",font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Mã sản phẩm",font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Tên sản phẩm",font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Số lượng",font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Ngày tạo",font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Ngày sửa",font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Trạng thái",font));
        table.addCell(cell);

    }

    public void WirteTableData(PdfPTable table){

                for (SanPham product : productList){

                       table.addCell(String.valueOf(product.getImage()));
                       table.addCell(product.getMasp());
                       table.addCell(product.getTensp());
                       table.addCell(String.valueOf(product.getSoluong()));
                       table.addCell(String.valueOf(product.getNgaytao()));
                       table.addCell(String.valueOf(product.getNgaysua()));
                       table.addCell(String.valueOf(product.getTrangthai()==1?"Còn hàng":"Hết hàng"));

                }

    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {

        //tạo đối tượng
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document,response.getOutputStream());
        document.open();
        document.add(new Paragraph("List danh sách sản phẩm"));
        PdfPTable table = new PdfPTable(7);//lấy file fdftable text
        table.setWidthPercentage(100);

        table.setSpacingBefore(15);

        WirteTableHeader(table);
        WirteTableData(table);

        document.add(table);

        document.close();

    }


}
