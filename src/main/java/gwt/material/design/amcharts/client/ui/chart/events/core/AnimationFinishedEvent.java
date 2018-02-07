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
package gwt.material.design.amcharts.client.ui.chart.events.core;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import gwt.material.design.amcharts.client.ui.chart.events.object.CoreData;
//@formatter:off

/**
 * Dispatched when initial chart animations are finished.
 *
 * @author kevzlou7979
 */
public class AnimationFinishedEvent extends GwtEvent<AnimationFinishedEvent.AnimationFinishedHandler> {

    public static final Type<AnimationFinishedHandler> TYPE = new Type<>();
    private CoreData data;

    public AnimationFinishedEvent(CoreData data) {
        this.data = data;
    }

    public static Type<AnimationFinishedHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, CoreData data) {
        source.fireEvent(new AnimationFinishedEvent(data));
    }

    @Override
    public Type<AnimationFinishedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(AnimationFinishedEvent.AnimationFinishedHandler handler) {
        handler.onAnimationFinished(this);
    }

    public CoreData getData() {
        return data;
    }

    public interface AnimationFinishedHandler extends EventHandler {
        void onAnimationFinished(AnimationFinishedEvent event);
    }
}
