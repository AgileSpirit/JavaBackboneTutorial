package domain;

import org.joda.time.DateTime;

/**
 * <p>
 * This is the main domain entity class. At this step, the data persistence is Java-Hash-made, thus there is no JPA/Hibernate mapping
 * annotations
 * </p>
 * <p>
 * Notice : the use of JodaTime#DateTime class for the <code>creationDate</code> and <code>modificationDate</code> fields.
 * </p>
 */
public class Bookmark {

    /**
     * The unique ID of the bookmark
     */
    private Long id;

    /**
     * The href link of the bookmark, ex : "http://agile-spirit.fr"
     */
    private String url;

    /**
     * The description of the bookmark
     */
    private String description;

    /**
     * The creation date of the bookmark
     */
    private DateTime creationDate;

    /**
     * The modification date of the bookmark
     */
    private DateTime modificationDate;

    /**
     * Factory method to instance a bookmark with the creation date set to current date time
     * 
     * @param url
     *            the href link of the bookmark
     * @param description
     *            the description of the bookmark
     * @return
     */
    public static Bookmark create(String url, String description) {
        Bookmark bookmark = new Bookmark();
        bookmark.url = url;
        bookmark.description = description;
        bookmark.creationDate = new DateTime();
        return bookmark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(DateTime creationDate) {
        this.creationDate = creationDate;
    }

    public DateTime getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(DateTime modificationDate) {
        this.modificationDate = modificationDate;
    }

}
