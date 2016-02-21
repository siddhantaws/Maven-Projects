package org.devoxx.javaee6;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAllBooks", query = "SELECT b FROM Book b ORDER BY b.id DESC"),
        @NamedQuery(name = "findAllScifiBooks", query = "SELECT b FROM Book b WHERE b.tags = 'scifi' ORDER BY b.id DESC")
})
public class Book {

    // ======================================
    // =             Attributes             =
    // ======================================
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String title;
    private Float price;
    @Column(length = 2000)
    private String description;

    private Integer nbOfPage;
//    private Boolean illustrations;
    private String contentLanguage;

    @ElementCollection
    @CollectionTable(name = "tags")
    private List<String> tags = new ArrayList<String>();

    // ======================================
    // =            Constructors            =
    // ======================================

    public Book() {
    }

    public Book(String title, Float price, String description, String isbn, Integer nbOfPage/*, Boolean illustrations*/) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.nbOfPage = nbOfPage;
//        this.illustrations = illustrations;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNbOfPage() {
        return nbOfPage;
    }

    public void setNbOfPage(Integer nbOfPage) {
        this.nbOfPage = nbOfPage;
    }

//    public Boolean getIllustrations() {
//        return illustrations;
//    }
//
//    public void setIllustrations(Boolean illustrations) {
//        this.illustrations = illustrations;
//    }

    public List<String> getTags() {
        return tags;
    }

    public String getTagsAsString() {
        String s = new String();
        for (String tag : tags) {
            s += tag + ", ";
        }
        if (s.length() > 2)
            return s.substring(0, s.length() - 2);
        else
            return s;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getContentLanguage() {
        return contentLanguage;
    }

    public void setContentLanguage(String contentLanguage) {
        this.contentLanguage = contentLanguage;
    }

    // ======================================
    // =         hash, equals, toString     =
    // ======================================

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Book");
        sb.append("{id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", price=").append(price);
        sb.append(", description='").append(description).append('\'');
        sb.append(", nbOfPage=").append(nbOfPage);
//        sb.append(", illustrations=").append(illustrations);
        sb.append(", contentLanguage=").append(contentLanguage);
        sb.append(", tags=").append(getTagsAsString());
        sb.append('}');
        return sb.toString();
    }
}