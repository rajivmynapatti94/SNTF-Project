package com.sntf.steps;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.NotFoundException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class BARCodeReader {
	@Test
	public void SingleBarCodeReader() throws NotFoundException, IOException, com.google.zxing.NotFoundException {
		try {
			BufferedImage bufferedImage = ImageIO
					.read(new File(System.getProperty("user.dir") + "/BARCODE-PNG/" + "BARCODE.png"));

			LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

			Result result = new MultiFormatReader().decode(bitmap);
			String decodedText = null;
			decodedText = result.getText();
			System.out.println(decodedText);
			// testng assertion
			Assert.assertEquals(decodedText, "QA-ENGINEER");

		} catch (IOException e) {
			System.out.println("Could not decode QR Code, IOException :: " + e.getMessage());
		}
	}

	@Test
	public void MultipleBarCodeReader() throws com.google.zxing.NotFoundException {
		try {
			File dir = new File(System.getProperty("user.dir") + "/BARCODE-PNG");

			for (File file : dir.listFiles()) {

				BufferedImage bufferedImage = ImageIO.read(file);
				LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
				BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
				Result result = new MultiFormatReader().decode(bitmap);
				String decodedText = result.getText();
				System.out.println("Multiple-Decoded text = " + decodedText);
			}

		} catch (IOException e) {
			System.out.println("Could not decode QR Code, IOException :: " + e.getMessage());
		}

	}

}
