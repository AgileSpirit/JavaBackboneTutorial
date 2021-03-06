package infra.util;

import infra.repository.BookmarkRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.Bookmark;

@Named
public class DataGenerator {

    @Inject
    private BookmarkRepository bookmarkRepository;

    private static Logger logger = LoggerFactory.getLogger(DataGenerator.class);

    public void populateData() {
        List<Bookmark> bookmarks = new ArrayList<Bookmark>();

        bookmarks.add(Bookmark.create("http://agile-spirit.fr", "Agile Spirit"));
        bookmarks.add(Bookmark.create("http://octo.com", "OCTO Technology"));
        bookmarks.add(Bookmark.create("http://google.com", "Google"));
        bookmarks.add(Bookmark.create("http://amazon.com", "Amazon"));
        bookmarks.add(Bookmark.create("http://facebook.com", "Facebook"));
        bookmarks.add(Bookmark.create("http://twitter.com", "Twitter"));
        bookmarks.add(Bookmark.create("http://linkedin.com", "LinkedIn"));
        bookmarks.add(Bookmark.create("http://ebay.com", "Ebay"));

        bookmarkRepository.save(bookmarks);
    }

    public void retrieveAndDisplayAllData() {
        displayData(bookmarkRepository.findAll());
    }

    private void displayData(List<Bookmark> bookmarks) {
        if (bookmarks.isEmpty()) {
            logger.info("There is no data");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("\r\n\"bookmarks\" : {\r\n");
            for (Bookmark bookmark : bookmarks) {
                sb.append("  {\r\n");
                sb.append("    \"id\" : \"" + bookmark.getId() + "\",\r\n");
                sb.append("    \"url\" : \"" + bookmark.getUrl() + "\",\r\n");
                sb.append("    \"description\" : \"" + bookmark.getDescription() + "\",\r\n");
                sb.append("    \"creationDate\" : \"" + bookmark.getCreationDate() + "\",\r\n");
                sb.append("    \"modificationDate\" : \"" + bookmark.getModificationDate() + "\"\r\n");
                sb.append("  }\r\n");
            }
            sb.append("}");
            logger.info(sb.toString());
        }
    }

}
