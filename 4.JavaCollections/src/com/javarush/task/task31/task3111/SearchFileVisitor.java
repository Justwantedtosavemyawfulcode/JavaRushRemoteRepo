package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private boolean minSizeIsSet = false;
    private int maxSize;
    private boolean maxSizeIsSet = false;
    private List<Path> foundFiles = new ArrayList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public String getPartOfName() {
        return partOfName;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public String getPartOfContent() {
        return partOfContent;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSizeIsSet = true;
        this.minSize = minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSizeIsSet = true;
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        boolean sizeCheck = false;
        boolean nameCheck = false;
        boolean contentCheck = false;

        if (minSizeIsSet && content.length >= minSize && maxSizeIsSet && content.length <= maxSize) {
            sizeCheck = true;
        }
        if (!minSizeIsSet && maxSizeIsSet && content.length <= maxSize) sizeCheck = true;
        if (!maxSizeIsSet && minSizeIsSet && content.length >= minSize) sizeCheck = true;
        if (!minSizeIsSet && !maxSizeIsSet) sizeCheck = true;

        if (partOfName != null && file.getFileName().toString().contains(partOfName)) nameCheck = true;
        if (partOfName == null) nameCheck = true;

        String text = new String(Files.readAllBytes(file));
        if (partOfContent != null && text.contains(partOfContent)) contentCheck = true;
        if (partOfContent == null) contentCheck = true;

        if (sizeCheck && nameCheck && contentCheck) {
            foundFiles.add(file);
        }

        return FileVisitResult.CONTINUE;
    }
}
