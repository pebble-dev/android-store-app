
package io.rebble.store.api.model;

import java.util.HashMap;
import java.util.Map;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "android",
    "aplite",
    "basalt",
    "chalk",
    "diorite",
    "emery",
    "ios"
})
public class Compatibility implements Parcelable
{

    @JsonProperty("android")
    public Boolean android;
    @JsonProperty("aplite")
    public Boolean aplite;
    @JsonProperty("basalt")
    public Boolean basalt;
    @JsonProperty("chalk")
    public Boolean chalk;
    @JsonProperty("diorite")
    public Boolean diorite;
    @JsonProperty("emery")
    public Boolean emery;
    @JsonProperty("ios")
    public Boolean iphone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<Compatibility> CREATOR = new Creator<Compatibility>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Compatibility createFromParcel(Parcel in) {
            Compatibility instance = new Compatibility();
            instance.android = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.aplite = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.basalt = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.chalk = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.diorite = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.emery = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.iphone = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Compatibility[] newArray(int size) {
            return (new Compatibility[size]);
        }

    }
    ;

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(android);
        dest.writeValue(aplite);
        dest.writeValue(basalt);
        dest.writeValue(chalk);
        dest.writeValue(diorite);
        dest.writeValue(emery);
        dest.writeValue(iphone);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
