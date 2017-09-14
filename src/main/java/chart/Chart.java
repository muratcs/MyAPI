package chart;

import javafx.util.Pair;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

public class Chart {

    private final List<Pair<String, Integer>> dataSet;
    private final GraphType graphType;
    private final String title;
    private final String categoryAxisName;
    private final String valueAxisName;
    private final ByteArrayOutputStream baos;


    Chart(List<Pair<String, Integer>> dataSet, GraphType graphType, String title, String categoryAxisName, String valueAxisName, ByteArrayOutputStream baos){
        super();
        this.dataSet = dataSet;
        this.graphType = graphType;
        this.title = title;
        this.categoryAxisName = categoryAxisName;
        this.valueAxisName = valueAxisName;
        this.baos = baos;
    }

    List<Pair<String, Integer>> getDataSet() {
        return dataSet;
    }

    GraphType getGraphType() {
        return graphType;
    }

    String getTitle() {
        return title;
    }

    String getCategoryAxisName() {
        return categoryAxisName;
    }

    String getValueAxisName() {
        return valueAxisName;
    }

    public String getEncodedOutput() {

        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(baos.toByteArray());
    }

    public void saveAsJPEG (String pathName) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] buffer = decoder.decodeBuffer(getEncodedOutput());
        InputStream inputStream = new ByteArrayInputStream(buffer);
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        File file = new File(pathName + ".jpeg");
        ImageIO.write(bufferedImage, "jpeg", file);
    }

}
