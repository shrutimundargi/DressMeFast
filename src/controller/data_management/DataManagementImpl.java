package controller.data_management;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

import controller.exception.MyException;
import model.interfaces.User;
import model.interfaces.UserManagement;

/**
 * An implementation of the SavingData.
 *
 */
public class DataManagementImpl implements DataManagement {

    private static final String PROBLEM_IMAGES_FOLDER = "problem with the creation of images folder";
    private static final String PROBLEM_MAIN_FOLDER = "problem with the creation of main folder";
    private static final String MAIN_PATH = System.getProperty("user.home") + File.separator + "dmfData";
    private static final String IMAGE_PATH = MAIN_PATH + File.separator + "images";

    /**
     * manage the dmfData folder and the images folder.
     */
    public DataManagementImpl() {
        final File mainFolder;
        final File imagesFolder;
        mainFolder = new File(MAIN_PATH);
        imagesFolder = new File(IMAGE_PATH);
        if (!mainFolder.exists()) {
            try {
                mainFolder.mkdir();
            } catch (Exception e) {
                final RuntimeException e2 = new MyException(PROBLEM_MAIN_FOLDER);
                throw e2;
            }
        }

        if (!imagesFolder.exists()) {
            try {
                imagesFolder.mkdir();
            } catch (Exception e) {
                final RuntimeException e2 = new MyException(PROBLEM_IMAGES_FOLDER);
                throw e2;
            }
        }

    }

    @Override
    public Information save(final Set<User> userSet) {
        try (ObjectOutputStream outS = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(new File(MAIN_PATH + File.separator + "userDat.dat"))))) {
            outS.writeObject(userSet);
        } catch (FileNotFoundException e) {
            final RuntimeException e2 = new MyException("file not found");
            throw e2;
        } catch (IOException e) {
            final RuntimeException e2 = new MyException("saving problem");
            throw e2;
        }

        return Information.SAVING_OK;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Information load(final UserManagement userM) {

        if (!new File(MAIN_PATH + File.separator + "userDat.dat").exists()) {
            return save(new HashSet<User>());
        }
        try (ObjectInputStream inS = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(new File(MAIN_PATH + File.separator + "userDat.dat"))))) {
            try {
                userM.setUsers((Set<User>) inS.readObject());
            } catch (ClassNotFoundException e) {
                final RuntimeException e2 = new MyException("impossible read file");
                throw e2;
            }
        } catch (FileNotFoundException e) {
            final RuntimeException e2 = new MyException("file not found");
            throw e2;
        } catch (IOException e) {
            final RuntimeException e2 = new MyException("loading problem");
            throw e2;
        }
        return Information.LOADING_OK;
    }

}
