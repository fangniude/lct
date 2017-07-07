package com.winnertel.em.standard.resource;

import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import org.jdom.*;
import org.jdom.input.SAXBuilder;
import org.jdom.input.SAXHandler;
import org.xml.sax.SAXException;

import java.net.URL;
import java.util.Properties;
import java.util.StringTokenizer;

public class DocumentLoader {
    private static ILogger fgLogger = LoggerController.createLogger(DocumentLoader.class);


    public static Element buildDocument(URL aUrl) {
        Document doc = loadDocument(aUrl);
        if (doc != null) {
            return doc.getRootElement();
        } else {
            return null;
        }
    }


    public static Document loadDocument(URL aUrl) {
        SAXBuilder builder = new SAXBuilder() {
            protected SAXHandler createContentHandler() throws Exception {
                try {
                    return new PIHandler();
                } catch (Exception ex) {
                    return super.createContentHandler();
                }
            }
        };
        //for support include process instruction at 2004-01-19
        try {
            return builder.build(aUrl);
        } catch (Exception ex) {
            fgLogger.debug("Error in build document " + aUrl.getPath(), ex);
            return null;
        }
    }

    //for support include process instruction at 2004-01-19
    private static class PIHandler extends SAXHandler {

        private final static String PI = "include";
        //Tags pre-defined
        private final static String URL = "url";
        //private final static String TAG  = "tag";
        //private final static String PATH = "path";
        //end Tags

        private Properties fProperties = new Properties();
        //
        //private Properties fPrimaryKey = new Properties();

        PIHandler() throws Exception {
            super();
        }

        private void parseData(String aData) {
            //the aData will like
            //url="XX" tag="XX" path="XX,XX,XX"
            StringTokenizer tokenizer = new StringTokenizer(aData, " ");
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                int index = token.indexOf("=");
                int length = token.length();
                fProperties.setProperty(token.substring(0, index),
                        token.substring(index + 2, length - 1));
            }
        }

        private Element loadRootElement() {
            String sUrl = fProperties.getProperty(URL);
            URL url = getClass().getClassLoader().getResource(sUrl);
            return buildDocument(url);
        }

        public void processingInstruction(String target, String data) throws SAXException {
            super.processingInstruction(target, data);
            if (PI.equalsIgnoreCase(target)) {
                parseData(data);
                Element locatedResourceRoot = loadRootElement();
                loadResource(locatedResourceRoot, getCurrentElement());
            }
        }

        private boolean loadResource(Element aResourceRoot, Element aRoot) {
            if (aResourceRoot == null || aRoot == null) {
                return false;
            }
            Object[] children = aResourceRoot.getContent().toArray();
            if (children == null) {
                return true;
            }
            for (int i = 0; i < children.length; i++) {
                Object child = children[i];
                if (child instanceof Element) {
                    aRoot.addContent(((Element) child).detach());
                } else if (child instanceof Text) {
                    aRoot.addContent(((Text) child).detach());
                } else if (child instanceof Comment) {
                    aRoot.addContent(((Comment) child).detach());
                } else if (child instanceof ProcessingInstruction) {
                    aRoot.addContent(((ProcessingInstruction) child).detach());
                } else if (child instanceof CDATA) {
                    aRoot.addContent(((CDATA) child).detach());
                } else if (child instanceof EntityRef) {
                    aRoot.addContent(((EntityRef) child).detach());
                }
            }
            return true;
        }

    }//end class PIHandler
}
