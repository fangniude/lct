/*
 * Copyright (c) 2008  All rights reserved.
 */
package com.winnertel.em.standard.text;

import java.util.ArrayList;
import java.util.List;

public class TextUtils {
    /**
     * Default row length for a text paragraph. Used by <code>textWrap(String())</code> method.
     */
    public static final int DEFAULT_ROW_LENGTH = 80;

    /**
     * Wraps the text to specified line length using specified line separator. Lines will be cut after space, comma or
     * dot. This method does not make "brute force cut" in case of over-length word.
     *
     * @param text          text to wrap
     * @param lineSeparator line separator to use (e.g. '<br>' '\n', ...)
     * @param rowLength     row length in chars
     * @return original string + line separators
     */
    public static String textWrap(String text, String lineSeparator, int rowLength) {
        StringBuilder line = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        if (rowLength <= 0 || text == null || text.length() <= 0) {
            return "";
        } else if (text.length() < rowLength) {
            return text;
        }

        List<String> parts = new ArrayList<String>();
        String toSplit = text;

        // split the string to parts using spaces
        int spaceIndex;
        // split the parts the contain line breaks so that the text and line break are in separate items
        while ((spaceIndex = toSplit.indexOf(" ")) != -1) {
            // take a part of the text up to the first space
            String part = toSplit.substring(0, spaceIndex);

            int index;
            // split the parts so that the text and possible line breaks are in separate items
            while ((index = part.indexOf(lineSeparator)) != -1) {
                parts.add(part.substring(0, index));
                parts.add(part.substring(index, index + lineSeparator.length()));
                part = part.substring(index + lineSeparator.length());
            }

            // now the part won't contain any line breaks, add it and following space to parts.
            parts.add(part);
            parts.add(toSplit.substring(spaceIndex, spaceIndex + 1));
            // remove handled parts from the string
            toSplit = toSplit.substring(spaceIndex + 1);
        }
        // add final part also
        parts.add(toSplit);

        // handle the split string
        for (String part : parts) {
            // start the new line if the part is a line separator
            if (part.equals(lineSeparator)) {
                sb.append(line);
                sb.append(lineSeparator);
                line.delete(0, line.length());
                continue;
            }

            // if the line length is zero, we must add the part to line, since we don't split parts
            if (line.length() > 0) {
                // line length + part length is longer than the desired row, start new line
                if ((line.length() + part.length()) > rowLength) {
                    // Remove the space from the end of the line since we are adding a line separator
                    if (line.toString().endsWith(" ") && !part.equals(" ")) {
                        line.deleteCharAt(line.lastIndexOf(" "));
                    }

                    sb.append(line);
                    sb.append(lineSeparator);
                    line.delete(0, line.length());

                    // if the next part is a space, do not add it since we just added a line separator
                    if (" ".equals(part)) {
                        continue;
                    }
                }
            }
            // add the part to the line
            line.append(part);
        }

        // add the final line, it cannot be too long because of the checks before     
        return sb.append(line).toString();
    }

    /**
     * Wraps the text to specified line length using system's line separator . Lines will be cut after space, comma or
     * dot. This method does not make "brute force cut" in case of over-length word.
     *
     * @param text      text to wrap
     * @param rowLength row length in chars
     * @return original text (+ line separators)
     */
    public static String textWrap(String text, int rowLength) {
        String lineSeparator = System.getProperty("line.separator");
        return textWrap(text, lineSeparator, rowLength);
    }

    /**
     * Wraps the text to line length of 80 characters using system's line separator . Lines will be cut after space,
     * comma or dot. This method does not make "brute force cut" in case of over-length word.
     *
     * @param text text to wrap
     * @return original text (+ line separators)
     */
    public static String textWrap(String text) {
        String lineSeparator = System.getProperty("line.separator");
        return textWrap(text, lineSeparator, DEFAULT_ROW_LENGTH);
    }

    /**
     * Wraps the text to specified line length using specified line separator.
     * Line breaks can be inserted between words.
     *
     * @param text          Text to wrap
     * @param lineSeparator Line separator to be inserted
     * @param rowLength     Length of each row
     * @return Wrapped text
     */
    public static String forcedTextWrap(String text, String lineSeparator, int rowLength) {
        int length = text.length();
        if (length < rowLength) {
            return text;
        }
        StringBuffer result = new StringBuffer();
        for (int idx = 0; idx < length; idx++) {
            if (idx % rowLength == 0) {
                result.append(lineSeparator);
            }
            result.append(text.charAt(idx));
        }
        return result.toString();
    }

    /**
     * Wraps the text to line length of 80 characters using system's line separator.
     * Line breaks can be inserted between words.
     *
     * @param text Text to wrap
     * @return text with line breaks inserted
     */
    public static String forcedTextWrap(String text) {
        return forcedTextWrap(text, System.getProperty("line.separator"), DEFAULT_ROW_LENGTH);
    }

    /**
     * Encode HTML, all non allowed characters will be replaced
     * with "%XX" where XX is the hex value of the character.
     *
     * @param text the text to be encoded
     * @return encoded text.
     */
    public static String encodeHTML(String text) {
        // the percentage signs must be encoded first,
        // because other encodings add percentage signs
        String tempText = text.replace("%", "%25");
        tempText = tempText.replace(" ", "%20");
        tempText = tempText.replace("!", "%21");
        tempText = tempText.replace("\"", "%22");
        tempText = tempText.replace("#", "%23");
        tempText = tempText.replace("$", "%24");
        // % sign is the first
        tempText = tempText.replace("&", "%26");
        tempText = tempText.replace("'", "%27");
        tempText = tempText.replace("(", "%28");
        tempText = tempText.replace(")", "%29");
        tempText = tempText.replace("*", "%2A");
        tempText = tempText.replace("+", "%2B");
        tempText = tempText.replace(",", "%2C");
        tempText = tempText.replace("-", "%2D");
        tempText = tempText.replace(".", "%2E");
        // '/' and digits are allowed
        tempText = tempText.replace(":", "%3A");
        tempText = tempText.replace(";", "%3B");
        tempText = tempText.replace("<", "%3C");
        tempText = tempText.replace("=", "%3D");
        tempText = tempText.replace(">", "%3E");
        tempText = tempText.replace("?", "%3F");
        tempText = tempText.replace("@", "%40");
        // upper case letters are allowed        
        tempText = tempText.replace("[", "%5B");
        tempText = tempText.replace("\\", "%5C");
        tempText = tempText.replace("]", "%5D");
        tempText = tempText.replace("^", "%5E");
        tempText = tempText.replace("_", "%5F");
        tempText = tempText.replace("`", "%60");
        // lover case letters are allowed
        tempText = tempText.replace("{", "%7B");
        tempText = tempText.replace("|", "%7C");
        tempText = tempText.replace("}", "%7D");
        tempText = tempText.replace("~", "%7E");
        return tempText;
    }

    /**
     * Decode HTML, all "%XX" sequences will be replaced
     * with a character which is defined by the hex value following the%.
     *
     * @param text the path to be decoded.
     * @return decoded text.
     */
    public static String decodeHTML(String text) {
        String tempText = text.replace("%20", " ");
        tempText = tempText.replace("%21", "!");
        tempText = tempText.replace("%22", "\"");
        tempText = tempText.replace("%23", "#");
        tempText = tempText.replace("%24", "$");
        // % sign is the last
        tempText = tempText.replace("%26", "&");
        tempText = tempText.replace("%27", "'");
        tempText = tempText.replace("%28", "(");
        tempText = tempText.replace("%29", ")");
        tempText = tempText.replace("%2A", "*");
        tempText = tempText.replace("%2a", "*");
        tempText = tempText.replace("%2B", "+");
        tempText = tempText.replace("%2b", "+");
        tempText = tempText.replace("%2C", ",");
        tempText = tempText.replace("%2c", ",");
        tempText = tempText.replace("%2D", "-");
        tempText = tempText.replace("%2d", "-");
        tempText = tempText.replace("%2E", ".");
        tempText = tempText.replace("%2e", ".");
        // '/' and digits are allowed
        tempText = tempText.replace("%3A", ":");
        tempText = tempText.replace("%3a", ":");
        tempText = tempText.replace("%3B", ";");
        tempText = tempText.replace("%3b", ";");
        tempText = tempText.replace("%3C", "<");
        tempText = tempText.replace("%3c", "<");
        tempText = tempText.replace("%3D", "=");
        tempText = tempText.replace("%3d", "=");
        tempText = tempText.replace("%3E", ">");
        tempText = tempText.replace("%3e", ">");
        tempText = tempText.replace("%3F", "?");
        tempText = tempText.replace("%3f", "?");
        tempText = tempText.replace("%40", "@");
        // upper case letters are allowed        
        tempText = tempText.replace("%5B", "[");
        tempText = tempText.replace("%5b", "[");
        tempText = tempText.replace("%5C", "\\");
        tempText = tempText.replace("%5c", "\\");
        tempText = tempText.replace("%5D", "]");
        tempText = tempText.replace("%5d", "]");
        tempText = tempText.replace("%5E", "^");
        tempText = tempText.replace("%5e", "^");
        tempText = tempText.replace("%5F", "_");
        tempText = tempText.replace("%5f", "_");
        tempText = tempText.replace("%60", "`");
        // lover case letters are allowed
        tempText = tempText.replace("%7B", "{");
        tempText = tempText.replace("%7b", "{");
        tempText = tempText.replace("%7C", "|");
        tempText = tempText.replace("%7c", "|");
        tempText = tempText.replace("%7D", "}");
        tempText = tempText.replace("%7d", "}");
        tempText = tempText.replace("%7E", "~");
        tempText = tempText.replace("%7e", "~");

        // the percentage signs must be decoded last,
        // because other encodings remove percentage signs
        tempText = tempText.replace("%25", "%");

        return tempText;
    }
}