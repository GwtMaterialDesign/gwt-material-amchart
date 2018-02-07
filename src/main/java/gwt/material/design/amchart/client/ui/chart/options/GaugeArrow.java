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
package gwt.material.design.amchart.client.ui.chart.options;

import gwt.material.design.amchart.client.ui.chart.base.ChartOptions;
import gwt.material.design.amchart.client.ui.chart.js.options.AmGaugeArrow;
import gwt.material.design.amchart.client.ui.chart.js.options.AmGaugeAxis;
import gwt.material.design.client.base.helper.ColorHelper;
import gwt.material.design.client.constants.Color;

//@formatter:off

/**
 * Creates an arrow for AmAngularGauge charts, multiple can be assigned.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/GaugeArrow">Official Documentation</a>
 */
//@formatter:on
public class GaugeArrow extends ChartOptions {

    private AmGaugeArrow gaugeArrow;

    public double getAlpha() {
        return getAmGaugeArrow().alpha;
    }

    /**
     * Opacity of an arrow. Default to 1
     */
    public void setAlpha(double alpha) {
        getAmGaugeArrow().alpha = alpha;
    }

    public AmGaugeAxis getAxis() {
        return getAmGaugeArrow().axis;
    }

    /**
     * Axis of the arrow. You can use reference to the axis or id of the axis. If you don't set any axis, the first
     * axis of a chart will be used.
     */
    public void setAxis(GaugeAxis axis) {
        getAmGaugeArrow().axis = axis.getAmGaugeAxis();
    }

    public int getBorderAlpha() {
        return getAmGaugeArrow().borderAlpha;
    }

    /**
     * Opacity of arrow border. Default to 1
     */
    public void setBorderAlpha(int borderAlpha) {
        getAmGaugeArrow().borderAlpha = borderAlpha;
    }

    public boolean isClockWiseOnly() {
        return getAmGaugeArrow().clockWiseOnly;
    }

    /**
     * In case you need the arrow to rotate only clock-wise, set this property to true. Default to false
     */
    public void setClockWiseOnly(boolean clockWiseOnly) {
        getAmGaugeArrow().clockWiseOnly = clockWiseOnly;
    }

    public String getColor() {
        return getAmGaugeArrow().color;
    }

    public void setColor(Color color) {
        setColor(ColorHelper.setupComputedBackgroundColor(color));
    }

    /**
     * Color of an arrow. Default to #000000
     */
    public void setColor(String color) {
        getAmGaugeArrow().color = color;
    }

    public String getId() {
        return getAmGaugeArrow().id;
    }

    /**
     * Unique id of an arrow.
     */
    public void setId(String id) {
        getAmGaugeArrow().id = id;
    }

    public Object getInnerRadius() {
        return getAmGaugeArrow().innerRadius;
    }

    /**
     * Inner radius of an arrow. Default to 0
     */
    public void setInnerRadius(Object innerRadius) {
        getAmGaugeArrow().innerRadius = innerRadius;
    }

    public int getNailAlpha() {
        return getAmGaugeArrow().nailAlpha;
    }

    /**
     * Opacity of a nail, holding the arrow. Default to 1
     */
    public void setNailAlpha(int nailAlpha) {
        getAmGaugeArrow().nailAlpha = nailAlpha;
    }

    public int getNailBorderAlpha() {
        return getAmGaugeArrow().nailBorderAlpha;
    }

    /**
     * Opacity of nail border. Default to 0
     */
    public void setNailBorderAlpha(int nailBorderAlpha) {
        getAmGaugeArrow().nailBorderAlpha = nailBorderAlpha;
    }

    public int getNailBorderThickness() {
        return getAmGaugeArrow().nailBorderThickness;
    }

    /**
     * Thickness of nail border. Default to 1
     */
    public void setNailBorderThickness(int nailBorderThickness) {
        getAmGaugeArrow().nailBorderThickness = nailBorderThickness;
    }

    public int getNailRadius() {
        return getAmGaugeArrow().nailRadius;
    }

    /**
     * Radius of a nail, holding the arrow. Default to 8
     */
    public void setNailRadius(int nailRadius) {
        getAmGaugeArrow().nailRadius = nailRadius;
    }

    public Object getRadius() {
        return getAmGaugeArrow().radius;
    }

    /**
     * Radius of an arrow. Default to 90%
     */
    public void setRadius(Object radius) {
        getAmGaugeArrow().radius = radius;
    }

    public int getStartWidth() {
        return getAmGaugeArrow().startWidth;
    }

    /**
     * Default to 8
     */
    public void setStartWidth(int startWidth) {
        getAmGaugeArrow().startWidth = startWidth;
    }

    public int getValue() {
        return getAmGaugeArrow().value;
    }

    /**
     * Value to which the arrow should point at.
     */
    public void setValue(int value) {
        getAmGaugeArrow().setValue(value);
    }

    public AmGaugeArrow getAmGaugeArrow() {
        if (gaugeArrow == null) {
            gaugeArrow = new AmGaugeArrow();
        }
        return gaugeArrow;
    }
}
