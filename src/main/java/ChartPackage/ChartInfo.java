package ChartPackage;

import javafx.util.Pair;

import java.util.List;

class ChartInfo {

    private final List<Pair<String, Integer>> dataSet;
    private final GraphType graphType;
    private final String title;
    private final String categoryAxisName;
    private final String valueAxisName;

    ChartInfo(List<Pair<String, Integer>> dataSet, GraphType graphType, String title, String categoryAxisName, String valueAxisName){
        super();
        this.dataSet = dataSet;
        this.graphType = graphType;
        this.title = title;
        this.categoryAxisName = categoryAxisName;
        this.valueAxisName = valueAxisName;
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
}
