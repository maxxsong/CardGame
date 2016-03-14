import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.*;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * Created by Yuanping Song on 3/14/2016.
 */
public class CardPrinter {

    static final String TWO_OF_CLUBS = "  ,#############################@###############################'  \n" +
            " @                                                               @ \n" +
            ",                                                               ` @\n" +
            "+                                                                 @\n" +
            "+                                                                 @\n" +
            "+                                                                 @\n" +
            "+      :`                                                         @\n" +
            "+    ;##@`                                                        @\n" +
            "+    @  @;                                                        @\n" +
            "+      `@                      +@@@@`                             @\n" +
            "+      `+                     :@@@@@@                             @\n" +
            "+      @                      @@@@@@@                             @\n" +
            "+     @ `@                    @@@@@@@                             @\n" +
            "+    @@@@'                    #@@@@@@                             @\n" +
            "#                           '+,#@@@@'@@+                          @\n" +
            "#     @@@                 :@@@@#@@@@@@@@@                         @\n" +
            "#     @@@ `               @@@@@@@@@@@@@@@                         @\n" +
            "#   :@#@#@.               @@@@@@@@#@@@@@@                         @\n" +
            "#   @@@@@#+               @@@@@@@@'@@@@@@                         @\n" +
            "#  ``@##@@                @@@@@#:@ @@@@@@                         @\n" +
            "#      @`                  @@@@+ @;.#@@@                          @\n" +
            "#                               `@@                               @\n" +
            "#                               #@@                               @\n" +
            "#                               @@@,                              @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "#                                                                 @\n" +
            "@                                                                 @\n" +
            "@                                                                 @\n" +
            "@                              `@@@;                              @\n" +
            "@                               @@@                               @\n" +
            "@                               .@#                               @\n" +
            "@                          #@@@, @; @@@#                   @      @\n" +
            "@                         +@@@@@.@ @@@@@#               ,#@@@@`   @\n" +
            "@                         @@@@@@@@,@@@@@@               @@@@@@#   @\n" +
            "@                         @@@@@@@@@@@@@@@               .@@@@@`   @\n" +
            "@                         @@@@@@@@@@@@@@@                 @@@     @\n" +
            "@                         #@@@@@@@@@@@@@#                `#@@     @\n" +
            "@                          .@##@@@@@@@@@                          @\n" +
            "@                             '@@@@@#                    '#+++    @\n" +
            "@                             #@@@@@@                    ###@     @\n" +
            "@                             #@@@@@@                   `  #      @\n" +
            "@                             '@@@@@@                     #`      @\n" +
            "@                              @@@@@`                     #       @\n" +
            "@                                                        @@  @    @\n" +
            "@                                                        ;@,;'    @\n" +
            "@                                                         '@;     @\n" +
            "@                                                       `         @\n" +
            "#                                                                 @\n" +
            ",                                                                 @\n" +
            " @`                                                              # \n" +
            "  ,+++++++++++++++################@#############@@@@@@@@@@@@@@@@'  \n";
static final String THREE_OF_ClUBS;
static final String FOUR_OF_ClUBS;
static final String FIVE_OF_ClUBS;
static final String SIX_OF_ClUBS;
static final String SEVEN_OF_ClUBS;
static final String EIGHT_OF_ClUBS;
static final String NINE_OF_ClUBS;
static final String TEN_OF_ClUBS;
static final String JACK_OF_ClUBS;
static final String QUEEN_OF_ClUBS;
static final String KING_OF_ClUBS;
static final String ACE_OF_ClUBS;

static final String TWO_OF_HEARTS;
static final String THREE_OF_HEARTS;
static final String FOUR_OF_HEARTS;
static final String FIVE_OF_HEARTS;
static final String SIX_OF_HEARTS;
static final String SEVEN_OF_HEARTS;
static final String EIGHT_OF_HEARTS;
static final String NINE_OF_HEARTS;
static final String TEN_OF_HEARTS;
static final String JACK_OF_HEARTS;
static final String QUEEN_OF_HEARTS;
static final String KING_OF_HEARTS;
static final String ACE_OF_HEARTS;

static final String TWO_OF_DIAMONDS;
static final String THREE_OF_DIAMONDS;
static final String FOUR_OF_DIAMONDS;
static final String FIVE_OF_DIAMONDS;
static final String SIX_OF_DIAMONDS;
static final String SEVEN_OF_DIAMONDS;
static final String EIGHT_OF_DIAMONDS;
static final String NINE_OF_DIAMONDS;
static final String TEN_OF_DIAMONDS;
static final String JACK_OF_DIAMONDS;
static final String QUEEN_OF_DIAMONDS;
static final String KING_OF_DIAMONDS;
static final String ACE_OF_DIAMONDS;

static final String TWO_OF_SPADES;
static final String THREE_OF_SPADES;
static final String FOUR_OF_SPADES;
static final String FIVE_OF_SPADES;
static final String SIX_OF_SPADES;
static final String SEVEN_OF_SPADES;
static final String EIGHT_OF_SPADES;
static final String NINE_OF_SPADES;
static final String TEN_OF_SPADES;
static final String JACK_OF_SPADES;
static final String QUEEN_OF_SPADES;
static final String KING_OF_SPADES;
static final String ACE_OF_SPADES;


    public static void print(Card c){

    }
}
