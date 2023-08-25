package com.example.demo.file;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table
public class File {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String fileName;
    private LocalDateTime fileDate;
    private String filePath;
    
    @Lob()
    @Column(length = 100000)
    private byte[] data;

    public File() {
    }

    public File(Integer id, String fileName, LocalDateTime fileDate, String filePath, byte[] data) {
        this.id = id;
        this.fileName = fileName;
        this.fileDate = fileDate;
        this.filePath = filePath;
        this.data = data;
    }

    public File(String fileName, byte[] data) {
        this.fileName = fileName;
        this.data = data;
    }

    public File(String fileName) {
        this.fileName = fileName;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public LocalDateTime getFileDate() {
        return this.fileDate;
    }

    public void setFileDate(LocalDateTime fileDate) {
        this.fileDate = fileDate;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", fileName='" + getFileName() + "'" +
                ", fileDate='" + getFileDate() + "'" +
                ", filePath='" + getFilePath() + "'" +
                ", data='" + getData() + "'" +
                "}";
    }
    public String formatString() {
        return "{" +
                "fileName='" + getFileName() + "'" +
                ", fileDate='" + getFileDate() + "'" +
                ", filePath='" + getFilePath() + "'" +
                "}";
    }
    

}
