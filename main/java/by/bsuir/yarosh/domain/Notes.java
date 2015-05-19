package by.bsuir.yarosh.domain;

import javax.persistence.*;
import java.sql.*;

/**
 * Created by Lemm on 16.05.2015.
 */
@Entity
@Table(name = "tbl_notes", schema = "", catalog = "edi_schema")
public class Notes {
    private Integer noteId;
    private Timestamp lastModified;
    private String content;
    private String title;
    private Boolean isDeleted;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NoteId")
    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    @Basic
    @Column(name = "LastModified")
    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }

    @Basic
    @Column(name = "Content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "IsDeleted")
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notes that = (Notes) o;

        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (lastModified != null ? !lastModified.equals(that.lastModified) : that.lastModified != null) return false;
        if (noteId != null ? !noteId.equals(that.noteId) : that.noteId != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noteId != null ? noteId.hashCode() : 0;
        result = 31 * result + (lastModified != null ? lastModified.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    private NotesCategory category;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = NotesCategory.class)
    @JoinColumn(name = "CategoryId")
    public NotesCategory getCategory() {
        return category;
    }

    public void setCategory(NotesCategory category) {
        this.category = category;
    }
}
