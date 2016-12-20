
package io.rebble.store.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "id",
    "href",
    "title",
    "description",
    "type",
    "author",
    "source",
    "website",
    "banner_image",
    "screenshot_images",
    "header_images",
    "list_image",
    "rating",
    "hearts",
    "icon_image",
    "pbw_file",
    "uuid",
    "published_date",
    "version",
    "release_id",
    "links",
    "category_name",
    "category_color",
    "developer_id",
    "compatibility",
    "ios_companion",
    "android_companion"
})
public class Application implements Parcelable
{

    @JsonProperty("id")
    public String id;
    @JsonProperty("href")
    public String href;
    @JsonProperty("title")
    public String title;
    @JsonProperty("description")
    public String description;
    @JsonProperty("type")
    public String type;
    @JsonProperty("author")
    public String author;
    @JsonProperty("source")
    public String source;
    @JsonProperty("website")
    public String website;
    @JsonProperty("banner_image")
    public String bannerImage;
    @JsonProperty("screenshot_images")
    public List<String> screenshotImages = null;
    @JsonProperty("header_images")
    public List<String> headerImages = null;
    @JsonProperty("list_image")
    public String listImage;
    @JsonProperty("rating")
    public Integer rating;
    @JsonProperty("hearts")
    public Integer hearts;
    @JsonProperty("icon_image")
    public String iconImage;
    @JsonProperty("pbw_file")
    public String pbwFile;
    @JsonProperty("uuid")
    public String uuid;
    @JsonProperty("published_date")
    public String publishedDate;
    @JsonProperty("version")
    public String version;
    @JsonProperty("release_id")
    public String releaseId;
    @JsonProperty("links")
    public Links links;
    @JsonProperty("category_name")
    public String categoryName;
    @JsonProperty("category_color")
    public String categoryColor;
    @JsonProperty("developer_id")
    public String developerId;
    @JsonProperty("compatibility")
    public Compatibility compatibility;
    @JsonProperty("ios_companion")
    public IosCompanion iosCompanion;
    @JsonProperty("android_companion")
    public AndroidCompanion androidCompanion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<Application> CREATOR = new Creator<Application>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Application createFromParcel(Parcel in) {
            Application instance = new Application();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            instance.title = ((String) in.readValue((String.class.getClassLoader())));
            instance.description = ((String) in.readValue((String.class.getClassLoader())));
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.author = ((String) in.readValue((String.class.getClassLoader())));
            instance.source = ((String) in.readValue((String.class.getClassLoader())));
            instance.website = ((String) in.readValue((String.class.getClassLoader())));
            instance.bannerImage = ((String) in.readValue((String.class.getClassLoader())));
            instance.screenshotImages = new ArrayList<>();
            in.readList(instance.screenshotImages, (String.class.getClassLoader()));
            instance.headerImages = new ArrayList<>();
            in.readList(instance.headerImages, (String.class.getClassLoader()));
            instance.listImage = ((String) in.readValue((String.class.getClassLoader())));
            instance.rating = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.hearts = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.iconImage = ((String) in.readValue((String.class.getClassLoader())));
            instance.pbwFile = ((String) in.readValue((String.class.getClassLoader())));
            instance.uuid = ((String) in.readValue((String.class.getClassLoader())));
            instance.publishedDate = ((String) in.readValue((String.class.getClassLoader())));
            instance.version = ((String) in.readValue((String.class.getClassLoader())));
            instance.releaseId = ((String) in.readValue((String.class.getClassLoader())));
            instance.links = ((Links) in.readValue((Links.class.getClassLoader())));
            instance.categoryName = ((String) in.readValue((String.class.getClassLoader())));
            instance.categoryColor = ((String) in.readValue((String.class.getClassLoader())));
            instance.developerId = ((String) in.readValue((String.class.getClassLoader())));
            instance.compatibility = ((Compatibility) in.readValue((Compatibility.class.getClassLoader())));
            instance.iosCompanion = ((IosCompanion) in.readValue((IosCompanion.class.getClassLoader())));
            instance.androidCompanion = ((AndroidCompanion) in.readValue((AndroidCompanion.class.getClassLoader())));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Application[] newArray(int size) {
            return (new Application[size]);
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
        dest.writeValue(href);
        dest.writeValue(title);
        dest.writeValue(description);
        dest.writeValue(type);
        dest.writeValue(author);
        dest.writeValue(source);
        dest.writeValue(website);
        dest.writeValue(bannerImage);
        dest.writeList(screenshotImages);
        dest.writeList(headerImages);
        dest.writeValue(listImage);
        dest.writeValue(rating);
        dest.writeValue(hearts);
        dest.writeValue(iconImage);
        dest.writeValue(pbwFile);
        dest.writeValue(uuid);
        dest.writeValue(publishedDate);
        dest.writeValue(version);
        dest.writeValue(releaseId);
        dest.writeValue(links);
        dest.writeValue(categoryName);
        dest.writeValue(categoryColor);
        dest.writeValue(developerId);
        dest.writeValue(compatibility);
        dest.writeValue(iosCompanion);
        dest.writeValue(androidCompanion);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
