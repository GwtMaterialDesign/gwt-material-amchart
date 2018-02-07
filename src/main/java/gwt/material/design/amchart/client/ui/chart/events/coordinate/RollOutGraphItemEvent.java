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
package gwt.material.design.amchart.client.ui.chart.events.coordinate;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import gwt.material.design.amchart.client.ui.chart.events.object.CoordinateGraphItemData;
//@formatter:off

/**
 * Dispatched when user rolls-out of the data item (column/bullet)
 *
 * @author kevzlou7979
 */
public class RollOutGraphItemEvent extends GwtEvent<RollOutGraphItemEvent.RollOutGraphItemHandler> {

    public static final Type<RollOutGraphItemHandler> TYPE = new Type<>();
    private CoordinateGraphItemData data;

    public RollOutGraphItemEvent(CoordinateGraphItemData data) {
        this.data = data;
    }

    public static Type<RollOutGraphItemHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, CoordinateGraphItemData data) {
        source.fireEvent(new RollOutGraphItemEvent(data));
    }

    @Override
    public Type<RollOutGraphItemHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(RollOutGraphItemEvent.RollOutGraphItemHandler handler) {
        handler.onRollOutGraphItem(this);
    }

    public CoordinateGraphItemData getData() {
        return data;
    }

    public interface RollOutGraphItemHandler extends EventHandler {
        void onRollOutGraphItem(RollOutGraphItemEvent event);
    }
}
