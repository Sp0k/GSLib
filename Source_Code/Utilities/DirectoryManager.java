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
    // Address of current directory
    String currentDirectory = System.getProperty("user.dir");

    // Path of the directory to be created
    String directoryPath = currentDirectory + File.separator + directoryName;

    // File object to hold the directory
    File d = new File(directoryPath);

    if (d.mkdir()) {
      System.out.printf("Successfully created %s!\nPath: %s\n", d.getName(), d.getPath());
    } else {
      System.out.printf("Failed to create the directory. It may already exist at: %s\n", directoryPath);
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
    // Path of the new directory
    String dirPath = (directoryPath.charAt(directoryPath.length() - 1) == '/') ? directoryPath + directoryName
        : directoryPath + File.separator + directoryName;

    // File object to hold the directory
    File d = new File(dirPath);

    if (d.mkdir()) {
      System.out.printf("Successfully created %s!\nPath: %s\n", d.getName(), d.getPath());
    } else {
      System.out.printf("Failed to create the directory. It may already exist at: %s\n", directoryPath);
    }
  }
}
