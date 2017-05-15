package controller.saving;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Set;

import controller.exception.MyException;
import model.enumerations.Status;
import model.interfaces.User;

/**
 * An implementation of the SavingData.
 *
 */
public class SavingDataImpl implements SavingData {

    private static final String MAIN_PATH = System.getProperty("user.home") + File.separator + "dmfData";
    private static final String IMAGE_PATH = MAIN_PATH + File.separator + "images";

    /**
     * 
     */
    public SavingDataImpl() {
        final File mainFolder;
        final File imagesFolder;
        mainFolder = new File(MAIN_PATH);
        imagesFolder = new File(IMAGE_PATH);
        if (!mainFolder.exists()) {
            try {
                mainFolder.mkdir();
            } catch (Exception e) {
                final RuntimeException e2 = new MyException("problem with the creation of main folder");
                throw e2;
            }
        }

        if (!imagesFolder.exists()) {
            try {
                imagesFolder.mkdir();
            } catch (Exception e) {
                final RuntimeException e2 = new MyException("problem with the creation of images folder");
                throw e2;
            }
        }

    }

    @Override
    public Status save(final Set<User> userSet) {
        try (ObjectOutputStream outS = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(new File(MAIN_PATH + "test.dat"))))) {
            outS.writeObject(userSet);
        } catch (FileNotFoundException e) {
            final RuntimeException e2 = new MyException("problem with the creation of images folder");
            throw e2;
        } catch (IOException e) {
            final RuntimeException e2 = new MyException("problem with the creation of images folder");
            throw e2;
        }

        return null;
    }

    @Override
    public Status load() {

        return Status.CATEGORIES_ALREADY_INITIALIZED;
    }

}
