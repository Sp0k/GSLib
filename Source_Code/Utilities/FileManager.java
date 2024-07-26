/*
 *    █████████   █████████
 *   ███░░░░░███ ███░░░░░███        File Manager
 *  ███     ░░░ ░███    ░░░
 * ░███         ░░█████████         @author Gab 'Sp0k' Savard
 * ░███    █████ ░░░░░░░░███        @version 1.3
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

public class FileManager {
  /*
   * Create a new File
   *
   * @param filename A String holding the path for the new file
   */
  public static void newFile(String filename) {
    try {
      File f = new File(filename);
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
   * @param filename A String holding the path of the file
   *
   * @return String containing the text contained in the file
   */
  public static String readFile(String filename) {
    File f = new File(filename);
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
   * @param filename A String holding the path of the file
   *
   * @param text A String holding the text to add to the file
   */
  public static void writeToFile(String filename, String text) {
    try {
      FileWriter w = new FileWriter(filename);
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
   * @param filename A String holding the path of the file
   */
  public static void eraseContent(String filename) {
    // Replace the file's content with an empty string
    try (PrintWriter pw = new PrintWriter(filename)) {
    } catch (IOException e) {
      System.out.println("An error occured");
      e.printStackTrace();
    }
  }

  /*
   * Delete a file
   *
   * @param filename A String holding the path of the file
   */
  public static void deleteFile(String filename) {
    // Locate the file
    File f = new File(filename);

    // Delete the file
    if (f.delete()) {
      System.out.printf("Deleted the file: %s\n", f.getName());
    } else {
      System.out.printf("Failed to delete %s.\n", f.getName());
    }
  }

  /*
   * Rename a file
   *
   * @param filename A String holding the path to the file
   *
   * @param newName A String holding the new name of the file
   */
  public static void renameFile(String filename, String newName) {
    // File path
    String[] splitName = filename.split(File.pathSeparator);
    splitName[splitName.length - 1] = newName;

    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < splitName.length; i++) {
      builder.append(splitName[i]);
      if ((i + 1) < (splitName.length - 1))
        builder.append(File.pathSeparator);
    }

    // Locate the file
    File f = new File(filename);
    File dest = new File(builder.toString());

    // Rename the file
    if (f.renameTo(dest)) {
      System.out.printf("Successfully renamed file to %s!\n", f.getName());
    } else {
      System.out.printf("Failed to rename the file at %s\n", f.getPath());
    }
  }

  /*
   * Move a file
   *
   * @param filename A String holding the path to the file
   *
   * @param dest A String holding the new location
   */
  public static void moveFile(String filename, String dest) {
    // File path
    String[] splitName = filename.split(File.pathSeparator);
    StringBuilder builder = new StringBuilder(dest);
    builder.append(splitName[splitName.length - 1]);

    // Locate the file
    File f = new File(filename);
    File fileDest = new File(builder.toString());

    if (f.renameTo(fileDest)) {
      System.out.printf("Successfully moved file to %s!\n", f.getPath());
    } else {
      System.out.printf("Failed to file the file at %s\n", f.getPath());
    }
  }
}
