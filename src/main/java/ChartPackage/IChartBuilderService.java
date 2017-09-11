package ChartPackage;

import javafx.util.Pair;

import java.util.List;

public interface IChartBuilderService {


    void buildChart(ChartInfo chartInfo);


//    default void buildChart(List<Pair<String, Integer>> data) {
//        buildChart(data,"Title" ,"Category Axis", "ValueAxis","BAR");
//    }

    default void buildBarChart(List<Pair<String, Integer>> dataSet) {
        buildBarChart(dataSet,"Title" ,"Category Axis", "ValueAxis");
    }


//    void buildChart(List<Pair<String, Integer>> data, String title, String xAxisName, String yAxisName, String ChartPackage.GraphType);

    void buildBarChart(List<Pair<String, Integer>> dataSet, String title, String xAxisName, String yAxisName);

    void buildPieChart(List<Pair<String, Integer>> dataSet, String title);

    void buildLineChart(List<Pair<String, Integer>> dataSet, String title, String xAxisName, String yAxisName);

}
