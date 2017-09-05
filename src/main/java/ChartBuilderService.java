import java.awt.Color;
import java.awt.Paint;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import javafx.util.Pair;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class ChartBuilderService implements IChartBuilderService{


    private CategoryDataset createDataset(List<Pair<String,Integer>> data) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for(Pair P : data){
            dataset.addValue(P.getValue().hashCode(), "row", P.getKey().toString());
        }

        return dataset;
    }

    private PieDataset createPieDataSet(List<Pair<String,Integer>> data) {
        DefaultPieDataset dataset = new DefaultPieDataset();

        for(Pair P : data){
            dataset.setValue(P.getKey().toString(), P.getValue().hashCode());
        }

        return dataset;
    }

    private void display(JFreeChart chart) {
        JFrame f = new JFrame("Graph");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.add(new ChartPanel(chart));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }


    @Override
    public void buildChart(List<Pair<String, Integer>> data, String title, String xAxisName, String yAxisName, String GraphType) {
        CategoryDataset dataset = createDataset(data);
        CategoryAxis categoryAxis = new CategoryAxis(xAxisName);
        ValueAxis valueAxis = new NumberAxis(yAxisName);

        if(GraphType.equals("BAR")){
            BarRenderer renderer = new BarRenderer(){
                @Override
                public Paint getItemPaint(int row, int column) {
                    return (column%2 == 0) ? Color.BLUE : Color.RED;
                }
            };
            renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
            renderer.setBaseItemLabelsVisible(Boolean.TRUE);
            CategoryPlot plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
            JFreeChart chart = new JFreeChart(title, plot);
            chart.removeLegend();
            display(chart);

        }
        else if(GraphType.equals("PIE")){
            buildPieChart(data, title);
        }

    }

    @Override
    public void buildBarChart(List<Pair<String, Integer>> data, String title, String xAxisName, String yAxisName) {

        JFreeChart barChart = ChartFactory.createBarChart(
                title,
                xAxisName,
                yAxisName,
                createDataset(data),
                PlotOrientation.VERTICAL,
                false,
                false,
                false
        );
        Paint itemPaint = barChart.getCategoryPlot().getRenderer().getItemPaint(0, 0);
        System.out.println(itemPaint);

//        ChartPanel chartPanel = new ChartPanel(barChart);
//        chartPanel.setPreferredSize(new java.awt.Dimension(500,270));

        display(barChart);

    }

    @Override
    public void buildPieChart(List<Pair<String, Integer>> data, String title) {
        JFreeChart pieChart = ChartFactory.createPieChart(
                title,
                createPieDataSet(data),
                true,
                true,
                false
        );

        display(pieChart);

    }

    @Override
    public void buildLineChart(List<Pair<String, Integer>> data, String title, String xAxisName, String yAxisName) {
        JFreeChart lineChart = ChartFactory.createLineChart(
                title,
                xAxisName,
                yAxisName,
                createDataset(data),
                PlotOrientation.VERTICAL,
                false,
                false,
                false
        );
        display(lineChart);

    }



    private void display2(List<Pair<String,Integer>> data) {
        JFrame f = new JFrame("Plot");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new ChartPanel(createBarChart(createDataset( data))));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private JFreeChart createBarChart(CategoryDataset dataset) {
        CategoryAxis categoryAxis = new CategoryAxis("cat");
        ValueAxis valueAxis = new NumberAxis("dog");
//        valueAxis.setVisible(false);

        BarRenderer renderer = new BarRenderer() {

//            @Override
//            public Paint getItemPaint(int row, int column) {
//                switch (column) {
//                    case 0:
//                        return Color.red;
//                    case 1:
//                        return Color.yellow;
//                    case 2:
//                        return Color.blue;
//                    case 3:
//                        return Color.orange;
//                    case 4:
//                        return Color.gray;
//                    case 5:
//                        return Color.green.darker();
//                    default:
//                        return Color.red;
//                }
//            }
        };

//        renderer.setDrawBarOutline(false);

        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(Boolean.TRUE);
//        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER));
//        renderer.setBarPainter(new StandardBarPainter());
        CategoryPlot plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
        JFreeChart chart = new JFreeChart("xx", JFreeChart.DEFAULT_TITLE_FONT, plot, true);

//        chart.setBackgroundPaint(Color.white);
        return chart;
    }



    public static void main(String[] args) {
        List<Pair<String,Integer>> data = new ArrayList<>();
//        Pair<String,Integer> p0 = new Pair<>("test", 100);
        data.add(new Pair<>("A", 10));
        data.add(new Pair<>("B", 20));
        data.add(new Pair<>("C", 30));
        data.add(new Pair<>("D",40));
        data.add(new Pair<>("LUL",90));


//        new ChartBuilderService().display2(data);
        new ChartBuilderService().buildChart(data);
        new ChartBuilderService().buildBarChart(data);
//        new ChartBuilderService().buildPieChart(data, "PIE");
//        new ChartBuilderService().buildLineChart(data, "LINE", "x", "y");


    }



}