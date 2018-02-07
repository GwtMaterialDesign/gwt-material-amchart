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
package gwt.material.design.amchart.client.ui.chart.events.cursor;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import gwt.material.design.amchart.client.ui.chart.events.object.CursorDisplayData;
//@formatter:off

/**
 * Dispatched when cursor is hidden.
 *
 * @author kevzlou7979
 */
public class OnHideCursorEvent extends GwtEvent<OnHideCursorEvent.OnHideCursorHandler> {

    public static final Type<OnHideCursorHandler> TYPE = new Type<>();
    private CursorDisplayData data;

    public OnHideCursorEvent(CursorDisplayData data) {
        this.data = data;
    }

    public static Type<OnHideCursorHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, CursorDisplayData data) {
        source.fireEvent(new OnHideCursorEvent(data));
    }

    @Override
    public Type<OnHideCursorHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(OnHideCursorEvent.OnHideCursorHandler handler) {
        handler.onOnHideCursor(this);
    }

    public CursorDisplayData getData() {
        return data;
    }

    public interface OnHideCursorHandler extends EventHandler {
        void onOnHideCursor(OnHideCursorEvent event);
    }
}
