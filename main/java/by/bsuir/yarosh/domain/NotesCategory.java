package by.bsuir.yarosh.domain;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Lemm on 16.05.2015.
 */
@Entity
@Table(name = "tbl_notes_category", schema = "", catalog = "edi_schema")
public class NotesCategory {
    private Integer categoryId;
    private String categoryTitle;
    private Boolean isPrivate;

    @Id
    @Column(name = "CategoryId")
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "CategoryTitle")
    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    @Basic
    @Column(name = "IsPrivate")
    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotesCategory that = (NotesCategory) o;

        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;
        if (categoryTitle != null ? !categoryTitle.equals(that.categoryTitle) : that.categoryTitle != null)
            return false;
        if (isPrivate != null ? !isPrivate.equals(that.isPrivate) : that.isPrivate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryId != null ? categoryId.hashCode() : 0;
        result = 31 * result + (categoryTitle != null ? categoryTitle.hashCode() : 0);
        result = 31 * result + (isPrivate != null ? isPrivate.hashCode() : 0);
        return result;
    }

    private User user;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private Collection<Notes> notes;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Notes.class, mappedBy = "category")
    public Collection<Notes> getNotes() {
        return notes;
    }

    public void setNotes(Collection<Notes> notes) {
        this.notes = notes;
    }
}
