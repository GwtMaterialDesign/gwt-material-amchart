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
package gwt.material.design.amcharts.client.ui.chart.js.options;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

//@formatter:off

/**
 * JS
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/GaugeBand">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class AmGaugeBand {

    @JsProperty
    public double alpha;

    @JsProperty
    public String balloonText;

    @JsProperty
    public String color;

    @JsProperty
    public int endValue;

    @JsProperty
    public int[] gradientRatio;

    @JsProperty
    public String id;

    @JsProperty
    public Object innerRadius;

    @JsProperty
    public Object radius;

    @JsProperty
    public int startValue;

    @JsProperty
    public String url;

    @JsMethod
    public native void setEndValue(int value);

    @JsMethod
    public native void setStartValue(int value);
}
