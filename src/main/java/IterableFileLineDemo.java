import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by paulbaker on 5/27/15.
 */
public class IterableFileLineDemo extends File implements Iterable<String> {
    public IterableFileLineDemo(String pathname) {
        super(pathname);
    }

    public Iterator<String> iterator() {
        return new FileLineIterator(this);
    }

    private class FileLineIterator implements Iterator<String> {

        final private Scanner scanner;

        private FileLineIterator(File file) {
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        public boolean hasNext() {
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

    public static void main(String[] args){
        
    }
}
