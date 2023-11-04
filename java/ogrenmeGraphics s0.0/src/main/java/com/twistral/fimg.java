package com.twistral;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Locale;


public class fimg {



	/*  GENERAL FUNCTIONS  */

	public static BufferedImage getCopyOf(BufferedImage imageToCopy){
		BufferedImage newImg = new BufferedImage(imageToCopy.getWidth(), imageToCopy.getHeight(), BufferedImage.TYPE_INT_RGB);
		for(int i = 0; i < newImg.getWidth(); i++)
			for(int j = 0; j < newImg.getHeight(); j++){
				Color c = new Color(imageToCopy.getRGB(i,j));
				newImg.setRGB(i, j, c.getRGB() );
			}
		return newImg;
	}

	public static BufferedImage getEmptyImage(int width, int height, int type){
		return new BufferedImage(width, height, type);
	}

	public static BufferedImage getEmptyImage(int width, int height){
		return new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	}

	public static BufferedImage getExistingImage(String imgPath){
		return getExistingImage( new File(imgPath) );
	}

	public static BufferedImage getExistingImage(File imgFile){
		BufferedImage img = null;
		try{ img = ImageIO.read(imgFile); }
		catch (IOException e) { e.printStackTrace(); }
		return img;
	}

	public static void exportImage(BufferedImage imageToExport, File exportLocation, String extension){
		checkForExtension(extension);
		try{ ImageIO.write(imageToExport, extension, exportLocation); }
		catch(Exception e){ e.printStackTrace(); }
	}

	public static void exportImage(BufferedImage imageToExport, String exportPathWithExtension, String extension){
		checkForExtension(extension);
		try{ ImageIO.write(imageToExport, extension, new File(exportPathWithExtension)); }
		catch(Exception e){ e.printStackTrace(); }
	}



	/*  IMAGE COMBINING  */

	public static BufferedImage getSideBySideImage(BufferedImage leftImage, BufferedImage rightImage){
		BufferedImage img1 = getCopyOf(leftImage);
		BufferedImage img2 = getCopyOf(rightImage);
		BufferedImage newImg = new BufferedImage(img1.getWidth() + img2.getWidth(), Math.max(img1.getHeight(), img2.getHeight()), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = newImg.createGraphics();
		g2d.drawImage(img1, 0, 0, null);
		g2d.drawImage(img2, img1.getWidth(), 0, null);
		g2d.dispose();
		return newImg;
	}

	public static BufferedImage getCombinedImage(BufferedImage image1, BufferedImage image2){
		BufferedImage img1 = getCopyOf(image1);
		BufferedImage img2 = getCopyOf(image2);
		BufferedImage newImg = new BufferedImage(img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = newImg.createGraphics();
		g2d.drawImage(img1, 0, 0, null);
		g2d.drawImage(img2, 0, 0, null);
		g2d.dispose();
		return newImg;
	}



	/*  COLOR MANIPULATION  */

	public static BufferedImage getBlurredImage(BufferedImage imageToBlur, int neighborCount, double similarity){
		if(similarity > 1 || similarity < 0) throw new RuntimeException("Similarity should be a double between 0 and 1");
		BufferedImage blurredImage = new BufferedImage( imageToBlur.getWidth(), imageToBlur.getHeight(), imageToBlur.getType());
		Color c1, c2;
		for(int i = 0; i < blurredImage.getWidth(); i++){
			for(int j = 0; j < blurredImage.getHeight(); j++){
				c1 = getAverageColorUsingNeighboringCells(imageToBlur, neighborCount, i, j);
				c2 = new Color(imageToBlur.getRGB(i,j));
				int r = c2.getRed() - ((int) ( (c2.getRed() - c1.getRed()) * similarity ));
				int g = c2.getGreen() - ((int) ( (c2.getGreen() - c1.getGreen()) * similarity ));
				int b = c2.getBlue() - ((int) ( (c2.getBlue() - c1.getBlue()) * similarity ));
				blurredImage.setRGB(i, j, new Color(r,g,b).getRGB());
			}
		}
		return blurredImage;
	}

	public static BufferedImage getBlurredImage(BufferedImage imageToBlur, int neighborCount){
		return getBlurredImage(imageToBlur, neighborCount, 1);
	}

	public static BufferedImage getGreenfulImage(BufferedImage imageToChange){ return changeGreen(imageToChange, 255); }

	public static BufferedImage getGreenlessImage(BufferedImage imageToChange){ return changeGreen(imageToChange, 0); }

	public static BufferedImage getRedfulImage(BufferedImage imageToChange){ return changeRed(imageToChange, 255); }

	public static BufferedImage getRedlessImage(BufferedImage imageToChange){ return changeRed(imageToChange, 0); }

	public static BufferedImage getBluefulImage(BufferedImage imageToChange){ return changeBlue(imageToChange, 255); }

	public static BufferedImage getBluelessImage(BufferedImage imageToChange){ return changeBlue(imageToChange, 0); }

	public static BufferedImage getGrayscaledImage(BufferedImage imageToChange){
		BufferedImage img = getCopyOf(imageToChange);
		Color currentColor;
		Color newColor;
		for(int i = 0; i < img.getWidth(); i++){
			for(int j = 0; j < img.getHeight(); j++){
				currentColor = new Color( img.getRGB(i,j) );

				int red = (int) (currentColor.getRed() * 0.299);
				int green = (int) (currentColor.getGreen() * 0.587);
				int blue = (int) (currentColor.getBlue() * 0.114);
				int sum = red + green + blue;

				newColor = new Color(sum, sum, sum);

				img.setRGB(i, j, newColor.getRGB());
			}
		}
		return img;
	}

	public static BufferedImage getGrayscaledImage(BufferedImage imageToChange, int harshness, boolean setColorToDarkAreas){
		if(setColorToDarkAreas) return getGrayscaledImage(imageToChange, harshness, setColorToDarkAreas, Color.BLACK);
		else return getGrayscaledImage(imageToChange, harshness, setColorToDarkAreas, Color.WHITE);
	}

	public static BufferedImage getGrayscaledImage(BufferedImage imageToChange, int harshness, boolean setColorToDarkAreas, Color secondaryColor){
		if(harshness >= 256 || harshness < 0) throw new RuntimeException("Invalid harshness value, harshness must a value between 0 and 255");
		BufferedImage img = getCopyOf(imageToChange);
		Color currentColor;
		Color newColor;
		for(int i = 0; i < img.getWidth(); i++){
			for(int j = 0; j < img.getHeight(); j++){
				currentColor = new Color( img.getRGB(i,j) );

				int red = (int) (currentColor.getRed() * 0.299);
				int green = (int) (currentColor.getGreen() * 0.587);
				int blue = (int) (currentColor.getBlue() * 0.114);
				int sum = red + green + blue;

				newColor = new Color(sum, sum, sum);

				if(setColorToDarkAreas){
					if(sum > harshness) img.setRGB(i, j, newColor.getRGB());
					else img.setRGB(i, j, secondaryColor.getRGB());
				}
				else{
					if(sum > harshness) img.setRGB(i, j, secondaryColor.getRGB());
					else img.setRGB(i, j, newColor.getRGB());
				}

			}
		}
		return img;
	}



	/*  HELPER FUNCTIONS  */

	private static void checkForExtension(String extension) {
		if( ! (extension.toLowerCase().startsWith("png") || extension.toLowerCase().startsWith("jpg")) )
			throw new RuntimeException("The extension must be either 'PNG' or 'JPG'");
	}

	private static Color getAverageColorUsingNeighboringCells(BufferedImage imageToBlur, int neighborCount, int x, int y){
		Color c1;
		int termCount = 0;
		int sumR = 0;
		int sumG = 0;
		int sumB = 0;
		for(int i = x - neighborCount; i < x + neighborCount; i++){
			for(int j = y - neighborCount; j < y + neighborCount; j++){
				if(i >= 0 && j >= 0 && i < imageToBlur.getWidth() && j < imageToBlur.getHeight()){
					c1 = new Color( imageToBlur.getRGB(i,j));
					sumR += c1.getRed();
					sumG += c1.getGreen();
					sumB += c1.getBlue();
					termCount++;
				}
			}
		}
		return new Color(sumR / termCount, sumG / termCount, sumB / termCount);
	}

	private static BufferedImage changeGreen(BufferedImage imageToChange, int greenChange){
		BufferedImage img = getCopyOf(imageToChange);
		Color currentColor;
		Color newColor;
		for(int i = 0; i < img.getWidth(); i++){
			for(int j = 0; j < img.getHeight(); j++){
				currentColor = new Color( img.getRGB(i,j) );
				newColor = new Color(currentColor.getRed(), greenChange, currentColor.getBlue());
				img.setRGB(i, j, newColor.getRGB());
			}
		}
		return img;
	}

	private static BufferedImage changeRed(BufferedImage imageToChange, int redChange){
		BufferedImage img = getCopyOf(imageToChange);
		Color currentColor;
		Color newColor;
		for(int i = 0; i < img.getWidth(); i++){
			for(int j = 0; j < img.getHeight(); j++){
				currentColor = new Color( img.getRGB(i,j) );
				newColor = new Color(redChange, currentColor.getGreen(), currentColor.getBlue());
				img.setRGB(i, j, newColor.getRGB());
			}
		}
		return img;
	}

	private static BufferedImage changeBlue(BufferedImage imageToChange, int blueChange){
		BufferedImage img = getCopyOf(imageToChange);
		Color currentColor;
		Color newColor;
		for(int i = 0; i < img.getWidth(); i++){
			for(int j = 0; j < img.getHeight(); j++){
				currentColor = new Color( img.getRGB(i,j) );
				newColor = new Color(currentColor.getRed(), currentColor.getGreen(), blueChange);
				img.setRGB(i, j, newColor.getRGB());
			}
		}
		return img;
	}


}
