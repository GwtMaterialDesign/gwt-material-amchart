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
import gwt.material.design.amchart.client.ui.chart.SliceChart;
import gwt.material.design.amchart.client.ui.chart.events.slice.*;

//@formatter:off

/**
 * {@link SliceChart} event handlers
 *
 * @author kevzlou7979@gmail.com
 */
//@formatter:on
public interface HasSliceChartHandlers {

    /**
     * Dispatched when user clicks on a slice. Event is an instance of original mouse event.
     */
    HandlerRegistration addClickSliceHandler(ClickSliceEvent.ClickSliceHandler handler);

    /**
     * Dispatched when user clicks on a slice and the slice is pulled-in. Event is an instance of original mouse event.
     */
    HandlerRegistration addPullInSliceHandler(PullInSliceEvent.PullInSliceHandler handler);

    /**
     * Dispatched when user clicks on a slice and the slice is pulled-out. Event is an instance of original mouse event.
     */
    HandlerRegistration addPullOutSliceHandler(PullOutSliceEvent.PullOutSliceHandler handler);

    /**
     * Dispatched when user right-clicks the slice. Event is an instance of original mouse event.
     */
    HandlerRegistration addRightClickSliceHandler(RightClickSliceEvent.RightClickSliceHandler handler);

    /**
     * Dispatched when user rolls-out of the slice. Event is an instance of original mouse event.
     */
    HandlerRegistration addRollOutSliceHandler(RollOutSliceEvent.RollOutSliceHandler handler);

    /**
     * Dispatched when user rolls-over the slice. Event is an instance of original mouse event.
     */
    HandlerRegistration addRollOverSliceHandler(RollOverSliceEvent.RollOverSliceHandler handler);
}
