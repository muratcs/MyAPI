package ChartPackage;

import javafx.util.Pair;

import java.util.List;

public class ChartInfoBuilder {

    private List<Pair<String, Integer>> dataSet;
    private GraphType graphType;
    private String title;
    private String categoryAxisName;
    private String valueAxisName;
//    private

//    public enum ChartPackage.GraphType{BAR, PIE, LINE};


    public ChartInfoBuilder setDataSet(List<Pair<String, Integer>> dataSet){
        this.dataSet = dataSet;
        return this;
    }

    public ChartInfoBuilder setGraphType(GraphType graphType){
        this.graphType = graphType;
        return this;
    }

    public ChartInfoBuilder setTitle(String title){
        this.title = title;
        return this;
    }

    public ChartInfoBuilder setCategoryAxisName(String categoryAxisName){
        this.categoryAxisName = categoryAxisName;
        return this;
    }

    public ChartInfoBuilder setValueAxisName(String valueAxisName){
        this.valueAxisName = valueAxisName;
        return this;
    }

    public ChartInfo buildChartInfo(){
        return new ChartInfo(dataSet, graphType, title, categoryAxisName, valueAxisName);
    }

    public List<Pair<String, Integer>> getDataSet() {
        return dataSet;
    }

    public GraphType getGraphType() {
        return graphType;
    }

    public String getTitle() {
        return title;
    }

    public String getCategoryAxisName() {
        return categoryAxisName;
    }

    public String getValueAxisName() {
        return valueAxisName;
    }
}
