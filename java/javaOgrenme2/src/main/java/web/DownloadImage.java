package web;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class DownloadImage {

    public static void main(String[] args) throws Exception {

        String imagePath = "";
        try(InputStream in = new URL(imagePath).openStream()){
            Path path = Paths.get("C:\\Users\\oguzh\\Desktop\\test\\test.jpg");
            Files.copy(in, path);
        }

    }

}
