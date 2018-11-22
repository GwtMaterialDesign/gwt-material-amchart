package gwt.material.design.amcharts.client.ui.chart.series;

import gwt.material.design.amcharts.client.ui.chart.base.Sprite;
import gwt.material.design.amcharts.client.ui.chart.datafields.IFunnelSeriesDataFields;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = "am4charts")
public class PictorialStackedSeries extends PyramidSeries {

    @JsProperty
    public Sprite maskSprite;
}
