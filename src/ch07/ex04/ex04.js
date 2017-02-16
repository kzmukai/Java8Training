/**
 * 
 */

var str = 'Hello World!'; 
 print(str + ":" + str.getClass()); 
 str = str.substring(2,10) 
 print(str + " :" + str.getClass()) ; 
 str = java.lang.String.class.cast(str); 
 print(str + " :" + str.getClass()); 
  
