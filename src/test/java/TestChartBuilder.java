import chart.*;
import javafx.util.Pair;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestChartBuilder {

    public static void main(String[] args) throws IOException {

        List<Pair<String,Integer>> data = new ArrayList<>();
//        Pair<String,Integer> p0 = new Pair<>("test", 100);
        data.add(new Pair<>("A", 10));
        data.add(new Pair<>("B", 20));
        data.add(new Pair<>("C", 30));
        data.add(new Pair<>("D",40));
        data.add(new Pair<>("LUL",90));


        ChartBuilder chartBuilder = new ChartBuilder();
        Chart chart = chartBuilder.setDataSet(data)
                                  .setTitle("title1")
                                  .setGraphType(GraphType.BAR)
                                  .buildChart();

        BASE64Decoder decoder = new BASE64Decoder();
        byte[] b = decoder.decodeBuffer(chart.getEncodedOutput());
        InputStream inputStream = new ByteArrayInputStream(b);
        BufferedImage image = ImageIO.read(inputStream);
        File file = new File("returnedImage.jpeg");
        ImageIO.write(image, "jpeg", file);

//        System.out.println(chart.getEncodedOutput());

        chart.saveAsJPEG("src/test/java/resources/testchart");
    }

}
