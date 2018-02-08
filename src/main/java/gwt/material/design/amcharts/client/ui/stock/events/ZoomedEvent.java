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
package gwt.material.design.amcharts.client.ui.stock.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import gwt.material.design.amcharts.client.ui.stock.events.object.ZoomedData;
//@formatter:off

/**
 * Dispatched when the chart is zoomed (even for the first time, when chart is initialized).
 *
 * @author kevzlou7979
 */
public class ZoomedEvent extends GwtEvent<ZoomedEvent.ZoomedHandler> {

    public static final Type<ZoomedHandler> TYPE = new Type<>();
    private ZoomedData data;

    public ZoomedEvent(ZoomedData data) {
        this.data = data;
    }

    public static Type<ZoomedHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, ZoomedData data) {
        source.fireEvent(new ZoomedEvent(data));
    }

    @Override
    public Type<ZoomedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ZoomedEvent.ZoomedHandler handler) {
        handler.onZoomed(this);
    }

    public ZoomedData getData() {
        return data;
    }

    public interface ZoomedHandler extends EventHandler {
        void onZoomed(ZoomedEvent event);
    }
}
