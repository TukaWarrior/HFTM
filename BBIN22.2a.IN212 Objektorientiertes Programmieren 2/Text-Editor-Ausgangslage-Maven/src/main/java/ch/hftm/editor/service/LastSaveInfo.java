package ch.hftm.editor.service;

import java.io.Serializable;
import java.util.Date;

public class LastSaveInfo implements Serializable {
    private static final long serialVersionUID  = 1L;

    private String fileName;
    private String filePath;
    private Date saveDate;

    public LastSaveInfo(String fileName, String filePath, Date saveDate) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.saveDate = saveDate;
    }

    public String getFileName(){
        return this.fileName;
    }

    public String getFilePath(){
        return this.filePath;
    }

    public Date getSaveDate(){
        return this.saveDate;
    }
}