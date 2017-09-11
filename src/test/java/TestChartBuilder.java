import ChartPackage.*;
import javafx.util.Pair;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
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

//        new ChartPackage.ChartBuilderService().display2(data);
//        new ChartPackage.ChartBuilderService().buildChart(data);
//        new ChartPackage.ChartBuilderService().buildBarChart(data);
//        new ChartPackage.ChartBuilderService().buildPieChart(data, "PIE");
//        new ChartPackage.ChartBuilderService().buildLineChart(data, "LINE", "x", "y");


        IChartBuilderService service = new ChartBuilderService();
        BASE64Decoder decoder = new BASE64Decoder();

        ChartBuilder chartBuilder = new ChartBuilder();
        chartBuilder.setDataSet(data)
                    .setTitle("ff")
                    .setGraphType(GraphType.BAR);

        Chart chart = chartBuilder.buildChart();
        byte[] b = decoder.decodeBuffer(chart.getEncodedOutput());
        /* OR */ b = decoder.decodeBuffer(service.getOutput(chart));
        InputStream inputStream = new ByteArrayInputStream(b);
        BufferedImage image = ImageIO.read(inputStream);
        File file = new File("returnedImage.jpeg");
        ImageIO.write(image, "jpeg", file);

    }


}
