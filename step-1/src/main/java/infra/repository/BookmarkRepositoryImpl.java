package infra.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.joda.time.DateTime;

import domain.Bookmark;

@Named
public class BookmarkRepositoryImpl implements BookmarkRepository {

    private Long sequence = Long.valueOf(0);
    private Map<Long, Bookmark> data = new HashMap<>();
    
    @Override
    public Bookmark save(Bookmark bookmark) {
        if (bookmark.getId() == null) {
            bookmark.setId(++sequence);
            bookmark.setCreationDate(new DateTime());
        } else {
            bookmark.setModificationDate(new DateTime());
        }
        data.put(bookmark.getId(), bookmark);
        return bookmark;
    }

    @Override
    public void save(Iterable<Bookmark> bookmarks) {
        for (Bookmark bookmark : bookmarks) {
            save(bookmark);
        }
    }

    @Override
    public List<Bookmark> findAll() {
        return new ArrayList<>(data.values());
    }

}
