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
package gwt.material.design.amcharts.client.ui.chart.js;

import gwt.material.design.amcharts.client.ui.chart.js.options.Guide;
import gwt.material.design.amcharts.client.ui.chart.js.options.AmValueAxis;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

//@formatter:off

/**
 * Base class of {@link AmRectangularChart} and {@link AmRadarChart}. It can not be instantiated explicitly.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmCoordinateChart">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, namespace = "AmCharts")
public class AmCoordinateChart extends AmChart {

    /**
     * Read-only. Array, holding processed chart's data.
     */
    @JsProperty
    public Object[] chartData;

    /**
     * Specifies the colors of the graphs if the lineColor of a graph is not set. If there are more graphs then colors
     * in this array, the chart picks a random color.
     */
    @JsProperty
    public String[] colors;

    /**
     * The array of graphs belonging to this chart.
     */
    @JsProperty
    public AmGraph[] graphs;

    /**
     * Specifies if grid should be drawn above the graphs or below. Will not work properly with 3D charts. Default
     * to false
     */
    @JsProperty
    public boolean gridAboveGraphs;

    /**
     * Instead of adding guides to the axes, you can push all of them to this array. In case guide has category or date
     * defined, it will automatically will be assigned to the category axis. Otherwise to first value axis, unless you
     * specify a different valueAxis for the guide.
     */
    @JsProperty
    public Guide[] guides;

    /**
     * Specifies whether the animation should be sequenced or all objects should appear at once. Default to true
     */
    @JsProperty
    public boolean sequencedAnimation;

    /**
     * The initial opacity of the column/line. If you set startDuration to a value higher than 0, the columns/lines
     * will fade in from startAlpha. Value range is 0 - 1. Default to 1
     */
    @JsProperty
    public double startAlpha;

    /**
     * Duration of the animation, in seconds. Default to 0
     */
    @JsProperty
    public double startDuration;

    /**
     * Animation effect. Possible values are: easeOutSine, easeInSine, elastic, bounce. Default to "elastic"
     */
    @JsProperty
    public String startEffect;

    /**
     * Target of url. Default to _self
     */
    @JsProperty
    public String urlTarget;

    /**
     * The array of value axes. Chart creates one value axis automatically, so if you need only one value axis,
     * you don't need to create it.
     */
    @JsProperty
    public AmValueAxis[] valueAxes;

    /**
     * Adds a graph to the chart.
     */
    @JsMethod
    public native void addGraph(AmGraph amGraph);

    /**
     * Adds value axis to the chart. One value axis is created automatically, so if you don't want to change anything
     * or add more value axes, you don't need to add it.
     */
    @JsMethod
    public native void addValueAxis(AmValueAxis valueAxis);

    /**
     * You can trigger the animation of the chart.
     */
    @JsMethod
    public native void animateAgain();

    /**
     * Returns graph by id.
     */
    @JsMethod
    public native AmGraph getGraphById(String id);

    /**
     * Returns value axis by id.
     */
    @JsMethod
    public native AmValueAxis getValueAxisById(String id);

    /**
     * Hide the graph (if it is visible). Usually this method is called from the ChartLegend, when you click on the legend
     * marker.
     */
    @JsMethod
    public native void hideGraph(AmGraph amGraph);

    /**
     * Hide value balloon of a graph. Usually this method is called from the ChartLegend, when you click on the legend text.
     */
    @JsMethod
    public native void hideGraphsBalloon(AmGraph amGraph);

    /**
     * Highlight the graph. Usually this method is called from the ChartLegend, when you roll-over the legend entry.
     */
    @JsMethod
    public native void highlightGraph(AmGraph amGraph);

    /**
     * Removes graph from the chart.
     */
    @JsMethod
    public native void removeGraph(AmGraph amGraph);

    /**
     * Removes value axis from the chart. When you remove value axis, all graphs assigned to this axis are also removed.
     */
    @JsMethod
    public native void removeValueAxis(AmValueAxis valueAxis);

    /**
     * Show the graph (if it is hidden). Usually this method is called from the ChartLegend, when you click on the legend
     * marker.
     */
    @JsMethod
    public native void showGraph(AmGraph amGraph);

    /**
     * Show value balloon of a graph. Usually this method is called from the ChartLegend, when you click on the legend text.
     */
    @JsMethod
    public native void showGraphsBalloon(AmGraph amGraph);

    /**
     * UnhighlightGraph the graph. Usually this method is called from the ChartLegend, when you roll-out the legend entry.
     */
    @JsMethod
    public native void unhighlightGraph(AmGraph amGraph);
}
