# Utilities

This is the utilities package. This package contains classes and methods useful
for managing various things in your code. So far, I have these classes created:

- [File Manager](#file-manager)
- [Directory Manager](#directory-manager)

## File Manager

The File Manager class contains methods I use for managing files in my code.
The more projects I do and the bigger they get, the more I find myself
rewriting these methods into my code. This class is the reason I started
working on this library. My goal in having this class is to replace the need
of having multiple File objects in my code to keep tracks of my files. Instead,
I get to use most of the File class methods through static method calls, which
might potentially make my code more efficient, but definitely makes it easier
to read.

### Features

- File Creation
- File Deletion
- File Reading
- File Writing
- File Renaming
- File moving
- Copy a file
- Erase Content of a file

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
    String filename = "path/to/your/file";
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
    String filename = "path/to/your/file";
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
    String filename = "path/to/your/file";
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
    String filename = "path/to/your/file";
    FileManager.deleteFile(filename);
  }
}
```

To rename a file, you will have to use the **renameFile()** method. This method
takes in a String `filename` to locate the file and a String `newName` holding
the file's new name as parameters. The new name should include the file's type.

```java
import GSLib.Utilities.FileManager;

public class Example {
  void main() {
    String filename = "path/to/your/file";
    FileManager.renameFile(filename, "newName");
  }
}
```

To move a file, you will be able to use the **moveFile()** method. This method
takes in a String `filename` to locate the file and a String `dest` holding the
new location of the file.

```java
import GSLib.Utilities.FileManager;

public class Example {
  void main() {
    String filename = "path/to/your/file";
    String dest = "new/destination/";
    FileManager.moveFile(filename, dest);
  }
}
```

To copy a file, you can use the **copyFile()** method. This method takes in a
String `src` and a String `dest` to know what file to copy where.

```java
import GSLib.Utilities.FileManager;

public class Example {
  void main() {
    String src = "path/to/original/file";
    String dest = "path/to/copy/destination";
    FileManager.copyFile(src, dest);
  }
}
```

## Directory Manager

The Directory Manager is the second class I decided to write, once I had time
to focus on the project again. Having a manager for my files, I thought that on
bigger projects I might want to be able to also manage the directories for my
data. This lead to this class. I also like this class because there is over
6 months between this one and File Manager, and the difference between the
understanding of what I'm doing and the quality of work is huge.

### Features

- Directory Creation (in the current directory and in a specified location)
- Directory Deletion
- Directory renaming
- Move Directory

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
    String directoryPath = "path/for/new/directory/location";
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
    String directoryPath = "path/to/your/directory";
    DirectoryManager.deleteDirectory(directoryPath);
  }
}
```

To rename a directory, you can use the **renameDirectory()** method. This method
takes a String `directoryName` which specifies the path to the directory and a
String `newName` which specifies the new name for the directory.

```java
import GSLib.Utilities.DirectoryManager;

public class Example {
  void main() {
    String directoryName = "path/to/your/directory";
    String newName = "renamedDirectory";
    DirectoryManager.renameDirectory(directoryName, newName);
  }
}
```

To move a directory, you can use the **moveDirectory()** method. This method
takes a String `directoryName` which specifies the path to the directory and a
String `dest` which specifies the new location for the directory;

```java
import GSLib.Utilities.DirectoryManager;

public class Example {
  void main() {
    String directoryName = "path/to/your/directory";
    String dest = "path/to/new/location";
    DirectoryManager.moveDirectory(directoryName, dest);
  }
}
```

## Acknowledgements

Some of the methods are not original, rather, some are modified piece of code
from friends or online resources, which I have linked below.

- [GeeksForGeeks](https://www.geeksforgeeks.org/),
- [W3Schools](https://www.w3schools.com/),
- [Suchith Sridhar](https://github.com/SuchithSridhar),
- [Baeldung](https://https://www.baeldung.com/).
