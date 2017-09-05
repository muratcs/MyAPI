import javafx.util.Pair;

import java.util.List;

public interface IChartBuilderService {


    default void buildChart(List<Pair<String, Integer>> data) {
        buildChart(data,"Title" ,"Category Axis", "ValueAxis","BAR");
    }

    default void buildBarChart(List<Pair<String, Integer>> data) {
        buildBarChart(data,"hebele" ,"Category Axis", "ValueAxis");
    }


    void buildChart(List<Pair<String, Integer>> data, String title, String xAxisName, String yAxisName, String GraphType);

    void buildBarChart(List<Pair<String, Integer>> data, String title, String xAxisName, String yAxisName);

    void buildPieChart(List<Pair<String, Integer>> data, String title);

    void buildLineChart(List<Pair<String, Integer>> data, String title, String xAxisName, String yAxisName);




}
