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
package gwt.material.design.amcharts.client;

import gwt.material.design.amcharts.client.base.Container;
import gwt.material.design.amcharts.client.datafields.chart.IChordDiagramDataFields;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = "am4charts")
public class ChordDiagram extends FlowDiagram {

    @JsProperty
    public Container chordContainer;

    @JsProperty
    public Number endAngle;

    /**
     * Accepts {@link Number} or {@link gwt.material.design.amcharts.client.base.Percent}
     */
    @JsProperty
    public Object innerRadius;

    //TODO nodes

    @JsProperty
    public boolean nonRibbon;

    /**
     * Accepts {@link Number} or {@link gwt.material.design.amcharts.client.base.Percent}
     */
    @JsProperty
    public Object radius;

    @JsProperty
    public Number startAngle;

    @JsProperty
    public IChordDiagramDataFields dataFields;
}
