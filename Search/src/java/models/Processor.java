package models;
//import ch.qos.cal10n.util.Parser;
import com.sun.media.sound.InvalidFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URL;
import java.util.Properties;
import opennlp.tools.chunker.ChunkerME;
import opennlp.tools.chunker.ChunkerModel;
import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.cmdline.postag.POSModelLoader;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.Span;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author debmeister
 */
public class Processor {
public String base="/home/debmeister/NetBeansProjects/fortue/web/resources/";
public String[] SentenceDetect (String sentence) throws InvalidFormatException,IOException {
InputStream is = new FileInputStream( "se-sent.bin" ) ;
SentenceModel model = new
SentenceModel ( is ) ;
SentenceDetectorME sdetector = new
SentenceDetectorME( model ) ;
String sentences [] = sdetector. sentDetect (sentence) ;
is. close() ;
return sentences;
}
 
 public String[] Tokenize (String sentence) throws InvalidFormatException, IOException {
 Properties configProp=new Properties();
// URL url = Processor.class.getResource("en-token.bin");
InputStream is=new FileInputStream(base+"en-token.bin");
//InputStream is = ClassLoader.getSystemResourceAsStream("/en-token.bin");
//        new FileInputStream( "en-token.bin" ) ;
//InputStream is = new FileInputStream( "en-token.bin" ) ;
if(is == null){
 throw new FileNotFoundException(is.toString());   
}else{
TokenizerModel model = new
TokenizerModel ( is ) ;
Tokenizer tokenizer = new TokenizerME( model ) ;
String tokens [] = tokenizer. tokenize(sentence) ;
return tokens;
}
}
 public Span[] findName (String [] sentence) throws IOException{
//InputStream is = new FileInputStream( "resources/en-ner-person.bin" ) ;
InputStream is = ClassLoader.getSystemResourceAsStream(base+"/en-ner-person.bin");
     TokenNameFinderModel model = newTokenNameFinderModel ( is ) ;
is. close() ;
NameFinderME nameFinder = new
NameFinderME ( model ) ;
Span nameSpans [] =nameFinder. find( sentence ) ;
return nameSpans;
}

    private TokenNameFinderModel newTokenNameFinderModel(InputStream is) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 public void POSTag () throws IOException {
POSModel model = new POSModelLoader().load ( new File (base+"en-pos-maxent.bin" )) ;
PerformanceMonitor perfMon = new PerformanceMonitor ( System .err, "sent" ) ;
POSTaggerME tagger = new
POSTaggerME ( model ) ;
String input = "Hi. How are you? This is Mike." ;
ObjectStream< String > lineStream =new PlainTextByLineStream (new StringReader( input )) ;
perfMon. start () ;
String line ;
while (( line = lineStream. read ()) != null ) {
String whitespaceTokenizerLine [] =WhitespaceTokenizer. INSTANCE.tokenize ( line ) ;
String [] tags = tagger. tag( whitespaceTokenizerLine ) ;
POSSample sample = new POSSample ( whitespaceTokenizerLine, tags ) ;
System . out .println( sample. toString ()) ;
perfMon. incrementCounter() ;
}
perfMon. stopAndPrintFinalResult() ;
}
 
 public void chunk () throws IOException {
POSModel model = new POSModelLoader().load( new File(base+"en-pos-maxent.bin" )) ;
PerformanceMonitor perfMon = new PerformanceMonitor ( System .err, "sent" ) ;
POSTaggerME tagger = new POSTaggerME ( model ) ;
String input = "Hi. How are you? This is Mike." ;
ObjectStream< String > lineStream =new PlainTextByLineStream (new StringReader( input )) ;
perfMon. start () ;
String line ;
String whitespaceTokenizerLine [] =null ;
String [] tags = null ;
while (( line = lineStream. read ()) != null ) {
whitespaceTokenizerLine =WhitespaceTokenizer. INSTANCE.tokenize ( line ) ;
tags = tagger. tag( whitespaceTokenizerLine ) ;
POSSample sample = new POSSample ( whitespaceTokenizerLine, tags ) ;
System . out .println( sample. toString ()) ;
perfMon. incrementCounter() ;
}
perfMon. stopAndPrintFinalResult() ;
// chunker
InputStream is = new FileInputStream( "en-chunker.bin" ) ;
ChunkerModel cModel = new ChunkerModel ( is ) ;
ChunkerME chunkerME = new ChunkerME ( cModel) ;
String result [] = chunkerME. chunk( whitespaceTokenizerLine, tags ) ;
for ( String s : result )
System . out .println ( s ) ;
Span [] span =chunkerME. chunkAsSpans
( whitespaceTokenizerLine, tags ) ;
for ( Span s : span )
System . out .println
( s. toString ()) ;
}
 
 public static void Parse () throws InvalidFormatException, IOException {
// http://sourceforge.net/apps/mediawiki/opennlp/index.php?title=Parser#Training_Tool
/*InputStream is = new FileInputStream( "en-parser-chunking.bin" ) ;
ParserModel model = new ParserModel( is ) ;
Parser parser = ParserFactory. create( model ) ;
String sentence = "Programcreek is a very huge and useful website." ;
Parse topParses [] =ParserTool. parseLine( sentence, parser, 1 ) ;
for ( Parse p : topParses )
p. show () ;
is. close() ;*/
/*
 * (TOP (S (NP (NN Programcreek) )
(VP (VBZ is) (NP (DT a) (ADJP (RB
* very) (JJ huge) (CC and) (JJ useful)
) ) ) (. website.) ) )
*/
}
 
}
