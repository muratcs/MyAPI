import ChartPackage.*;
import javafx.util.Pair;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class TestChartBuilder {

    public static void main(String[] args) {

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




        ChartInfoBuilder cb = new ChartInfoBuilder();
//        cb.setTitle("xd");
        cb.setDataSet(data);
        cb.setGraphType(GraphType.PIE);
        cb.setGraphType(GraphType.BAR);
//        ChartInfo chartInfo = cb.buildChartInfo();
        IChartBuilderService chartBuilderService = new ChartBuilderService();
        chartBuilderService.buildChart(cb.buildChartInfo());


    }


}
