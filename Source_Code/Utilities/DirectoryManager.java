package GSLib.Utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Utility class for directory management operations such as creating,
 * deleting, renaming, moving, and copying directories.
 * <p>
 * This class provides static methods to perform various directory operations,
 * making it easier to handle directories within your application.
 * </p>
 *
 * @author Gab 'Sp0k' Savard
 * @version 1.3
 * @since 2024-07-25
 */
public class DirectoryManager {

  /**
   * Creates a new directory (in the current directory)
   *
   * @param dirName A String containing the name of the new directory
   */
  public static void newDirectory(String dirName) {
    try {
      // Address of current directory
      String currDirectory = System.getProperty("user.dir");

      // Path of the directory to be created
      String dirPath = currDirectory + File.separator + dirName;

      // File object to hold the directory
      File d = new File(dirPath);

      // Create new directory
      if (d.mkdir()) {
        System.out.printf("Successfully created %s!\nPath: %s\n", d.getName(), d.getPath());
      } else {
        System.out.printf("Failed to create the directory. It may already exist at: %s\n", dirPath);
      }
    } catch (Exception e) {
      System.err.printf("An error occurred while creating the directory: %s\n", e.getMessage());
    }
  }

  /**
   * Creates a new directory (at a specified location)
   *
   * @param dirName A String containing the name of the new directory
   *
   * @param dirPath A String containing the path for the new directory's
   *                location
   */
  public static void newDirectory(String dirName, String dirPath) {
    try {
      // Path of the new directory
      String path = (dirPath.charAt(dirPath.length() - 1) == File.separatorChar) ? dirPath + dirName
          : dirPath + File.separator + dirName;

      // File object to hold the directory
      File d = new File(path);

      // Create new directory
      if (d.mkdir()) {
        System.out.printf("Successfully created %s!\nPath: %s\n", d.getName(), d.getPath());
      } else {
        System.out.printf("Failed to create the directory. It may already exist at: %s\n", dirPath);
      }
    } catch (Exception e) {
      System.err.printf("An error occurred while creating the directory: %s\n", e.getMessage());
    }
  }

  /**
   * Deletes a specified directory
   *
   * This method deletes the specified directory and everything it holds
   *
   * @param directoryPath A String containing the path to the directory to delete
   */
  public static void deleteDirectory(String directoryPath) {
    try {
      // Locate directory
      File d = new File(directoryPath);

      // Delete all the subdirectories and files contained
      deleteSubDirectory(d);

      // Delete the directory
      if (d.delete()) {
        System.out.printf("Successfully deleted %s!\n", d.getName());
      } else {
        System.out.printf("Failed to delete the directory at %s\n", d.getPath());
      }
    } catch (Exception e) {
      System.err.printf("An error occurred while deleting the directory: %s\n", e.getMessage());
    }
  }

  /**
   * Deletes the subdirectories and files of a specified directory.
   * <p>
   * This method takes care of deleting the subdirectories and files within
   * the specified directory. It is private as there is no reason to access it
   * from outside the class.
   * </p>
   *
   * @param dir A File representing the directory for which to delete all
   *            subdirectories and files
   */
  private static void deleteSubDirectory(File dir) {
    try {
      for (File subDir : dir.listFiles()) {
        if (subDir.isDirectory()) {
          deleteSubDirectory(subDir);
        }

        if (!subDir.delete()) {
          System.out.printf("Failed to delete the directory at %s\n", subDir.getPath());
        }
      }
    } catch (Exception e) {
      System.err.printf("An error occurred while deleting subdirectories: %s\n", e.getMessage());
    }
  }

  /**
   * Rename a specified directory
   *
   * @param dirPath A String containing the path to the directory
   *
   * @param newName A String containing the new name to the directory
   */
  public static void renameDirectory(String dirPath, String newName) {
    try {
      // Directory path
      String[] splitName = dirPath.split(File.separator);
      splitName[splitName.length - 1] = newName;

      StringBuilder builder = new StringBuilder();

      for (int i = 0; i < splitName.length; i++) {
        builder.append(splitName[i]);
        if ((i + 1) < (splitName.length - 1))
          builder.append(File.separator);
      }

      File d = new File(dirPath);
      File newDir = new File(builder.toString());

      if (d.renameTo(newDir)) {
        System.out.printf("Successfully renamed directory to %s!\n", d.getName());
      } else {
        System.out.printf("Failed to rename the directory at %s\n", d.getPath());
      }
    } catch (Exception e) {
      System.err.printf("An error occurred while renaming the directory: %s\n", e.getMessage());
    }
  }

  /**
   * Moves a specified directory
   *
   * @param dirPath A String containing the path to the directory
   *
   * @param dest    A String containing the path the new location
   */
  public static void moveDirectory(String dirPath, String dest) {
    try {
      // Directory path
      String[] splitName = dirPath.split(File.separator);
      StringBuilder builder = new StringBuilder(dest);
      if (dest.charAt(dest.length() - 1) != File.separatorChar)
        builder.append(File.separator);
      builder.append(splitName[splitName.length - 1]);

      // Locate the directory
      File d = new File(dirPath);
      File newDir = new File(builder.toString());

      if (d.renameTo(newDir)) {
        System.out.printf("Successfully moved directory to %s!\n", newDir.getPath());
      } else {
        System.out.printf("Failed to file the directory at %s\n", newDir.getPath());
      }
    } catch (Exception e) {
      System.err.printf("An error occured while moving the directory: %s\n", e.getMessage());
    }
  }

  /**
   * Copies a specified directory
   *
   * @param dirPath A String holding the path to the diretory to copy
   *
   * @param dest    A String holding the location for the copy of the directory
   */
  public static void copyDirectory(String dirPath, String dest) {
    try {
      Files.walk(Paths.get(dirPath))
          .forEach(source -> {
            Path destination = Paths.get(dest, source.toString()
                .substring(dirPath.length()));
            try {
              Files.copy(source, destination);
            } catch (IOException e) {
              System.out.println("An error occured while copying the directory:");
              e.printStackTrace();
            }
          });
      System.out.printf("Successfully copied the directory from %s to %s!\n", dirPath, dest);
    } catch (IOException e) {
      System.out.println("An error occurred while copying the directory:");
      e.printStackTrace();
    }
  }
}
