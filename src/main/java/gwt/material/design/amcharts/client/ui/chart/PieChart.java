/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package gwt.material.design.amcharts.client.ui.chart;

import gwt.material.design.amcharts.client.ui.chart.base.constants.ChartType;
import gwt.material.design.amcharts.client.ui.chart.js.AmPieChart;
import gwt.material.design.amcharts.client.ui.chart.js.options.GraphDataItem;
import gwt.material.design.jquery.client.api.Functions;

//@formatter:off

/**
 * Extension for {@link SliceChart} to create pie/donut charts.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmPieChart">Official Documentation</a>
 */
//@formatter:on
public class PieChart extends SliceChart {

    protected AmPieChart chart;

    public PieChart() {
        super(ChartType.PIE);
    }

    /**
     * Sometimes, because of a rounding, percent of a sum of all slices is not equal to 100%. If you set this to true,
     * when this case happens, number of decimals will be increased so that sum would become 100%. Default to false
     */
    public void setAdjustPrecision(boolean adjustPrecision) {
        getChart().adjustPrecision = adjustPrecision;
    }

    /**
     * Pie lean angle (for 3D effect). Valid range is 0 - 90. Default to 0
     */
    public void setAngle(int angle) {
        getChart().angle = angle;
    }

    /**
     * If you set some function, the graph will call it and pass
     * {@link GraphDataItem} object to it. This function
     * should return a string which will be displayed in a balloon.
     */
    public void setBalloonFunction(Functions.Func balloonFunction) {
        getChart().balloonFunction = balloonFunction;
    }

    /**
     * Balloon text. The following tags can be used: [[value]], [[title]], [[percents]], [[description]] or any other
     * field name from your data provider. HTML tags can also be used.
     * Default to [[title]]: [[percents]]% ([[value]])\n[[description]]
     */
    public void setBalloonText(String balloonText) {
        getChart().balloonText = balloonText;
    }

    /**
     * Depth of the pie (for 3D effect). Default to 0
     */
    public void setDepth3D(int depth3D) {
        getChart().depth3D = depth3D;
    }

    /**
     * Type of gradient. Use gradientRatio to create gradients. Default to radial
     */
    public void setGradientType(String gradientType) {
        getChart().gradientType = gradientType;
    }

    /**
     * Inner radius of the pie, in pixels or percents. Default to 0
     */
    public void setInnerRadius(Object innerRadius) {
        getChart().innerRadius = innerRadius;
    }

    /**
     * The distance between the label and the slice, in pixels. You can use negative values to put the label on
     * the slice. Default to 20
     */
    public void setLabelRadius(Object labelRadius) {
        getChart().labelRadius = labelRadius;
    }

    /**
     * Name of the field in dataProvider which specifies the length of a tick. Note, the chart will not try to arrange
     * labels automatically if this property is set.
     */
    public void setLabelRadiusField(String labelRadiusField) {
        getChart().labelRadiusField = labelRadiusField;
    }

    /**
     * Label text. The following tags can be used: [[value]], [[title]], [[percents]], [[description]] or any other
     * field name from your data provider. Default to [[title]]: [[percents]]%
     */
    public void setLabelText(String labelText) {
        getChart().labelText = labelText;
    }

    /**
     * Minimum radius of the pie, in pixels. Default to 10
     */
    public void setMinRadius(Object minRadius) {
        getChart().minRadius = minRadius;
    }

    /**
     * You can set fixed position of a pie center, in pixels or in percents.
     */
    public void setPieX(Object pieX) {
        getChart().pieX = pieX;
    }

    /**
     * You can set fixed position of a pie center, in pixels or in percents.
     */
    public void setPieY(Object pieY) {
        getChart().pieY = pieY;
    }

    /**
     * Pull out radius, in pixels or percents. Default to 20%
     */
    public void setPullOutRadius(Object pullOutRadius) {
        getChart().pullOutRadius = pullOutRadius;
    }

    /**
     * Radius of a pie, in pixels or percents. By default, radius is calculated automatically.
     */
    public void setRadius(Object radius) {
        getChart().radius = radius;
    }

    /**
     * Angle of the first slice, in degrees. This will work properly only if "depth3D" is set to 0. If "depth3D" is
     * greater than 0, then there can be two angles only: 90 and 270. Value range is 0-360. Default to 90
     */
    public void setStartAngle(Object startAngle) {
        getChart().startAngle = startAngle;
    }

    /**
     * Radius of the positions from which the slices will fly in. Default to 500%
     */
    public void setStartRadius(Object startRadius) {
        getChart().startRadius = startRadius;
    }

    @Override
    public AmPieChart getChart() {
        if (chart == null) {
            chart = new AmPieChart();
        }
        return chart;
    }
}
