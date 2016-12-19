
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
    "platform",
    "jsv",
    "hardware"
})
public class Compatibility implements Parcelable
{

    @JsonProperty("platform")
    public Boolean platform;
    @JsonProperty("jsv")
    public Boolean jsv;
    @JsonProperty("hardware")
    public Boolean hardware;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<Compatibility> CREATOR = new Creator<Compatibility>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Compatibility createFromParcel(Parcel in) {
            Compatibility instance = new Compatibility();
            instance.platform = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.jsv = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.hardware = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
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
        dest.writeValue(platform);
        dest.writeValue(jsv);
        dest.writeValue(hardware);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
