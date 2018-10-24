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

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

//@formatter:off

/**
 * JSInterop util for {@link gwt.material.design.amcharts.client.ui.chart.options.DataLoader}
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="http://www.amcharts.com/kbase/using-data-loader-plugin/">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class AmDataLoader {

    @JsProperty
    public boolean async;

    @JsProperty
    public Functions.Func complete;

    @JsProperty
    public String delimiter;

    @JsProperty
    public Functions.Func error;

    @JsProperty
    public String format;

    @JsProperty
    public Functions.Func load;

    @JsProperty
    public boolean noStyles;

    @JsProperty
    public Functions.Func postProcess;

    @JsProperty
    public boolean showErrors;

    @JsProperty
    public boolean showCurtain;

    @JsProperty
    public int reload;

    @JsProperty
    public String url;

    @JsProperty
    public AmDataLoaderHeader[] headers;
    
    @JsProperty
    public boolean reverse;

    @JsProperty
    public int skip;

    @JsProperty
    public boolean timestamp;

    @JsProperty
    public boolean useColumnNames;
}
