# Utilities

This is the utilities package. This package contains classes and methods useful
for managing various things in your code. So far, I have these classes created:

- [File Manager](#file-manager)
- [Directory Manager](#directory-manager)

## File Manager

The File Manager package contains methods I use for managing files in my code.
The more projects I do and the bigger they get, the more I find myself
rewriting these methods into my code. This package is the reason I started
working on this library.

### Features

- File Creation: Create a file from a path to the file
- File Deletion: Delete a file from a path to the file
- File Reading: Read a file from a path to the file
- File Writing: Write content to a file using a String from your code
- Erase Content: Completely wipe the content of a file.

I would like to add a method to delete specific code from a file, a method
to move files to another location and a method to rename files in the future.

### Usage

Each of the methods will print an error message to the screen if any is
encountered.

The **newFile()** method takes a String `filename` as a parameter which should be
the absolute or relative path to your file (e.g.
`~/Documents/Example/myFile.txt` or `../myFile.txt`).

```java
import GSLib.Utilities.FileManager;

public class Example {
  void main() {
    String filename = "path/to/your/file"; // If you are using windows, replace / with \\
    FileManager.newFile(filename);
  }
}
```

You can read a file using the **readFile()** method. The method takes in a
String `filename` as a parameter in order to locate the file to read. It then
scans the entire file and returns its content as a String.

```java
import GSLib.Utilities.FileManager;

public class Example {
  void main() {
    // ...

    String file = FileManager.readFile(filename);
  }
}
```

To write to a file, you will need to use the **writeToFile()** method. The
method takes in a String `filename` and a String `content` as parameters. It
will find the file using `filename` and then writes the String in content in said
file.

```java
import GSLib.Utilities.FileManager;

public class Example {
  void main() {
    // ...

    String content = "Hello, World! This is my message!";
    FileManager.writeToFile(filename, content);
  }
}
```

To erase the content of a file, you can use the **eraseContent()** method which
takes in a String `filename` parameter to locate the file. It will replace the
content of the file with an empty String.

```java
import GSLib.Utilities.FileManager;

public class Example {
  void main() {
    // ...

    FileManager.eraseContent(filename);
  }
}
```

You can use the **deleteFile()** method to delete files. The method takes in a
String `filename` as a parameter to locate the file and then deletes it.

```java
import GSLib.Utilities.FileManager;

public class Example {
  void main() {
    // ...

    FileManager.deleteFile(filename);
  }
}
```

### Acknowledgements

I did not write most of the methods myself, I modified some from code I learned
on GeeksForGeeks and W3School and another method was written by my friend
[Suchith Sridhar](https://github.com/SuchithSridhar).

_Suchith_ wrote the `readFile()` method.
_W3School_ wrote the original code for the `createFile()` and `writeToFile()` methods.
_GeekForGeeks_ wrote the original code for both delete methods.

## Directory Manager

The Directory Manager is the second package I decided to write, once I had time
to focus on the project again. Having a manager for my files, I thought that on
bigger projects I might want to be able to also manage the directories for my
data. This lead to this package. I also like this package because there is over
6 months between this one and File Manager, and the difference between the
understanding of what I'm doing and the quality of work is huge.

### Features

- Directory Creation (in the current directory and in a specified location)
- Directory Deletion

More methods will be coming soon, like moving directories, and renaming them.

### Usage

Each of the methods will print an error message to the screen if any is
encountered.

To create a new directory inside the current one, you can use **newDirectory()**
method. The method takes a String `directoryName` which specifies the name of the
new directory.

```java
import GSLib.Utilities.DirectoryManager;

public class Example {
  void main() {
    String directoyName = "newDirectory";
    DirectoryManager.newDirectory(directoryName);
  }
}
```

To create a new directory at a specific location, you can use the **newDirectory()**
method. The method takes a String `directoryName` which specifies the name of the
new directory and a String `directoryPath` which specifies the location of the new
directory.

```java
import GSLib.Utilities.DirectoryManager;

public class Example {
  void main() {
    String directoryName = "newDirectory";
    String directoryPath = "/path/for/new/directory/location";
    DirectoryManager.newDirectory(directoryName, directoryPath);
  }
}
```

To erase a directory, you can use the **deleteDirectory()** method. This method
takes a String `directoryPath` which specifies the path to the directory to
delete.

```java
import GSLib.Utilities.DirectoryManager;

public class Example {
  void main() {
    String directoryPath = "/path/to/your/directory";
    DirectoryManager.deleteDirectory(directoryPath);
  }
}
```

### Acknowledgements

This section will be written soon
