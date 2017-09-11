package ChartPackage;

import java.awt.Color;
import java.awt.Paint;
import java.io.*;
import java.util.List;
import javax.swing.*;

import javafx.util.Pair;
import org.jfree.chart.*;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class ChartBuilderService implements IChartBuilderService {
    @Override
    public String toString(Chart chart) {
        return chart.getEncodedByteOutput();
    }

    //    @Override
//    public void buildChart(ChartInfo chartInfo) {
//        switch ((chartInfo.getGraphType() != null) ? chartInfo.getGraphType() : GraphType.BAR) {
//            case BAR:
//                buildBarChart(chartInfo.dataSet(),
//                              chartInfo.getTitle(),
//                              chartInfo.getCategoryAxisName(),
//                              chartInfo.getValueAxisName());
//                break;
//
//            case PIE:
//                buildPieChart(chartInfo.dataSet(),
//                              chartInfo.getTitle());
//                break;
//
//            case LINE:
//                buildLineChart(chartInfo.dataSet(),
//                               chartInfo.getTitle(),
//                               chartInfo.getCategoryAxisName(),
//                               chartInfo.getValueAxisName());
//                break;
//        }
//    }
//
//    private CategoryDataset createDataset(List<Pair<String, Integer>> data) {
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        for (Pair P : data) {
//            dataset.addValue(P.getValue().hashCode(), "row", P.getKey().toString());
//        }
//        return dataset;
//    }
//
//    private PieDataset createPieDataSet(List<Pair<String, Integer>> data) {
//        DefaultPieDataset dataset = new DefaultPieDataset();
//        for (Pair P : data) {
//            dataset.setValue(P.getKey().toString(), P.getValue().hashCode());
//        }
//        return dataset;
//    }
//
//
//    @Override
//    public void buildBarChart(List<Pair<String, Integer>> dataSet, String title, String xAxisName, String yAxisName) {
//
//        JFreeChart barChart = ChartFactory.createBarChart(title,
//                                                          xAxisName,
//                                                          yAxisName,
//                                                          createDataset(dataSet),
//                                                          PlotOrientation.VERTICAL,
//                                                          false,
//                                                          false,
//                                                          false);
//
//        BarRenderer renderer = new BarRenderer() {
//            @Override
//            public Paint getItemPaint(int row, int column) {
//                return (column % 2 == 0) ? Color.BLUE : Color.RED;
//            }
//        };
//        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
//        renderer.setBaseItemLabelsVisible(Boolean.TRUE);
//        barChart.getCategoryPlot().setRenderer(renderer);
//
////        ChartPanel chartPanel = new ChartPanel(barChart);
////        chartPanel.setPreferredSize(new java.awt.Dimension(500,270));
//        ChartFrame frame = new ChartFrame("Demo", barChart);
//        frame.pack();
//        frame.setVisible(true);
////        display(barChart);
//
//    }
//
//    @Override
//    public void buildPieChart(List<Pair<String, Integer>> dataSet, String title) {
//        JFreeChart pieChart = ChartFactory.createPieChart(title,
//                                                          createPieDataSet(dataSet),
//                                                          true,
//                                                          true,
//                                                          false);
//        try {
//            ChartUtilities.saveChartAsJPEG(new File("chart.jpeg"), pieChart, 500, 500);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        display(pieChart);
//
//    }
//
//    @Override
//    public void buildLineChart(List<Pair<String, Integer>> dataSet, String title, String xAxisName, String yAxisName) {
//        JFreeChart lineChart = ChartFactory.createLineChart(title,
//                                                            xAxisName,
//                                                            yAxisName,
//                                                            createDataset(dataSet),
//                                                            PlotOrientation.VERTICAL,
//                                                            false,
//                                                            false,
//                                                            false);
//        display(lineChart);
//
//    }
//
//
//    private void display(JFreeChart chart) {
//        JFrame f = new JFrame("Graph");
//        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        f.add(new ChartPanel(chart));
//        f.pack();
//        f.setLocationRelativeTo(null);
//        f.setVisible(true);
//    }

//    @Override
//    public void buildChart(List<Pair<String, Integer>> data, String title, String xAxisName, String yAxisName, String ChartPackage.GraphType) {
//        CategoryDataset dataset = createDataset(data);
//        CategoryAxis categoryAxis = new CategoryAxis(xAxisName);
//        ValueAxis valueAxis = new NumberAxis(yAxisName);
//
//        if(ChartPackage.GraphType.equals("BAR")){
//            BarRenderer renderer = new BarRenderer(){
//                @Override
//                public Paint getItemPaint(int row, int column) {
//                    return (column%2 == 0) ? Color.BLUE : Color.RED;
//                }
//            };
//            renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
//            renderer.setBaseItemLabelsVisible(Boolean.TRUE);
//            CategoryPlot plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
//            JFreeChart chart = new JFreeChart(title, plot);
//            chart.removeLegend();
//            display(chart);
//
//        }
//        else if(ChartPackage.GraphType.equals("PIE")){
//            buildPieChart(data, title);
//        }
//
//    }
//
//    private static class ChartBuilder {
//        private String xAxisName;
//        private String yAxisName;
//        private String title;
//        private List<Pair<String,Integer>> data;
//
//        enum ChartPackage.GraphType{BAR, PIE, LINE, XY};
//
//        public ChartBuilder(String Title, String xAxisNAme, String yAxisName){
//            this.xAxisName = xAxisNAme;
//            this.yAxisName = yAxisName;
//            this.title = Title;
//
//        }
//
//    }
//
//    private String title = "Title";
//    private String xAxisName = "xAxisName";
//    private String yAxisName = "yAxisName";
}