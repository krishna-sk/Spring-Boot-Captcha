package com.springbootsimplecaptcha;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.GradiatedBackgroundProducer;
import cn.apiclub.captcha.noise.CurvedLineNoiseProducer;
import cn.apiclub.captcha.text.producer.FiveLetterFirstNameTextProducer;

/*
 * This class is for reference purpose and to create a captcha image in the specified path
 */
public class SimpleCaptcha {

	// 1.Create Captcha class Object
	public static Captcha createCaptcha(int width, int height) {

		return new Captcha.Builder(width, height)
//				.addBackground(new TransparentBackgroundProducer())
//				.addBackground(new FlatColorBackgroundProducer())
//				.addBackground(new SquigglesBackgroundProducer())
				.addBackground(new GradiatedBackgroundProducer())
//				.addText(new DefaultTextProducer())
				.addText(new FiveLetterFirstNameTextProducer())
//				.addText(new NumbersAnswerProducer())
//				.addNoise(new StraightLineNoiseProducer())
				.addNoise(new CurvedLineNoiseProducer())
				.build();
	}

	// 2. convert into image
	public static void createImage(Captcha captcha) {

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ImageIO.write(captcha.getImage(), "png", os);
			FileOutputStream fos = new FileOutputStream("C:/Users/krish/Documents/captcha/mycaptcha.png");
			fos.write(os.toByteArray());
			fos.flush();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Captcha captcha = createCaptcha(200, 80);
		createImage(captcha);
		System.out.println("Captcha is Generated!!!");
	}

}
