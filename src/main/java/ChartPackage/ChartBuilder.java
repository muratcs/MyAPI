package ChartPackage;

import javafx.util.Pair;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ChartBuilder {

    private List<Pair<String, Integer>> dataSet;
    private GraphType graphType;
    private String title;
    private String categoryAxisName;
    private String valueAxisName;
    private ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        private Chart chart;


    public ChartBuilder setDataSet(List<Pair<String, Integer>> dataSet) {
        this.dataSet = dataSet;
        return this;
    }

    public ChartBuilder setGraphType(GraphType graphType) {
        this.graphType = graphType;
        return this;
    }

    public ChartBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public ChartBuilder setCategoryAxisName(String categoryAxisName) {
        this.categoryAxisName = categoryAxisName;
        return this;
    }

    public ChartBuilder setValueAxisName(String valueAxisName) {
        this.valueAxisName = valueAxisName;
        return this;
    }


    public Chart buildChart() {
        JFreeChart jChart;
        switch ((graphType != null) ? graphType : GraphType.BAR) {
            case BAR:
                jChart = createBarChart(dataSet,
                                        title,
                                        categoryAxisName,
                                        valueAxisName);
                break;

            case PIE:
                jChart = createPieChart(dataSet,
                                        title);
                break;

            case LINE:
                jChart = createLineChart(dataSet,
                                         title,
                                         categoryAxisName,
                                         valueAxisName);
                break;

            default:
                jChart = createBarChart(dataSet,
                                        title,
                                        categoryAxisName,
                                        valueAxisName);
                break;
        }

        try {
            ChartUtilities.writeChartAsJPEG(baos, jChart, 500, 500);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Chart(dataSet,
                         graphType,
                         title,
                         categoryAxisName,
                         valueAxisName,
                         baos);
    }

    private CategoryDataset createDataset(List<Pair<String, Integer>> data) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Pair P : data) {
            dataset.addValue(P.getValue().hashCode(), "row", P.getKey().toString());
        }
        return dataset;
    }

    private PieDataset createPieDataSet(List<Pair<String, Integer>> data) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Pair P : data) {
            dataset.setValue(P.getKey().toString(), P.getValue().hashCode());
        }
        return dataset;
    }


    private JFreeChart createBarChart(List<Pair<String, Integer>> dataSet, String title, String xAxisName, String yAxisName) {

        JFreeChart barChart = ChartFactory.createBarChart(title,
                                                          xAxisName,
                                                          yAxisName,
                                                          createDataset(dataSet),
                                                          PlotOrientation.VERTICAL,
                                                          false,
                                                          false,
                                                          false);

        BarRenderer renderer = new BarRenderer() {
            @Override
            public Paint getItemPaint(int row, int column) {
                return (column % 2 == 0) ? Color.BLUE : Color.RED;
            }
        };
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(Boolean.TRUE);
        barChart.getCategoryPlot().setRenderer(renderer);
        return barChart;
    }

    private JFreeChart createPieChart(List<Pair<String, Integer>> dataSet, String title) {
        JFreeChart pieChart = ChartFactory.createPieChart(title,
                                                          createPieDataSet(dataSet),
                                                          true,
                                                          true,
                                                          false);
        return pieChart;
    }

    private JFreeChart createLineChart(List<Pair<String, Integer>> dataSet, String title, String xAxisName, String yAxisName) {
        JFreeChart lineChart = ChartFactory.createLineChart(title,
                                                            xAxisName,
                                                            yAxisName,
                                                            createDataset(dataSet),
                                                            PlotOrientation.VERTICAL,
                                                            false,
                                                            false,
                                                            false);
        return lineChart;
    }



}
