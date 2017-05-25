package cn.edu.upc.study_online.util;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created by songqiaolin on 2017/5/24.
 */
public class PdfUtil {
    public static void wordConvert(String docxPath) {
        try {
            String pdfPath = docxPath.replace("docx","pdf");
            InputStream inputStream = new FileInputStream(new File(docxPath));
            XWPFDocument document = new XWPFDocument(inputStream);
            PdfOptions options = PdfOptions.create();
            OutputStream outputStream = new FileOutputStream(new File(pdfPath));
            PdfConverter.getInstance().convert(document, outputStream, options);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {

        }

    }

    public static void excelConvert(String excelPath) {
        try {
            String excelPdf = excelPath.replace("xlsx","pdf");
            FileInputStream fileInputStream = new FileInputStream(new File(excelPath));
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
            Iterator<Row> rowIterator = xssfSheet.rowIterator();
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(new File(excelPdf)));
            document.open();
            PdfPTable pdfPTable = new PdfPTable(rowIterator.next().getPhysicalNumberOfCells());
            BaseFont bfArialUni = BaseFont.createFont("/Users/songqiaolin/study_online/arialuni.ttf", BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
            Font fontArialUni = new Font(bfArialUni, 12f);
            PdfPCell pdfPCell;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellTypeEnum()) {
                        case STRING:
                            pdfPCell = new PdfPCell(new Phrase(cell.getStringCellValue(), fontArialUni));
                            pdfPTable.addCell(pdfPCell);
                            break;
                        default:
                            pdfPCell =  new PdfPCell(new Phrase(" "));
                            pdfPTable.addCell(pdfPCell);
                            break;
                    }
                }
            }
            document.add(pdfPTable);

            document.close();
            fileInputStream.close();
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        } finally {

        }
    }

    public static void pptConvert(String pptPath){
        try {
            String pptPdf = pptPath.replace("pptx","pdf");
            FileInputStream fileInputStream = new FileInputStream(new File(pptPath));
            double zoom = 2;
            AffineTransform affineTransform = new AffineTransform();
            affineTransform.setToScale(zoom,zoom);
            Document document = new Document();
            PdfWriter pdfWriter = PdfWriter.getInstance(document,new FileOutputStream(new File(pptPdf)));
            PdfPTable pdfPTable = new PdfPTable(1);
            pdfWriter.open();
            Dimension dimension;
            Image image;
            BufferedImage bufferedImage;

            XMLSlideShow xmlSlideShow = new XMLSlideShow(fileInputStream);
            dimension = xmlSlideShow.getPageSize();
            List<XSLFSlide> xslfSlides = xmlSlideShow.getSlides();
            document.setPageSize(new Rectangle((float)dimension.getWidth(),(float)dimension.getHeight()));
            pdfWriter.open();
            document.open();
            for (XSLFSlide xslfSlide : xslfSlides) {
                bufferedImage = new BufferedImage((int) Math.ceil(dimension.width * zoom), (int) Math.ceil(dimension.height * zoom), BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics2D = bufferedImage.createGraphics();
                graphics2D.setTransform(affineTransform);

                graphics2D.setPaint(Color.WHITE);
                graphics2D.fill(new Rectangle2D.Float(0, 0, dimension.width, dimension.height));
                xslfSlide.draw(graphics2D);
                image = Image.getInstance(bufferedImage, null);
                pdfPTable.addCell(new PdfPCell(image, true));
            }
            document.add(pdfPTable);
            document.close();
            pdfWriter.close();

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void convertToPdf(String path, String type){
        switch (type){
            case "docx":
                wordConvert(path);
                break;
            case "xlsx":
                excelConvert(path);
                break;
            case "pptx":
                pptConvert(path);
                break;
            default:
                break;
        }
    }
}
