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
package gwt.material.design.amcharts.client.ui.chart.events.legend;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import gwt.material.design.amcharts.client.ui.chart.events.object.LegendData;
//@formatter:off

/**
 * Dispatched when legend label is clicked.
 *
 * @author kevzlou7979
 */
public class ClickMarkerEvent extends GwtEvent<ClickMarkerEvent.ClickMarkerHandler> {

    public static final Type<ClickMarkerHandler> TYPE = new Type<>();
    private LegendData data;

    public ClickMarkerEvent(LegendData data) {
        this.data = data;
    }

    public static Type<ClickMarkerHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, LegendData data) {
        source.fireEvent(new ClickMarkerEvent(data));
    }

    @Override
    public Type<ClickMarkerHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ClickMarkerEvent.ClickMarkerHandler handler) {
        handler.onClickMarker(this);
    }

    public LegendData getData() {
        return data;
    }

    public interface ClickMarkerHandler extends EventHandler {
        void onClickMarker(ClickMarkerEvent event);
    }
}
