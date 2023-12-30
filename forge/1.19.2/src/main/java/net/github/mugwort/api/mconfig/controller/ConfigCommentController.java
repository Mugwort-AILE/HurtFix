package net.github.mugwort.api.mconfig.controller;
import com.electronwill.nightconfig.core.CommentedConfig;
import com.electronwill.nightconfig.core.file.FileConfig;

public class ConfigCommentController {

    private final CommentedConfig comments;

    public ConfigCommentController(FileConfig config) {
        this.comments = CommentedConfig.copy(config);
    }

    public void addComment(String path, Object value) {
        comments.setComment(path, value.toString());
    }

    public void removeComment(String path) {
        comments.removeComment(path);
    }

    public String getComment(String path) {
        return comments.getComment(path);
    }

    public void setComment(String path, Object value) {
        comments.set(path, value);
    }
}