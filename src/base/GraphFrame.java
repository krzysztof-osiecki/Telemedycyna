package base;

import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraphFrame extends javax.swing.JFrame {

  private ChartPanel chartPanel;

  public GraphFrame (Pacjent pacjent, TypPomiaru typ) {
    final DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
    final List<Pomiar> list = pacjent.pomiary.computeIfAbsent(typ, r -> new ArrayList<>());
    list.forEach((pomiar) -> {
      defaultCategoryDataset.addValue((Number) pomiar.value, typ.name(), list.indexOf(pomiar));
    });
    JFreeChart chart = ChartFactory.createLineChart("Dane", "", "", defaultCategoryDataset);
    CategoryPlot plot = chart.getCategoryPlot();
    ((NumberAxis) plot.getRangeAxis()).setAutoRangeIncludesZero(false);
    plot.getRangeAxis().setAutoRange(true);
    initComponents(chart);
  }

  private void initComponents (JFreeChart chart) {

    chartPanel = new ChartPanel(chart);
    chartPanel.setPreferredSize(new java.awt.Dimension(700, 500));
    this.add(chartPanel);

    setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(chartPanel)
        .addGap(0, 400, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(chartPanel)
        .addGap(0, 300, Short.MAX_VALUE)
    );

    pack();
  }
}
