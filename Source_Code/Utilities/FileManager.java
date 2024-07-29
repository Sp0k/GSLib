/*
 *    █████████   █████████
 *   ███░░░░░███ ███░░░░░███        File Manager
 *  ███     ░░░ ░███    ░░░
 * ░███         ░░█████████         @author Gab 'Sp0k' Savard
 * ░███    █████ ░░░░░░░░███        @version 1.5
 * ░░███  ░░███  ███    ░███        since 2023-10-13
 *  ░░█████████ ░░█████████
 *   ░░░░░░░░░   ░░░░░░░░░
 *
 *  @description: File management methods. This class holds methods to simplify
 *  the creation, deletion and use of files.
 */
package GSLib.Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
  /*
   * Create a new File
   *
   * @param filepath A String holding the path for the new file
   */
  public static void newFile(String filepath) {
    try {
      File f = new File(filepath);
      if (f.createNewFile()) {
        System.out.printf("File created: %s\npath: %s\n", f.getName(), f.getAbsolutePath());
      } else {
        System.out.printf("File already exists.\n");
      }
    } catch (IOException e) {
      System.out.println("An error occured");
      e.printStackTrace();
    }
  }

  /*
   * Read files
   *
   * @param filepath A String holding the path of the file
   *
   * @return String containing the text contained in the file
   */
  public static String readFile(String filepath) {
    File f = new File(filepath);
    java.util.Scanner reader = null;
    String lines = "";

    try {
      reader = new Scanner(f);
    } catch (FileNotFoundException e) {
      System.out.println("File was not found");
      return "";
    }

    while (reader.hasNext()) {
      lines += reader.nextLine() + "\n";
    }
    reader.close();

    return lines;
  }

  /*
   * Write to a file
   *
   * @param filepath A String holding the path of the file
   *
   * @param text A String holding the text to add to the file
   */
  public static void writeToFile(String filepath, String text) {
    try {
      FileWriter w = new FileWriter(filepath);
      w.write(text);
      w.close();
    } catch (IOException e) {
      System.out.println("An error occured");
      e.printStackTrace();
    }
  }

  /*
   * Erase the content of a file
   *
   * @param filepath A String holding the path of the file
   */
  public static void eraseContent(String filepath) {
    // Replace the file's content with an empty string
    try (PrintWriter pw = new PrintWriter(filepath)) {
    } catch (IOException e) {
      System.out.println("An error occured");
      e.printStackTrace();
    }
  }

  /*
   * Delete a file
   *
   * @param filepath A String holding the path of the file
   */
  public static void deleteFile(String filepath) {
    try {
      // Locate the file
      File f = new File(filepath);

      // Delete the file
      if (f.delete()) {
        System.out.printf("Deleted the file: %s\n", f.getName());
      } else {
        System.out.printf("Failed to delete %s.\n", f.getName());
      }
    } catch (Exception e) {
      System.err.printf("An error occured while deleting the file: %s\n", e.getMessage());
    }
  }

  /*
   * Rename a file
   *
   * @param filepath A String holding the path to the file
   *
   * @param newName A String holding the new name of the file
   */
  public static void renameFile(String filepath, String newName) {
    try {
      // File path
      String[] splitName = filepath.split(File.pathSeparator);
      splitName[splitName.length - 1] = newName;

      StringBuilder builder = new StringBuilder();

      for (int i = 0; i < splitName.length; i++) {
        builder.append(splitName[i]);
        if ((i + 1) < (splitName.length - 1))
          builder.append(File.pathSeparator);
      }

      // Locate the file
      File f = new File(filepath);
      File dest = new File(builder.toString());

      // Rename the file
      if (f.renameTo(dest)) {
        System.out.printf("Successfully renamed file to %s!\n", f.getName());
      } else {
        System.out.printf("Failed to rename the file at %s\n", f.getPath());
      }
    } catch (Exception e) {
      System.err.printf("An error occured while renaming the file: %s\n", e.getMessage());
    }
  }

  /*
   * Move a file
   *
   * @param filepath A String holding the path to the file
   *
   * @param dest A String holding the new location
   */
  public static void moveFile(String filepath, String dest) {
    try {
      // File path
      String[] splitName = filepath.split(File.pathSeparator);
      StringBuilder builder = new StringBuilder(dest);
      if (dest.charAt(dest.length() - 1) != File.separatorChar)
        builder.append(File.separator);
      builder.append(splitName[splitName.length - 1]);

      // Locate the file
      File f = new File(filepath);
      File fileDest = new File(builder.toString());

      if (f.renameTo(fileDest)) {
        System.out.printf("Successfully moved file to %s!\n", f.getPath());
      } else {
        System.out.printf("Failed to file the file at %s\n", f.getPath());
      }
    } catch (Exception e) {
      System.err.printf("An error occured while moving the file: %s\n", e.getMessage());
    }
  }

  /*
   * Copy a file
   *
   * @param filepath A String holding the path to the original file
   *
   * @param dest A String holding the path to the copy of the file
   */
  public static void copyFile(String filepath, String dest) {
    try {
      Path fromFile = Paths.get(filepath);
      Path toFile = Paths.get(dest);

      if (Files.notExists(fromFile)) {
        System.out.printf("File doesn't exists: %s\n", fromFile);
        return;
      }

      Path parent = toFile.getParent();
      if (parent != null) {
        if (Files.notExists(parent)) {
          Files.createDirectories(parent);
        }
      }

      Files.copy(fromFile, toFile);
      System.out.printf("Successfully copied file: %s to %s!\n", fromFile, toFile);
    } catch (IOException e) {
      System.out.print("Failed to copy te file\n");
      e.printStackTrace();
    }
  }
}
