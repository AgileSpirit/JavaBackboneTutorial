package application;

import infra.repository.BookmarkRepository;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.Bookmark;

/**
 * Application service used to demostrate :
 * <ul>
 * <li>DDD application service</li>
 * <li>Spring bean Dependency Injection</li>
 * <li>SLF4J/Logback logging</li>
 * </ul>
 */
@Named
public class BookmarkService {

    /**
     * Instance of the Logback logger (the logger implementation) through SLF4J (the logger interface)  
     */
    private static Logger logger = LoggerFactory.getLogger(BookmarkService.class);

    /**
     * The injected Spring bean
     */
    @Inject
    private BookmarkRepository bookmarkRepository;

    /**
     * No-arg constructor required by Spring
     * @see org.springframework.beans.factory.BeanCreationException
     */
    BookmarkService() {
        // Empty constructor
    }

    /**
     * Parameterized constructor for Mockito with Spring DI
     * 
     * @param bookmarkRepository
     */
    BookmarkService(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    public Bookmark save(Bookmark bookmark) {
        if (bookmark == null) {
            logger.error("Can not save null object.");
        }
        return bookmarkRepository.save(bookmark);
    }

}
