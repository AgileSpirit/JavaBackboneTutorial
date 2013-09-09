package infra.repository;

import java.util.List;

import domain.Bookmark;

public interface BookmarkRepository {

    Bookmark save(Bookmark bookmark);

    void save(Iterable<Bookmark> bookmarks);

    List<Bookmark> findAll();
    
}
