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
package gwt.material.design.amchart.client.ui.chart;

import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.amchart.client.ui.chart.base.AbstractChart;
import gwt.material.design.amchart.client.ui.chart.base.constants.AnimationEffect;
import gwt.material.design.amchart.client.ui.chart.base.constants.ChartType;
import gwt.material.design.amchart.client.ui.chart.events.AmChartEvents;
import gwt.material.design.amchart.client.ui.chart.events.HasSliceChartHandlers;
import gwt.material.design.amchart.client.ui.chart.events.object.SliceData;
import gwt.material.design.amchart.client.ui.chart.events.slice.*;
import gwt.material.design.amchart.client.ui.chart.js.AmSlicedChart;
import gwt.material.design.client.base.helper.ColorHelper;
import gwt.material.design.client.constants.Color;
import gwt.material.design.jquery.client.api.Functions;

//@formatter:off

/**
 * Extension for {@link AbstractChart} and base class of {@link PieChart} and {@link FunnelChart}. It can not be
 * instantiated explicitly.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmSlicedChart">Official Documentation</a>
 */
//@formatter:on
public abstract class SliceChart extends AbstractChart implements HasSliceChartHandlers {

    private Functions.Func1<Object> clickSliceEvent, pullInSliceEvent, pullOutSliceEvent, rightClickSliceEvent, rollOutSliceEvent, rollOverSliceEvent;

    public SliceChart(ChartType chartType) {
        super(chartType);
    }

    @Override
    protected void loadEvents() {
        super.loadEvents();

        clickSliceEvent = object -> ClickSliceEvent.fire(this, (SliceData) object);
        pullInSliceEvent = object -> PullInSliceEvent.fire(this, (SliceData) object);
        pullOutSliceEvent = object -> PullOutSliceEvent.fire(this, (SliceData) object);
        rightClickSliceEvent = object -> RightClickSliceEvent.fire(this, (SliceData) object);
        rollOutSliceEvent = object -> RollOutSliceEvent.fire(this, (SliceData) object);
        rollOverSliceEvent = object -> RollOverSliceEvent.fire(this, (SliceData) object);

        addListener(AmChartEvents.CLICK_SLICE, clickSliceEvent);
        addListener(AmChartEvents.PULL_IN_SLICE, pullInSliceEvent);
        addListener(AmChartEvents.PULL_OUT_SLICE, pullOutSliceEvent);
        addListener(AmChartEvents.RIGHT_CLICK_SLICE, rightClickSliceEvent);
        addListener(AmChartEvents.ROLL_OUT_SLICE, rollOutSliceEvent);
        addListener(AmChartEvents.ROLL_OVER_SLICE, rollOverSliceEvent);
    }

    @Override
    public void unload() {
        super.unload();

        removeListener(getChart(), AmChartEvents.CLICK_SLICE, clickSliceEvent);
        removeListener(getChart(), AmChartEvents.PULL_IN_SLICE, pullInSliceEvent);
        removeListener(getChart(), AmChartEvents.PULL_OUT_SLICE, pullOutSliceEvent);
        removeListener(getChart(), AmChartEvents.RIGHT_CLICK_SLICE, rightClickSliceEvent);
        removeListener(getChart(), AmChartEvents.ROLL_OUT_SLICE, rollOutSliceEvent);
        removeListener(getChart(), AmChartEvents.ROLL_OVER_SLICE, rollOverSliceEvent);
    }

    /**
     * Text which screen readers will read if user rolls-over the slice or sets focus using tab key (this is possible
     * only if tabIndex property of AmSlicedChart is set to some number). Text is added as aria-label tag. Note - not
     * all screen readers and browsers support this. Default to [[title]]: [[percents]]% [[value]] [[description]]
     */
    public void setAccessibleLabel(String accessibleLabel) {
        getChart().accessibleLabel = accessibleLabel;
    }

    /**
     * Opacity of all slices. Default to 1
     */
    public void setAlpha(double alpha) {
        getChart().alpha = alpha;
    }

    /**
     * Name of the field in chart's dataProvider which holds slice's alpha.
     */
    public void setAlphaField(String alphaField) {
        getChart().alphaField = alphaField;
    }

    /**
     * Color of the first slice. All the other will be colored with darker or brighter colors. Use brightnessStep to
     * set intensity of color change for each subsequent slice.
     */
    public void setBaseColor(String baseColor) {
        getChart().baseColor = baseColor;
    }

    public void setBaseColor(Color color) {
        setBaseColor(ColorHelper.setupComputedBackgroundColor(color));
    }

    /**
     * If you set baseColor to some color, the chart will not use colors array to color each slice but rather this
     * setting to color the first slice with gradually increasing (or decreasing) brightness for each subsequent slice.
     * This setting describes the intensity of each step. Set to positive number to make the color brighter with each
     * slice. Set to negative to make the colors darker for subsequent slices. Default to 20
     */
    public void setBrightnessStep(int brightnessStep) {
        getChart().brightnessStep = brightnessStep;
    }

    /**
     * Read-only. Array of AmSlice objects.
     */
    public void setChartData(Object... chartData) {
        getChart().chartData = chartData;
    }

    /**
     * If this field is set and addClassNames is enabled, the slice element will have this class name set.
     */
    public void setClassNameField(String classNameField) {
        getChart().classNameField = classNameField;
    }

    /**
     * Name of the field in chart's dataProvider which holds slice's color.
     */
    public void setColorField(String colorField) {
        getChart().colorField = colorField;
    }

    /**
     * Specifies the colors of the slices, if the slice color is not set. If there are more slices than colors in this
     * array, the chart picks random color.
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
     * Name of the field in chart's dataProvider which holds a string with description.
     */
    public void setDescriptionField(String descriptionField) {
        getChart().descriptionField = descriptionField;
    }

    /**
     * Example: [-0.2, 0, -0.2]. Will make slices to be filled with color gradients. Negative value means the color
     * will be darker than the original, and positive number means the color will be lighter.
     */
    public void setGradientRatio(Double... gradientRatio) {
        getChart().gradientRatio = gradientRatio;
    }

    /**
     * Opacity of the group slice. Value range is 0 - 1. Default to 1
     */
    public void setGroupedAlpha(double groupedAlpha) {
        getChart().groupedAlpha = groupedAlpha;
    }

    /**
     * Color of the group slice. The default value is not set - this means the next available color from "colors"
     * array will be used.
     */
    public void setGroupedColor(String groupedColor) {
        getChart().groupedColor = groupedColor;
    }

    public void setGroupedColor(Color color) {
        setGroupedColor(ColorHelper.setupComputedBackgroundColor(color));
    }

    /**
     * Description of the group slice.
     */
    public void setGroupedDescription(String groupedDescription) {
        getChart().groupedDescription = groupedDescription;
    }

    /**
     * If this is set to true, the group slice will be pulled out when the chart loads. Default to false
     */
    public void setGroupedPulled(boolean groupedPulled) {
        getChart().groupedPulled = groupedPulled;
    }

    /**
     * Title of the group slice.
     */
    public void setGroupedTitle(String groupedTitle) {
        getChart().groupedTitle = groupedTitle;
    }

    /**
     * If there is more than one slice whose percentage of the pie is less than this number, those slices will be
     * grouped together into one slice. This is the "other" slice. It will always be the last slice in a pie.
     * Default to 0
     */
    public void setGroupPercent(int groupPercent) {
        getChart().groupPercent = groupPercent;
    }

    /**
     * Slices with percent less then hideLabelsPercent won't display labels This is useful to avoid cluttering up
     * the chart, if you have a lot of small slices. 0 means all labels will be shown. Default to 0
     */
    public void setHideLabelsPercent(int hideLabelsPercent) {
        getChart().hideLabelsPercent = hideLabelsPercent;
    }

    /**
     * Opacity of a hovered slice. Value range is 0 - 1. Default to 1
     */
    public void setHoverAlpha(double hoverAlpha) {
        getChart().hoverAlpha = hoverAlpha;
    }

    /**
     * A field in data which holds color value for the tick. Use it to set color of the label for each slice
     * individually. Default to #000000
     */
    public void setLabelColorField(String labelColorField) {
        getChart().labelColorField = labelColorField;
    }

    /**
     * You can use it to format data labels in any way you want. Chart will call this method and will pass AmSlice object
     * and formatted text as attributes. This function should return string which will be displayed as label.
     */
    public void setLabelFunction(Functions.Func labelFunction) {
        getChart().labelFunction = labelFunction;
    }

    /**
     * Specifies whether data labels are visible. Default to true
     */
    public void setLabelsEnabled(boolean labelsEnabled) {
        getChart().labelsEnabled = labelsEnabled;
    }

    /**
     * Label tick opacity. Value range is 0 - 1. Default to 0.2
     */
    public void setLabelTickAlpha(double labelTickAlpha) {
        getChart().labelTickAlpha = labelTickAlpha;
    }

    /**
     * Label tick color. Default to #000000
     */
    public void setLabelTickColor(String labelTickColor) {
        getChart().labelTickColor = labelTickColor;
    }

    public void setLabelTickColor(Color color) {
        setLabelTickColor(ColorHelper.setupComputedBackgroundColor(color));
    }

    /**
     * Bottom margin of the chart. Default to 10
     */
    public void setMarginBottom(int marginBottom) {
        getChart().marginBottom = marginBottom;
    }

    /**
     * Left margin of the chart. Default to 0
     */
    public void setMarginLeft(int marginLeft) {
        getChart().marginLeft = marginLeft;
    }

    /**
     * Right margin of the chart. Default to 0
     */
    public void setMarginRight(int marginRight) {
        getChart().marginRight = marginRight;
    }

    /**
     * Top margin of the chart. Default to 10
     */
    public void setMarginTop(int marginTop) {
        getChart().marginTop = marginTop;
    }

    /**
     * If width of the label is bigger than maxLabelWidth, it will be wrapped. Default to 200
     */
    public void setMaxLabelWidth(int maxLabelWidth) {
        getChart().maxLabelWidth = maxLabelWidth;
    }

    /**
     * Outline opacity. Value range is 0 - 1. Default to 0
     */
    public void setOutlineAlpha(double outlineAlpha) {
        getChart().outlineAlpha = outlineAlpha;
    }

    /**
     * Outline color. Default to #FFFFFF
     */
    public void setOutlineColor(String outlineColor) {
        getChart().outlineColor = outlineColor;
    }

    public void setOutlineColor(Color color) {
        setOutlineColor(ColorHelper.setupComputedBackgroundColor(color));
    }

    /**
     * Pie outline thickness. Default to 1
     */
    public void setOutlineThickness(int outlineThickness) {
        getChart().outlineThickness = outlineThickness;
    }

    /**
     * Field name in your data provider which holds pattern information. Value of pattern should be object with url,
     * width, height of an image, optionally it might have x, y, randomX and randomY values. For example:
     * {"url":"../amcharts/patterns/black/pattern1.png", "width":4, "height":4}. Check amcharts/patterns folder for
     * some patterns. You can create your own patterns and use them. Note, x, y, randomX and randomY properties won't
     * work with IE8 and older. 3D bar/Pie charts won't work properly with patterns.
     */
    public void setPatternField(String patternField) {
        getChart().patternField = patternField;
    }

    /**
     * Name of the field in chart's dataProvider which holds a boolean value telling the chart whether this slice must
     * be pulled or not.
     */
    public void setPulledField(String pulledField) {
        getChart().pulledField = pulledField;
    }

    /**
     * Pull out duration, in seconds. Default to 1
     */
    public void setPullOutDuration(int pullOutDuration) {
        getChart().pullOutDuration = pullOutDuration;
    }

    /**
     * Pull out effect. Possible values are: easeOutSine, easeInSine, elastic, bounce. Default to "bounce"
     */
    public void setPullOutEffect(String pullOutEffect) {
        getChart().pullOutEffect = pullOutEffect;
    }

    /**
     * If this is set to true, only one slice can be pulled out at a time. If the viewer clicks on a slice, any other
     * pulled-out slice will be pulled in. Default to false
     */
    public void setPullOutOnlyOne(boolean pullOutOnlyOne) {
        getChart().pullOutOnlyOne = pullOutOnlyOne;
    }

    /**
     * Specifies whether the animation should be sequenced or all slices should appear at once. Default to true
     */
    public void setSequencedAnimation(boolean sequencedAnimation) {
        getChart().sequencedAnimation = sequencedAnimation;
    }

    /**
     * If you set this to true, the chart will display outlines (if visible) and labels for slices even if their value
     * is 0. Default to false
     */
    public void setShowZeroSlices(boolean showZeroSlices) {
        getChart().showZeroSlices = showZeroSlices;
    }

    /**
     * Initial opacity of all slices. Slices will fade in from startAlpha. Default to 0
     */
    public void setStartAlpha(double startAlpha) {
        getChart().startAlpha = startAlpha;
    }

    /**
     * Duration of the animation, in seconds. Default to 1
     */
    public void setStartDuration(int startDuration) {
        getChart().startDuration = startDuration;
    }

    /**
     * Animation effect. Possible values are: easeOutSine, easeInSine, elastic, bounce. Default to "bounce"
     */
    public void setStartEffect(AnimationEffect startEffect) {
        getChart().startEffect = startEffect.getName();
    }

    /**
     * Name of the field in chart's dataProvider which holds slice's title.
     */
    public void setTitleField(String titleField) {
        getChart().titleField = titleField;
    }

    /**
     * Name of the field in chart's dataProvider which holds url which would be accessed if the user clicks on a slice.
     */
    public void setUrlField(String urlField) {
        getChart().urlField = urlField;
    }

    /**
     * If url is specified for a slice, it will be opened when user clicks on it. urlTarget specifies target of this url.
     * Use _blank if you want url to be opened in a new window. Default to _self
     */
    public void setUrlTarget(String urlTarget) {
        getChart().urlTarget = urlTarget;
    }

    /**
     * Name of the field in chart's dataProvider which holds slice's value.
     */
    public void setValueField(String valueField) {
        getChart().valueField = valueField;
    }

    /**
     * Use this field to selectively specify which slice is shown in legend. It should be set to a boolean field in
     * data (that holds either true or false). For example if you set visibleInLegendField to "showInLegend", all slices
     * that have showInLegend: false in their data will not be shown in the legend.
     */
    public void setVisibleInLegendField(String visibleInLegendField) {
        getChart().visibleInLegendField = visibleInLegendField;
    }

    /**
     * You can trigger the animation of the chart.
     */
    public void animateAgain() {
        getChart().animateAgain();
    }

    /**
     * You can trigger the click on a slice from outside.
     */
    public void clickSlice(Object slice) {
        getChart().clickSlice(slice);
    }

    /**
     * Hides slice.
     */
    public void hideSlice(Object slice) {
        getChart().hideSlice(slice);
    }

    /**
     * You can simulate roll-out of a slice from outside.
     */
    public void rollOutSlice(Object slice) {
        getChart().rollOutSlice(slice);
    }

    /**
     * You can simulate roll-over a slice from outside.
     */
    public void rollOverSlice(Object slice) {
        getChart().rollOverSlice(slice);
    }

    /**
     * Shows slice.
     */
    public void showSlice(Object slice) {
        getChart().showSlice(slice);
    }

    @Override
    public abstract AmSlicedChart getChart();

    @Override
    public HandlerRegistration addClickSliceHandler(ClickSliceEvent.ClickSliceHandler handler) {
        return addHandler(handler, ClickSliceEvent.getType());
    }

    @Override
    public HandlerRegistration addPullInSliceHandler(PullInSliceEvent.PullInSliceHandler handler) {
        return addHandler(handler, PullInSliceEvent.getType());
    }

    @Override
    public HandlerRegistration addPullOutSliceHandler(PullOutSliceEvent.PullOutSliceHandler handler) {
        return addHandler(handler, PullOutSliceEvent.getType());
    }

    @Override
    public HandlerRegistration addRightClickSliceHandler(RightClickSliceEvent.RightClickSliceHandler handler) {
        return addHandler(handler, RightClickSliceEvent.getType());
    }

    @Override
    public HandlerRegistration addRollOutSliceHandler(RollOutSliceEvent.RollOutSliceHandler handler) {
        return addHandler(handler, RollOutSliceEvent.getType());
    }

    @Override
    public HandlerRegistration addRollOverSliceHandler(RollOverSliceEvent.RollOverSliceHandler handler) {
        return addHandler(handler, RollOverSliceEvent.getType());
    }
}
