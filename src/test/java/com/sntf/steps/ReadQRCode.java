package com.sntf.steps;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import javax.imageio.ImageIO;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadQRCode {

	@Test(priority = 1)
	public void SingleQRReader() throws NotFoundException {
		try {
			File file = new File(System.getProperty("user.dir") + "/QRCODE-PNG/" + "QR.png");
			String decodedText = null;

			// store the file as an image
			BufferedImage bufferedImage = ImageIO.read(file);

			// process the image
			LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
			// store the details of the QR code
			Result result = new MultiFormatReader().decode(bitmap);
			decodedText = result.getText();

			// print to console
			System.out.println("Single-Decoded text = " + decodedText);

			// testng assertion
			Assert.assertEquals(decodedText, "QA-ENGINEER");

		} catch (IOException e) {
			System.out.println("Could not decode QR Code, IOException :: " + e.getMessage());
		}
	}

	@Test(priority = 2)
	public void MultipleQRReader() throws IOException, NotFoundException {

		try {
			File dir = new File(System.getProperty("user.dir") + "/QRCODE-PNG");

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
