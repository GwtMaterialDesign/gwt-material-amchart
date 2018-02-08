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

import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.amcharts.client.ui.chart.base.AbstractChart;
import gwt.material.design.amcharts.client.ui.chart.base.constants.AnimationEffect;
import gwt.material.design.amcharts.client.ui.chart.base.constants.ChartType;
import gwt.material.design.amcharts.client.ui.chart.events.AmChartEvents;
import gwt.material.design.amcharts.client.ui.chart.events.HasCoordinateChartHandlers;
import gwt.material.design.amcharts.client.ui.chart.events.coordinate.*;
import gwt.material.design.amcharts.client.ui.chart.events.object.CoordinateGraphData;
import gwt.material.design.amcharts.client.ui.chart.events.object.CoordinateGraphItemData;
import gwt.material.design.amcharts.client.ui.chart.js.AmCoordinateChart;
import gwt.material.design.amcharts.client.ui.chart.js.AmGraph;
import gwt.material.design.amcharts.client.ui.chart.js.options.AmValueAxis;
import gwt.material.design.amcharts.client.ui.chart.options.Graph;
import gwt.material.design.amcharts.client.ui.chart.options.Guide;
import gwt.material.design.amcharts.client.ui.chart.options.ValueAxis;
import gwt.material.design.client.base.helper.ColorHelper;
import gwt.material.design.client.constants.Color;
import gwt.material.design.jquery.client.api.Functions;

//@formatter:off

/**
 * Base class of {@link RectangularChart} and {@link RadarChart}. It can not be instantiated explicitly.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmCoordinateChart">Official Documentation</a>
 */
//@formatter:on
public abstract class CoordinateChart extends AbstractChart implements HasCoordinateChartHandlers {

    private Functions.Func1<Object> clickGraphEvent, clickGraphItemEvent, rightClickGraphItemEvent, rollOutGraphEvent, rollOutGraphItemEvent, rollOverGraphEvent, rollOverGraphItemEvent;

    public CoordinateChart(ChartType chartType) {
        super(chartType);
    }

    @Override
    public void unload() {
        super.unload();

        removeListener(getChart(), AmChartEvents.CLICK_GRAPH, clickGraphEvent);
        removeListener(getChart(), AmChartEvents.CLICK_GRAPH_ITEM, clickGraphItemEvent);
        removeListener(getChart(), AmChartEvents.RIGHT_CLICK_GRAPH_ITEM, rightClickGraphItemEvent);
        removeListener(getChart(), AmChartEvents.ROLL_OUT_GRAPH, rollOutGraphEvent);
        removeListener(getChart(), AmChartEvents.ROLL_OUT_GRAPH_ITEM, rollOutGraphItemEvent);
        removeListener(getChart(), AmChartEvents.ROLL_OVER_GRAPH, rollOverGraphEvent);
        removeListener(getChart(), AmChartEvents.ROLL_OVER_GRAPH_ITEM, rollOverGraphItemEvent);
    }

    @Override
    protected void loadEvents() {
        super.loadEvents();

        clickGraphEvent = object -> ClickGraphEvent.fire(this, (CoordinateGraphData) object);
        clickGraphItemEvent = object -> ClickGraphItemEvent.fire(this, (CoordinateGraphItemData) object);
        rightClickGraphItemEvent = object -> RightClickGraphItemEvent.fire(this, (CoordinateGraphItemData) object);
        rollOutGraphEvent = object -> RollOutGraphEvent.fire(this, (CoordinateGraphData) object);
        rollOutGraphItemEvent = object -> RollOutGraphItemEvent.fire(this, (CoordinateGraphItemData) object);
        rollOverGraphEvent = object -> RollOverGraphEvent.fire(this, (CoordinateGraphData) object);
        rollOverGraphItemEvent = object -> RollOverGraphItemEvent.fire(this, (CoordinateGraphItemData) object);

        addListener(AmChartEvents.CLICK_GRAPH, clickGraphEvent);
        addListener(AmChartEvents.CLICK_GRAPH_ITEM, clickGraphItemEvent);
        addListener(AmChartEvents.RIGHT_CLICK_GRAPH_ITEM, rightClickGraphItemEvent);
        addListener(AmChartEvents.ROLL_OUT_GRAPH, rollOutGraphEvent);
        addListener(AmChartEvents.ROLL_OUT_GRAPH_ITEM, rollOutGraphItemEvent);
        addListener(AmChartEvents.ROLL_OVER_GRAPH, rollOverGraphEvent);
        addListener(AmChartEvents.ROLL_OVER_GRAPH_ITEM, rollOverGraphItemEvent);
    }

    /**
     * Read-only. Array, holding processed chart's data.
     */
    public void setChartData(Object... chartData) {
        getChart().chartData = chartData;
    }

    /**
     * Specifies the colors of the graphs if the lineColor of a graph is not set. If there are more graphs then colors
     * in this array, the chart picks a random color.
     */
    public void setColors(String... colors) {
        getChart().colors = colors;
    }

    public void setColors(Color... colors) {
        for (int i = 0; i < colors.length; i++) {
            getChart().colors[i] = ColorHelper.setupComputedBackgroundColor(colors[i]);
        }
    }

    /**
     * The array of graphs belonging to this chart.
     */
    public void setGraphs(Graph... graphs) {
        for (int i = 0; i < graphs.length; i++) {
            getChart().graphs[i] = graphs[i].getAmGraph();
        }
    }

    /**
     * Specifies if grid should be drawn above the graphs or below. Will not work properly with 3D charts. Default
     * to false
     */
    public void setGridAboveGraphs(boolean gridAboveGraphs) {
        getChart().gridAboveGraphs = gridAboveGraphs;
    }

    /**
     * Instead of adding guides to the axes, you can push all of them to this array. In case guide has category or date
     * defined, it will automatically will be assigned to the category axis. Otherwise to first value axis, unless you
     * specify a different valueAxis for the guide.
     */
    public void setGuides(Guide... guides) {
        for (int i = 0; i < guides.length; i++) {
            getChart().guides[i] = guides[i].getAmGuide();
        }
    }

    /**
     * Specifies whether the animation should be sequenced or all objects should appear at once. Default to true
     */
    public void setSequencedAnimation(boolean sequencedAnimation) {
        getChart().sequencedAnimation = sequencedAnimation;
    }

    /**
     * Duration of the animation, in seconds. Default to 0
     */
    public void setStartDuration(double startDuration) {
        getChart().startDuration = startDuration;
    }

    /**
     * Animation effect. Possible values are: easeOutSine, easeInSine, elastic, bounce. Default to "elastic"
     */
    public void setStartEffect(AnimationEffect startEffect) {
        getChart().startEffect = startEffect.getName();
    }

    /**
     * The initial opacity of the column/line. If you set startDuration to a value higher than 0, the columns/lines
     * will fade in from startAlpha. Value range is 0 - 1. Default to 1
     */
    public void setStartAlpha(double startAlpha) {
        getChart().startAlpha = startAlpha;
    }

    /**
     * Target of url. Default to _self
     */
    public void setUrlTarget(String urlTarget) {
        getChart().urlTarget = urlTarget;
    }

    /**
     * The array of value axes. Chart creates one value axis automatically, so if you need only one value axis,
     * you don't need to create it.
     */
    public void setValueAxes(ValueAxis... valueAxes) {
        for (int i = 0; i < valueAxes.length; i++) {
            getChart().valueAxes[i] = valueAxes[i].getAmValueAxis();
            valueAxes[i].load();
        }
    }

    /**
     * Adds a graph to the chart.
     */
    public void addGraph(Graph graph) {
        getChart().addGraph(graph.getAmGraph());
    }

    /**
     * Adds value axis to the chart. One value axis is created automatically, so if you don't want to change anything
     * or add more value axes, you don't need to add it.
     */
    public void addValueAxis(ValueAxis valueAxis) {
        getChart().addValueAxis(valueAxis.getAmValueAxis());
        valueAxis.load();
    }

    /**
     * You can trigger the animation of the chart.
     */
    public void animateAgain() {
        getChart().animateAgain();
    }

    /**
     * Returns graph by id.
     */
    public AmGraph getGraphById(String id) {
        return getChart().getGraphById(id);
    }

    /**
     * Returns value axis by id.
     */
    public AmValueAxis getValueAxisById(String id) {
        return getChart().getValueAxisById(id);
    }

    /**
     * Hide the graph (if it is visible). Usually this method is called from the ChartLegend, when you click on the legend
     * marker.
     */
    public void hideGraph(Graph graph) {
        getChart().hideGraph(graph.getAmGraph());
    }

    /**
     * Hide value balloon of a graph. Usually this method is called from the ChartLegend, when you click on the legend text.
     */
    public void hideGraphsBalloon(Graph graph) {
        getChart().hideGraphsBalloon(graph.getAmGraph());
    }

    /**
     * Highlight the graph. Usually this method is called from the ChartLegend, when you roll-over the legend entry.
     */
    public void highlightGraph(Graph graph) {
        getChart().highlightGraph(graph.getAmGraph());
    }

    /**
     * Removes graph from the chart.
     */
    public void removeGraph(Graph graph) {
        getChart().removeGraph(graph.getAmGraph());
    }

    /**
     * Removes value axis from the chart. When you remove value axis, all graphs assigned to this axis are also removed.
     */
    public void removeValueAxis(ValueAxis valueAxis) {
        getChart().removeValueAxis(valueAxis.getAmValueAxis());
        valueAxis.unload();
    }

    /**
     * Show the graph (if it is hidden). Usually this method is called from the ChartLegend, when you click on the legend
     * marker.
     */
    public void showGraph(Graph graph) {
        getChart().showGraph(graph.getAmGraph());
    }

    /**
     * Show value balloon of a graph. Usually this method is called from the ChartLegend, when you click on the legend text.
     */
    public void showGraphsBalloon(Graph graph) {
        getChart().showGraphsBalloon(graph.getAmGraph());
    }

    /**
     * UnhighlightGraph the graph. Usually this method is called from the ChartLegend, when you roll-out the legend entry.
     */
    public void unhighlightGraph(Graph graph) {
        getChart().unhighlightGraph(graph.getAmGraph());
    }

    @Override
    public abstract AmCoordinateChart getChart();

    @Override
    public HandlerRegistration addClickGraphHandler(ClickGraphEvent.ClickGraphHandler handler) {
        return addHandler(handler, ClickGraphEvent.getType());
    }

    @Override
    public HandlerRegistration addClickGraphItemHandler(ClickGraphItemEvent.ClickGraphItemHandler handler) {
        return addHandler(handler, ClickGraphItemEvent.getType());
    }

    @Override
    public HandlerRegistration addRightClickGraphItemHandler(RightClickGraphItemEvent.RightClickGraphItemHandler handler) {
        return addHandler(handler, RightClickGraphItemEvent.getType());
    }

    @Override
    public HandlerRegistration addRollOutGraphHandler(RollOutGraphEvent.RollOutGraphHandler handler) {
        return addHandler(handler, RollOutGraphEvent.getType());
    }

    @Override
    public HandlerRegistration addRollOutGraphItemHandler(RollOutGraphItemEvent.RollOutGraphItemHandler handler) {
        return addHandler(handler, RollOutGraphItemEvent.getType());
    }

    @Override
    public HandlerRegistration addRollOverGraphHandler(RollOverGraphEvent.RollOverGraphHandler handler) {
        return addHandler(handler, RollOverGraphEvent.getType());
    }

    @Override
    public HandlerRegistration addRollOverGraphItemHandler(RollOverGraphItemEvent.RollOverGraphItemHandler handler) {
        return addHandler(handler, RollOverGraphItemEvent.getType());
    }
}
