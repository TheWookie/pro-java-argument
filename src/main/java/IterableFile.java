import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by paulbaker on 5/27/15.
 */
public class IterableFile extends File implements Iterable<String> {
    public IterableFile(String pathname) {
        super(pathname);
    }

    public Iterator<String> iterator() {
        return new FileLineIterator(this);
    }

    /**
     * There is a little boilerplate, but this isn't THAT bad
     */
    private class FileLineIterator implements Iterator<String> {

        final private Scanner scanner;

        private FileLineIterator(File file) {
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                // This is one of the points where I actually agree.
                // At times you need to just throw a RuntimeException
                // instead because there shouldn't be a recovery.
                throw new RuntimeException(e);
            }
        }

        public boolean hasNext() {
            // We check the has-next and close it gracefully.
            if (scanner.hasNextLine() == false) {
                scanner.close();
                return false;
            }
            return true;
        }

        public String next() {
            return scanner.nextLine();
        }
    }

    public static void main(String[] args) {
        // Get the file relative to the project
        String filename = IterableFile.class.getClassLoader().getResource("file.txt").getFile();
        // Now we iterate over the file.
        // Note, that this demo shows that java DOES in fact use an iterator in a for-each loop
        // Note, this demo also shows a valid use case for using the hashNext method (we close the file
        // gracefully and silently at the same time)
        for (String fileline : new IterableFile(filename)) {
            System.out.println(fileline);
        }
    }
}
