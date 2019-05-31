package com.sntf.steps;

import java.io.File;
import java.io.FileOutputStream;

import org.testng.annotations.Test;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.sntf.driver.SharedBrowser;

public class BARCodeGenerator extends SharedBrowser {

	@Test
	public void BAR_Code_Generator() throws Exception {
		String BAR_CODE_TEXT = "QA-ENGINEER";
		Writer writer = new QRCodeWriter();

		// set Barcode format
		BitMatrix bitMatrix = new Code128Writer().encode(BAR_CODE_TEXT, BarcodeFormat.CODE_128, 150, 80, null);

		// write the barcode into file system
		MatrixToImageWriter.writeToStream(bitMatrix, "png", new FileOutputStream(
				new File(System.getProperty("user.dir") + "/BARCODE-PNG/" + "BARCODE.png")));

		System.out.println("Code128 Barcode Generated.");

	}

}
