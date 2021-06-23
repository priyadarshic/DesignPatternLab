/*
 * Copyright (c) 2021.
 * All Intellectual Property Rights to this File/Digital Product belong to the @Author
 * @PriyadarshiChaudhuri. Contact priyadarshi.c@gmail.com for enquiries.
 * This File maybe used for Non-commercial purpose only with Credits and link to GitHub repository.
 */

package imageprocessing;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProcessingRGB {

    public static final String SOURCE = "Grey_Flower.jpg";
    public static final String DESTINATION = "output.jpg";
    // D:\DesignPatternsLab\

    public static void main(String[] args) throws IOException {

        System.out.println( new File(SOURCE).getCanonicalPath());
        BufferedImage image = ImageIO.read(new File(SOURCE));
        BufferedImage output = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

        processSingleThreaded(image, output);

        File outputFile = new File(DESTINATION);
        ImageIO.write(output, "jpg", outputFile);

    }

    public static void processPixel(BufferedImage image, BufferedImage output, int x, int y){

        int rgb = image.getRGB(x, y);

        int red = getRed(rgb);
        int green = getGreen(rgb);
        int blue = getBlue(rgb);

        int newRed;
        int newGreen;
        int newBlue;

        if(isGray(red, green, blue)){
            /*newRed = Math.min(255, red + 10);
            newGreen = Math.max(0, green - 80);
            newBlue = Math.max(0, blue - 20);*/
            newRed = Math.max(0, red - 30);
            newGreen = Math.min(0, green + 30);
            newBlue = Math.min(255, blue + 30);
        }else{
            newRed = red;
            newGreen = green;
            newBlue = blue;
        }

        int newRGB = createRGB(newRed, newGreen, newBlue);
        setRGB(output, x, y, newRGB);


    }

    public static void processSingleThreaded(BufferedImage image, BufferedImage output){
        processImage(image, output, 0, 0, image.getWidth(), image.getHeight());
    }

    public static void processImage(BufferedImage image, BufferedImage output, int left, int top, int width, int height){
        for(int x = left; x < left + width && x < image.getWidth(); x++){
            for( int y = top; y < top + height && y < image.getHeight(); y++){
                processPixel(image, output, x, y);
            }
        }
    }

    public static void setRGB(BufferedImage image, int x, int y, int rgb){
        image.getRaster().setDataElements(x, y, image.getColorModel().getDataElements(rgb, null));
    }


    public static boolean isGray(int red, int green, int blue){
        return Math.abs(red - green) < 30 && Math.abs(red - blue) < 30 && Math.abs(green - blue) < 30;
    }

    public static int createRGB(int red, int green, int blue){
        int rgb = 0;

        rgb |= blue;
        rgb |= green << 8;
        rgb |= red << 16;
        rgb |= 0xFF000000;

        return rgb;
    }

    public static int getRed(int rgb){
        return (rgb & 0x00FF0000) >> 16;
    }

    public static int getGreen(int rgb){
        return (rgb & 0x0000FF00) >> 8;
    }

    public static int getBlue(int rgb){
        return rgb & 0x000000FF;
    }



}
