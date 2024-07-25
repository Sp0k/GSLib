/*
 *    █████████   █████████
 *   ███░░░░░███ ███░░░░░███        Directory Manager
 *  ███     ░░░ ░███    ░░░
 * ░███         ░░█████████         @author Gab 'Sp0k' Savard
 * ░███    █████ ░░░░░░░░███        @version 1.0
 * ░░███  ░░███  ███    ░███        since 2024-07-25
 *  ░░█████████ ░░█████████
 *   ░░░░░░░░░   ░░░░░░░░░
 *
 *  @description: Directory Management methods. This class holds methods for
 *  creating, deleting and navigating through directories
 */
package GSLib.Utilities;

import java.io.File;

public class DirectoryManager {
  /*
   * Create new directory (in the current directory)
   *
   * @param directoryName A String containing the name of the new directory
   */
  public static void newDirectory(String directoryName) {
    try {
      // Address of current directory
      String currentDirectory = System.getProperty("user.dir");

      // Path of the directory to be created
      String directoryPath = currentDirectory + File.separator + directoryName;

      // File object to hold the directory
      File d = new File(directoryPath);

      // Create new directory
      if (d.mkdir()) {
        System.out.printf("Successfully created %s!\nPath: %s\n", d.getName(), d.getPath());
      } else {
        System.out.printf("Failed to create the directory. It may already exist at: %s\n", directoryPath);
      }
    } catch (Exception e) {
      System.err.printf("An error occurred while creating the directory: %s\n", e.getMessage());
    }
  }

  /*
   * Create new directory (inside other directories)
   *
   * @param directoryName A String containing the name of the new directory
   *
   * @param directoryPath A String containing the path for the new directory's
   * location
   */
  public static void newDirectory(String directoryName, String directoryPath) {
    try {
      // Path of the new directory
      String dirPath = (directoryPath.charAt(directoryPath.length() - 1) == '/') ? directoryPath + directoryName
          : directoryPath + File.separator + directoryName;

      // File object to hold the directory
      File d = new File(dirPath);

      // Create new directory
      if (d.mkdir()) {
        System.out.printf("Successfully created %s!\nPath: %s\n", d.getName(), d.getPath());
      } else {
        System.out.printf("Failed to create the directory. It may already exist at: %s\n", directoryPath);
      }
    } catch (Exception e) {
      System.err.printf("An error occurred while creating the directory: %s\n", e.getMessage());
    }
  }

  /*
   * Delete directory
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

  /*
   * Delete sub directory
   *
   * This method takes care of deleting the subdirectories. It is private as there
   * is no reason to access it from the code.
   *
   * @param dir A File containing the directory for which to delete all of the
   * subdirectories
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
}
