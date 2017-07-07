package com.winnertel.ems.epon.iad.util.text;
import java.util.*;
import java.util.regex.*;
import java.io.File;

/**
  * A thread safe file system search utility.
  */

public class FileSearch {
    File [] roots;

/**
  * Creates an instance of FileSearch, with all of the system roots
  * configured as search paths.
  */

public FileSearch() {
    roots = File.listRoots();
}

/**
  * Creates an instance of FileSearch, with the supplied name
  * configured as a search path.
  *
  * @param root A path to begin searching from.
  *
  */

public FileSearch(String root) {
    if (root == null) roots = File.listRoots();
    else {
        roots = new File[1];
        roots[0] = new File(root);
        }
}

/**
  * Creates an instance of FileSearch, with the supplied File
  * configured as a search path.
  *
  * @param root A File path to begin searching from.
  *
  */

public FileSearch(File root) {
    if (root == null) roots = File.listRoots();
    else {
        roots = new File[1];
        roots[0] = root;
        }
}

/**
  * Creates an instance of FileSearch, with the supplied Files
  * configured as a search path.
  *
  * @param roots Array of @{link File}s, indicating where to search from.
  *
  */

public FileSearch(File[] roots) {
    if (roots == null) roots = File.listRoots();
    else {
        this.roots = new File[roots.length];
        System.arraycopy(roots, 0, this.roots, 0, this.roots.length);
        }
}

/**
  * Initiates a search using the supplied <b>regular expression</b> string.
  *
  *
  * @param sp A String for what to search for, expressed as a regular
expression.
  * @return A List of File objects.
  * @see List
  * @see File
  * @see Pattern
  *
  */

public List search(String sp) {
    return search(Pattern.compile(sp));
}

/**
  * Initiates a search using the supplied <b>regular expression</b> pattern.
  *
  *
  * @param p A regular expression Pattern indicating the file name to match.
  * @return A List of File objects.
  * @see List
  * @see File
  * @see Pattern
  */

public List search(Pattern p) {

    List found = new LinkedList();
    LinkedList stack = new LinkedList();

    stack.addAll(Arrays.asList(roots));

    while (!stack.isEmpty()) {
        File currentDir = (File) stack.removeLast();
        File [] listing = currentDir.listFiles();

        if (listing != null) { // in case we can't get into a directory
            for (int i = 0; i<listing.length; i++) {
                if (p.matcher(listing[i].getName()).matches())
found.add(listing[i]);
                if (listing[i].isDirectory()) stack.addLast(listing[i]);
            }
            }
        }
    return found;
    }

    public static void main(String [] args) {
        FileSearch fs = new FileSearch("D:\\eclipse\\workspace\\b9001.2.3\\javasrc\\com\\utstar\\em\\broadband\\adsl_1u\\r2_0");
        List l = fs.search(".*\\.java");
        for (Iterator i = l.iterator(); i.hasNext(); ) {
            System.out.println(((File) i.next()));
            }

        }
}
