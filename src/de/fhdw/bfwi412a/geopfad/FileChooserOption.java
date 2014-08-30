package de.fhdw.bfwi412a.geopfad;


import android.annotation.SuppressLint;

// hold our data were going to get from listing all the file and directories
public class FileChooserOption implements Comparable<FileChooserOption>{
    private String name;
    private String data;
    private String path;
    
    public FileChooserOption(String n,String d,String p)
    {
        name = n;
        data = d;
        path = p;
    }
    public String getName()
    {
        return name;
    }
    public String getData()
    {
        return data;
    }
    public String getPath()
    {
        return path;
    }
    @SuppressLint("DefaultLocale") 
    @Override
    public int compareTo(FileChooserOption o) {
        if(this.name != null)
            return this.name.toLowerCase().compareTo(o.getName().toLowerCase()); 
        else 
            throw new IllegalArgumentException();
    }
}