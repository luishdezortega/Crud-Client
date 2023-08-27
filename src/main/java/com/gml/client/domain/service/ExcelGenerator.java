package com.gml.client.domain.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gml.client.domain.model.Client;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class ExcelGenerator {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	public ExcelGenerator(List<Client> clients) {

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

	public void generateExcelFile(HttpServletResponse response) throws IOException {

		writeHeader(Arrays.asList("Shared Key", "Business ID", "E-Mail", "Phone", "Binding Date"));
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();

	}
}