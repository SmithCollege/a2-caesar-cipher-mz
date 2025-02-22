// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

public class DynamicArray < T > implements IndexAccess < T > {

  /**array to store copy of passed array */
  T[] baseArray;
  
  /**offset of the baseArray */
  int offset;

  /**
   * creates a DynamicArray object that defines the instance variables, including
   * populating the copy (baseArray) of the passed in array
   * @param offset offset of dynamic array
   * @param baseArray array that is being copied
   */
  public DynamicArray(int offset, T[] baseArray) {
    this.offset = offset;
    this.baseArray = (T[]) new Object[baseArray.length];
    int i = 0;

    while (i < baseArray.length) {
      int newIndex = (i) % baseArray.length;
      this.baseArray[i] = baseArray[newIndex];
      i++;
    }
  }

  /**
   * finds the element at a specific index
   * @param index index being looked up
   * @return element at index
   */
  public T get(int index) {
    return baseArray[index];
  }

  /**
   * finds element at index that has been offset
   * @param index index of element
   * @param offset offset of array
   * @return element at specific index
   */
  public T get(int index, int offset) {
    int newIndex = (index + offset) % baseArray.length;
    if (newIndex < 0) {
      newIndex = newIndex + baseArray.length;
    }
    return baseArray[newIndex];
  }

  /**
   * sets the element of the baseArray at a specific index
   * @param index index that is being set
   * @param element element being set in index
   */
  public void set(int index, T element) {
    baseArray[index] = element;
  }
}