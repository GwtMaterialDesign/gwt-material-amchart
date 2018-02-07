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
package gwt.material.design.amchart.client.ui.chart.events;

import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.amchart.client.ui.chart.base.AbstractChart;
import gwt.material.design.amchart.client.ui.chart.events.core.*;
//@formatter:off

/**
 * {@link AbstractChart} event handlers
 *
 * @author kevzlou7979@gmail.com
 */
//@formatter:on
public interface HasChartHandlers {

    /**
     * Dispatched when initial chart animations are finished.
     */
    HandlerRegistration addAnimationFinishedHandler(AnimationFinishedEvent.AnimationFinishedHandler handler);

    /**
     * Fired just before the chart starts to build itself for the first time. Note: you might need to set processTimeout
     * to > 0 value in order to register this event properly.
     */
    HandlerRegistration addBuildStartedHandler(BuildStartedEvent.BuildStartedHandler handler);

    /**
     * Dispatched when chart is build for the first time or after validateData() method was called.
     */
    HandlerRegistration addDataUpdatedHandler(DataUpdatedEvent.DataUpdatedHandler handler);

    /**
     * Fired every time chart is drawn or re-drawn - graph toggle, chart area resize, etc.
     * <p>
     * Please note, that this event will not fire on zoom. Use "zoomed" event instead to catch those events.
     */
    HandlerRegistration addDrawnHandler(DrawnEvent.DrawnHandler handler);

    /**
     * Dispatched when chart is build for the first time.
     */
    HandlerRegistration addInitHandler(InitEvent.InitHandler handler);

    /**
     * Dispatched when the chart is build for the first time and each time after chart.validateNow() method is called
     * and the chart is build.
     */
    HandlerRegistration addRenderedHandler(RenderedEvent.RenderedHandler handler);
}
