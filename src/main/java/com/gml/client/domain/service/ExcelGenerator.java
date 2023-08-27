package com.gml.client.domain.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gml.client.domain.model.Client;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class ExcelGenerator {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	List<Client> clients;

	public ExcelGenerator(List<Client> clients) {
		this.clients = clients;
		this.workbook = new XSSFWorkbook();
		this.sheet = workbook.createSheet("Clients-All");
	}

	private void writeHeader(List<String> headers) {

		Row row = sheet.createRow(0);
		for (int i = 0; i < headers.size(); i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(headers.get(i));
		}

	}

	private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (valueOfCell instanceof Integer) {
			cell.setCellValue((Integer) valueOfCell);
		} else if (valueOfCell instanceof Long) {
			cell.setCellValue((Long) valueOfCell);
		} else if (valueOfCell instanceof String) {
			cell.setCellValue((String) valueOfCell);
		} else if (valueOfCell instanceof Boolean) {
			cell.setCellValue((Boolean) valueOfCell);
		}
		cell.setCellStyle(style);
	}

	private void write(List<Client> clients) {

		int rowCount = 1;
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);
		for (Client record : clients) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getSharedKey(), style);
			createCell(row, columnCount++, record.getName(), style);
			createCell(row, columnCount++, record.getMail(), style);
			createCell(row, columnCount++, record.getPhone(), style);
			createCell(row, columnCount++, record.getBindingDate().toString(), style);

		}

	}

	public void generateExcelFile(HttpServletResponse response) throws IOException {

		writeHeader(Arrays.asList("Shared Key", "Business ID", "E-Mail", "Phone", "Binding Date"));
		write(clients);
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();

	}
}