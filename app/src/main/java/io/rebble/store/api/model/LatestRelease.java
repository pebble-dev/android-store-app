package io.rebble.store.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "js_md5",
        "js_version",
        "pbw_file",
        "published_date",
        "release_notes",
        "version"
})
public class LatestRelease implements Parcelable
{

    @JsonProperty("id")
    public String id;
    @JsonProperty("js_md5")
    public String jsMd5;
    @JsonProperty("js_version")
    public Integer jsVersion;
    @JsonProperty("pbw_file")
    public String pbwFile;
    @JsonProperty("published_date")
    public String publishedDate;
    @JsonProperty("release_notes")
    public String releaseNotes;
    @JsonProperty("version")
    public String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<LatestRelease> CREATOR = new Creator<LatestRelease>() {


        @SuppressWarnings({
                "unchecked"
        })
        public LatestRelease createFromParcel(Parcel in) {
            LatestRelease instance = new LatestRelease();

            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.jsMd5 = ((String) in.readValue((String.class.getClassLoader())));
            instance.jsVersion = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.pbwFile = ((String) in.readValue((String.class.getClassLoader())));
            instance.publishedDate = ((String) in.readValue((String.class.getClassLoader())));
            instance.releaseNotes = ((String) in.readValue((String.class.getClassLoader())));
            instance.version = ((String) in.readValue((String.class.getClassLoader())));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public LatestRelease[] newArray(int size) {
            return (new LatestRelease[size]);
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

        dest.writeValue(id);
        dest.writeValue(jsMd5);
        dest.writeValue(jsVersion);
        dest.writeValue(pbwFile);
        dest.writeValue(publishedDate);
        dest.writeValue(releaseNotes);
        dest.writeValue(version);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
