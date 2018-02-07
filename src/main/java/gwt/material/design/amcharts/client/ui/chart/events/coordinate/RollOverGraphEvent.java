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
package gwt.material.design.amcharts.client.ui.chart.events.coordinate;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import gwt.material.design.amcharts.client.ui.chart.events.object.CoordinateGraphData;
//@formatter:off

/**
 * Dispatched when user rolls-over a graph.
 *
 * @author kevzlou7979
 */
public class RollOverGraphEvent extends GwtEvent<RollOverGraphEvent.RollOverGraphHandler> {

    public static final Type<RollOverGraphHandler> TYPE = new Type<>();
    private CoordinateGraphData data;

    public RollOverGraphEvent(CoordinateGraphData data) {
        this.data = data;
    }

    public static Type<RollOverGraphHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, CoordinateGraphData data) {
        source.fireEvent(new RollOverGraphEvent(data));
    }

    @Override
    public Type<RollOverGraphHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(RollOverGraphEvent.RollOverGraphHandler handler) {
        handler.onRollOverGraph(this);
    }

    public CoordinateGraphData getData() {
        return data;
    }

    public interface RollOverGraphHandler extends EventHandler {
        void onRollOverGraph(RollOverGraphEvent event);
    }
}
