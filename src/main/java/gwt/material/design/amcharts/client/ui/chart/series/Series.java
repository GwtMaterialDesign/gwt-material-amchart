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
package gwt.material.design.amcharts.client.ui.chart.series;

import gwt.material.design.amcharts.client.ui.chart.SerialChart;
import gwt.material.design.amcharts.client.ui.chart.base.Bullet;
import gwt.material.design.amcharts.client.ui.chart.base.Component;
import gwt.material.design.amcharts.client.ui.chart.base.ListTemplate;
import gwt.material.design.amcharts.client.ui.chart.dataitem.AxisDataItem;
import gwt.material.design.amcharts.client.ui.chart.dataitem.LegendDataItem;
import gwt.material.design.amcharts.client.ui.chart.legend.LegendSettings;
import gwt.material.design.amcharts.client.ui.chart.properties.IHeatRule;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import java.util.List;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class Series extends Component {

    @JsProperty
    public boolean autoDispose;

    @JsProperty
    public List<AxisDataItem> axisRanges;

    @JsProperty
    public ListTemplate<Bullet> bullets;

    @JsProperty
    public boolean calculatePercent;

    @JsProperty
    public SerialChart chart;

    @JsProperty
    public IHeatRule heatRules;

    @JsProperty
    public boolean hiddenInLegend;

    @JsProperty
    public boolean ignoreMinMax;

    @JsProperty
    public String itemReaderText;

    @JsProperty
    public LegendDataItem legendDataItem;

    @JsProperty
    public LegendSettings legendSettings;

    @JsProperty
    public Number minBulletDistance;

    @JsProperty
    public String name;

    @JsProperty
    public boolean skipFocusThreshold;

    @JsMethod
    public native void copyFrom(Series source);

    @JsMethod
    public native void positionBullet(Bullet bullet);

    @JsMethod
    public native void raiseCriticalError(Object error);
}
