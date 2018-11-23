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
package gwt.material.design.amcharts.client.base;

import gwt.material.design.amcharts.client.properties.ILocale;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = "am4core")
public class Language extends BaseObjectsEvents {

    //TODO: adapter

    @JsProperty
    public ILocale locale;

    @JsMethod
    public native boolean isDefault();

    @JsMethod
    public native String translate(Object prompt);

    @JsMethod
    public native String translate(Object prompt, ILocale locale, String[] rest);

    @JsMethod
    public native String[] translateAll(Object[] keys);

    @JsMethod
    public native String[] translateAll(Object[] keys, ILocale locale);

    @JsMethod
    public native String translateEmpty(Object prompt);

    @JsMethod
    public native String translateEmpty(Object prompt, ILocale locale, String[] rest);

    @JsMethod
    public native Object translateFunc(Object prompt);

    @JsMethod
    public native Object translateFunc(Object prompt, ILocale locale);
}
