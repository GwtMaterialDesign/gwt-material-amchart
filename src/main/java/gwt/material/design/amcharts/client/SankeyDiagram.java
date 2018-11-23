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

import gwt.material.design.amcharts.client.datafields.chart.ISankeyDiagramDataFields;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = "am4charts")
public class SankeyDiagram extends FlowDiagram {

    /**
     * @see gwt.material.design.amcharts.client.constants.NodeAlign
     */
    @JsProperty
    public String nodeAlign;

    /**
     * @see gwt.material.design.amcharts.client.constants.Orientation
     */
    @JsProperty
    public String orientation;

    @JsProperty
    public Number valueHeight;

    @JsProperty
    public ISankeyDiagramDataFields dataFields;
}
