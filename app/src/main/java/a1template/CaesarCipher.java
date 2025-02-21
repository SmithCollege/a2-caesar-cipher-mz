// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

public class CaesarCipher {

  /** Character array to store the letters in the alphabet in order */
  Character[] alphabet;

  /** DynamicArray object providing ArrayList-like operations for Characters */
  DynamicArray < Character > cipher;

  /** Private offset that tracks how many positions to shift the index for
   * this cipher */
  private int offset;

  /** Constructor that defines the instance variables, including
   * populating the alphabet
   * @param offset Offset to use when creating `cipher` of DynamicArray type
   */
  CaesarCipher(int offset) {
    this.alphabet = new Character[26];
    for (int i = 0; i < 26; i++) {
      alphabet[i] = Character.valueOf((char)('a' + i));
    }
    this.offset = offset;
    this.cipher = new DynamicArray(offset, alphabet);

  }

  /** Implementation of linear search that looks through the alphabet
   * array to identify the position of the passed value
   * @param val character to search for
   * @return int indicating position of val in the alphabet array
   */
  public int findIndex(char val) {
    // This is a stub -- fill in the code and return the
    // value you calculate
    int i = 0;
    int index = 0;
    while (val != alphabet[i]) {
      i++;
      index++;
    }
    return index;
  }

  /** Encode a message using the cipher
   * @param T message to encode
   * @return encoded message */
  public String encode(String message) {
    if (message == null || message.isEmpty()) {
      return ""; // Handle empty message case
    }

    String encodedMessage = "";
    char[] messageArray = message.toLowerCase().toCharArray();
    char[] originalMessageArray = message.toCharArray();

    int y = 0;
    int index = 0;
    while (y < messageArray.length) {
      if (Character.isAlphabetic(messageArray[y])) {

        index = this.findIndex(messageArray[y]);

        if (Character.isUpperCase(originalMessageArray[y])) {
          encodedMessage += Character.toUpperCase(cipher.get(index, -this.offset));
        } else {
          encodedMessage += cipher.get(index, -this.offset);
        }
      } else {
        encodedMessage += messageArray[y];
      }
      y++;
    }
    return encodedMessage;
  }
//CONFUSED ON WHY I NEED THE KEY IS THE CAESAR CIPHER OBJECT ALREADY HAS AN OFFSET
  /** Decode a message using the cipher 
   * @param String message to decode
   * @param int key to use in decoding
   * @return decoded message
   */
  public String decode(String message) {
    // Fill in here and update return statement based on your code
    if (message == null || message.isEmpty()) {
      return ""; // Handle empty message case
    }

    String decodedMessage = "";
    char[] messageArray = message.toLowerCase().toCharArray();
    char[] originalMessageArray = message.toCharArray();

    int y = 0;
    int index = 0;
    while (y < messageArray.length) {
      if (Character.isAlphabetic(messageArray[y])) {
        index = this.findIndex(messageArray[y]);

        if (Character.isUpperCase(originalMessageArray[y])) {
          decodedMessage += Character.toUpperCase(cipher.get(index, this.offset));
        } else {
          decodedMessage += cipher.get(index,this.offset);
        }
      } else {
        decodedMessage += messageArray[y];
      }
      y++;
    }
    return decodedMessage;
  }
  
  /**
   * returns character at the index in the alphabet array that has been shifted by an offset
   * @param index
   * @return character at the shifted index
   */
  public char get(int index) {
    return alphabet[(((index - offset) + alphabet.length) % alphabet.length)];
  }

  public static void main(String[] args) {}

}