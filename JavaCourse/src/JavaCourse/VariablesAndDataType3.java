package JavaCourse;

//Anatomy of a java program
//Suggested- Documentation section
//Optional - package Statement,Import Statement,Interface Statement,Class Definitions
//Essential - Main Method class
			//{
				//Main Method Definition
			//}	

//The set of these rules is called syntax.(vocabulary and grammar of java).

//Variables- A Variables is a container that stores a value. This value can be change during the execution of the program.
// Example :  int(Data Type) name(Variable Name ) = 8(value it stores!);

//	Rules for declaring a variable name:
//1.Must not begin with a digit -> int 1jainik is invalid!
//2.Name is case Sensitive -> Jainik and jainik are different!
//3.Should not be a keyword (like Void);
//4.With space not allowed-> int jainik java; is invalid.
//5.Can contain alphabets, $character,_character and digits if the other conditions are met.

//Data types : Data types in java fall under the following categories:
//1. Primitive Data Types (Intrinsic)
//2. Non - Primitive Data Type (Derived)

//1. Primitive Data Types :
//Java is Statically Typed -> variables must be declared before use!
// There are 8 primitive data types supported by java.

//1.byte -> # value range from -128 to 127
		//	# takes 1 byte (one byte means is 8 bits.) (1 bits k under 0 or 1le sakte he ).
		//	# default value is 0.
		// (2(power)*8)/2 to (2(power)*8)/2 - 1.(2 to  the power 8, i have divided it by 2 so it became 2 to the power 7)

//2.short -> # value range from -32,768 to 32,768 
		//	# takes 2 byte (one byte means is 8 bits.) (1 bits k under 0 or 1le sakte he ).
		//	# default value is 0.
		// (2(power)*16)/2 to (2(power)*16)/2 - 1.(2 to  the power 16, i have divided it by 2 so it became 2 to the power 15 )-1 comes because zero is also one value

//3.int -> # value range from 32-bit
		//	# takes 4 byte (one byte means is 8 bits.) (1 bits k under 0 or 1le sakte he ).
		//	# default value is 0.
		// (2(power)*32)/2 to (2(power)*32)/2 - 1.(2 to  the power 32, i have divided it by 2 so it became 2 to the power 31 )-1 comes because zero is also one value

//4.float -> # value range from 32-bit 
		//	# takes 4 byte (one byte means is 8 bits.) (1 bits k under 0 or 1le sakte he ).
		//	# default value is 0.0f.
		// See Docs

//5.long -> # value range from 64-bit 
		//	# takes 8 byte (one byte means is 8 bits.) (1 bits k under 0 or 1le sakte he ).
		//	# default value is 0.
		// (2(power)*64)/2 to (2(power)*64)/2 - 1.(2 to  the power 64, i have divided it by 2 so it became 2 to the power 63 )-1 comes because zero is also one value

//6.double -> # value range from 64-bit 
		//	# takes 8 byte (one byte means is 8 bits.) (1 bits k under 0 or 1le sakte he ).
		//	# default value is 0.
		//  See Docs

//7.char -> # value range from 0 to 65535(2*(power)16 - 1) 
		//	# takes 2 byte -> (because it support unicode)(one byte means is 8 bits.) (1 bits k under 0 or 1le sakte he ).
		//	# default value is 0.
		// (2(power)*16)/2 to (2(power)*16)/2 - 1.(2 to  the power 16, i have divided it by 2 so it became 2 to the power 15 )-1 comes because zero is also one value

//8.boolean -> # value can be true or false 
		//	# size depends on 
		//	# default value is false.
		

public class VariablesAndDataType3 {
		
	public static void main(String[] args) {
		 
		System.out.print("The sum of these numbers is: "); // println is add a new line 
		int num1 = 6;
		int num2 = 12;
		int num3 = 16;
		 int sum = num1 + num2 + num3;
		 System.out.println(sum);
		
				
	}
}
